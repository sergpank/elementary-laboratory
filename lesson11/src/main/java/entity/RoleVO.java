package entity;

public class RoleVO extends ValueObject
{

  private String description;
  static int counter = 1;

  {
    this.id = counter++;
  }

  public RoleVO()
  {
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

    RoleVO roleVO = (RoleVO) o;

    return description.equals(roleVO.description);

  }

  @Override
  public int hashCode()
  {
    return description.hashCode();
  }

  @Override
  public String toString()
  {
    return "RoleVO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
