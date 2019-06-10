import dao.UserDao;
import entity.User;

import java.sql.SQLException;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
    final UserDao dao = new UserDao();
    final User mendeleev = new User("Дмитрий Менделеев", "химик", "elementary_table");

    System.out.println("Creating: " + mendeleev);
    dao.create(mendeleev);

    final User read = dao.read(mendeleev.getId());
    System.out.println("Read: " + read);

    System.out.println(read.equals(mendeleev));
  }
}
