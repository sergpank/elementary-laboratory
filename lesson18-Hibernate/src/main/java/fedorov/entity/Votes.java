package fedorov.entity;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Votes
{
  @Column
  private int upVotes;

  @Column
  private int downVotes;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="post_id", referencedColumnName = "id")
  private Post post;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="topic_id", referencedColumnName = "id")
  private Topic topic;

  public int getUpVotes()
  {
    return upVotes;
  }

  public void setUpVotes(int upVotes)
  {
    this.upVotes = upVotes;
  }

  public int getDownVotes()
  {
    return downVotes;
  }

  public void setDownVotes(int downVotes)
  {
    this.downVotes = downVotes;
  }

  public Post getPost()
  {
    return post;
  }

  public void setPost(Post post)
  {
    this.post = post;
  }

  public Topic getTopic()
  {
    return topic;
  }

  public void setTopic(Topic topic)
  {
    this.topic = topic;
  }
}
