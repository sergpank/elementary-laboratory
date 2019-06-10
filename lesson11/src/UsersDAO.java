import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements DAO
{
  public boolean create(Statement statement, User user) throws SQLException
  {
    ResultSet resultSet = statement.executeQuery("SELECT * From Groups WHERE name = '" + user.group.name  + "'");
    statement.executeUpdate("INSERT INTO Users (name, login, password, GroupID) VALUES ('" + user.name + "','" +
        user.login + "','" + user.password + "','" + resultSet.getInt("groupsid") + "')");
    return true;
  }

  public User read(Statement statement, long id) throws SQLException
  {
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Users INNER JOIN Groups ON Users.groupID = Groups.groupsid  WHERE Users.id = '" + id + "'");
    User user = new User(resultSet.getString("name"),resultSet.getString("login"),resultSet.getString("password"),new Group(resultSet.getString("name")));
    user.id = resultSet.getInt("id");
    return user;
  }

  public ArrayList<User> read(Statement statement) throws SQLException
  {
    ArrayList<User> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Users INNER JOIN Groups ON Users.groupID = Groups.groupsid");

    while(resultSet.next())
    {
      User user = new User(resultSet.getString("name"),resultSet.getString("login"),resultSet.getString("password"),new Group(resultSet.getString("name")));
      user.id = resultSet.getInt("id");
      list.add(user);
    }

    return list;
  }

  public boolean update(Statement statement, User user, long id) throws SQLException
  {
    ResultSet resultSet = statement.executeQuery("SELECT * From Groups WHERE name = '" + user.group.name  + "'");
    statement.executeUpdate("UPDATE Users SET name = '" + user.name + "', login = '" + user.login + "', password = '" + user.password + "'," +
        "groupID = '" + resultSet.getInt("groupsid") + "' WHERE id = '" + id + "'");
    return true;
  }

  public boolean delete(Statement statement, long id) throws SQLException
  {
    statement.executeUpdate("DELETE FROM Users WHERE id = '" + id + "'");
    return true;
  }
}
