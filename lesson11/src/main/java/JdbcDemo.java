import dao.GroupDAO;
import dao.RoleDAO;
import dao.UserDAO;
import vo.Group;
import vo.Role;
import vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
    RoleDAO userDao = new RoleDAO();
    System.out.println("create role " + userDao.create(new Role("my group1", "test create")));
    System.out.println("update role " + userDao.update(new Role(4, "my group2", "test update")));
    System.out.println(userDao.read(4));
    System.out.println("delete role " + userDao.delete(4));
    System.out.println(userDao.read());
  }
}
