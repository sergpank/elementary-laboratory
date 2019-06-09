public class Role extends ValueObject
{
  protected String description;

  public Role(String name, String description)
  {
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
