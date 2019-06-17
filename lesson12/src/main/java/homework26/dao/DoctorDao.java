package homework26.dao;

import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Doctor;
import homework26.entity.Pet;
import homework26.entity.builder.DoctorBuilder;
import homework26.util.IConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao extends AbstractDao<Doctor>
{
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  private static final String CREATE_QUERY =
      "INSERT INTO doctor (name, surname, phoneNr, birthDate) " +
          "VALUES(?, ?, ?, ?);";

  private static final String DELETE_QUERY =
      "DELETE FROM doctor " +
          "WHERE id=?;";

  private static final String UPDATE_QUERY =
      "UPDATE doctor " +
          "SET name=?, surname=?, phoneNr=?, birthDate=? " +
          "WHERE id=?;";

  private static final String READ_QUERY =
      "SELECT id AS doctorId, " +
          "name AS doctorName, " +
          "surname AS doctorSurname, " +
          "phoneNr AS doctorPhoneNr, " +
          "birthDate AS doctorBirthDate " +
          "FROM doctor " +
          "WHERE id=?;";

  private static final String READ_ALL_QUERY =
      "SELECT id AS doctorId, " +
          "name AS doctorName, " +
          "surname AS doctorSurname, " +
          "phoneNr AS doctorPhoneNr, " +
          "birthDate AS doctorBirthDate " +
          "FROM doctor " +
          "ORDER BY doctorSurname, doctorName;";

  private static final String READ_PATIENTS_QUERY =
      "SELECT * FROM visitView WHERE doctorId=? " +
          "ORDER BY petName, surname;";

  public DoctorDao(IConnectionFactory factory)
  {
    super(factory);
  }

  @Override
  public Doctor create(Doctor item)
  {
    Doctor result = null;

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement st = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS))
    {
      st.setString(1, item.getName());
      st.setString(2, item.getSurname());
      st.setString(3, item.getPhoneNr());
      st.setString(4, DateConverter.dateToString(item.getBirthDate()));

      if (st.executeUpdate() > 0)
      {
        long id = lastInsertId(st);

        result = new DoctorBuilder().copyProps(item).setId(id).build();
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public Doctor read(long key)
  {
    Doctor result = null;

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement st = conn.prepareStatement(READ_QUERY))
    {
      st.setLong(1, key);
      ResultSet rs = st.executeQuery();
      if (rs != null && rs.next())
      {
        long doctorId = rs.getLong("doctorId");
        List<Pet> patients = getPatients(conn, doctorId);
        result = DaoHelper.readDoctor(rs, patients);
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public List<Doctor> read()
  {
    List<Doctor> result = new ArrayList<>();

    try (Connection conn = connectionFactory.getConnection();
         Statement st = conn.createStatement())
    {
      ResultSet rs = st.executeQuery(READ_ALL_QUERY);
      while (rs != null && rs.next())
      {
        long doctorId = rs.getLong("doctorId");
        List<Pet> patients = getPatients(conn, doctorId);

        Doctor doctor = DaoHelper.readDoctor(rs, patients);

        result.add(doctor);
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public boolean update(Doctor item)
  {
    boolean result = false;

    if (item.getId() > 0)
    {
      try (Connection conn = connectionFactory.getConnection();
           PreparedStatement st = conn.prepareStatement(UPDATE_QUERY))
      {
        st.setString(1, item.getName());
        st.setString(2, item.getSurname());
        st.setString(3, item.getPhoneNr());
        st.setString(4, DateConverter.dateToString(item.getBirthDate()));
        st.setLong(5, item.getId());
        if (st.executeUpdate() > 0)
        {
          result = true;
        }
      }
      catch (SQLException e)
      {
        for (Throwable t : e)
        {
          t.printStackTrace();
        }
      }
    }

    return result;
  }

  @Override
  public boolean delete(long key)
  {
    boolean result = false;

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement st = conn.prepareStatement(DELETE_QUERY))
    {
      st.setLong(1, key);
      if (st.executeUpdate() > 0)
      {
        result = true;
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }

    return result;
  }

  private List<Pet> getPatients(Connection conn, long doctorId) throws SQLException, IllegalAccessException
  {
    List<Pet> result = new ArrayList<>();

    PreparedStatement st = conn.prepareStatement(READ_PATIENTS_QUERY);
    st.setLong(1, doctorId);
    ResultSet resultSet = st.executeQuery();

    while (resultSet != null && resultSet.next())
    {
      Client master = DaoHelper.readClient(resultSet, null);

      Pet pet = DaoHelper.readPet(resultSet, master);

      result.add(pet);
    }

    return result;
  }


}
