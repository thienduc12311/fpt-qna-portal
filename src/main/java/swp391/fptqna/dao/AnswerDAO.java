package swp391.fptqna.dao;

import swp391.fptqna.dto.AnswerDTO;
import swp391.fptqna.dto.ExtendedAnswerDTO;
import swp391.fptqna.dto.ExtendedQuestionDTO;
import swp391.fptqna.utils.DButil;
import swp391.fptqna.utils.DateFormatter;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class AnswerDAO {
    private AnswerDTO parseFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        int questionId = resultSet.getInt("QuestionId");
        Date creationDate = resultSet.getDate("CreationDate");
        Date deletionDate = resultSet.getDate("DeletionDate");
        int score = resultSet.getInt("Score");
        String body = resultSet.getString("Body");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        int approveUserId = resultSet.getInt("ApproveUserId");
        int lastEditorUserId = resultSet.getInt("LastEditorUserId");
        Date lastEditDate = resultSet.getDate("LastEditDate");
        int commentCount = resultSet.getInt("CommentCount");
        return new AnswerDTO(id, questionId, creationDate, deletionDate, score, body, ownerUserId, approveUserId, lastEditorUserId, lastEditDate, commentCount);
    }

    public AnswerDTO getAnswerById(int id) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select * from Answers Where id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet != null && resultSet.next()) {
                    return parseFromDB(resultSet);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<AnswerDTO> getPendingAnswerByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Answers \n" +
                    "WHERE ApproveUserId IS NULL\n" +
                    "ORDER BY CreationDate ASC \n" +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<AnswerDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(parseFromDB(resultSet));
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isAnswered(int userId, int questionId) {
        String query = "SELECT * FROM Answers WHERE QuestionId = ? AND OwnerUserId = ?";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            preparedStatement.setInt(2, userId);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int answerId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "DELETE FROM Answers WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, answerId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addNewAnswer(int userId, int questionId, String content) {
        String query = "INSERT INTO Answers(QuestionId, CreationDate, Body, OwnerUserId) VALUES (?,?,?,?)";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
            preparedStatement.setString(3, content);
            preparedStatement.setInt(4, userId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteWithoutDB(int answerId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE Answers SET DeletionDate = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(2, answerId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getListAnswersOfQuestion(ExtendedQuestionDTO question) {
        String query = "SELECT * FROM (SELECT * FROM Answers WHERE QuestionId = ? AND DeletionDate IS NULL) a INNER JOIN Users u ON a.OwnerUserId = u.Id";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, question.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    int questionId = resultSet.getInt("QuestionId");
                    Date creationDate = resultSet.getDate("CreationDate");
                    Date deletionDate = resultSet.getDate("DeletionDate");
                    int score = resultSet.getInt("Score");
                    String body = resultSet.getString("Body");
                    int ownerUserId = resultSet.getInt("OwnerUserId");
                    int approveUserId = resultSet.getInt("ApproveUserId");
                    int lastEditorUserId = resultSet.getInt("LastEditorUserId");
                    Date lastEditDate = resultSet.getDate("LastEditDate");
                    int commentCount = resultSet.getInt("CommentCount");
                    String ownerUserAvt = resultSet.getString("ImgLink");
                    String ownerUserName = resultSet.getString("UserDisplayName");
                    ExtendedAnswerDTO answer = new ExtendedAnswerDTO(id, questionId, creationDate, deletionDate, score, body, ownerUserId, approveUserId, lastEditorUserId, lastEditDate, commentCount, ownerUserAvt, ownerUserName);
                    question.getAnswerList().add(answer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getAnswerCountByCalenderDate (ExtendedQuestionDTO question){
        Map<String, Integer> dateAnswerCountMap = new LinkedHashMap<>();
        String query = ";with d(date) as (\n" +
                "  select cast((convert(varchar, creationdate, 111)) as datetime) from questions where id = ?\n" +
                "  union all\n" +
                "  select date+1\n" +
                "  from d\n" +
                "  where date < getdate()\n" +
                "  )\n" +
                "select d.date CDate, t.count numofanswer\n" +
                "from d\n" +
                "left join (\n" +
                "SELECT Count(*) as count, CONVERT(varchar(10), Answers.CreationDate, 120) as date\n" +
                "FROM Questions, Answers\n" +
                "WHERE Questions.Id = Answers.QuestionId\n" +
                "AND Questions.Id = ?\n" +
                "AND Answers.CreationDate >= Questions.CreationDate\n" +
                "AND Answers.CreationDate <= GetDate()\n" +
                "GROUP BY CONVERT(varchar(10), Answers.CreationDate, 120) --02/08\n" +
                ") t\n" +
                "on d.date = t.date\n" +
                "order by d.date\n";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, question.getId());
            preparedStatement.setInt(2, question.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    dateAnswerCountMap.put(DateFormatter.convertFromDateToString(resultSet.getDate("CDate")), resultSet.getInt("numofanswer"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateAnswerCountMap;
    }

    public Map<String, Integer> getTopAnswerScoreFilterQuestionId (ExtendedQuestionDTO question){
        Map<String, Integer> dateAnswerCountMap = new LinkedHashMap<>();
        String query = "SELECT TOP 5 Users.UserDisplayName as name, Answers.Score as score\n" +
                "FROM Answers, Users\n" +
                "WHERE Users.Id = Answers.OwnerUserId\n" +
                "AND questionId = ?\n" +
                "ORDER BY Score DESC";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, question.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    dateAnswerCountMap.put(resultSet.getString("name"), resultSet.getInt("score"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateAnswerCountMap;
    }
}