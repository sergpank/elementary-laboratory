package dao;

import entity.Client;
import entity.Pet;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vaio on 16.06.19.
 */
public class PetDAO extends DAO<Pet> {
    public static final String INSERT_Pet_SQL = "INSERT INTO pet (name,birthDate,type,client_id) VALUES(?,?,?,?)";
    public static final String SELECT_Pet_SQL = "SELECT id,name,birthDate,type,client_id FROM pet where id = ?;";
    public static final String SELECT_Pet_SQL_ALL = "SELECT id,name,birthDate,type client_id FROM pet";
    public static final String UPDATE_Pet_SQL = "UPDATE pet SET name=? ,birthDate=? ,type=?, client_id=? WHERE id = ?";
    public static final String DELETE_Pet_SQL = "DELETE FROM pet WHERE id = ?";


    @Override
    public Pet create(Pet entity) {
        try (Connection con = DbUtil.getConnectionFromPool())
        {
            PreparedStatement pStmt = con.prepareStatement(INSERT_Pet_SQL,Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, entity.getName());
            pStmt.setLong(2, entity.getBirthDate().getTime());
            pStmt.setString(3, entity.getType());
            pStmt.setLong(4,entity.getMaster_id());

            pStmt.execute();
            entity.setId(getKey(pStmt));
            return entity;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Pet read(long id) {
        Pet pet = null;
        try (Connection con = DbUtil.getJdbcConnection()){
            PreparedStatement stmnt = con.prepareStatement(SELECT_Pet_SQL);
            stmnt.setLong(1,id);
            ResultSet resultSet = stmnt.executeQuery();
            resultSet.next();
            long ids = resultSet.getLong("id");
            String name = resultSet.getString("name");
            Date date = new Date(resultSet.getLong("birthDate"));
            String type = resultSet.getString("type");
            long client_id = resultSet.getLong("client_id");
            pet = new Pet(ids,name,date,type,client_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;
    }

    @Override
    public List<Pet> readAll() {
        Pet pet = null;
        List<Pet> petList = new ArrayList<>();
        try (Connection con = DbUtil.getJdbcConnection()){
            PreparedStatement stmnt = con.prepareStatement(SELECT_Pet_SQL_ALL);
            ResultSet resultSet = stmnt.executeQuery();
            while (resultSet.next()){
            long ids = resultSet.getLong("id");
            String name = resultSet.getString("name");
            Date date = new Date(resultSet.getLong("birthDate"));
            String type = resultSet.getString("type");
            long client_id = resultSet.getLong("client_id");
            pet = new Pet(ids,name,date,type,client_id);
                petList.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petList;
    }

    @Override
    public boolean update(Pet entity) {
        boolean rez = false;
        try (Connection con = DbUtil.getConnectionFromPool()){
            PreparedStatement statement = con.prepareStatement(UPDATE_Pet_SQL);
            statement.setString(1,entity.getName());
            statement.setLong(2, entity.getBirthDate().getTime());
            statement.setString(3, entity.getType());
            statement.setLong(4,entity.getId());
            if (statement.executeUpdate() == 1){
                rez = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez;
    }

    @Override
    public boolean delete(Pet entity) {
        boolean rez = false;
        try (Connection connection = DbUtil.getConnectionFromPool()){
            PreparedStatement statement = connection.prepareStatement(DELETE_Pet_SQL);
            statement.setLong(1,entity.getId());
            if (statement.executeUpdate() == 1){
                rez = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez;
    }
}
