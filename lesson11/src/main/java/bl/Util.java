package bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util
{
  public static Connection getConnection()
  {
    Connection connection = null;
    try
    {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:users.sqlite3");
    }
    catch (ClassNotFoundException | SQLException e)
    {
      e.printStackTrace();
      System.out.println("Connection ERROR");
    }


    return connection;
  }
}
