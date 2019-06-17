package homework26.dao;

import homework26.entity.*;
import homework26.entity.builder.VisitBuilder;
import homework26.util.IConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitDao extends AbstractDao<Visit>
{
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  private static final String CREATE_QUERY =
      "INSERT INTO visit (visitDate, description, charge, doctorId, petId) " +
          "VALUES (?, ?, ?, ?, ?);";

  private static final String DELETE_QUERY =
      "DELETE FROM visit WHERE id=?;";

  private static final String READ_QUERY =
      "SELECT * FROM visitView WHERE visitId=?;";

  private static final String READ_ALL_QUERY =
      "SELECT * FROM visitView " +
          "ORDER BY visitId DESC;";

  private static final String UPDATE_QUERY =
      "UPDATE visit " +
          "SET visitDate=?, description=?, charge=?, doctorId=?, petId=? " +
          "WHERE id=?;";

  public VisitDao(IConnectionFactory factory)
  {
    super(factory);
  }

  @Override
  public Visit create(Visit item)
  {
    Visit result = null;

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement st = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS))
    {
      st.setString(1, DateConverter.dateToString(item.getVisitDate()));
      st.setString(2, item.getDescription());
      st.setLong(3, item.getCharge());
      st.setLong(4, item.getDoctor().getId());
      st.setLong(5, item.getPatient().getId());
      if (st.executeUpdate() > 0)
      {
        long id = lastInsertId(st);
        result = new VisitBuilder().copyProps(item).setId(id).build();
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
  public Visit read(long key)
  {
    Visit result = null;

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement st = conn.prepareStatement(READ_QUERY))
    {
      st.setLong(1, key);

      ResultSet resultSet = st.executeQuery();
      if (resultSet != null && resultSet.next())
      {
        result = DaoHelper.readVisit(resultSet);
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
  public List<Visit> read()
  {
    List<Visit> result = new ArrayList<>();

    try (Connection conn = connectionFactory.getConnection();
         Statement st = conn.createStatement())
    {
      ResultSet resultSet = st.executeQuery(READ_ALL_QUERY);

      while (resultSet != null && resultSet.next())
      {

        Visit visit = DaoHelper.readVisit(resultSet);

        result.add(visit);
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
  public boolean update(Visit item)
  {
    boolean result = false;

    if (item.getId() > 0 && item.getDoctor().getId() > 0 && item.getPatient().getId() > 0 && item.getClient().getId() > 0)
    {
      try (Connection conn = connectionFactory.getConnection();
           PreparedStatement st = conn.prepareStatement(UPDATE_QUERY))
      {
        st.setString(1, DateConverter.dateToString(item.getVisitDate()));
        st.setString(2, item.getDescription());
        st.setLong(3, item.getCharge());
        st.setLong(4, item.getDoctor().getId());
        st.setLong(5, item.getPatient().getId());
        st.setLong(6, item.getId());

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

}
