package homework25.dao;

import homework25.dao.connection.IAbstractConnectionFactory;
import homework25.models.Group;
import homework25.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User>
{
  public UserDao(IAbstractConnectionFactory connectionFactory)
  {
    super(connectionFactory);
  }

  @Override
  public boolean create(User item)
  {
    boolean result = false;

    if (item.getId() == 0)
    {
      String query = "INSERT INTO users (login, password, groupId)" +
          "VaLUES (?, ?, ?)";

      try (Connection conn = connectionFactory.getConnection();
           PreparedStatement statement = conn.prepareStatement(query))
      {
        statement.setString(1, item.getLogin());
        statement.setString(2, item.getPassword());
        statement.setLong(3, item.getGroup().getId());

        int insertResult = statement.executeUpdate();

        if (insertResult != 0)
        {
          result = true;
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }

    return result;
  }

  @Override
  public boolean update(User item)
  {
    boolean result = false;

    String query = "UPDATE users " +
        "SET login=?, password=?, groupId=? " +
        "WHERE id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setString(1, item.getLogin());
      statement.setString(2, item.getPassword());
      statement.setLong(3, item.getGroup().getId());
      statement.setLong(4, item.getId());

      if (statement.executeUpdate() != 0)
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

  @Override
  public User read(long id)
  {
    User result = null;

    String query = "SELECT g.id AS groupId, g.name, u.login, u.password " +
        "FROM users AS u INNER JOIN groups AS g ON u.groupId=g.id " +
        "WHERE u.id=?;";

    try (Connection conn = connectionFactory.getConnection();
         PreparedStatement statement = conn.prepareStatement(query))
    {
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet != null && resultSet.next())
      {
        Group group = new Group(resultSet.getLong("groupId"),
            resultSet.getString("name"));

        result = new User(id, resultSet.getString("login"),
            resultSet.getString("password"), group);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return result;
  }

  @Override
  public List<User> read()
  {
    List<User> result = new ArrayList<>();

    String query = "SELECT g.id AS groupId, g.name AS name, u.id, u.login, u.password " +
        "FROM users AS u INNER JOIN groups AS g ON u.groupId=g.id;";

    try (Connection conn = connectionFactory.getConnection();
         Statement statement = conn.createStatement())
    {
      ResultSet resultSet = statement.executeQuery(query);


      while (resultSet != null && resultSet.next())
      {
        Group group = new Group(resultSet.getLong("groupId"),
            resultSet.getString("name"));

        result.add(new User(resultSet.getLong("id"),
            resultSet.getString("login"),
            resultSet.getString("password"), group));
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
    String query = "DELETE FROM users WHERE id=?;";

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
}
