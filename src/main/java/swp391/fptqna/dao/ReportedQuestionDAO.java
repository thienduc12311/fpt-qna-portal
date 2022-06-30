package swp391.fptqna.dao;

import swp391.fptqna.dto.ReportedQuestionDTO;
import swp391.fptqna.utils.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ReportedQuestionDAO {
    private ReportedQuestionDTO parseFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        byte flagTypeId = resultSet.getByte("FlagTypeId");
        int questionId = resultSet.getInt("AnswerId");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        Date creationDate = resultSet.getDate("CreationDate");
        byte state = resultSet.getByte("State");
        String description = resultSet.getString("Description");
        return new ReportedQuestionDTO(id, flagTypeId, questionId, ownerUserId, creationDate, state, description);
    }

    public ArrayList<ReportedQuestionDTO> getReportedQuestionByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM QuestionFlag \n" +
                    "WHERE State = 0\n" +
                    "ORDER BY CreationDate ASC \n" +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<ReportedQuestionDTO> list = new ArrayList<>();
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

    public boolean setState(int reportedQuestionId, byte state) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE QuestionFlag SET State = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setByte(1, state);
            preparedStatement.setInt(2, reportedQuestionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int reportedQuestionId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "DELETE FROM QuestionFlag WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, reportedQuestionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
