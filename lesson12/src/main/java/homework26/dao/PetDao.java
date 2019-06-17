package homework26.dao;

import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Pet;
import homework26.entity.builder.PetBuilder;
import homework26.util.IConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDao extends AbstractDao<Pet>
{
  private static final String CREATE_QUERY =
      "INSERT INTO pet(name, type, birthDate, masterId) " +
          "VALUES (?, ?, ?, ?);";

  private static final String DELETE_QUERY =
      "DELETE FROM pet WHERE id=?;";

  private static final String READ_QUERY =
      "SELECT *" +
          "FROM petView WHERE petId=?;";

  private static final String READ_ALL_QUERY =
      "SELECT * FROM petView " +
          "ORDER BY petName, surname;";

  private static final String UPDATE_QUERY =
      "UPDATE pet " +
          "SET name=?, type=?, birthDate=?, masterId=? " +
          "WHERE id=?;";

  public PetDao(IConnectionFactory factory)
  {
    super(factory);
  }

  @Override
  public Pet create(Pet item)
  {
    Pet result = null;


    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement st = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS))
    {
      st.setString(1, item.getName());
      st.setString(2, item.getType());
      st.setString(3, DateConverter.dateToString(item.getBirthDate()));
      st.setLong(4, item.getMaster().getId());
      if (st.executeUpdate() > 0)
      {
        long id = lastInsertId(st);
        result = new PetBuilder().copyProps(item).setId(id).build();
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
  public Pet read(long key)
  {
    Pet result = null;

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement st = conn.prepareStatement(READ_QUERY))
    {
      st.setLong(1, key);
      ResultSet rs = st.executeQuery();
      if (rs != null && rs.next())
      {
        Client master = DaoHelper.readClient(rs, null);

        result = DaoHelper.readPet(rs, master);
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
  public List<Pet> read()
  {
    List<Pet> result = new ArrayList<>();

    try (Connection conn = connectionFactory.getConnection();
         Statement st = conn.createStatement())
    {
      ResultSet rs = st.executeQuery(READ_ALL_QUERY);
      while (rs != null && rs.next())
      {
        Client master = DaoHelper.readClient(rs, null);

        Pet pet = DaoHelper.readPet(rs, master);

        result.add(pet);

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
  public boolean update(Pet item)
  {
    boolean result = false;

    if (item.getId() > 0 && item.getMaster().getId() > 0)
    {
      try (Connection conn = connectionFactory.getConnection();
           PreparedStatement st = conn.prepareStatement(UPDATE_QUERY))
      {
        st.setString(1, item.getName());
        st.setString(2, item.getType());
        st.setString(3, DateConverter.dateToString(item.getBirthDate()));
        st.setLong(4, item.getMaster().getId());
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
}
