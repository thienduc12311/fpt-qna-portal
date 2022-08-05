package swp391.fptqna.dao;

import swp391.fptqna.dto.NotificationDTO;
import swp391.fptqna.dto.NotificationViewDTO;
import swp391.fptqna.dto.QuestionDTO;
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

    public int getNumByUserId(int userId) throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS num FROM Notifications WHERE OwnerUserId = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("num");
                    return numberOfRecord;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfRecord;
    }

    public ArrayList<NotificationViewDTO> getTop(int id, int value) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "select A.*,B.Body as Content\n" +
                    "from (select * from Notifications where OwnerUserId = ?) as A left join NotificationTypes as B on A.NotificationTypeId = B.Id\n" +
                    "ORDER BY CreationDate DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,value);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<NotificationViewDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    NotificationDTO noti = parseFromDB(resultSet);
                    String content = resultSet.getString("Content");
                    list.add(new NotificationViewDTO(noti,content));
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

    public boolean updateState(int id, boolean state){
            try (Connection cn = DButil.getMyConnection()) {
                String query = "UPDATE Notifications SET State = ? WHERE Id = ?";
                PreparedStatement preparedStatement = cn.prepareStatement(query);
                preparedStatement.setBoolean(1, state);
                preparedStatement.setInt(2, id);
                int rs = preparedStatement.executeUpdate();
                return rs > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
    }
}