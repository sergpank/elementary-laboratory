import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RolesDAO implements DAO
{
  public boolean create(Role role) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("INSERT INTO Roles (name, description) VALUES('" + role.name + "','" +
        role.description + "')");
    return true;
  }

  public Role read(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Roles WHERE rolesid = '" + id + "'");
    Role role = new Role(resultSet.getInt("rolesid"), resultSet.getString("name"), resultSet.getString("description"));
    return role;
  }

  public ArrayList<Role> read() throws SQLException
  {
    Statement statement = connection.createStatement();
    ArrayList<Role> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Roles");

    while(resultSet.next())
    {
      Role role = new Role(resultSet.getInt("rolesid"), resultSet.getString("name"), resultSet.getString("description"));
      list.add(role);
    }

    return list;
  }

  public boolean update(Role role, long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("UPDATE Roles SET name = '" + role.name + "', description = '" + role.description + "' WHERE rolesid = '" + id + "'");
    return true;
  }

  public boolean delete(long id) throws SQLException
  {
    Statement statement = connection.createStatement();
    statement.executeUpdate("DELETE FROM Roles WHERE rolesid = '" + id + "'");
    return true;
  }
}
