package swp391.fptqna.dao;

import swp391.fptqna.dto.TagDTO;
import swp391.fptqna.utils.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class TagDAO {
    private TagDTO parseFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String tagName = resultSet.getString("TagName");
        String description = resultSet.getString("Discription");
        Date creationDate = resultSet.getDate("CreationDate");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        int questionCount = resultSet.getInt("QuestionCount");
        byte state = resultSet.getByte("State");
        return new TagDTO(id, tagName, description, creationDate, ownerUserId, questionCount,state);
    }

    private TagDTO getTagById(int id) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select * from Tags Where Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet != null && resultSet.next()) {
                    return parseFromDB(resultSet);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getNumberOfPage() throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Tags";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
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
    public ArrayList<TagDTO> getAllAvailableTag() throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Tags WHERE State = 1";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<TagDTO> list = new ArrayList<>();
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
    public ArrayList<TagDTO> getTagByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Tags \n" +
                    "ORDER BY Id DESC \n" +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<TagDTO> list = new ArrayList<>();
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

    public ArrayList<TagDTO> getListTagByQuestionId(int questionId) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT Tags.Id as Id, Tags.TagName as TagName FROM \n" +
                    "(SELECT * FROM QuestionTags\n" +
                    "WHERE QuestionId = ?) as QT LEFT JOIN Tags ON QT.TagId = Tags.Id;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<TagDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String tagName = resultSet.getString("TagName");
                    TagDTO tag = new TagDTO(id, tagName);
                    list.add(tag);
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

    public boolean addTag(String tagName, String description, int userId) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Insert into Tags values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, tagName);
            preparedStatement.setString(2, description);
            preparedStatement.setTimestamp(3, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(4, userId);
            preparedStatement.setInt(5,0);
            preparedStatement.setInt(6,1);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTags(int tagId, String tagName, String description, byte state) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE Tags SET TagName = ?, Discription = ?, State = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, tagName);
            preparedStatement.setString(2, description);
            preparedStatement.setByte(3, state);
            preparedStatement.setInt(4,tagId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}