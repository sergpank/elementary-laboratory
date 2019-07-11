package learn_hibernate.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AbstractEntity
{
  @Column
  private String login;
  @Column
  private String password;
  @Temporal(TemporalType.DATE)
  @Column(name = "registration_date")
  private Date registrationDate;
  @ManyToOne(optional = false)
  @JoinColumn(name = "group_id")
  private Group group;
  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private List<Post> posts;
  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private List<Topic> topics;

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

  public Date getRegistrationDate()
  {
    return registrationDate;
  }

  public void setRegistrationDate(Date registrationDate)
  {
    this.registrationDate = registrationDate;
  }

  public Group getGroup()
  {
    return group;
  }

  public void setGroup(Group group)
  {
    this.group = group;
  }

  public List<Post> getPosts()
  {
    return posts;
  }

  public void setPosts(List<Post> posts)
  {
    this.posts = posts;
  }

  @Override
  public String toString()
  {
    return "User{" +
        "id=" + super.getId() +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", registrationDate=" + registrationDate +
        ", group=" + group.getName() +
        '}';
  }

  public List<Topic> getTopics()
  {
    return topics;
  }

  public void setTopics(List<Topic> topics)
  {
    this.topics = topics;
  }
}
