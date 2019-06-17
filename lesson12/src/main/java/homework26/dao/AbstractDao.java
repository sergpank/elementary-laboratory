package homework26.dao;

import homework26.util.IConnectionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class AbstractDao<T> implements IDao<T>
{
  protected IConnectionFactory connectionFactory;

  public AbstractDao(IConnectionFactory factory)
  {
    this.connectionFactory = factory;
  }

  public abstract T create(T item);

  public abstract T read(long key);

  public abstract List<T> read();

  public abstract boolean update(T item);

  public abstract boolean delete(long key);

  public long lastInsertId(Statement statement) throws SQLException
  {
    long result = 0;

    ResultSet resultSet = statement.getGeneratedKeys();

    if (resultSet != null && resultSet.next())
    {
      result = resultSet.getLong(1);
    }

    return result;
  }
}
