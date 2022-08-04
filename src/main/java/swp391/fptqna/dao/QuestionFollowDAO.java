package swp391.fptqna.dao;

import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.UserDTO;
import swp391.fptqna.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class QuestionFollowDAO {
    public ArrayList<Integer> getFollower(int questionId) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT UserId FROM QuestionFollow WHERE QuestionId = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("UserId");
                    list.add(id);
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

    public boolean insert(int questionId, int userId){
        try (Connection cn = DButil.getMyConnection()) {
            String query = "INSERT INTO QuestionFollow VALUES (?,?,?)";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setTimestamp(3, new Timestamp(new Date().getTime()));
            int result = preparedStatement.executeUpdate();
            if (result > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
