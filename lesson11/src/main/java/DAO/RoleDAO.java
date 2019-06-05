package DAO;

import entity.RoleVO;

import java.sql.SQLException;
import java.util.List;

public interface RoleDAO extends DAO<RoleVO>
{
  boolean create(RoleVO role) throws SQLException;

  RoleVO read(long id) throws SQLException;

  List<RoleVO> read() throws SQLException;

  boolean update(RoleVO role) throws SQLException;

  boolean delete(long id);
}
