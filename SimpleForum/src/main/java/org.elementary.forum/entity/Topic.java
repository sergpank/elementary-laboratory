package org.elementary.forum.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic extends AbstractEntity
{
  @Column(name = "topic_title")
  private String title;
  @Temporal(TemporalType.DATE)
  @Column(name = "date_created")
  private Date dateCreated;
  @ManyToOne(optional = false)
  @JoinColumn(name = "author_id")
  private User author;
  @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
  private List<Post> posts;

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public Date getDateCreated()
  {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated)
  {
    this.dateCreated = dateCreated;
  }

  public User getAuthor()
  {
    return author;
  }

  public void setAuthor(User author)
  {
    this.author = author;
  }

  public List<Post> getPosts()
  {
    return posts;
  }

  public void setPosts(List<Post> posts)
  {
    this.posts = posts;
  }
}
