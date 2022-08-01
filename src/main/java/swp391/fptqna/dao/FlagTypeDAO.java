package swp391.fptqna.dao;

import swp391.fptqna.dto.FlagTypeDTO;
import swp391.fptqna.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class FlagTypeDAO {
    private FlagTypeDTO parseFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        String description = resultSet.getString("Description");
        return new FlagTypeDTO(id, name, description);
    }

    public FlagTypeDTO getFlagTypeById(int id) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select * from FlagTypes Where id = ?";
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

    public HashMap<Integer, FlagTypeDTO> getAll() throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select * from FlagTypes";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                HashMap<Integer, FlagTypeDTO> list = new HashMap<>();
                while (resultSet.next()) {
                    list.put(resultSet.getInt("Id"), parseFromDB(resultSet));
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

    public ArrayList<FlagTypeDTO> getAllFlag() throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select * from FlagTypes";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<FlagTypeDTO> list = new ArrayList<>();
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
}