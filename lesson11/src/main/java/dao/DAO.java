package dao;

import java.util.List;

public interface DAO<T>
{
   boolean create(T t);
   T read(int id);
   List<T> read();
   boolean update(T t);
   boolean delete(int id);

}
