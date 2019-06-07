import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class GroupDAO extends DAO<Group>
{
  public static void main(String[] args)
  {
    GroupDAO groupTable = new GroupDAO();

    // CRUD with groupTable
    //groupTable.create(new Group("Black Hall", "about Space"));
    //groupTable.read();
    //groupTable.read(3);
    //groupTable.update(new Group(6,"Black Hall","about Space"));
    //groupTable.delete(6);

    groupTable.close();
  }

  List<Group> groupsList = new ArrayList<Group>();

  public GroupDAO()
  {
    open();
  }

  public boolean create(Group group)
  {
    try
    {
      String name = group.getName();
      String description = group.getDescription();

      String query =
          "INSERT INTO Groups (group_name, group_description) " +
              "VALUES ('" + name + "','" + description + "')";

      PreparedStatement statement = connection.prepareStatement(query);
      statement.executeUpdate();
      System.out.println("New record added in Groups table ");
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

  public List<Group> read()
  {
    try
    {
      String query =
          "SELECT * FROM Groups";

      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet rs = statement.executeQuery();
      while (rs.next())
      {
        long groupId = rs.getLong("group_id");
        String groupName = rs.getString("group_name");
        String groupDescription = rs.getString("group_description");

        groupsList.add(new Group(groupId, groupName, groupDescription));
      }
      rs.close();
      statement.close();
      for (Group group : groupsList)
      {
        System.out.println(group);
      }
      System.out.println("All records were retrived");
      return groupsList;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return new ArrayList<Group>();
    }
  }

  public Group read(long id)
  {
    try
    {
      String query =
          "SELECT * " +
              "FROM Groups " +
              "WHERE group_id= '" + id + "'";

      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet rs = statement.executeQuery();

      String name = rs.getString("group_name");
      String description = rs.getString("group_description");

      Group group = new Group(id, name, description);
      System.out.println(group);

      rs.close();
      statement.close();

      return group;
    }
    catch (Exception e)
    {
      e.getMessage();
      System.out.println("Record with current ID: '" + id + "' is absent ");
      return new Group();

    }
  }

  public boolean update(Group group)
  {
    try
    {
      long id = group.getId();
      String name = group.getName();
      String discription = group.getDescription();

      String query =
              "UPDATE Groups " +
              " SET group_name='" + name + "', group_description='" + discription + "' " +
              " WHERE group_id='" + id + "'";

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
          "DELETE FROM Groups " +
              "WHERE group_id='" + id + "'";

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
