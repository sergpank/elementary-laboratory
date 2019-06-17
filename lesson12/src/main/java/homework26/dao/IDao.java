package homework26.dao;

import java.util.List;

public interface IDao<T>
{
  T create(T item);

  T read(long key);

  List<T> read();

  boolean update(T item);

  boolean delete(long key);
}