package main.dao;

import main.entity.Group;
import main.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User>
{

  @Override
  public void create(User user)
  {
    Connection connection = getConnection();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (user_name, user_login, user_password, user_groupId) VALUES (?,?,?,?)");
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getLogin());
      preparedStatement.setString(3, user.getPassword());
      preparedStatement.setLong(4, user.getGroup().getId());
      preparedStatement.executeUpdate();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        connection.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }


  @Override
  public User read(long id)
  {
    Connection connection = getConnection();
    User user = null;
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.user_name, u.user_login, u.user_password, g.id, g.name, g.description FROM users u INNER JOIN groups g ON u.user_groupId=g.id WHERE u.user_id = ?");
      preparedStatement.setLong(1,id);
      ResultSet resultSet = preparedStatement.executeQuery();

      String name = resultSet.getString("user_name");
      String login = resultSet.getString("user_login");
      String password = resultSet.getString("user_password");
      long groupId = resultSet.getInt("id");
      String groupName = resultSet.getString("name");
      String groupDescription = resultSet.getString("description");
      GroupDAO groupDAO = new GroupDAO();
      Group group = new Group(groupId, groupName, groupDescription, groupDAO.getRoles(groupId));
      user = new User(id, name, login, password, group);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        connection.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }

    }
    return user;
  }

  @Override
  public List<User> readAll()
  {
    Connection connection = getConnection();
    List<User> users = new ArrayList<>();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.user_id, u.user_name, u.user_login, u.user_password, g.id, g.name, g.description FROM users u INNER JOIN groups g ON u.user_groupId=g.id");
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next())
      {
        long id = resultSet.getLong("user_id");
        String name = resultSet.getString("user_name");
        String login = resultSet.getString("user_login");
        String password = resultSet.getString("user_password");
        long groupId = resultSet.getInt("id");
        String groupName = resultSet.getString("name");
        String groupDescription = resultSet.getString("description");

        Group group = new Group(groupId, groupName, groupDescription);
        User user = new User(id, name, login, password, group);
        users.add(user);
      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        connection.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }

    }
    return users;
  }

  @Override
  public void update(User user)
  {
    Connection connection = getConnection();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET user_name = ?, user_login = ?, user_password = ?, user_groupId = ? WHERE user_id = ?");
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getLogin());
      preparedStatement.setString(3, user.getPassword());
      preparedStatement.setLong(4, user.getGroup().getId());
      preparedStatement.setLong(5, user.getId());
      preparedStatement.executeUpdate();

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        connection.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void delete(long id)
  {
    Connection connection = getConnection();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE user_id = ?");
      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        connection.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }

}
