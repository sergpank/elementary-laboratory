package main.dao;

import main.entity.Group;
import main.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO extends DAO<Group>
{
  @Override
  public void create(Group group)
  {
    Connection connection = getConnection();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO groups (name, description) VALUES (?,?)");
      preparedStatement.setString(1, group.getName());
      preparedStatement.setString(2, group.getDescription());
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
  public Group read(long id)
  {
    Connection connection = getConnection();
    Group group = null;
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM groups WHERE id = ?");
      preparedStatement.setLong(1,id);
      ResultSet resultSet = preparedStatement.executeQuery();

      long groupId = resultSet.getInt("id");
      String groupName = resultSet.getString("name");
      String groupDescription = resultSet.getString("description");

      group = new Group(id, groupName, groupDescription, getRoles(id));
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
    return group;
  }

  @Override
  public List<Group> readAll()
  {
    Connection connection = getConnection();
    List<Group> groups = new ArrayList<>();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM groups");
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next())
      {
        long groupId = resultSet.getInt("id");
        String groupName = resultSet.getString("name");
        String groupDescription = resultSet.getString("description");
        Group group = new Group(groupId, groupName, groupDescription, getRoles(groupId));
        groups.add(group);
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
    return groups;
  }

  @Override
  public void update(Group group)
  {
    Connection connection = getConnection();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE groups SET name = ?, description = ? WHERE id = ?");
      preparedStatement.setString(1, group.getName());
      preparedStatement.setString(2, group.getDescription());
      preparedStatement.setLong(3, group.getId());
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
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM groups WHERE id = ?");
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

  protected List<Role> getRoles(long groupId)
  {
    Connection connection = getConnection();
    List<Role> roles = new ArrayList<>();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT r.id, r.name, r.description FROM groups g INNER JOIN groups_and_roles t ON g.id=t.groupId INNER JOIN roles r ON t.roleId=r.id WHERE g.id = ?");
      preparedStatement.setLong(1,groupId);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next())
      {
        long roleId = resultSet.getLong("id");
        String roleName = resultSet.getString("name");
        String roleDescription = resultSet.getString("description");
        roles.add(new Role(roleId, roleName, roleDescription));
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
    return roles;
  }
}

