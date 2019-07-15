package rvelikorod.dao;

import rvelikorod.entity.Visit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class VisitDAO extends DAO<Visit>
{
  private static final String INSERT_VISIT_SQL = "INSERT INTO visit (date, doctorId, clientId, petId, description, charge) VALUES (?, ?, ?, ?, ?, ?)";
  private static final String SELECT_VISIT_SQL = "SELECT id, date, doctorId, clientId, petId, description, charge FROM visit WHERE id = ?";
  private static final String SELECT_ALL_VISITS_SQL = "SELECT * FROM visit";
  private static final String UPDATE_VISIT_SQL = "UPDATE visit SET date = ?, doctorId = ?, clientId = ?, petId = ?, description = ?, charge = ? WHERE id = ?";
  private static final String DELETE_VISIT_SQL = "DELETE FROM visit WHERE id = ?";
  @Override
  public Visit create(Visit visit)
  {
    try(Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement preparedStatement = con.prepareStatement(INSERT_VISIT_SQL);
      preparedStatement.setLong(1, visit.getDate().getTime());
      preparedStatement.setLong(2, visit.getDoctor().getId());
      preparedStatement.setLong(3, visit.getClient().getId());
      preparedStatement.setLong(4, visit.getPet().getId());
      preparedStatement.setString(5, visit.getDescription());
      preparedStatement.setLong(6, visit.getCharge());
      preparedStatement.execute();

      visit.setId(getKey(preparedStatement));
      con.close();
      return visit;
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      return null;
    }

  }

  @Override
  public Visit read(long id)
  {
    try(Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement preparedStatement = con.prepareStatement(SELECT_VISIT_SQL);
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      resultSet.next();
      Date date = new Date(resultSet.getLong("date"));
      long doctorId = resultSet.getLong("doctorId");
      long clientId = resultSet.getLong("clientId");
      long petId = resultSet.getLong("petId");
      String description = resultSet.getString("description");
      long charge = resultSet.getLong("charge");
      DoctorDAO doctorDAO = new DoctorDAO();
      ClientDAO clientDAO = new ClientDAO();
      PetDAO petDAO = new PetDAO();
      con.close();
      return new Visit(id, date, doctorDAO.read(doctorId), clientDAO.read(clientId), petDAO.read(petId), description, charge);
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public ArrayList<Visit> readAll()
  {
    ArrayList<Visit> visits = new ArrayList<>();
    try(Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_VISITS_SQL);
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next())
      {
        long id = resultSet.getLong("id");
        Date date = new Date(resultSet.getLong("date"));
        long doctorId = resultSet.getLong("doctorId");
        long clientId = resultSet.getLong("clientId");
        long petId = resultSet.getLong("petId");
        String description = resultSet.getString("description");
        long charge = resultSet.getLong("charge");
        DoctorDAO doctorDAO = new DoctorDAO();
        ClientDAO clientDAO = new ClientDAO();
        PetDAO petDAO = new PetDAO();
        visits.add(new Visit(id, date, doctorDAO.read(doctorId), clientDAO.read(clientId), petDAO.read(petId), description, charge));
      }
      con.close();
      return visits;
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(Visit visit)
  {
    try(Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement preparedStatement = con.prepareStatement(UPDATE_VISIT_SQL);
      preparedStatement.setLong(1, visit.getDate().getTime());
      preparedStatement.setLong(2, visit.getDoctor().getId());
      preparedStatement.setLong(3, visit.getClient().getId());
      preparedStatement.setLong(4, visit.getPet().getId());
      preparedStatement.setString(5, visit.getDescription());
      preparedStatement.setLong(6, visit.getCharge());
      preparedStatement.setLong(7, visit.getId());
      preparedStatement.execute();
      con.close();
      return true;
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean delete(Visit visit)
  {
    try(Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement preparedStatement = con.prepareStatement(DELETE_VISIT_SQL);
      preparedStatement.setLong(1, visit.getId());
      preparedStatement.execute();
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
