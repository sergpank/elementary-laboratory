public class Role extends ValueObject
{
  private String description;

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

  public Role()
  {

  }

  public String getDescription()
  {
    return description;
  }

  @Override
  public String toString()
  {
    return super.getId()+ "\t | "+
        super.getName()+ "\t | "+
        getDescription()+ "\t | ";
  }
}
