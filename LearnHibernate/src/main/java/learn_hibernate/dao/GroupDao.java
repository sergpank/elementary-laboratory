package learn_hibernate.dao;

import learn_hibernate.entity.Group;
import learn_hibernate.entity.User;
import org.hibernate.Session;

import java.util.List;

public class GroupDao extends AbstractDao<Group>
{
  @Override
  public Group read(long id)
  {
    Long key = Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    Group group = session.get(Group.class, key);
    if (group != null)
    {
      loadUsers(group);
    }
    session.close();
    return group;
  }

  @Override
  public List<Group> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Group> groups = session.createQuery("from Group").list();
    for (Group g : groups)
    {
      loadUsers(g);
    }
    session.close();
    return groups;
  }

  private void loadUsers(Group group)
  {
    for (User u : group.getUsers())
    {
      ;
    }
  }
}
