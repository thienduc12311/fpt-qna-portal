package swp391.fptqna.dao;

import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.UserDTO;
import swp391.fptqna.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                   UserDTO user = new UserDTO(id,email,name,password,imgLink,score,role,state,bio);
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

    public UserDTO getUserById(int id) throws Exception {
        cn = DButil.getMyConnection();
        if(cn!=null){
            try {
                String query = "Select * from Users Where Id = ?";
                PreparedStatement preparedStatement = cn.prepareStatement(query);
                preparedStatement.setInt(1,id);
                this.resultSet = preparedStatement.executeQuery();
                if (resultSet != null && resultSet.next()) {
                    String email = resultSet.getString("Email");
                    String name = resultSet.getString("UserDisplayName");
                    String password = resultSet.getString("Password");
                    String imgLink = resultSet.getString("ImgLink");
                    int score = resultSet.getInt("Score");
                    int role = resultSet.getInt("Role");
                    boolean state = resultSet.getBoolean("State");
                    String bio = resultSet.getString("Bio");
                    UserDTO user = new UserDTO(id,email,name,password,imgLink,score,role,state,bio);
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
                    UserDTO user = new UserDTO(id,email,name,password,imgLink,score,role,state,bio);
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
    public boolean updateUser(String displayname, String password, String bio, int id) throws Exception {

        cn= DButil.getMyConnection();
        if (cn != null) {
            try {
                String query = "Update Users set UserDisplayName = ?, Password = ?, Bio = ? where Id = ?";
                PreparedStatement preparedStatement = cn.prepareStatement(query);
                preparedStatement.setString(1, displayname);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, bio);
                preparedStatement.setInt(4, id);
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

    public boolean setState(int id, boolean state) throws Exception {

        cn= DButil.getMyConnection();
        if (cn != null) {
            try {
                String query = "UPDATE Users SET State = ? WHERE Id = ?";
                PreparedStatement preparedStatement = cn.prepareStatement(query);
                preparedStatement.setBoolean(1, state);
                preparedStatement.setInt(2, id);
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

    public ArrayList<UserDTO> getUserByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Users \n" + "ORDER BY Id ASC \n" + "OFFSET ? ROWS\n" + "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<UserDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String email = resultSet.getString("Email");
                    String name = resultSet.getString("UserDisplayName");
                    String password = resultSet.getString("Password");
                    String imgLink = resultSet.getString("ImgLink");
                    int score = resultSet.getInt("Score");
                    int role = resultSet.getInt("Role");
                    boolean state = resultSet.getBoolean("State");
                    String bio = resultSet.getString("Bio");
                    UserDTO user = new UserDTO(id,email,name,password,imgLink,score,role,state,bio);
                    list.add(user);
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

    public ArrayList<UserDTO> searchByName(String key, int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Users \n" + "WHERE UserDisplayName LIKE ? \n" + "ORDER BY Id ASC \n" + "OFFSET ? ROWS\n" + "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setInt(2, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<UserDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String email = resultSet.getString("Email");
                    String name = resultSet.getString("UserDisplayName");
                    String password = resultSet.getString("Password");
                    String imgLink = resultSet.getString("ImgLink");
                    int score = resultSet.getInt("Score");
                    int role = resultSet.getInt("Role");
                    boolean state = resultSet.getBoolean("State");
                    String bio = resultSet.getString("Bio");
                    UserDTO user = new UserDTO(id,email,name,password,imgLink,score,role,state,bio);
                    list.add(user);
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

    public int getNumberOfPage(String key) throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Users WHERE UserDisplayName LIKE ?  ";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfRecord;
    }

    public int countUserQuestions (int userId) throws Exception{
        int numberofQuestions = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQues\n" +
                    "FROM Questions\n" +
                    "WHERE OwnerUserId = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    numberofQuestions = resultSet.getInt("numOfQues");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberofQuestions;
    }
    public int countUserAnswers (int userId) throws Exception{
        int numberofAnswers = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfAns\n" +
                    "FROM Answers\n" +
                    "WHERE OwnerUserId = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    numberofAnswers = resultSet.getInt("numOfAns");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberofAnswers;
    }
}