package swp391.fptqna.dao;

import swp391.fptqna.dto.ReportedAnswerDTO;
import swp391.fptqna.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ReportedAnswerDAO {
    private ReportedAnswerDTO parseFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        byte flagTypeId = resultSet.getByte("FlagTypeId");
        int answerId = resultSet.getInt("AnswerId");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        Date creationDate = resultSet.getDate("CreationDate");
        byte state = resultSet.getByte("State");
        String description = resultSet.getString("Description");
        return new ReportedAnswerDTO(id, flagTypeId, answerId, ownerUserId, creationDate, state, description);
    }

    public ArrayList<ReportedAnswerDTO> getReportedAnswerByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM AnswerFlag \n" +
                    "WHERE State = 2\n" +
                    "ORDER BY CreationDate ASC \n" +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<ReportedAnswerDTO> list = new ArrayList<>();
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

    public boolean setState(int reportedAnswerId, byte state) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE AnswerFlag SET State = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setByte(1,state);
            preparedStatement.setInt(2, reportedAnswerId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int reportedAnswerId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "DELETE FROM AnswerFlag WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, reportedAnswerId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
