public class Group extends ValueObject
{
  protected String description;

  public Group(String name, String description)
  {
    this.name = name;
    this.description = description;
  }

  public Group(long id,String name, String description)
  {
    this.id = id;
    this.name = name;
    this.description = description;
  }
  public Group(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    if(this.description == null)
    {
      return "Group{" +
          "name='" + name + '\'' +
          '}';
    }
    else
    {
      return "Group{" +
          "description='" + description + '\'' +
          ", id=" + id +
          ", name='" + name + '\'' +
          '}';
    }
  }

}
