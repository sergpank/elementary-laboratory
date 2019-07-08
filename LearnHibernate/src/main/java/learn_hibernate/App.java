package learn_hibernate;

import learn_hibernate.dao.*;
import learn_hibernate.entity.*;
import learn_hibernate.entity.builder.*;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IllegalAccessException
    {
        UserDao ud=new UserDao();
        TopicDao td=new TopicDao();
        GroupDao gd=new GroupDao();
        PostDao pd=new PostDao();
        VotesDao vd=new VotesDao();

        Group g=new GroupBuilder().setName("users2").build();
        gd.create(g);

        User u=new UserBuilder()
            .setLogin("petya")
            .setPassword("petya123")
            .setRegistrationDate(new Date())
            .setGroup(g).build();
        ud.create(u);

        Topic t=new TopicBuilder()
            .setTitle("title2")
            .setDateCreated(new Date())
            .setAuthor(u).build();
        td.create(t);
        Post p=new PostBuilder()
            .setAuthor(u)
            .setDateCreated(new Date())
            .setText("Text").setTopic(t).build();
        pd.create(p);

        Votes v=new VotesBuilder().setPost(p).build();
        vd.create(v);
        v.setUpVotes(5);
        vd.update(v);
        p=pd.read(p.getId());
        System.out.println(p.getVotes().getUpVotes());
        Session s=HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();

        s.getTransaction().commit();
        s.close();
    }
}
