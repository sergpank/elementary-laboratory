package homework25.dao;

import homework25.SqliteDbHelper;
import homework25.dao.connection.SqliteConnectionFactory;
import homework25.models.Group;
import homework25.models.User;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserTest
{
  private SqliteDbHelper helper;

  public UserTest()
  {
    helper = new SqliteDbHelper(new SqliteConnectionFactory("db/test2.db"));


  }

  @Test
  public void test1()
  {
    helper.clearTable("groups");
    helper.clearTable("users");

    GroupDao groupDao = new GroupDao(new SqliteConnectionFactory("db/test2.db"));
    Group group = new Group("admins");
    groupDao.create(group);
    UserDao userDao = new UserDao(new SqliteConnectionFactory("db/test2.db"));

    group = groupDao.read().get(0);
    User user = new User("vasya", "123", group);

    assertTrue(userDao.create(user));

    User actual = userDao.read().get(0);

    assertNotEquals(actual, user);

    assertEquals(actual.getGroup(), user.getGroup());

    assertEquals(actual.getLogin(), user.getLogin());

    assertEquals(actual.getPassword(), user.getPassword());

  }

  /*
  Read all and delete test
   */
  @Test
  public void test2()
  {
    helper.clearTable("groups");
    helper.clearTable("users");

    GroupDao groupDao = new GroupDao(new SqliteConnectionFactory("db/test2.db"));
    Group group = new Group("admins");
    groupDao.create(group);
    group = groupDao.read().get(0);

    UserDao userDao = new UserDao(new SqliteConnectionFactory("db/test2.db"));

    User[] users = {new User("vasya", "vasya123", group), new User("petya", "petya123", group)};

    for (User user : users)
    {
      userDao.create(user);
    }
    User[] actual = new User[0];

    actual = userDao.read().toArray(actual);

    assertNotEquals(actual, users);

    assertEquals(actual.length, users.length);

    assertEquals(actual[1].getLogin(), users[1].getLogin());

    userDao.delete(actual[0].getId());

    List<User> newList = userDao.read();

    assertEquals(newList.size(), 1);

    assertEquals(actual[1], newList.get(0));

    assertNotEquals(actual[0], newList.get(0));

  }

  /*
  Update test
   */
  @Test
  public void test3()
  {
    helper.clearTable("groups");
    helper.clearTable("users");

    GroupDao groupDao = new GroupDao(new SqliteConnectionFactory("db/test2.db"));
    Group group = new Group("admins");
    groupDao.create(group);
    Group group2 = new Group("users");
    groupDao.create(group2);
    group = groupDao.read().get(0);

    group2 = groupDao.read().get(1);

    UserDao userDao = new UserDao(new SqliteConnectionFactory("db/test2.db"));

    User[] users = {new User("vasya", "vasya123", group), new User("petya", "petya123", group)};

    for (User user : users)
    {
      userDao.create(user);
    }
    User[] current = new User[0];

    current = userDao.read().toArray(current);

    String newPassword = "123456";

    String newLogin = "newLogin";

    User u = new User(current[0].getId(), newLogin, newPassword, group2);

    userDao.update(u);

    User actual = userDao.read(u.getId());

    assertEquals(actual, u);

    User actual2 = userDao.read(current[1].getId());

    assertEquals(actual2, current[1]);

  }
}
