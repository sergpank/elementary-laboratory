package fedorov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB
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

  public static Connection getConnection(String path)
  {
    connection = null;
    try
    {
      connection = DriverManager.getConnection(path);
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
