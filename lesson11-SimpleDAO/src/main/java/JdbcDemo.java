import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
    loadDriver();

    Connection connection = getConnection();
    try
    {
//      Statement statement = connection.createStatement();
//      String userLogin = "alex";
//      ResultSet resultSet = statement.executeQuery("SELECT * from USERS WHERE login = '" + userLogin + "'");

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USERS WHERE login = ?");
      preparedStatement.setString(1, "alex");
      ResultSet resultSet = preparedStatement.executeQuery();

      List<User> users = new ArrayList<>();

      while (resultSet.next())
      {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");

        users.add(new User(id, name, login, password));
      }

      users.forEach(System.out::println);

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      connection.close();
    }
  }

  private static void loadDriver()
  {
    try
    {
      Class.forName("org.sqlite.JDBC");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private static Connection getConnection()
  {
    Connection connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:sqlite:test.sqlite3");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return connection;
  }
}
