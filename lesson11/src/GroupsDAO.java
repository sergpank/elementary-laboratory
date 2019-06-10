import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupsDAO implements DAO
{
  public boolean create(Statement statement, Group group) throws SQLException
  {
    statement.executeUpdate("INSERT INTO Groups (name, description) VALUES('" + group.name + "','" +
        group.description + "')");
    return true;
  }

  public Group read(Statement statement, long id) throws SQLException
  {
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Groups WHERE groupsid = '" + id + "'");
    Group group = new Group(resultSet.getString("name"), resultSet.getString("description"));
    group.id = resultSet.getInt("groupsid");
    return group;
  }

  public ArrayList<Group> read(Statement statement) throws SQLException
  {
    ArrayList<Group> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Groups");

    while(resultSet.next())
    {
      Group group = new Group(resultSet.getString("name"), resultSet.getString("description"));
      group.id = resultSet.getInt("groupsid");
      list.add(group);
    }

    return list;
  }

  public boolean update(Statement statement, Group group, long id) throws SQLException
  {
    statement.executeUpdate("UPDATE Groups SET name = '" + group.name + "', description = '" + group.description + "' WHERE groupsid = '" + id + "'");
    return true;
  }

  public boolean delete(Statement statement, long id) throws SQLException
  {
    statement.executeUpdate("DELETE FROM Groups WHERE groupsid = '" + id + "'");
    return true;
  }
}
