package homework26.dao;

import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Pet;
import homework26.entity.builder.AddressBulder;
import homework26.entity.builder.ClientBuilder;
import homework26.util.IConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao extends AbstractDao<Client>
{
  private static final String CREATE_ADDRESS_QUERY =
      "INSERT INTO address(street, houseNr, appartmentNr, zip)" +
          " VALUES(?, ?, ?, ?);";

  private static final String CREATE_QUERY =
      "INSERT INTO client(name, surname, phoneNr, birthDate, addressId) " +
          "VALUES (?, ?, ?, ?, ?);";

  private static final String DELETE_QUERY =
      "DELETE " +
          "FROM address " +
          "WHERE id IN " +
          "(SELECT addressId FROM client WHERE id=?);";

  private static final String READ_PETS_QUERY =
      "SELECT id AS petId, name AS petName, type AS petType, birthDate AS petBirthDate " +
          "FROM pet WHERE masterId=? " +
          "ORDER BY petName;";

  private static final String READ_QUERY =
      "SELECT * FROM clientView WHERE masterId=?;";

  private static final String READ_ALL_QUERY =
      "SELECT * FROM clientView " +
          "ORDER BY surname, masterName;";

  private static final String UPDATE_ADDRESS_QUERY =
      "UPDATE address " +
          "SET street=?, houseNr=?, appartmentNr=?, zip=?" +
          " WHERE id=?;";

  private static final String UPDATE_QUERY =
      "UPDATE client " +
          "SET name=?, surname=?, phoneNr=?, birthDate=?" +
          "WHERE id=?;";

  public ClientDao(IConnectionFactory factory)
  {
    super(factory);
  }

  @Override
  public Client create(Client item)
  {
    Client result = null;
    Address address = item.getAddress();

    try (Connection conn = connectionFactory.getConnection())
    {
      long addressId = createAddress(conn, item.getAddress());

      if (addressId > 0)
      {
        long clientId = createClient(conn, item, addressId);

        if (clientId > 0)
        {
          Address addr = new AddressBulder().copyProps(item.getAddress()).setId(addressId).build();

          result = new ClientBuilder().copyProps(item).setAddress(addr).setId(clientId).build();
        }
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return result;
  }

  @Override
  public Client read(long key)
  {
    Client result = null;

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement st = conn.prepareStatement(READ_QUERY))
    {
      st.setLong(1, key);
      ResultSet resultSet = st.executeQuery();
      if (resultSet != null && resultSet.next())
      {
        long id = resultSet.getLong("masterId");

        List<Pet> pets = getPets(conn, id);

        result = DaoHelper.readClient(resultSet, pets);
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return result;
  }

  @Override
  public List<Client> read()
  {
    List<Client> result = new ArrayList<>();

    try (Connection conn = connectionFactory.getConnection();
         Statement st = conn.createStatement())
    {
      ResultSet resultSet = st.executeQuery(READ_ALL_QUERY);
      while (resultSet != null && resultSet.next())
      {
        long id = resultSet.getLong("masterId");

        List<Pet> pets = getPets(conn, id);

        Client client = DaoHelper.readClient(resultSet, pets);

        result.add(client);
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return result;
  }

  @Override
  public boolean update(Client item)
  {
    boolean result = false;

    Address addr = item.getAddress();

    if (item.getId() > 0)
    {
      try (Connection conn = connectionFactory.getConnection())
      {
        PreparedStatement st = conn.prepareStatement(UPDATE_ADDRESS_QUERY);

        prepareStatementForAddress(st, addr);

        st.setLong(5, addr.getId());

        if (st.executeUpdate() > 0)
        {
          st.close();
          st = conn.prepareStatement(UPDATE_QUERY);

          prepareStatementForClient(st, item);

          st.setLong(5, item.getId());

          if (st.executeUpdate() > 0)
          {
            result = true;
          }
          else
          {
            st.close();
          }
        }
        else
        {
          st.close();
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

    try (Connection conn = connectionFactory.getConnection())
    {
      PreparedStatement st = conn.prepareStatement(DELETE_QUERY);
      st.setLong(1, key);
      if (st.executeUpdate() > 0)
      {
        st.close();
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

  private long createAddress(Connection conn, Address address) throws SQLException
  {
    long addressId = 0;

    PreparedStatement statement = conn.prepareStatement(CREATE_ADDRESS_QUERY, Statement.RETURN_GENERATED_KEYS);

    prepareStatementForAddress(statement, address);

    if (statement.executeUpdate() > 0)
    {
      addressId = lastInsertId(statement);
    }
    statement.close();

    return addressId;
  }

  private long createClient(Connection conn, Client client, long addressId) throws SQLException
  {
    long clientId = 0;

    PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);

    prepareStatementForClient(statement, client);

    statement.setLong(5, addressId);
    if (statement.executeUpdate() > 0)
    {
      clientId = lastInsertId(statement);
    }
    statement.close();

    return clientId;
  }

  private List<Pet> getPets(Connection conn, long masterId) throws SQLException, IllegalAccessException
  {
    List<Pet> result = new ArrayList<>();

    PreparedStatement st = conn.prepareStatement(READ_PETS_QUERY);

    st.setLong(1, masterId);
    ResultSet resultSet = st.executeQuery();
    while (resultSet.next())
    {
      result.add(DaoHelper.readPet(resultSet, null));
    }

    return result;
  }

  private void prepareStatementForAddress(PreparedStatement statement, Address address) throws SQLException
  {
    statement.setString(1, address.getStreet());
    statement.setString(2, address.getHouseNr());
    statement.setString(3, address.getAppartmentNr());
    statement.setInt(4, address.getZip());
  }

  private void prepareStatementForClient(PreparedStatement statement, Client client) throws SQLException
  {
    statement.setString(1, client.getName());
    statement.setString(2, client.getSurname());
    statement.setString(3, client.getPhoneNr());
    statement.setString(4, DateConverter.dateToString(client.getBirthDate()));

  }

}
