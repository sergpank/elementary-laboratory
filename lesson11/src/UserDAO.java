import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO
{
  public boolean create(Statement statement, User user) throws SQLException
  {
      statement.executeUpdate("INSERT INTO User (id, name, login, password, Group_id) VALUES ('" + user.id + "','" + user.name + "','" +
          user.login + "','" + user.password + "','" + user.group + "')");
    return true;
  }

  public User read(Statement statement, long id) throws SQLException
  {
      ResultSet resultSet = statement.executeQuery("SELECT * FROM User WHERE id = 7");
      User user = new User(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("login"),resultSet.getString("password"));
      return user;
  }

  public void read(Statement statement)
  //public List<User> read()
  {

  }

  public boolean update(Statement statement, User user)
  {
    return true;
  }

  public boolean delete(Statement statement, long id)
  {
    return true;
  }
}
