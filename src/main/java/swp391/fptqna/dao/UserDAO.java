package swp391.fptqna.dao;

import swp391.fptqna.dto.UserDTO;
import swp391.fptqna.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    Connection cn = null;
    ResultSet resultSet = null;
    private void closeConnection() throws SQLException {
        cn.close();
        this.resultSet = null;
    }
    public UserDTO getUser(String email) throws Exception {
        cn = DButil.getMyConnection();
       if(cn!=null){
           try {
               String query = "Select * from Users Where email = ?";
               PreparedStatement preparedStatement = cn.prepareStatement(query);
               preparedStatement.setString(1,email);
                this.resultSet = preparedStatement.executeQuery();
               if (resultSet != null && resultSet.next()) {
                   int id = resultSet.getInt("Id");
                   String name = resultSet.getString("UserDisplayName");
                   String googleId = resultSet.getString("GoogleId");
                   String avtUrl = resultSet.getString("avt_url");
                   int score = resultSet.getInt("Score");
                   int role = resultSet.getInt("Role");
                   UserDTO user = new UserDTO(email,name,googleId,avtUrl,role,score);
                   return user;
               }

           }catch (Exception e) {
               e.printStackTrace();
           }
           finally {
               closeConnection();
           }

       }
        return null;
    }
    public boolean insertUser(String email, String fullName, String googleID, String avtUrl) throws Exception {
        int score = 0;
         int role = 0;

        cn= DButil.getMyConnection();
        if (cn != null) {
           try {
               String query = "Insert into Users values (?,?,?,?,?,?)";
               PreparedStatement preparedStatement = cn.prepareStatement(query);
               preparedStatement.setString(1, email);
               preparedStatement.setString(2, fullName);
               preparedStatement.setString(3,googleID);
               preparedStatement.setInt(4,score);
               preparedStatement.setInt(5,role);
               preparedStatement.setString(6,avtUrl);
               int rs = preparedStatement.executeUpdate();
               return rs > 0;
           } catch (Exception e){
               e.printStackTrace();
           } finally {
               closeConnection();
           }
        }
        return false;
    }
}
