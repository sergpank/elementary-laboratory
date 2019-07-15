package rvelikorod.dao;


import rvelikorod.entity.Address;
import rvelikorod.entity.Client;
import rvelikorod.entity.Pet;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class ClientDAO extends DAO<Client>
{
  private static final String INSERT_ADDRESS_SQL = "INSERT INTO address (street, house, apartmentNr, zip) VALUES (?, ?, ?, ?)";
  private static final String INSERT_CLIENT_SQL = "INSERT INTO client (name, surname, address_id, date_of_birth, phone_nr) VALUES (?, ?, ?, ?, ?)";
  private static final String SELECT_CLIENT_SQL = "SELECT c.id, c.name, c.surname, c.date_of_birth, c.phone_nr, c.address_id, " +
      "  a.street, a.house, a.apartmentNr, a.zip" +
      "  FROM client c" +
      "  INNER JOIN address a on c.address_id = a.id" +
      "  WHERE c.id = ? ";
  private static final String SELECT_ALL_CLIENTS_SQL = "SELECT c.id, c.name, c.surname, c.date_of_birth, c.phone_nr, c.address_id, " +
      "  a.street, a.house, a.apartmentNr, a.zip" +
      "  FROM client c" +
      "  INNER JOIN address a on c.address_id = a.id";
  private static final String SELECT_PET_LIST_SQL = "SELECT p.id, p.name, p.birthDate, p.type, p.masterId " +
      "  FROM clients_pets_doctors cpd INNER JOIN pet p ON cpd.petId = p.id WHERE cpd.clientId = ?";
  private static final String UPDATE_CLIENT_SQL = "UPDATE client SET name = ?, surname = ?, address_id = ?, date_of_birth = ?, phone_nr = ? WHERE id = ?";
  private static final String DELETE_CLIENT_SQL = "DELETE FROM client WHERE id = ?";
  private static final String INSERT_CLIENT_TO_CPD = "INSERT INTO clients_pets_doctors (clientId) VALUES (?)";

  @Override
  public Client create(Client client)
  {
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      long addressId = saveAddress(client.getAddress(), con);

      PreparedStatement pStmt = con.prepareStatement(INSERT_CLIENT_SQL);
      pStmt.setString(1, client.getName());
      pStmt.setString(2, client.getSurname());
      pStmt.setLong(3, addressId);
      pStmt.setLong(4, client.getBirthDate().getTime());
      pStmt.setString(5, client.getPhoneNr());

      pStmt.execute();
      long clientId = getKey(pStmt);
      client.setId(clientId);
      insertToCPD(con, clientId);
      con.close();
      return client;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  private void insertToCPD(Connection connection, Long clientId)
  {
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_TO_CPD);
      preparedStatement.setLong(1, clientId);
      preparedStatement.execute();

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private long saveAddress(Address address, Connection con) throws SQLException
  {
    PreparedStatement pStmt = con.prepareStatement(INSERT_ADDRESS_SQL);

    pStmt.setString(1, address.getStreet());
    pStmt.setString(2, address.getHouse());
    pStmt.setLong(3, address.getApartmentNr());
    pStmt.setLong(4, address.getZip());

    pStmt.executeUpdate();
    long key = getKey(pStmt);
    address.setId(key);

    return key;
  }

  private ArrayList<Pet> getPets(Connection con, long clientId)
  {
    ArrayList<Pet> pets = new ArrayList<>();
    try
    {
      PreparedStatement pstm = con.prepareStatement(SELECT_PET_LIST_SQL);
      pstm.setLong(1, clientId);
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

  @Override
  public Client read(long id)
  {
    Client client = null;
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(SELECT_CLIENT_SQL);
      pStmt.setLong(1, id);

      ResultSet resultSet = pStmt.executeQuery();
      while (resultSet.next())
      {
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        Date birthDate = new Date(resultSet.getLong("date_of_birth"));
        String phoneNr = resultSet.getString("phone_nr");

        long aId = resultSet.getLong("address_id");
        String street = resultSet.getString("street");
        String house = resultSet.getString("house");
        long apartmentNr = resultSet.getLong("apartmentNr");
        long zip = resultSet.getLong("zip");
        ArrayList <Pet> pets = getPets(con, id);
        con.close();
        client = new Client(id, name, surname, new Address(aId, street, house, apartmentNr, zip), birthDate, phoneNr, pets);
      }

      con.close();
      return client;

    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public ArrayList<Client> readAll()
  {
    ArrayList<Client> clients = new ArrayList<>();
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      PreparedStatement pStmt = con.prepareStatement(SELECT_ALL_CLIENTS_SQL);

      ResultSet resultSet = pStmt.executeQuery();
      while (resultSet.next())
      {
        long cId = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        Date birthDate = new Date(resultSet.getLong("date_of_birth"));
        String phoneNr = resultSet.getString("phone_nr");

        long aId = resultSet.getLong("address_id");
        String street = resultSet.getString("street");
        String house = resultSet.getString("house");
        long apartmentNr = resultSet.getLong("apartmentNr");
        long zip = resultSet.getLong("zip");

        clients.add(new Client(cId, name, surname, new Address(aId, street, house, apartmentNr, zip), birthDate, phoneNr, getPets(con, cId)));
      }
      con.close();
      return clients;

    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(Client client)
  {
    try (Connection con = DbUtil.getConnectionFromPool())
    {
      long addressId = saveAddress(client.getAddress(), con);

      PreparedStatement pStmt = con.prepareStatement(UPDATE_CLIENT_SQL);
      pStmt.setString(1, client.getName());
      pStmt.setString(2, client.getSurname());
      pStmt.setLong(3, addressId);
      pStmt.setLong(4, client.getBirthDate().getTime());
      pStmt.setString(5, client.getPhoneNr());
      pStmt.setLong(6, client.getId());

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
  public boolean delete(Client client)
  {
    try (Connection con = DbUtil.getConnectionFromPool())
    {

      PreparedStatement pStmt = con.prepareStatement(DELETE_CLIENT_SQL);
      pStmt.setLong(1, client.getId());
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
