package homework25.dao;

import homework25.dao.connection.IAbstractConnectionFactory;
import homework25.models.Group;
import homework25.models.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDao extends AbstractDao<Group>
{
  public GroupDao(IAbstractConnectionFactory connectionFactory)
  {
    super(connectionFactory);
  }

  @Override
  public boolean create(Group item)
  {
    boolean result = false;

    if (item.getId() == 0)
    {
      String query = "INSERT INTO groups (name) values (?);";

      try (Connection conn = connectionFactory.getConnection();
           PreparedStatement statement = conn.prepareStatement(query))
      {
        statement.setString(1, item.getName());
        int insertResult = statement.executeUpdate();
        if (insertResult != 0)
        {
          result = true;
        }

        insertAccordingItems(item.getRoles(), conn);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }

    }
    return result;
  }

  @Override
  public Group read(long id)
  {
    Group result = null;
    String query = "SELECT id, name FROM groups WHERE id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet != null && resultSet.next())
      {
        result = new Group(resultSet.getLong("id"),
            resultSet.getString("name"),
            this::getRoles);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public List<Group> read()
  {
    List<Group> result = new ArrayList<>();

    String query = "SELECT id, name FROM groups;";

    try (Connection conn = connectionFactory.getConnection();
         Statement statement = conn.createStatement())
    {
      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet != null && resultSet.next())
      {
        result.add(new Group(resultSet.getLong("id"),
            resultSet.getString("name"),
            this::getRoles));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public boolean update(Group item)
  {
    boolean result = false;

    String query = "UPDATE groups SET name=? WHERE id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setString(1, item.getName());
      statement.setLong(2, item.getId());

      int updateResult = statement.executeUpdate();

      if (updateResult != 0)
      {
        result = true;
      }
      updateAccordingItems(item.getId(), item.getRoles(), conn);
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
    String query = "DELETE FROM groups WHERE id=?;";

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

  public int count()
  {
    int result = 0;
    String query = "SELECT count(id) AS num FROM groups;";
    try (Connection conn = connectionFactory.getConnection();
         Statement statement = conn.createStatement())
    {
      ResultSet resultSet = statement.executeQuery(query);
      resultSet.next();
      result = resultSet.getInt("num");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return result;
  }

  public List<Role> getRoles(long groupId)
  {
    List<Role> result = new ArrayList<>();

    String query = "SELECT r.id AS roleId, r.description AS roleDescription " +
        "FROM roles AS r INNER JOIN (groupsAndRoles AS gr INNER JOIN groups AS g " +
        "ON gr.groupId=g.id) ON gr.roleId=r.id " +
        "WHERE g.id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setLong(1, groupId);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet != null && resultSet.next())
      {
        result.add(new Role(resultSet.getLong("roleId"),
            resultSet.getString("roleDescription")));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  private void updateAccordingItems(long groupId, List<Role> items, Connection conn) throws SQLException
  {
    deleteAccordingItems(groupId, conn);

    insertAccordingItems(groupId, items, conn);
  }

  private void deleteAccordingItems(long groupId, Connection conn) throws SQLException
  {
    String query = "DELETE FROM groupsAndRoles WHERE groupId=?";

    PreparedStatement statement = conn.prepareStatement(query);

    statement.setLong(1, groupId);

    statement.executeUpdate();

    statement.close();
  }

  private void insertAccordingItems(long groupId, List<Role> items, Connection conn) throws SQLException
  {
    String query = "INSERT INTO groupsAndRoles(groupId, roleId) VALUES (?, ?);";
    PreparedStatement statement = conn.prepareStatement(query);
    statement.setLong(1, groupId);

    for (Role item : items)
    {
      statement.setLong(2, item.getId());
      statement.executeUpdate();
    }
    statement.close();
  }

  private void insertAccordingItems(List<Role> items, Connection conn) throws SQLException
  {
    String query = "SELECT last_insert_rowid() AS id FROM groups";

    Statement st = conn.createStatement();

    ResultSet resultSet = st.executeQuery(query);

    resultSet.next();

    long id = resultSet.getLong("id");

    st.close();

    insertAccordingItems(id, items, conn);
  }

}
