package vo;

public class Role extends ValueObject
{
  private String description ;

  public Role(int id, String name, String description)
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

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Override
  public String toString()
  {
    return "vo.Role{" +
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

    Role rol = (Role) o;

    return description != null ? description.equals(rol.description) : rol.description == null;
  }

  @Override
  public int hashCode()
  {
    return description != null ? description.hashCode() : 0;
  }
}
