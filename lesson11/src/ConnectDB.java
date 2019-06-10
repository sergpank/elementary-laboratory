import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB
{
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
    Connection connection = null;
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
}
