package learn_hibernate.dao;

import java.util.List;

public interface IDao<T>
{
  T read(long id);
  List<T> readAll();
  T create(T item);
  void update(T item);
  void delete(T item);
}
