package swp391.fptqna.dao;

import swp391.fptqna.dto.NotificationDTO;
import swp391.fptqna.utils.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class NotificationDAO {
    private NotificationDTO parseFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        int notificationTypeId = resultSet.getInt("NotificationTypeId");
        Date creationDate = resultSet.getDate("CreationDate");
        String body = resultSet.getString("Body");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        boolean state = resultSet.getBoolean("State");
        return new NotificationDTO(id, notificationTypeId, creationDate, body, ownerUserId, state);
    }

    public boolean insert(int notificationTypeId, String body, int ownerUserId) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Insert into Notifications values (?,?,?,?,?)";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, notificationTypeId);
            preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
            preparedStatement.setString(3, body);
            preparedStatement.setInt(4, ownerUserId);
            preparedStatement.setBoolean(5, true);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<NotificationDTO> getNotiByUserAndType(int userId, int typeId) {
        String query = "SELECT * FROM Notifications WHERE  OwnerUserId = ? And NotificationTypeId = ?";
        ArrayList<NotificationDTO> notificationDTOS = new ArrayList<>();
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, typeId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                NotificationDTO notificationDTO = parseFromDB(result);
                notificationDTOS.add(notificationDTO);
            }
            return notificationDTOS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}