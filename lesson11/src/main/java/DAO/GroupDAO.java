package DAO;

import DAO.DAO;
import bl.Util;
import entity.GroupVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO extends Util implements DAO<GroupVO>
{

  @Override
  public boolean create(GroupVO group) throws SQLException
  {
    Connection connection = getConnection();
    boolean create = true;
    PreparedStatement preparedStatement = null;
    String sql = "INSERT INTO groups (id, name, description) VALUES (?, ?, ?)";
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, group.getId());
      preparedStatement.setString(2, group.getName());
      preparedStatement.setString(3, group.getDescription());

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
  public GroupVO read(long id) throws SQLException
  {

    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    String sql = "SELECT id, name, description FROM groups WHERE id=?";
    GroupVO group = new GroupVO();
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();
      group.setId(resultSet.getLong("id"));
      group.setName(resultSet.getString("name"));
      group.setDescription(resultSet.getString("description"));

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
    return group;
  }

  @Override
  public List<GroupVO> read() throws SQLException
  {
    Connection connection = getConnection();
    List<GroupVO> groupList = new ArrayList<>();

    String sql = "SELECT id, name, description FROM groups";
    Statement statement = null;
    try
    {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next())
      {
        GroupVO group = new GroupVO();
        group.setId(resultSet.getLong("id"));
        group.setName(resultSet.getString("name"));
        group.setDescription(resultSet.getString("description"));


        groupList.add(group);
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
    return groupList;
  }

  @Override
  public boolean update(GroupVO group) throws SQLException
  {

    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    boolean update = true;
    String sql = "UPDATE groups SET name=?, description=? WHERE id=?";
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, group.getName());
      preparedStatement.setString(2, group.getDescription());
      preparedStatement.setLong(3, group.getId());

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
    String sql = "DELETE FROM groups WHERE id=?";

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
