package dao;

import entity.Client;
import entity.Visit;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VisitDAO extends DAO<Visit>
{
  public static final String INSERT_CLIENT_SQL = "INSERT INTO client (name, surname, address_id, date_of_birth, phone_nr) VALUES (?, ?, ?, ?, ?)";
  public static final String INSERT_VISIT_SQL = "INSERT INTO visit (birthdate, client_id, pet_id, doc_id, description, charge) VALUES (?, ?, ?, ?, ?, ?)";

  public long getClient_id(Connection con, Client client) throws SQLException
  {
    long client_id = 0;
    PreparedStatement statement = con.prepareStatement("");
    return client_id;
  }
  @Override
  public Visit create(Visit entity)
  {
    return null;
  }

  @Override
  public Visit read(long id)
  {
    return null;
  }

  @Override
  public List<Visit> readAll()
  {
    return null;
  }

  @Override
  public boolean update(Visit entity) throws SQLException {
      boolean rezult = false;
      Connection con = DbUtil.getConnectionFromPool();
      PreparedStatement statement = con.prepareStatement("UPDATE visit SET birthDate = ?," +
              "");


    return false;
  }

  @Override
  public boolean delete(Visit entity)
  {
    return false;
  }
}
