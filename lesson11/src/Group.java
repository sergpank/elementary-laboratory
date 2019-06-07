public class Group extends ValueObject
{
  protected String description;

  public Group(String name, String description)
  {
    this.id +=1;
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString()
  {
    return "Group{" +
        "description='" + description + '\'' +
        ", id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
