package main;

import main.dao.GroupDAO;
import main.dao.RoleDAO;
import main.dao.UserDAO;
import main.entity.Group;
import main.entity.Role;
import main.entity.User;

public class Main
{
  public static void main(String[] args)
  {
    User user1 = new User("Alexandr Alexndrov", "alex", "32", new Group(3));
    User user2 = new User(1, "Denis Denisov", "den", "2343", new Group(1));
    UserDAO userDAO = new UserDAO();
//    System.out.println(userDAO.read(14));
    userDAO.readAll().forEach(System.out::println);
//    userDAO.create(user1);
//    userDAO.update(user2);
//    userDAO.delete(13);
    Group group1 = new Group(6, "blacklist","don't have any access");
    Group group2 = new Group("test", "test");
    GroupDAO groupDAO = new GroupDAO();
//    groupDAO.readAll().forEach(System.out::println);
//    System.out.println(groupDAO.read(2));
//    groupDAO.create(group2);
//    groupDAO.update(group1);
//    groupDAO.delete(6);
    Role role1 = new Role(5,"w", "no description");
    Role role2 = new Role("test", "test");
    RoleDAO roleDAO = new RoleDAO();
//    roleDAO.readAll().forEach(System.out::println);
//    System.out.println(roleDAO.read(2));
//    roleDAO.create(role2);
//    roleDAO.update(role1);
//    roleDAO.delete(5);
  }
}
