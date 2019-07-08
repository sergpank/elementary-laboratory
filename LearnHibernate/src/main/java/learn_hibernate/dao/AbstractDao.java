package learn_hibernate.dao;

import learn_hibernate.entity.AbstractEntity;
import org.hibernate.Session;

public abstract class AbstractDao<T extends AbstractEntity> implements IDao<T>
{
  @Override
  public T create(T item)
  {
    if(item.getId()==0)
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
    if(item.getId()!=0)
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(item);
      session.getTransaction().commit();
      session.close();
    }
  }

  @Override
  public void delete(T item)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.delete(item);
    session.close();
  }
}
