package homework26.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class DbSQLiteUtil
{
  private static HikariDataSource dataSource;

  private static String protocol;
  private static String dbLocation;
  private static String driver;
  private static String poolName;
  private static int poolSize;
  private static String createScriptLocation;

  static
  {
    Properties props = new Properties();
    try (InputStream in = Files.newInputStream(Paths.get("resources/db.properties")))
    {
      props.load(in);

      driver = props.getProperty("driver");
      poolName = props.getProperty("pool_name");
      protocol = props.getProperty("protocol");
      dbLocation = props.getProperty("db_location");
      poolSize = Integer.parseInt(props.getProperty("pool_size"));
      createScriptLocation = props.getProperty("create_script_location");


      Class.forName(driver);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

  }

  private static void init()
  {
    HikariConfig config = new HikariConfig();
    config.setPoolName(poolName);
    config.setDriverClassName(driver);
    config.setJdbcUrl(protocol + dbLocation);
    config.setConnectionTestQuery("SELECT 1");
    config.setMaxLifetime(60000); // 60 Sec
    config.setIdleTimeout(45000); // 45 Sec
    config.setMaximumPoolSize(poolSize); // 50 Connections (including idle connections)
    dataSource = new HikariDataSource(config);

  }

  public static Connection getConnectionFromPool()
  {
    Connection connection = null;

    if (dataSource == null)
    {
      init();
    }

    try
    {
      connection = dataSource.getConnection();
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }

    return connection;
  }

  /**
   * Plain JDBC Connection
   *
   * @return Connection to Database. NOTE: this connection is not pooled, so don't forget
   * to close it when the work is done.
   */
  public static Connection getJdbcConnection() throws SQLException
  {
    Connection connection = null;

    String url = protocol + dbLocation;
    connection = DriverManager.getConnection(url);

    return connection;
  }

  public static void initDb()
  {

    String[] queries = readSqlQueries(createScriptLocation);

    try (Connection conn = getConnectionFromPool())
    {
      for (String query : queries)
      {
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        st.close();
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
  }

  private static String[] readSqlQueries(String path)
  {
    String[] result = new String[0];

    File file = new File(path);

    if (file.exists())
    {
      try (BufferedReader reader = new BufferedReader(new FileReader(file)))
      {
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null)
        {
          sb.append(line);
        }
        if (sb.length() > 0)
        {
          result = sb.toString().split(";");
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    return result;
  }

  public static void dropTable(String tableName)
  {
    String query = "DROP TABLE IF EXISTS " + tableName + ";";
    try (Connection conn = getConnectionFromPool(); Statement st = conn.createStatement())
    {
      st.executeUpdate(query);
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
  }

  public static void clearTable(String tableName)
  {
    String query = "DELETE FROM  " + tableName + ";";
    try (Connection conn = getConnectionFromPool(); Statement st = conn.createStatement())
    {
      st.executeUpdate(query);
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
  }

  public static void dropView(String viewName)
  {
    String query = "DROP VIEW IF EXISTS " + viewName + ";";
    try (Connection conn = getConnectionFromPool(); Statement st = conn.createStatement())
    {
      st.executeUpdate(query);
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
  }

  public static void clearDb()
  {
    String[] tables = {"address", "client", "pet", "doctor", "visit"};
    String[] views = {"clientView", "petView", "patientView", "visitView"};

    for (String table : tables)
    {
      dropTable(table);
    }

    for (String view : views)
    {
      dropView(view);
    }
  }
}
