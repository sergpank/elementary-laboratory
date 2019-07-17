package com.elementary.forum.dao;

import com.elementary.forum.entites.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@FunctionalInterface
public interface SessionWrapper
{
  void execute(Session s, Topic t);

  default void wrap(SessionFactory factory, Topic topic)
  {
    Session session = factory.openSession();
    Transaction transaction = session.beginTransaction();

    try
    {
      execute(session, topic);
    }
    catch (Exception e)
    {
      transaction.rollback();
    }
    finally
    {
      transaction.commit();
      session.close();
    }
  }
}
