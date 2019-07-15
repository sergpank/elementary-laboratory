package rvelikorod.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic
{
  @Id
  @GeneratedValue(generator = "inrcement")
  @GenericGenerator(name = "increment", strategy = "increment")
  private long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User author;

  @Column
  private String title;

  @Column(name = "date_created")
  @Temporal(TemporalType.DATE)
  private Date dateCreated;

  @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private List<Post> posts;


  public long getId()
  {
    return id;
  }

  public User getAuthor()
  {
    return author;
  }

  public String getTitle()
  {
    return title;
  }

  public Date getDateCreated()
  {
    return dateCreated;
  }

  public List<Post> getPosts()
  {
    return posts;
  }


  public void setId(long id)
  {
    this.id = id;
  }

  public void setAuthor(User author)
  {
    this.author = author;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setDateCreated(Date dateCreated)
  {
    this.dateCreated = dateCreated;
  }

  public void setPosts(List<Post> posts)
  {
    this.posts = posts;
  }

}
