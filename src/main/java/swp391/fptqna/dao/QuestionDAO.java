package swp391.fptqna.dao;

import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.utils.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class QuestionDAO {


    private QuestionDTO parseFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        Date creationDate = resultSet.getDate("CreationDate");
        Date closedDate = resultSet.getDate("ClosedDate");
        Date deletionDate = resultSet.getDate("DeletionDate");
        int score = resultSet.getInt("Score");
        String title = resultSet.getString("Title");
        String body = resultSet.getString("Body");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        int approveUserId = resultSet.getInt("ApproveUserId");
        int lastEditorUserId = resultSet.getInt("LastEditorUserId");
        Date lastEditDate = resultSet.getDate("LastEditDate");
        int answerCount = resultSet.getInt("AnswerCount");
        int commentCount = resultSet.getInt("CommentCount");
        return new QuestionDTO(id, creationDate, closedDate, deletionDate, score, title, body, ownerUserId, approveUserId, lastEditorUserId, lastEditDate, answerCount, commentCount);
    }

    public QuestionDTO getQuestionById(int id) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select * from Questions Where Id = ?";
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

    public ArrayList<QuestionDTO> getPendingQuestionByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Questions \n" + "WHERE ApproveUserId IS NULL AND DeletionDate IS NULL \n" + "ORDER BY CreationDate ASC \n" + "OFFSET ? ROWS\n" + "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
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

    public boolean approve(int questionId, int userId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE Questions SET ApproveUserId = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, questionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int questionId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "DELETE FROM Questions WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteWithoutDB(int questionId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE Questions SET DeletionDate = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(2, questionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<QuestionDTO> getQuestionByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Questions \n" + "ORDER BY Id ASC \n" + "OFFSET ? ROWS\n" + "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
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

    public int getNumberOfPagePendingQuestion() throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Questions WHERE ApproveUserId IS NULL AND DeletionDate IS NULL  ";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfRecord;
    }

    public int getNumberOfPage() throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Questions";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfRecord;
    }
}
