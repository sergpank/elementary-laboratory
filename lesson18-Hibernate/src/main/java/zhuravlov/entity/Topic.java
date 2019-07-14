package zhuravlov.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic
{
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private long id;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User author;

  @Column
  private String title;

  @Column(name = "date_created")
  @Temporal(TemporalType.DATE)
  private Date dateCreated;

  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private List<Post> posts;
}
