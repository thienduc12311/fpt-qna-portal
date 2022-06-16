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
                   String password = resultSet.getString("Password");
                   String imgLink = resultSet.getString("ImgLink");
                   int score = resultSet.getInt("Score");
                   int role = resultSet.getInt("Role");
                   boolean state = resultSet.getBoolean("State");
                   String bio = resultSet.getString("Bio");
                   UserDTO user = new UserDTO(email,name,password,imgLink,score,role,state,bio);
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
    public UserDTO checkLogin(String email, String password) throws Exception {
        cn = DButil.getMyConnection();
        if(cn!=null){
            try {
                String query = "Select * from Users Where email = ? and password = ?";
                PreparedStatement preparedStatement = cn.prepareStatement(query);
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,password);
                this.resultSet = preparedStatement.executeQuery();
                if (resultSet != null && resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String name = resultSet.getString("UserDisplayName");
                    String imgLink = resultSet.getString("ImgLink");
                    int score = resultSet.getInt("Score");
                    int role = resultSet.getInt("Role");
                    boolean state = resultSet.getBoolean("State");
                    String bio = resultSet.getString("Bio");
                    UserDTO user = new UserDTO(email,name,password,imgLink,score,role,state,bio);
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
    public boolean insertUser(String email, String fullName, String password, String avtUrl) throws Exception {
        int score = 0;
        int role = 0;
        boolean state = true;
        String bio = "";
        cn= DButil.getMyConnection();
        if (cn != null) {
           try {
               String query = "Insert into Users values (?,?,?,?,?,?,?,?)";
               PreparedStatement preparedStatement = cn.prepareStatement(query);
               preparedStatement.setString(1, email);
               preparedStatement.setString(2, fullName);
               preparedStatement.setString(3,password);
               preparedStatement.setString(4,avtUrl);
               preparedStatement.setInt(5,score);
               preparedStatement.setInt(6,role);
               preparedStatement.setBoolean(7,state);
               preparedStatement.setString(8, bio);
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

    public boolean registerUser(String email, String fullName, String password) throws Exception {
        int score = 0;
        int role = 0;
        boolean state = true;
        String bio = "";
        String avtUrl = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png";

        cn= DButil.getMyConnection();
        if (cn != null) {
            try {
                String query = "Insert into Users values (?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = cn.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, fullName);
                preparedStatement.setString(3,password);
                preparedStatement.setString(4,avtUrl);
                preparedStatement.setInt(5,score);
                preparedStatement.setInt(6,role);
                preparedStatement.setBoolean(7,state);
                preparedStatement.setString(8, bio);
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
