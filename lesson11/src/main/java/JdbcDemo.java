import dao.GroupDAO;
import dao.UserDAO;
import vo.Group;
import vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
    GroupDAO groupDAO = new GroupDAO();
    System.out.println(groupDAO.read(1));
    UserDAO userDAO = new UserDAO();
    System.out.println(userDAO.read());
    /*System.out.println(userDAO.create(new Group("my group","test create")));
    System.out.println(userDAO.update(new Group(4,"my group","test update")));
    System.out.println(userDAO.read(4));
    System.out.println(userDAO.delete(4));
    System.out.println(userDAO.read());*/
  }
}
