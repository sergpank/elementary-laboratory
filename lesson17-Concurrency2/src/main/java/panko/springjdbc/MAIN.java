package panko.springjdbc;

import java.util.List;

public class MAIN
{
  public static void main(String[] args)
  {
    List<User> users = new UserDAO().readAll();

    users.forEach(System.out::println);
  }
}
