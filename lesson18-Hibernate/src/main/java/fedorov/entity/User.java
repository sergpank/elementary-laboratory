package fedorov.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private long id;

  @Column
  private String login;
  @Column
  private String password;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private List<Post> posts;

  @Column(name = "registration_date")
  @Temporal(TemporalType.DATE)
  private Date registrationDate;

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getLogin()
  {
    return login;
  }

  public void setLogin(String login)
  {
    this.login = login;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public List<Post> getPosts()
  {
    return posts;
  }

  public void setPosts(List<Post> posts)
  {
    this.posts = posts;
  }

  public Date getRegistrationDate()
  {
    return registrationDate;
  }

  public void setRegistrationDate(Date registrationDate)
  {
    this.registrationDate = registrationDate;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id=").append(id);
    sb.append(", login='").append(login).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", posts=").append(posts.toString());
    sb.append(", registrationDate=").append(registrationDate);
    sb.append('}');
    return sb.toString();
  }
}
