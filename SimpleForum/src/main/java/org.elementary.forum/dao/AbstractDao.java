package org.elementary.forum.dao;

import org.elementary.forum.entity.AbstractEntity;
import org.hibernate.Session;

public abstract class AbstractDao<T extends AbstractEntity> implements IDao<T>
{
  @Override
  public T create(T item)
  {
    if (item.getId() == null)
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(item);
      session.getTransaction().commit();
      session.close();
    }

    return item;
  }

  @Override
  public void update(T item)
  {
    if (item.getId() != null)
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(item);
      session.getTransaction().commit();
      session.close();
    }
  }

  @Override
  public void delete(long id)
  {
    T item=read(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.delete(item);
    session.flush();
    session.getTransaction().commit();
    session.close();
  }
}
