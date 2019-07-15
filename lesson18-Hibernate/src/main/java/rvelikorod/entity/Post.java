package rvelikorod.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post
{
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User author;

  @Column
  private String text;

  @Column(name = "date_created")
  @Temporal(TemporalType.DATE)
  private Date dateCreated;

  @ManyToOne
  @JoinColumn(name = "topic_id")
  private Topic topic;


  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public User getAuthor()
  {
    return author;
  }

  public void setAuthor(User author)
  {
    this.author = author;
  }

  public String getText()
  {
    return text;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public Date getDateCreated()
  {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated)
  {
    this.dateCreated = dateCreated;
  }

  public Topic getTopic()
  {
    return topic;
  }

  public void setTopic(Topic topic)
  {
    this.topic = topic;
  }


  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("Post{");
    sb.append("id=").append(id);
    sb.append(", author=").append(author.getId());
    sb.append(", text='").append(text).append('\'');
    sb.append(", dateCreated=").append(dateCreated);
    sb.append('}');
    return sb.toString();
  }
}
