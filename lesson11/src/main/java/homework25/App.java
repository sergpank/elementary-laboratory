package homework25;


import homework25.dao.GroupDao;
import homework25.dao.RoleDao;
import homework25.dao.UserDao;
import homework25.dao.connection.SqliteConnectionFactory;
import homework25.models.User;
import homework25.view_components.AppFrame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class App
{
  public static void main(String[] args)
  {
    SqliteDbHelper h = new SqliteDbHelper(new SqliteConnectionFactory("db/test.db"));
    h.initDb("db/create.sql");

    SqliteConnectionFactory connectionFactory = new SqliteConnectionFactory("db/test.db");
    UserDao userDao = new UserDao(connectionFactory);
    GroupDao groupDao = new GroupDao(connectionFactory);
    RoleDao roleDao = new RoleDao(connectionFactory);

    EventQueue.invokeLater(() -> {
      JFrame frame = new AppFrame(groupDao, userDao, roleDao);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });

  }

}
