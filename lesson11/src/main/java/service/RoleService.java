package service;

import DAO.RoleDAO;
import bl.Util;
import entity.RoleVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleService  extends Util implements RoleDAO
{
  @Override
  public boolean create(RoleVO role) throws SQLException
  {
    Connection connection = getConnection();
    boolean create = true;
    PreparedStatement preparedStatement = null;
    String sql = "INSERT INTO roles (id, name, description) VALUES (?, ?, ?)";
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, role.getId());
      preparedStatement.setString(2, role.getName());
      preparedStatement.setString(3, role.getDescription());

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
  public RoleVO read(long id) throws SQLException
  {

    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    String sql = "SELECT id, name, description FROM roles WHERE id=?";
    RoleVO role = new RoleVO();
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();
      role.setId(resultSet.getLong("id"));
      role.setName(resultSet.getString("name"));
      role.setDescription(resultSet.getString("description"));

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
    return role;
  }

  @Override
  public List<RoleVO> read() throws SQLException
  {
    Connection connection = getConnection();
    List<RoleVO> roleList = new ArrayList<>();

    String sql = "SELECT id, name, description FROM roles";
    Statement statement = null;
    try
    {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next())
      {
        RoleVO role = new RoleVO();
        role.setId(resultSet.getLong("id"));
        role.setName(resultSet.getString("name"));
        role.setDescription(resultSet.getString("description"));


        roleList.add(role);
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
    return roleList;
  }

  @Override
  public boolean update(RoleVO role) throws SQLException
  {

    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    boolean update = true;
    String sql = "UPDATE roles SET name=?, description=? WHERE id=?";
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, role.getName());
      preparedStatement.setString(2, role.getDescription());
      preparedStatement.setLong(3, role.getId());

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
    String sql = "DELETE FROM roles WHERE id=?";

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