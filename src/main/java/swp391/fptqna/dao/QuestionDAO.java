package swp391.fptqna.dao;

import swp391.fptqna.dto.ExtendQuestionList;
import swp391.fptqna.dto.ExtendedQuestionDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.TagDTO;
import swp391.fptqna.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String query = "Select * from Questions Where id = ?";
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

    public ArrayList<QuestionDTO> getAvailableQuestionByPage(int page) throws Exception{
        try(Connection cn = DButil.getMyConnection()){
            String query = "SELECT * FROM \n" +
                    "(SELECT * FROM Questions \n" +
                    "    WHERE ApproveUserId IS NOT NULL    \n" +
                    "    ORDER BY CreationDate ASC \n" +
                    "    OFFSET ? ROWS \n" +
                    "    FETCH NEXT 10 ROWS ONLY) q \n" +
                    "INNER JOIN Users u ON q.OwnerUserId = u.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
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
    public int getNumberOfPage() throws Exception{
        int numberOfRecord = 0;
        try(Connection cn = DButil.getMyConnection()){
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Questions";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int)((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      return 0;
    }
    public ExtendQuestionList getAllTagsOfQuestion(ExtendQuestionList questions){
        try(Connection cn = DButil.getMyConnection()){
            String query = "SELECT * FROM (SELECT * FROM QuestionTags WHERE QuestionId IN (?,?,?,?,?,?,?,?,?,?)) q INNER JOIN Tags t ON q.TagId = t.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            for (int i = 0; i < questions.size(); i++) {
                preparedStatement.setInt(i + 1, questions.get(i).getId());
            }
            for (int i = questions.size(); i < 11; i++) {
                preparedStatement.setString(i,null);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    int questionId = resultSet.getInt("QuestionId");
                    int id = resultSet.getInt("Id");
                    String tagName = resultSet.getString("TagName");
                    String description = resultSet.getString("Discription");
                    Date creationDate = resultSet.getDate("CreationDate");
                    int ownerUserId = resultSet.getInt("OwnerUserId");
                    int questionCount = resultSet.getInt("QuestionCount");
                    byte state = resultSet.getByte("State");
                    TagDTO tag = new TagDTO(id, tagName, description, creationDate, ownerUserId, questionCount,state);
                    questions.getQuestionById(questionId).getTags().add(tag);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
    public ArrayList<QuestionDTO> getPendingQuestionByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Questions \n" +
                    "WHERE ApproveUserId IS NULL\n" +
                    "ORDER BY CreationDate ASC \n" +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY;";
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
}
