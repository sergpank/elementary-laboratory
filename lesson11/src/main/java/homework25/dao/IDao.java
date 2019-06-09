package homework25.dao;

import java.util.List;

/*

 */

public interface IDao<T>
{
  boolean create(T item);

  T read(long id);

  List<T> read();

  boolean update(T item);

  boolean delete(long id);
}
