package main.entity;

import java.util.List;

public class Role extends  ValueObject
{
  private String description;
  private List<Group> groups;

  public Role(long id, String name, String description, List<Group> groups)
  {
    super(id, name);
    this.description = description;
    this.groups = groups;
  }

  public Role(long id, String name, String description)
  {
    super(id, name);
    this.description = description;
  }
  public Role(String name, String description)
  {
    super(name);
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }

  @Override
  public String toString()
  {
    return "Role{" +
        "description='" + description + '\'' +
        ", groups=" + groups +
        ", id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
