package DAO;

import bl.Util;
import entity.UserVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends Util implements DAO<UserVO>
{
  @Override
  public boolean create(UserVO user) throws SQLException
  {
    Connection connection = getConnection();
    boolean create = true;
    PreparedStatement preparedStatement = null;
    String sql = "INSERT INTO users (id, name, login, password, group_id) VALUES (?, ?, ?, ?, ?)";
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, user.getId());
      preparedStatement.setString(2, user.getName());
      preparedStatement.setString(3, user.getLogin());
      preparedStatement.setString(4, user.getPassword());
      preparedStatement.setLong(5, user.getGroup());

      preparedStatement.executeUpdate();
      create = true;
    }
    catch (SQLException e)
    {
      create = false;
      e.printStackTrace();
    }
    finally
    {
      if (preparedStatement != null)
      {
        preparedStatement.close();
      }
      if (connection != null)
      {
        connection.close();
      }
    }
    return create;
  }

  @Override
  public UserVO read(long id) throws SQLException
  {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    String sql = "SELECT id, name, login, password, group_id FROM users WHERE id=?";
    UserVO user = new UserVO();
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();
      user.setId(resultSet.getLong("id"));
      user.setName(resultSet.getString("name"));
      user.setLogin(resultSet.getString("login"));
      user.setPassword(resultSet.getString("password"));
      user.setGroup(resultSet.getLong("group_id"));

      preparedStatement.executeQuery();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (preparedStatement != null)
      {
        preparedStatement.close();
      }
      if (connection != null)
      {
        connection.close();
      }
    }
    return user;
  }

  @Override
  public List<UserVO> read() throws SQLException
  {
    Connection connection = getConnection();
    List<UserVO> usersList = new ArrayList<>();

    String sql = "SELECT id, name, login, password, group_id FROM users";
    Statement statement = null;
    try
    {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next())
      {
        UserVO user = new UserVO();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setGroup(resultSet.getLong("group_id"));

        usersList.add(user);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (statement != null)
      {
        statement.close();
      }
      if (connection != null)
      {
        connection.close();
      }
    }
    return usersList;
  }

  @Override
  public boolean update(UserVO user) throws SQLException
  {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    boolean update = true;
    String sql = "UPDATE users SET name=?, login=?, password=?, group_id=? WHERE id=?";
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getLogin());
      preparedStatement.setString(3, user.getPassword());
      preparedStatement.setLong(4, user.getGroup());
      preparedStatement.setLong(5, user.getId());

      preparedStatement.executeUpdate();
      update = true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      update = false;
    }
    finally
    {
      if (preparedStatement != null)
      {
        preparedStatement.close();
      }
      if (connection != null)
      {
        connection.close();
      }
    }
    return update;
  }

  @Override
  public boolean delete(long id)
  {
    Connection connection = getConnection();
    boolean delete = true;
    PreparedStatement preparedStatement = null;
    String sql = "DELETE FROM users WHERE id=?";

    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();
      delete = true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      delete = false;
    }
    return delete;
  }
}
