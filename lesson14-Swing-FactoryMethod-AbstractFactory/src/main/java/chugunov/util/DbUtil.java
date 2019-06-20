package chugunov.util;

import com.zaxxer.hikari.HikariDataSource;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DbUtil
{
  protected HikariDataSource dataSource;
  protected String dbLocation;

  public DbUtil(String dbLocation)
  {
    this.dbLocation = dbLocation;
  }

  public Connection getConnection()
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

  public List<String> getTableNames()
  {
    List<String> result = new ArrayList<>();

    try (Connection conn = getConnection())
    {
      DatabaseMetaData metaData = conn.getMetaData();
      ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
      while (resultSet.next())
      {
        result.add(resultSet.getString(3));
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

  protected abstract void init();

}
