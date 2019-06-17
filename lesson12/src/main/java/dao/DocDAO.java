package dao;

import entity.Client;
import entity.Doc;
import entity.Pet;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Vaio on 17.06.19.
 */
public class DocDAO extends DAO<Doc>
{
  public static final String SELECT_Pet_SQL = "SELECT pet_id FROM visit WHERE doc_id = ?;";
  public static final String INSERT_Doc_SQL = "INSERT INTO doc (name, surname, birthdate, phone) VALUES (?,?,?,?);";
  public static final String SELECT_Doc_SQL = "SELECT id, name, surname, birthdate, phone  FROM doc WHERE id = ?;";
  public static final String SELECT_Doc_SQL_ALL = "SELECT id, name, surname, birthdate, phone  FROM doc;";

  public List<Pet> getPets(Connection con, long id)
  {
    Set<Pet> pets = new HashSet<>();
    try
    {
      PreparedStatement statement = con.prepareStatement(SELECT_Pet_SQL);
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        long pet_id = resultSet.getLong("pet_id");
        pets.add(new PetDAO().read(pet_id));
      }

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return new ArrayList<>(pets);
  }

  @Override
  public Doc create(Doc entity)
  {
    try (Connection connection = DbUtil.getConnectionFromPool())
    {
      PreparedStatement statement = connection.prepareStatement(INSERT_Doc_SQL);
      statement.setString(1, entity.getName());
      statement.setString(2, entity.getSurname());
      statement.setLong(3, entity.getBirthDate().getTime());
      statement.setLong(4, Long.parseLong(entity.getPhoneNr()));
      statement.execute();
      entity.setId(getKey(statement));
      entity.setPetList(getPets(connection, entity.getId()));
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return entity;

  }

  @Override
  public Doc read(long id)
  {
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(SELECT_Doc_SQL);
      pStmt.setLong(1, id);

      ResultSet resultSet = pStmt.executeQuery();
      resultSet.next();

      int pos = 1;
      long cId = resultSet.getLong(pos++);
      String name = resultSet.getString(pos++);
      String surname = resultSet.getString(pos++);
      Date birthDate = new Date(resultSet.getLong(pos++));
      String phoneNr = resultSet.getString(pos++);
      return new Doc(cId, name, surname, birthDate, phoneNr, getPets(con, cId));
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Doc> readAll()
  {
    List<Doc> docs = new ArrayList<>();
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(SELECT_Doc_SQL_ALL);
      ResultSet resultSet = pStmt.executeQuery();
      while (resultSet.next())
      {
        int pos = 1;
        long cId = resultSet.getLong(pos++);
        String name = resultSet.getString(pos++);
        String surname = resultSet.getString(pos++);
        Date birthDate = new Date(resultSet.getLong(pos++));
        String phoneNr = resultSet.getString(pos++);
        docs.add(new Doc(cId, name, surname, birthDate, phoneNr, getPets(con, cId)));
      }
      return docs;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(Doc entity)
  {
    return false;
  }

  @Override
  public boolean delete(Doc entity)
  {
    return false;
  }
}
