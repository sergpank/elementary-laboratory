import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientDAO implements DAO
{
  public boolean create(Client client) throws SQLException
  {
    Statement statement = connection.createStatement();
    if(client.address_id == 0)
    {
      statement.executeUpdate("INSERT INTO Client (name, surname, address_id, date_of_birth, phone_number) VALUES ('" + client.name + "','" + client.surname + "','"
          + null + "','" + client.date_of_birth + "','" + client.phone_number + "')");
    }
    else
    {
      statement.executeUpdate("INSERT INTO Client (name, surname, address_id, date_of_birth, phone_number) VALUES ('" + client.name + "','" + client.surname + "','"
          + client.address_id + "','" + client.date_of_birth + "','" + client.phone_number + "')");
    }
    statement.close();
    return true;
  }

  public Client read(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Client WHERE id = '" + id + "'");
    Client client = new Client(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getInt("address_id"),
        resultSet.getString("date_of_birth"), resultSet.getString("phone_number"));
    statement.close();
    return client;
  }

  public ArrayList<Client> read() throws SQLException
  {
    Statement statement = connection.createStatement();
    ArrayList<Client> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Client");

    while(resultSet.next())
    {
      Client user = new Client(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getInt("address_id"),
          resultSet.getString("date_of_birth"), resultSet.getString("phone_number"));
      list.add(user);
    }
    statement.close();
    return list;

  }

  public boolean update(Client client, long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("UPDATE Client SET name = '" + client.name + "', surname = '" + client.surname + "', address_id = '" + client.address_id + "'," +
        "date_of_birth = '" + client.date_of_birth + "', phone_number = '" + client.phone_number + "' WHERE id = '" + id + "'");
    statement.close();
    return true;

  }

  public boolean delete(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("DELETE FROM Client WHERE id = '" + id + "'");
    statement.close();
    return true;
  }
}
