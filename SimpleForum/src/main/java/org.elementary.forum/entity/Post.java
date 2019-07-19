package org.elementary.forum.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post extends AbstractEntity
{
  @Column(name = "content", length = 2000)
  private String text;
  @Temporal(TemporalType.DATE)
  @Column(name = "date_created")
  private Date dateCreated;
  @ManyToOne(optional = false)
  @JoinColumn(name = "author_id")
  private User author;
  @OneToOne(optional = false, cascade = CascadeType.ALL, mappedBy = "post")
  private Votes votes;
  @ManyToOne(optional = false)
  @JoinColumn(name = "topic_id")
  private Topic topic;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
  List<Post> children;
  @ManyToOne(optional = true)
  @JoinColumn(name = "parent_id")
  Post parent;

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

  public User getAuthor()
  {
    return author;
  }

  public void setAuthor(User author)
  {
    this.author = author;
  }

  public Votes getVotes()
  {
    return votes;
  }

  public void setVotes(Votes votes)
  {
    this.votes = votes;
  }

  public Topic getTopic()
  {
    return topic;
  }

  public void setTopic(Topic topic)
  {
    this.topic = topic;
  }

  public Post getParent()
  {
    return parent;
  }

  public void setParent(Post parent)
  {
    this.parent = parent;
  }

  public List<Post> getChildren()
  {
    return children;
  }
  public void setChildren(List<Post> children)
  {
    this.children = children;
  }
}
