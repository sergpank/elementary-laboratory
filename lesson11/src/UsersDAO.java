import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDAO implements DAO
{
  public boolean create(User user) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * From Groups WHERE name = '" + user.group.name  + "'");
    statement.executeUpdate("INSERT INTO Users (name, login, password, GroupID) VALUES ('" + user.name + "','" +
        user.login + "','" + user.password + "','" + resultSet.getInt("groupsid") + "')");
    statement.close();
    return true;
  }

  public User read(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Users INNER JOIN Groups ON Users.groupID = Groups.groupsid  WHERE Users.id = '" + id + "'");
    User user = new User(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("login"),resultSet.getString("password"),new Group(resultSet.getString("name")));
    statement.close();
    return user;
  }

  public ArrayList<User> read() throws SQLException
  {
    Statement statement = connection.createStatement();
    ArrayList<User> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Users INNER JOIN Groups ON Users.groupID = Groups.groupsid");

    while(resultSet.next())
    {
      User user = new User(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("login"),resultSet.getString("password"),new Group(resultSet.getString("name")));
      list.add(user);
    }
    statement.close();
    return list;
  }

  public boolean update(User user, long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * From Groups WHERE name = '" + user.group.name  + "'");
    statement.executeUpdate("UPDATE Users SET name = '" + user.name + "', login = '" + user.login + "', password = '" + user.password + "'," +
        "groupID = '" + resultSet.getInt("groupsid") + "' WHERE id = '" + id + "'");
    statement.close();
    return true;
  }

  public boolean delete(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("DELETE FROM Users WHERE id = '" + id + "'");
    statement.close();
    return true;
  }
}
