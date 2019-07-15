package org.elementary.forum.dao;

import org.elementary.forum.entity.Group;
import org.elementary.forum.entity.User;
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
    session.close();
    return group;
  }

  @Override
  public List<Group> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Group> groups = session.createQuery("from Group").list();
    session.close();
    return groups;
  }

  @Override
  public Group loadDependentProperty(Group item, String propName)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.update(item);
    if(propName.equals("users"))
    {
      for(User u : item.getUsers())
      {

      }
    }
    session.close();
    return item;
  }

  public Group readByName(String groupName)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Group> groups = session.createQuery("from Group as g where g.name= :name")
        .setParameter("name", groupName)
        .list();
    session.close();
    return groups.size()>0? groups.get(0) : null;
  }
}
