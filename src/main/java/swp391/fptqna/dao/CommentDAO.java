package swp391.fptqna.dao;

import swp391.fptqna.dto.CommentDTO;
import swp391.fptqna.dto.ExtendedQuestionDTO;
import swp391.fptqna.utils.DButil;

import java.sql.*;
import java.util.Date;

public class CommentDAO {
    private CommentDTO parseFromDB(ResultSet resultSet, String type) throws SQLException {
        int id = resultSet.getInt("Id");
        int parentId = 0;
        if (type.equals("question")) parentId = resultSet.getInt("QuestionId");
        else parentId = resultSet.getInt("AnswerId");
        java.util.Date creationDate = resultSet.getDate("CreationDate");
        String content = resultSet.getString("Content");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        String ownerUserName = resultSet.getString("UserDisplayName");
        String ownerAvt = resultSet.getString("ImgLink");
        return new CommentDTO(id, parentId, content, creationDate, ownerUserId, ownerUserName, ownerAvt);
    }

    public boolean createNewComment(int userId, int parentId, String content, String type) throws Exception {
        String questionComment = "INSERT INTO QuestionComment VALUES (?,?,?,?)";
        String answerComment = "INSERT INTO AnswerComment VAlUES(?,?,?,?)";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = null;
            if (type.equals("question")) {
                preparedStatement = cn.prepareStatement(questionComment);
            } else if (type.equals("answer")) {
                preparedStatement = cn.prepareStatement(answerComment);
            }
            preparedStatement.setInt(1, parentId);
            preparedStatement.setString(2, content);
            preparedStatement.setTimestamp(3, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(4, userId);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getListCommentOfQuestion(ExtendedQuestionDTO question) {
        String query = "SELECT * FROM (SELECT * FROM QuestionComment WHERE QuestionId = ?) a INNER JOIN Users u ON a.OwnerUserId = u.Id";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, question.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    question.getComments().add(parseFromDB(resultSet, "question"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteComment(String type, int typeId, int userId) {
        String questionComment = "DELETE FROM QuestionComment WHERE QuestionId = ? AND OwnerUserId = ?";
        String answerComment = "DELETE FROM AnswerComment WHERE AnswerId = ? AND OwnerUserId = ?";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = null;
            if (type.equals("question")) {
                preparedStatement = cn.prepareStatement(questionComment);
            } else if (type.equals("answer")) {
                preparedStatement = cn.prepareStatement(answerComment);
            }
            preparedStatement.setInt(1, typeId);
            preparedStatement.setInt(2, userId);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getListCommentOfAnswer(ExtendedQuestionDTO question) {
        String query = "select * FROM (Select * FROM AnswerComment where AnswerId in (select Id from Answers where QuestionId = ?)) c LEFT JOIN dbo.Users u on c.OwnerUserId = u.Id\n";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, question.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int answerId = resultSet.getInt("AnswerId");
                    question.getAnswerList().getAnswerById(answerId).getComments().add(parseFromDB(resultSet, "answer"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}