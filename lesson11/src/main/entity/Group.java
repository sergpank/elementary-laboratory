package main.entity;

import java.util.List;

public class Group extends ValueObject
{
  private String description;
  private List<Role> roles;


  public String getDescription()
  {
    return description;
  }



  public Group(long id)
  {
    super(id);
  }

  public Group(long id, String name, String description)
  {
    super(id, name);
    this.description = description;
  }

  public Group(long id, String name, String description, List<Role> roles)
  {
    super(id, name);
    this.description = description;
    this.roles = roles;
  }
  public Group(String name, String description)
  {
    super(name);
    this.description = description;
  }

  @Override
  public String toString()
  {
    return "Group{" +
        "description='" + description + '\'' +
        ", roles=" + roles +
        ", id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
