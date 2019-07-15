package rvelikorod.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil
{
  private static final Logger log = LogManager.getLogger(DbUtil.class);

  private static final String PROTOCOL = "jdbc:sqlite:";
  private static final String DB_NAME = "db.name";

  private static HikariDataSource dataSource;

  public static void init(String dbFilePath)
  {
    //final String dbFilePath = DbUtil.class.getClassLoader().getResource(dbName).getFile();

    log.debug("Db file path : {}", dbFilePath);

    final String dbPath = dbFilePath.replaceAll("%20", " ");

    HikariConfig config = new HikariConfig();
    config.setPoolName("SQLitePool");
    config.setDriverClassName("org.sqlite.JDBC");
    config.setJdbcUrl(PROTOCOL + dbPath);
    config.setConnectionTestQuery("SELECT 1");
    config.setMaxLifetime(60000); // 60 Sec
    config.setIdleTimeout(45000); // 45 Sec
    config.setMaximumPoolSize(1); // 50 Connections (including idle connections)
    dataSource = new HikariDataSource(config);
  }

  public static Connection getConnection()
  {
    Connection connection = null;

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
}
