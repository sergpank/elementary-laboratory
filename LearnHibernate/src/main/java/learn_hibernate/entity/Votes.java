package learn_hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="votes")
public class Votes extends AbstractEntity
{
  @Column(name="up_votes")
  private int upVotes;
  @Column(name ="down_votes")
  private int downVotes;
  @OneToOne(optional = false)
  @JoinColumn(name="post_id")
  private Post post;

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

}
