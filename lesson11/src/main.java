import java.sql.*;

public class main
{
  public static void main(String[] args) throws SQLException
  {
    UsersDAO usersDAO = new UsersDAO();
    GroupsDAO groupsDAO = new GroupsDAO();
    RolesDAO rolesDAO = new RolesDAO();
    Connection connection = ConnectDB.getConnection();

    try
    {
      Statement statement = connection.createStatement();

      //groupsDAO.create(statement, new Group("others","boring things"));
      //groupsDAO.create(statement, new Group("programmers","work hard die young"));
      //rolesDAO.create(statement, new Role("employees","do some things"));
      //rolesDAO.create(statement, new Role("elite_guard","creating shit-style code"));
      //usersDAO.create(statement, new User("Kolya","randomlogin","1111", new Group("others")));
      //usersDAO.create(statement, new User("Petya","petrrr","123qweasd", new Group("programmers")));
      //usersDAO.create(statement, new User("Kirill","kirilllok","qazwsxedc", new Group("programmers")));
      //usersDAO.create(statement, new User("Vasya","vaska","plre", new Group("others")));
      //usersDAO.create(statement, new User("Sveta","svetik","g123d", new Group("programmers")));
      //System.out.println(usersDAO.read(statement,25));
      /*ArrayList<User> show = usersDAO.read(statement);
      for(User a : show)
      {
        System.out.println(a);
      }*/

      //usersDAO.delete(statement, 26);
      //usersDAO.create(statement, new User("Vasya","vaska","plre", new Group("others")));
      //usersDAO.update(statement, new User("Vasylissa","vaska","12234543221", new Group("others")), 28);
      //System.out.println(groupsDAO.read(statement,4));
      /*ArrayList<Group> show = groupsDAO.read(statement);
      for(Group a : show)
      {
        System.out.println(a);
      }*/
      //groupsDAO.update(statement, new Group("tekst", "loolitworking"), 5);
      //groupsDAO.delete(statement, 5);
      //System.out.println(rolesDAO.read(statement, 2));
      /*ArrayList<Role> show = rolesDAO.read(statement);
      for(Role a : show)
      {
        System.out.println(a);
      }*/
      //rolesDAO.create(statement, new Role("test", "testing"));
      //rolesDAO.update(statement, new Role("lol", "works"), 3);
      //rolesDAO.delete(statement, 3);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      connection.close();
    }

  }
}
