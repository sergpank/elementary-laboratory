package org.elementary.forum.entity;
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
}
