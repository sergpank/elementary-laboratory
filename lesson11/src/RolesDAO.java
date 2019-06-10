import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RolesDAO implements DAO
{
  public boolean create(Statement statement, Role role) throws SQLException
  {
    statement.executeUpdate("INSERT INTO Roles (name, description) VALUES('" + role.name + "','" +
        role.description + "')");
    return true;
  }

  public Role read(Statement statement, long id) throws SQLException
  {
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Roles WHERE rolesid = '" + id + "'");
    Role role = new Role(resultSet.getInt("rolesid"), resultSet.getString("name"), resultSet.getString("description"));
    return role;
  }

  public ArrayList<Role> read(Statement statement) throws SQLException
  {
    ArrayList<Role> list = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Roles");

    while(resultSet.next())
    {
      Role role = new Role(resultSet.getInt("rolesid"), resultSet.getString("name"), resultSet.getString("description"));
      list.add(role);
    }

    return list;
  }

  public boolean update(Statement statement, Role role, long id) throws SQLException
  {
    statement.executeUpdate("UPDATE Roles SET name = '" + role.name + "', description = '" + role.description + "' WHERE rolesid = '" + id + "'");
    return true;
  }

  public boolean delete(Statement statement, long id) throws SQLException
  {
    statement.executeUpdate("DELETE FROM Roles WHERE rolesid = '" + id + "'");
    return true;
  }
}
