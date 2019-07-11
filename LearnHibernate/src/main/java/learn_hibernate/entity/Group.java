package learn_hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups_table")
public class Group extends AbstractEntity
{
  @Column(name = "group_name")
  private String name;

  @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
  private List<User> users;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public List<User> getUsers()
  {
    return users;
  }

  public void setUsers(List<User> users)
  {
    this.users = users;
  }

  @Override
  public String toString()
  {
    return "Group{" +
        "id=" + super.getId() +
        ", name='" + name + '\'' +
        ", users=" + (users != null ? users : "none") +
        '}';
  }
}
