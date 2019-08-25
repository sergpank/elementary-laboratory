package vo;

public class Group extends ValueObject
{
  private String description;

  public Group(int id, String name, String description)
  {
    super(id, name);
    this.description = description;
  }

  public Group(String name, String description)
  {
    super(name);
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Override
  public String toString()
  {
    return "vo.Group{" +
        "description='" + description + '\'' +
        ", id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }

    Group group = (Group) o;

    return description != null ? description.equals(group.description) : group.description == null;
  }

  @Override
  public int hashCode()
  {
    return description != null ? description.hashCode() : 0;
  }
}
