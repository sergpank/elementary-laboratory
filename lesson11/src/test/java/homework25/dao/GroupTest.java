package homework25.dao;

import homework25.SqliteDbHelper;
import homework25.dao.connection.SqliteConnectionFactory;
import homework25.models.Group;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GroupTest
{
  private SqliteDbHelper helper;

  public GroupTest()
  {
    helper = new SqliteDbHelper(new SqliteConnectionFactory("db/test2.db"));

    helper.initDb("db/create.sql");


  }

  @Test
  public void test1()
  {
    helper.clearTable("groups");

    GroupDao groupDao = new GroupDao(new SqliteConnectionFactory("db/test2.db"));

    String[] names = {"admins", "managers", "users"};

    for (String name : names)
    {
      groupDao.create(new Group(name));
    }

    List<Group> groups = groupDao.read();
    List<String> namesList = Arrays.asList(names);

    for (Group group : groups)
    {
      assertTrue(namesList.contains(group.getName()));
    }

    assertEquals(namesList.size(), groups.size());

    Group removed = groups.remove(0);

    assertTrue(groupDao.delete(removed.getId()));

    assertFalse(groupDao.delete(removed.getId()));

    List<Group> groups2 = groupDao.read();

    assertEquals(groups.size(), groups2.size());

    Group group = groups2.get(0);

    String newName = "newName";

    Group modifiedGroup = new Group(group.getId(), newName);

    assertTrue(groupDao.update(modifiedGroup));

    Group actual = groupDao.read(modifiedGroup.getId());

    assertEquals(modifiedGroup.getName(), newName);
  }
}
