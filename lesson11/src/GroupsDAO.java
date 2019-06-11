import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupsDAO implements DAO
{
  public boolean create(Group group) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("INSERT INTO Groups (name, description) VALUES('" + group.name + "','" +
        group.description + "')");
    statement.close();
    return true;
  }

  public Group read(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Groups WHERE groupsid = '" + id + "'");
    Group group = new Group(resultSet.getInt("groupsid"), resultSet.getString("name"), resultSet.getString("description"));
    statement.close();
    return group;
  }

  public ArrayList<Group> read() throws SQLException
  {
    Statement statement = connection.createStatement();
    ArrayList<Group> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Groups");

    while(resultSet.next())
    {
      Group group = new Group(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"));
      list.add(group);
    }

    statement.close();
    return list;
  }

  public boolean update(Group group, long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("UPDATE Groups SET name = '" + group.name + "', description = '" + group.description + "' WHERE groupsid = '" + id + "'");
    statement.close();
    return true;
  }

  public boolean delete(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("DELETE FROM Groups WHERE groupsid = '" + id + "'");
    statement.close();
    return true;
  }
}
