import java.sql.*;

public class main
{
  public static Connection connection = ConnectDB.getConnection();
  public static void main(String[] args) throws SQLException
  {
    UsersDAO usersDAO = new UsersDAO();
    GroupsDAO groupsDAO = new GroupsDAO();
    RolesDAO rolesDAO = new RolesDAO();

      //groupsDAO.create(new Group("others","boring things"));
      //groupsDAO.create(new Group("programmers","work hard die young"));
      //rolesDAO.create(new Role("employees","do some things"));
      //rolesDAO.create(new Role("elite_guard","creating shit-style code"));
      //usersDAO.create(new User("Kolya","randomlogin","1111", new Group("others")));
      //usersDAO.create(new User("Petya","petrrr","123qweasd", new Group("programmers")));
      //usersDAO.create(new User("Kirill","kirilllok","qazwsxedc", new Group("programmers")));
      //usersDAO.create(new User("Vasya","vaska","plre", new Group("others")));
      //usersDAO.create(new User("Sveta","svetik","g123d", new Group("programmers")));
      //System.out.println(usersDAO.read(25));
      /*ArrayList<User> show = usersDAO.read();
      for(User a : show)
      {
        System.out.println(a);
      }*/

      //usersDAO.delete(26);
      //usersDAO.create(new User("Vasya","vaska","plre", new Group("others")));
      //usersDAO.update(new User("Vasylissa","vaska","12234543221", new Group("others")), 28);
      //System.out.println(groupsDAO.read(4));
      /*ArrayList<Group> show = groupsDAO.read();
      for(Group a : show)
      {
        System.out.println(a);
      }*/
      //groupsDAO.update(new Group("tekst", "loolitworking"), 5);
      //groupsDAO.delete(5);
      //System.out.println(rolesDAO.read(2));
      /*ArrayList<Role> show = rolesDAO.read();
      for(Role a : show)
      {
        System.out.println(a);
      }*/
      //rolesDAO.create(new Role("test", "testing"));
      //rolesDAO.update(new Role("lol", "works"), 3);
      //rolesDAO.delete(3);

  }
}
