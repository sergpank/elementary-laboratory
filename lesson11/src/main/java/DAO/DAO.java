package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T>
{
  boolean create(T entity) throws SQLException;

  T read(long id) throws SQLException;

  List<T> read() throws SQLException;

  boolean update(T entity) throws SQLException;

  boolean delete(long id);
}
