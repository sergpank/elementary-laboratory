import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressDAO implements DAO
{
  public boolean create(Address address) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("INSERT INTO Address (street, house, apartment, zip) VALUES ('" + address.street + "','" + address.house + "','"
        + address.apartments + "','" + address.zip + "')");
    statement.close();
    return true;
  }

  public Address read(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Address WHERE id = '" + id + "'");
    Address address = new Address(resultSet.getInt("id"),resultSet.getString("street"), resultSet.getInt("house"),resultSet.getInt("apartment"),resultSet.getInt("zip"));
    statement.close();
    return address;
  }

  public ArrayList<Address> read() throws SQLException
  {
    Statement statement = connection.createStatement();
    ArrayList<Address> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Address");

    while(resultSet.next())
    {
      Address address = new Address(resultSet.getInt("id"),resultSet.getString("street"), resultSet.getInt("house"),resultSet.getInt("apartment"),resultSet.getInt("zip"));
      list.add(address);
    }
    statement.close();
    return list;
  }

  public boolean update(Address address, long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("UPDATE Address SET street = '" + address.street + "', house = '" + address.house + "', apartment = '" + address.apartments +"'," +
        "zip = '" + address.zip + "' WHERE id = '" + id + "'");
    statement.close();
    return true;
  }

  public boolean delete(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("DELETE FROM Address WHERE id = '" + id + "'");
    statement.close();
    return true;
  }
}
