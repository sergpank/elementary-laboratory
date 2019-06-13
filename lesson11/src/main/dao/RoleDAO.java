package main.dao;

import main.entity.Group;
import main.entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends DAO<Role>
{
  @Override
  public void create(Role role)
  {
    Connection connection = getConnection();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO roles (name, description) VALUES (?,?)");
      preparedStatement.setString(1, role.getName());
      preparedStatement.setString(2, role.getDescription());
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
  public Role read(long id)
  {
    Connection connection = getConnection();
    Role role = null;
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM roles WHERE id = ?");
      preparedStatement.setLong(1,id);
      ResultSet resultSet = preparedStatement.executeQuery();

      long roleId = resultSet.getInt("id");
      String roleName = resultSet.getString("name");
      String roleDescription = resultSet.getString("description");

      role = new Role(id, roleName, roleDescription, getGroups(id));
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
    return role;
  }

  @Override
  public List<Role> readAll()
  {
    Connection connection = getConnection();
    List<Role> roles = new ArrayList<>();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM roles");
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next())
      {
        long roleId = resultSet.getInt("id");
        String roleName = resultSet.getString("name");
        String roleDescription = resultSet.getString("description");
        Role role = new Role(roleId, roleName, roleDescription, getGroups(roleId));
        roles.add(role);
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

  @Override
  public void update(Role role)
  {
    Connection connection = getConnection();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE roles SET name = ?, description = ? WHERE id = ?");
      preparedStatement.setString(1, role.getName());
      preparedStatement.setString(2, role.getDescription());
      preparedStatement.setLong(3, role.getId());
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
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM roles WHERE id = ?");
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

  private List<Group> getGroups(long roleId)
  {
    Connection connection = getConnection();
    List<Group> groups = new ArrayList<>();
    loadDriver();
    try
    {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT g.id, g.name, g.description FROM roles r INNER JOIN groups_and_roles t ON r.id=t.roleId INNER JOIN groups g ON t.groupId=g.id WHERE r.id = ?");
      preparedStatement.setLong(1,roleId);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next())
      {
        long groupId = resultSet.getLong("id");
        String groupName = resultSet.getString("name");
        String groupDescription = resultSet.getString("description");
        groups.add(new Group(groupId, groupName, groupDescription));
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
}
