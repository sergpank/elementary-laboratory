package rvelikorod.entity;

import javax.persistence.*;

@Embeddable
@Table(name = "votes")
public class Votes
{
  @Column
  private int upVotes;

  @Column
  private int downVotes;

  @OneToOne
  @JoinColumn(name = "post_id", referencedColumnName = "id")
  private Post post;

  @OneToOne
  @JoinColumn(name = "topic_id", referencedColumnName = "id")
  private Topic topic;

  public int getUpVotes()
  {
    return upVotes;
  }

  public int getDownVotes()
  {
    return downVotes;
  }

  public Post getPost()
  {
    return post;
  }

  public Topic getTopic()
  {
    return topic;
  }

  public void setUpVotes(int upVotes)
  {
    this.upVotes = upVotes;
  }

  public void setDownVotes(int downVotes)
  {
    this.downVotes = downVotes;
  }

  public void setPost(Post post)
  {
    this.post = post;
  }

  public void setTopic(Topic topic)
  {
    this.topic = topic;
  }
}
