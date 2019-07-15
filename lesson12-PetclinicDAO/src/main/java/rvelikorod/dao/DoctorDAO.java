package rvelikorod.dao;

import rvelikorod.entity.Doctor;
import rvelikorod.entity.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DoctorDAO extends DAO<Doctor>
{
  private static final String INSERT_DOCTOR_SQL = "INSERT INTO doctor (name, surname, birthDate, phoneNr) VALUES (?, ?, ?, ?)";
  private static final String SELECT_DOCTOR_SQL = "SELECT name, surname, birthDate, phoneNr FROM doctor" +
      "  WHERE id = ? ";
  private static final String SELECT_ALL_DOCTORS_SQL = "SELECT id, name, surname, birthDate, phoneNr FROM doctor";
  private static final String SELECT_PATIENTS_LIST_SQL = "SELECT p.id, p.name, p.birthDate, p.type, p.masterId " +
      "  FROM clients_pets_doctors cpd INNER JOIN pet p ON cpd.petId = p.id WHERE cpd.doctorId = ?";
  private static final String UPDATE_DOCTOR_SQL = "UPDATE doctor SET name = ?, surname = ?, birthDate = ?, phoneNr = ? WHERE id = ?";
  private static final String DELETE_DOCTOR_SQL = "DELETE FROM doctor WHERE id = ?";
  private static final String INSERT_DOCTOR_TO_CPD = "UPDATE clients_pets_doctors SET doctorId = ? WHERE petId = ?";
  @Override
  public Doctor create(Doctor doctor)
  {
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(INSERT_DOCTOR_SQL);
      pStmt.setString(1, doctor.getName());
      pStmt.setString(2, doctor.getSurname());
      pStmt.setLong(3, doctor.getBirthDate().getTime());
      pStmt.setString(4, doctor.getPhoneNr());
      pStmt.execute();
      doctor.setId(getKey(pStmt));
      for (Pet p:doctor.getPatients())
      {
        insertDoctorToCpd(con, doctor.getId(), p.getId());
      }
      con.close();
      return doctor;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }
  private void insertDoctorToCpd(Connection connection, long doctorId, long petId)
  {
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOCTOR_TO_CPD);
      preparedStatement.setLong(1, doctorId);
      preparedStatement.setLong(2, petId);
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  @Override
  public Doctor read(long id)
  {
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmnt = con.prepareStatement(SELECT_DOCTOR_SQL);
      pStmnt.setLong(1, id);
      ResultSet resultSet = pStmnt.executeQuery();
      resultSet.next();
      String name = resultSet.getString("name");
      String surname = resultSet.getString("surname");
      Date birthDate = new Date(resultSet.getLong("birthDate"));
      String phoneNr = resultSet.getString("phoneNr");
      ArrayList <Pet> pets = getPatients(con, id);
      con.close();
      return new Doctor(id, name, surname, birthDate, phoneNr, pets);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public ArrayList<Doctor> readAll()
  {
    ArrayList<Doctor> doctors = new ArrayList<>();
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmnt = con.prepareStatement(SELECT_ALL_DOCTORS_SQL);
      ResultSet resultSet = pStmnt.executeQuery();
      while(resultSet.next())
      {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        Date birthDate = new Date(resultSet.getLong("birthDate"));
        String phoneNr = resultSet.getString("phoneNr");
        doctors.add(new Doctor(id, name, surname, birthDate, phoneNr, getPatients(con, id)));
      }
      con.close();
      return doctors;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(Doctor doctor)
  {
    try (Connection con = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmnt = con.prepareStatement(UPDATE_DOCTOR_SQL);
      pStmnt.setString(1, doctor.getName());
      pStmnt.setString(2, doctor.getSurname());
      pStmnt.setLong(3, doctor.getBirthDate().getTime());
      pStmnt.setString(4, doctor.getPhoneNr());
      pStmnt.setLong(5, doctor.getId());
      pStmnt.execute();
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
  public boolean delete(Doctor doctor)
  {
    try(Connection connection = util.DbUtil.getConnectionFromPool())
    {
      PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTOR_SQL);
      preparedStatement.setLong(1, doctor.getId());
      preparedStatement.execute();
      connection.close();
      return true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return false;
    }
  }
  private ArrayList<Pet> getPatients(Connection con, long doctorId)
  {
    ArrayList<Pet> pets = new ArrayList<>();
    try
    {
      PreparedStatement pstm = con.prepareStatement(SELECT_PATIENTS_LIST_SQL);
      pstm.setLong(1, doctorId);
      ResultSet resultSet = pstm.executeQuery();
      while(resultSet.next())
      {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Date birthDate = new Date(resultSet.getLong("birthDate"));
        String type = resultSet.getString("type");
        Long masterId = resultSet.getLong("masterId");
        pets.add(new Pet(id, name, birthDate, type, masterId));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return pets;
  }
}
