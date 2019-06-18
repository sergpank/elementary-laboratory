package dao;

import entity.Visit;

import java.util.List;

public class VisitDAO extends DAO<Visit>
{
  public static final String INSERT_CLIENT_SQL = "INSERT INTO client (name, surname, address_id, date_of_birth, phone_nr) VALUES (?, ?, ?, ?, ?)";
  public static final String INSERT_VISIT_SQL = "INSERT INTO visit (birthdate, client_id, pet_id, doc_id, description, charge) VALUES (?, ?, ?, ?, ?, ?)";

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
  public boolean update(Visit entity)
  {
    return false;
  }

  @Override
  public boolean delete(Visit entity)
  {
    return false;
  }
}
