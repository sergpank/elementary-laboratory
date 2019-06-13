package main.dao;

import main.entity.ValueObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO <T extends ValueObject>
{
  protected static void loadDriver()
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

  protected static Connection getConnection()
  {
    Connection connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return connection;
  }

  public abstract void create(T valueObject);

  public abstract T read(long id);

  public abstract List<T> readAll();

  public abstract void update(T valueObject);

  public abstract void delete(long id);
}
