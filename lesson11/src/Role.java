public class Role extends ValueObject
{
  protected String description;

  public Role(String name, String description)
  {
    this.name = name;
    this.description = description;
  }

  public Role(long id, String name, String description)
  {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString()
  {
    return "Role{" +
        "description='" + description + '\'' +
        ", id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
