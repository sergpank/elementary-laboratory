package rvelikorod.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T>
{
  public abstract T create(T entity);

  public abstract T read(long id);

  public abstract List<T> readAll();

  public abstract boolean update(T entity);

  public abstract boolean delete(T entity);

  public long getKey(PreparedStatement pStmt) throws SQLException
  {
    ResultSet generatedKeys = pStmt.getGeneratedKeys();
    generatedKeys.next();
    return generatedKeys.getLong(1);
  }
}
