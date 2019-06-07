public class Group extends ValueObject
{
  private String description;

  public Group(long id, String name, String description)
  {
    super(id, name);
    this.description = description;
  }
  public Group(String name, String description)
  {
    super(name);
    this.description = description;
  }

  public Group(long id)
  {
    super(id);
  }

  public Group()
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
        getDescription()+ "\t ";
  }
}
