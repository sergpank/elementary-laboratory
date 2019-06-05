package DAO;

import entity.UserVO;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends DAO<UserVO>
{
  boolean create(UserVO user) throws SQLException;

  UserVO read(long id) throws SQLException;

  List<UserVO> read() throws SQLException;

  boolean update(UserVO user) throws SQLException;

  boolean delete(long id);
}
