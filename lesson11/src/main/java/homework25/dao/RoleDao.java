package homework25.dao;

import homework25.dao.connection.IAbstractConnectionFactory;
import homework25.models.Group;
import homework25.models.Role;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao<Role>
{
  public RoleDao(IAbstractConnectionFactory connectionFactory)
  {
    super(connectionFactory);
  }

  @Override
  public boolean create(Role item)
  {
    boolean result = false;

    if (item.getId() == 0)
    {
      String query = "INSERT INTO roles (description) values (?);";

      try (Connection conn = connectionFactory.getConnection();
           PreparedStatement statement = conn.prepareStatement(query))
      {
        statement.setString(1, item.getDescription());
        int insertResult = statement.executeUpdate();
        if (insertResult != 0)
        {
          result = true;
        }

        insertAccordingItems(item.getGroups(), conn);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }

    }
    return result;
  }

  @Override
  public boolean update(Role item)
  {
    boolean result = false;

    String query = "UPDATE roles SET description=? WHERE id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setString(1, item.getDescription());
      statement.setLong(2, item.getId());

      int updateResult = statement.executeUpdate();

      if (updateResult != 0)
      {
        result = true;
      }

      updateAccordingItems(item.getId(), item.getGroups(), conn);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public Role read(long id)
  {
    Role result = null;
    String query = "SELECT id, description FROM roles WHERE id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet != null && resultSet.next())
      {
        result = new Role(resultSet.getLong("id"),
            resultSet.getString("description"),
            this::getGroups);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public List<Role> read()
  {
    List<Role> result = new ArrayList<>();

    String query = "SELECT id, description FROM roles;";

    try (Connection conn = connectionFactory.getConnection();
         Statement statement = conn.createStatement())
    {
      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet != null && resultSet.next())
      {
        result.add(new Role(resultSet.getLong("id"),
            resultSet.getString("description"),
            this::getGroups));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public boolean delete(long id)
  {
    boolean result = false;

    String query = "DELETE FROM roles WHERE id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setLong(1, id);
      int deleteResult = statement.executeUpdate();

      if (deleteResult != 0)
      {
        result = true;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  /*--------------------------------------*/

  public List<Group> getGroups(long roleId)
  {
    List<Group> result = new ArrayList<>();

    String query = "SELECT g.id AS groupId, g.name AS groupName " +
        "FROM groups AS g INNER JOIN (groupsAndRoles AS gr INNER JOIN roles AS r " +
        "ON r.id=gr.roleId ) ON gr.groupId=g.id " +
        "WHERE r.id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setLong(1, roleId);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet != null && resultSet.next())
      {
        result.add(new Group(resultSet.getLong("groupId"), resultSet.getString("groupName")));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  private void updateAccordingItems(long roleId, List<Group> items, Connection conn) throws SQLException
  {
    deleteAccordingItems(roleId, conn);

    insertAccordingItems(roleId, items, conn);
  }

  private void deleteAccordingItems(long roleId, Connection conn) throws SQLException
  {
    String query = "DELETE FROM groupsAndRoles WHERE roleId=?";
    PreparedStatement statement = conn.prepareStatement(query);

    statement.setLong(1, roleId);

    statement.executeUpdate();

    statement.close();
  }

  private void insertAccordingItems(long roleId, List<Group> items, Connection conn) throws SQLException
  {
    String query = "INSERT INTO groupsAndRoles(roleId, groupId) VALUES (?, ?);";
    PreparedStatement statement = conn.prepareStatement(query);
    statement.setLong(1, roleId);

    for (Group item : items)
    {
      statement.setLong(2, item.getId());
      statement.executeUpdate();
    }
    statement.close();
  }

  private void insertAccordingItems(List<Group> items, Connection conn) throws SQLException
  {
    String query = "SELECT last_insert_rowid() AS id FROM roles";

    Statement st = conn.createStatement();

    ResultSet resultSet = st.executeQuery(query);

    resultSet.next();

    long id = resultSet.getLong("id");

    st.close();

    insertAccordingItems(id, items, conn);
  }
}
