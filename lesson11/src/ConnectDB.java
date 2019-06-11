import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB
{
  private static Connection connection;

  public static void main(String[] args)
  {
  loadDriver();
  }
  public static void  loadDriver()
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
  public static Connection getConnection()
  {
    connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:sqlite:data/lesson11.sqlite3");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return connection;
  }

    public static void close()
    {
      if (connection != null)
      {
        try
        {
          connection.close();
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }
      }
    }
}
