import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class UserDAO extends DAO<User>
{
  public static void main(String[] args)
  {
    UserDAO users = new UserDAO();


    // CRUD with Tables
    //users.create(new User("Serg","Lego","password", new Group(5)));
    //users.read();
    //users.read(5);
    //users.update(new User(10,"Nick","Fin","passwordsss",new Group(3) ));
    //users.delete(15);


    users.close();

  }

  List<User> usersList = new ArrayList<User>();

  public UserDAO()
  {
    open();
  }

  public boolean create(User user)
  {
    try
    {
      String name = user.getName();
      String login = user.getLogin();
      String password = user.getPassword();
      long groupID = user.getGroup().getId();

      String query =
          "INSERT INTO Users (name, login, password, group_id) " +
              "VALUES ('" + name + "','" + login + "','" + password + "','" + groupID + "')";

      PreparedStatement statement = connection.prepareStatement(query);
      statement.executeUpdate();
      System.out.println("New record added in Users table ");
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

  public List<User> read()
  {
    try
    {
      String query =
          "SELECT id, name, login, password, Groups.group_id, group_name, group_description "+
          "FROM Users "+
          "LEFT JOIN Groups "+
          "ON Users.group_id=Groups.group_id; ";

      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet rs = statement.executeQuery();
      while (rs.next())
      {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String login = rs.getString("login");
        String password = rs.getString("password");
        long groupID = rs.getLong("group_id");
        String groupName = rs.getString("group_name");
        String groupDescription = rs.getString("group_description");


        Group group = new Group(groupID,groupName,groupDescription);

        usersList.add(new User(id, name, login, password, group));
      }
      rs.close();
      statement.close();
      for (User user : usersList)
      {
        System.out.println(user);
      }
      System.out.println("All records were retrived");
      return usersList;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return new ArrayList<User>();
    }
  }

  public User read(long id)
  {
    try
    {
      String query =

          "SELECT name, login, password, Groups.group_id, group_name, group_description "+
              "FROM Users "+
              "LEFT JOIN Groups "+
              "ON Users.group_id=Groups.group_id "+
              "WHERE id= '" + id + "'";

      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet rs = statement.executeQuery();

      String name = rs.getString("name");
      String login = rs.getString("login");
      String password = rs.getString("password");
      long groupID = rs.getLong("group_id");
      String groupName = rs.getString("group_name");
      String groupDescription = rs.getString("group_description");

      Group group= new Group(groupID,groupName,groupDescription);

      User user = new User(id,name, login, password, group);

      rs.close();
      statement.close();
      System.out.println(user);
      System.out.println("Record with current ID: '" + id + "' was retrived");

      return user;
    }
    catch (Exception e)
    {
      e.getMessage();
      System.out.println("Record with current ID: '" + id + "' is absent ");
      return new User();

    }
  }

  public boolean update(User user)
  {
    try
    {
      long id = user.getId();
      String name = user.getName();
      String login = user.getLogin();
      String password = user.getPassword();
      long groupID = user.getGroup().getId();

      String query =
              "UPDATE Users " +
              " SET name='" + name + "', login='" + login + "', password='" + password + "', group_id='" + groupID + "'" +
              "WHERE id= '" + id+ "'";

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
          "DELETE FROM Users " +
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
