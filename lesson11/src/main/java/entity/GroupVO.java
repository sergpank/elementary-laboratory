package entity;

public class GroupVO extends ValueObject
{
  private String description;
  static int counter=1;

  {
    this.id = counter++;
  }

  public GroupVO()
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

    GroupVO groupVO = (GroupVO) o;

    return description.equals(groupVO.description);

  }

  @Override
  public int hashCode()
  {
    return description.hashCode();
  }

  @Override
  public String toString()
  {
    return "GroupVO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}

