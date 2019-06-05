package DAO;

import entity.GroupVO;

import java.sql.SQLException;
import java.util.List;

public interface GroupDAO extends DAO<GroupVO>
{
  boolean create(GroupVO group) throws SQLException;

  GroupVO read(long id) throws SQLException;

  List<GroupVO> read() throws SQLException;

  boolean update(GroupVO group) throws SQLException;

  boolean delete(long id);
}
