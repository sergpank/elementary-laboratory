package org.elementary.forum.dao;

import org.elementary.forum.entity.Votes;
import org.hibernate.Session;

import java.util.List;

public class VotesDao extends AbstractDao<Votes>
{
  @Override
  public Votes read(long id)
  {
    Long key = Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Votes votes = session.get(Votes.class, key);
    session.getTransaction().commit();
    session.close();
    return votes;
  }

  @Override
  public List<Votes> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Votes> votesList = session.createQuery("from Votes").list();
    session.getTransaction().commit();
    session.close();
    return votesList;
  }

  public Votes readByPostId(long postId)
  {
    Long key=Long.valueOf(postId);
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Votes> votesList = session.createQuery("from Votes as v where post.id= :postId")
        .setParameter("postId", key)
        .list();
    session.getTransaction().commit();
    session.close();
    return votesList.size()>0?votesList.get(0):null;
  }

  @Override
  public Votes loadDependentProperty(Votes item, String propName)
  {
    return item;
  }
}
