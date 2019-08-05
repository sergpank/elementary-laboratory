
import rvelikorod.dao.UserDao;
import rvelikorod.entity.Post;
import rvelikorod.entity.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MAIN
{
  public static void main(String[] args)
  {
    UserDao userDao = new UserDao();

//    User user = new User();
//    user.setLogin("my-login-2");
//    user.setPassword("my-password-2");
//    user.setRegistrationDate(new Date());
//
//    Post post1 = new Post();
//    post1.setAuthor(user);
//    post1.setDateCreated(new Date());
//    post1.setText("Post 3 message");
//
//    Post post2 = new Post();
//    post2.setAuthor(user);
//    post2.setDateCreated(new Date());
//    post2.setText("Post 4 message");
//
//    List<Post> posts = Arrays.asList(post1, post2);
//
//    user.setPosts(posts);
//
//    userDao.save(user);
//    System.out.println(user);

    List<User> users = userDao.loadAll();
    for (User user : users)
    {
      System.out.println(user);
    }
  }
}
