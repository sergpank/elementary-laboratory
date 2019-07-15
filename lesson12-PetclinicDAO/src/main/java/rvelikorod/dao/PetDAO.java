package rvelikorod.dao;


import rvelikorod.entity.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class PetDAO extends DAO<Pet>
{
  private static final String INSERT_PET_SQL = "INSERT INTO pet (name, birthDate, type, masterId) VALUES (?, ?, ?, ?)";
  private static final String SELECT_PET_SQL = "SELECT id, name, birthDate, type, masterId FROM pet" +
      "  WHERE id = ? ";
  private static final String SELECT_ALL_PETS_SQL = "SELECT id, name, birthDate, type, masterId FROM pet";
  private static final String UPDATE_PET_SQL = "UPDATE pet SET name = ?, birthDate = ?, type = ?, masterId = ? WHERE id = ?";
  private static final String DELETE_PET_SQL = "DELETE FROM pet WHERE id = ?";
  private static final String INSERT_DATA_TO_CPD = "UPDATE clients_pets_doctors SET petId = ? WHERE clientId = ?";

  @Override
  public Pet create(Pet pet)
  {
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(INSERT_PET_SQL);
      pStmt.setString(1, pet.getName());
      pStmt.setLong(2, pet.getBirthDate().getTime());
      pStmt.setString(3, pet.getType());
      pStmt.setLong(4, pet.getMasterId());

      pStmt.execute();

      pet.setId(getKey(pStmt));
      insertIdToCPD(con, pet.getId(), pet.getMasterId());
      con.close();
      return pet;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }
  private void insertIdToCPD(Connection connection, long petID, long clientID)
  {
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA_TO_CPD);
      preparedStatement.setLong(1, petID);
      preparedStatement.setLong(2, clientID);
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public Pet read(long id)
  {
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(SELECT_PET_SQL);
      pStmt.setLong(1, id);

      ResultSet resultSet = pStmt.executeQuery();
      resultSet.next();

      String name = resultSet.getString("name");
      Date birthDate = new Date(resultSet.getLong("birthDate"));
      String type = resultSet.getString("type");
      long masterId = resultSet.getLong("masterId");

      con.close();
      return new Pet(id, name, birthDate, type, masterId);

    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public ArrayList<Pet> readAll()
  {
    ArrayList<Pet> pets = new ArrayList<>();
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(SELECT_ALL_PETS_SQL);

      ResultSet resultSet = pStmt.executeQuery();
      while (resultSet.next())
      {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Date birthDate = new Date(resultSet.getLong("birthDate"));
        String type = resultSet.getString("type");
        long masterId = resultSet.getLong("masterId");
        pets.add(new Pet(id, name, birthDate, type, masterId));
      }
      con.close();
      return pets;

    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(Pet pet)
  {
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(UPDATE_PET_SQL);
      pStmt.setString(1, pet.getName());
      pStmt.setLong(2, pet.getBirthDate().getTime());
      pStmt.setString(3, pet.getType());
      pStmt.setLong(4, pet.getMasterId());
      pStmt.setLong(5, pet.getId());

      pStmt.execute();
      con.close();
      return true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean delete(Pet pet)
  {
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {

      PreparedStatement pStmt = con.prepareStatement(DELETE_PET_SQL);
      pStmt.setLong(1, pet.getId());
      pStmt.execute();
      con.close();
      return true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return false;
    }
  }
}
