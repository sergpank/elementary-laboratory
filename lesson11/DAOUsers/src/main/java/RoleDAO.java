import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class RoleDAO extends DAO<Role>
{
  public static void main(String[] args)
  {
    RoleDAO roleTable = new RoleDAO();

    // CRUD with roleTable
    //roleTable.create(new Role("Cleaner","Must clean"));
    //roleTable.read();
    //roleTable.read(1);
    //roleTable.update(new Role(4,"SuperCleaner","Only cleaning"));
    //roleTable.delete(5);

    roleTable.close();
  }
List<Role> roleList = new ArrayList<Role>();

  public RoleDAO()
  {
    open();
  }

  public boolean create(Role role)
  {
    try
    {
      String name = role.getName();
      String description =role.getDescription();

      String query =
          "INSERT INTO Roles (name, description) " +
              "VALUES ('" + name + "','" + description + "')";

      PreparedStatement statement = connection.prepareStatement(query);
      statement.executeUpdate();
      System.out.println("New record added in Roles table ");
      statement.close();
      read();
      return true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
  }

  public List<Role> read()
  {
    try
    {
      String query =
          "SELECT * FROM Roles";

      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet rs = statement.executeQuery();
      while (rs.next())
      {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String description = rs.getString("description");

        roleList.add(new Role(id, name, description));
      }
      rs.close();
      statement.close();
      for (Role role : roleList)
      {
        System.out.println(role);
      }
      System.out.println("All records were retrived");
      return roleList;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return new ArrayList<Role>();
    }
  }

  public Role read(long id)
  {
    try
    {
      String query =
          "SELECT * " +
              "FROM Roles " +
              "WHERE id= '" + id + "'";

      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet rs = statement.executeQuery();

      String name = rs.getString("name");
      String description = rs.getString("description");

      Role role = new Role(id, name, description);

      rs.close();
      statement.close();

      System.out.println(role);
      System.out.println("Record with current ID: '" + id + "' was retrived");

      return role;
    }
    catch (Exception e)
    {
      e.getMessage();
      System.out.println("Record with current ID: '" + id + "' is absent ");
      return new Role();

    }
  }

  public boolean update(Role role)
  {
    try
    {
      long id = role.getId();
      String name = role.getName();
      String discription = role.getDescription();

      String query =
          "UPDATE Roles " +
              " SET name='" + name + "', description='" + discription + "' " +
              " WHERE id='" + id+  "'";

      PreparedStatement statement = connection.prepareStatement(query);
      statement.executeUpdate();
      System.out.println("Request with ID : " + id+  " has been sent");
      statement.close();
      read();
      return true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
  }

  public boolean delete(long id)
  {
    try
    {
      String query =
          "DELETE FROM Roles " +
              "WHERE id='" + id + "'";

      PreparedStatement statement = connection.prepareStatement(query);
      statement.executeUpdate();
      statement.close();
      System.out.println("Record with current ID : " + id + " has been deleted");
      read();
      return true;
    }
    catch (Exception e)
    {
      e.getStackTrace();
      return false;
    }
  }
}
