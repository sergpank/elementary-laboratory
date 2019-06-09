package homework25.dao;

import homework25.dao.connection.IAbstractConnectionFactory;
import homework25.models.ValueObject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class AbstractDao<T extends ValueObject> implements IDao<T>
{
  protected IAbstractConnectionFactory connectionFactory;

  AbstractDao(IAbstractConnectionFactory connectionFactory)
  {
    this.connectionFactory = connectionFactory;
  }

  public abstract boolean create(T item);

  public abstract boolean update(T item);

  public abstract T read(long id);

  public abstract List<T> read();

  public abstract boolean delete(long id);

}
