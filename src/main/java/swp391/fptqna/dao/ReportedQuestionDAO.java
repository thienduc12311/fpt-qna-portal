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
        int questionId = resultSet.getInt("QuestionId");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        Date creationDate = resultSet.getDate("CreationDate");
        byte state = resultSet.getByte("State");
        String description = resultSet.getString("Description");
        return new ReportedQuestionDTO(id, flagTypeId, questionId, ownerUserId, creationDate, state, description);
    }

    public ReportedQuestionDTO getReportedQuestionById(int id) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select * from QuestionFlag Where id = ?";
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

    public boolean isReported(int questionId, int userId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM QuestionFlag WHERE QuestionId = ? AND OwnerUserId = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            preparedStatement.setInt(2, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean createReport(int flagId, int answerId, int userId, String description) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "INSERT INTO QuestionFlag VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, flagId);
            preparedStatement.setInt(2, answerId);
            preparedStatement.setInt(3, userId);
            preparedStatement.setTimestamp(4, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(5, 0);
            preparedStatement.setString(6, description);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public int getNumberOfPage() throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM QuestionFlag WHERE State = 0";
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

    public boolean disableAllRelated(int id) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE QuestionFlag SET State = 1 WHERE QuestionId = ? ";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

