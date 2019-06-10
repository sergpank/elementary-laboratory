package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil
{
  private static final String PROTOCOL = "jdbc:sqlite:";
  private static final String DB_LOCATION = "lesson12/resources/DB.sqlite3";

  private static HikariDataSource dataSource;

  private static void init()
  {
    HikariConfig config = new HikariConfig();
    config.setPoolName("SQLitePool");
    config.setDriverClassName("org.sqlite.JDBC");
    config.setJdbcUrl(PROTOCOL + DB_LOCATION);
    config.setConnectionTestQuery("SELECT 1");
    config.setMaxLifetime(60000); // 60 Sec
    config.setIdleTimeout(45000); // 45 Sec
    config.setMaximumPoolSize(50); // 50 Connections (including idle connections)
    dataSource = new HikariDataSource(config);
  }

  public static Connection getConnectionFromPool()
  {
    Connection connection = null;
    if(dataSource == null)
    {
      init();
    }

    try
    {
      connection = dataSource.getConnection();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return connection;
  }

  /**
   * Plain JDBC Connection
   *
   * @return Connection to Database. NOTE: this connection is not pooled, so don't forget
   * to close it when the work is done.
   */
  public static Connection getJdbcConnection()
  {
    Connection connection = null;
    try
    {
      String url = PROTOCOL + DB_LOCATION;
      connection = DriverManager.getConnection(url);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return connection;
  }
}
