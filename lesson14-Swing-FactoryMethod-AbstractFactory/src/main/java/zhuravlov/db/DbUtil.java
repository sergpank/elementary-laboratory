package zhuravlov.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

  public List<String> getColumnNames(String tableName)
  {
    List<String> result = new ArrayList<>();

    String query = "SELECT * FROM " + tableName;

    try (Connection conn = getConnection(); Statement st = conn.createStatement())
    {
      ResultSet resultSet = st.executeQuery(query);
      ResultSetMetaData meta = resultSet.getMetaData();

      for (int i = 1; i <= meta.getColumnCount(); i++)
      {
        result.add(meta.getColumnLabel(i));
      }

    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }

    return result;
  }

  public List<List<Object>> getTabledata(String tableName, List<String> columnNames)
  {
    List<List<Object>> result = new ArrayList<>();
    String query = "SELECT * FROM " + tableName;

    try (Connection conn = getConnection(); Statement st = conn.createStatement())
    {
      ResultSet rs = st.executeQuery(query);
      while (rs.next())
      {
        List<Object> row = new ArrayList<>();
        for (int i = 0; i < columnNames.size(); i++)
        {
          row.add(rs.getObject(columnNames.get(i)));
        }
        result.add(row);
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }

    return result;
  }
}
