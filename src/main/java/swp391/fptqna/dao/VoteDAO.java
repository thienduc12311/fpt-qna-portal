package swp391.fptqna.dao;

import swp391.fptqna.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

public class VoteDAO {
    public boolean unvote(int userId, int typeId, String type) {
        String questionVoteSql = "DELETE from QuestionVote Where OwnerUserId = ? AND QuestionId = ?";
        String answerVoteSql = "DELETE from AnswerVote Where OwnerUserId = ? AND AnswerId = ?";

        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = null;
            if (type.equals("question")) {
                preparedStatement = cn.prepareStatement(questionVoteSql);
            } else if (type.equals("answer")) {
                preparedStatement = cn.prepareStatement(answerVoteSql);
            }
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, typeId);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getVoteState(int userId, int typeId, String type) {
        String questionVoteSql = "SELECT State from QuestionVote Where OwnerUserId = ? AND QuestionId = ?";
        String answerVoteSql = "SELECT State from AnswerVote Where OwnerUserId = ? AND AnswerId = ?";

        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = null;
            if (type.equals("question")) {
                preparedStatement = cn.prepareStatement(questionVoteSql);
            } else if (type.equals("answer")) {
                preparedStatement = cn.prepareStatement(answerVoteSql);
            }
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, typeId);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return result.getInt("State");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 2;
    }

    public boolean vote(int userId, int typeId, String type, int state) {
        String questionVoteSql = "INSERT INTO QuestionVote VALUES (?,?,?,?)";
        String answerVoteSql = "INSERT INTO AnswerVote VALUES (?,?,?,?)";

        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = null;
            if (type.equals("question")) {
                preparedStatement = cn.prepareStatement(questionVoteSql);
            } else if (type.equals("answer")) {
                preparedStatement = cn.prepareStatement(answerVoteSql);
            }
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, typeId);
            preparedStatement.setInt(3, state);
            preparedStatement.setTimestamp(4, new Timestamp(new Date().getTime()));
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}