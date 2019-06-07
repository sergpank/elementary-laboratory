public class ValueObject
{
  private long id;
  private String name;

  public ValueObject(long id, String name)
  {
    this.id = id;
    this.name = name;
  }
  public ValueObject(String name)
  {
    this.name = name;
  }

  public ValueObject(long id)
  {
    this.id = id;
  }

  public ValueObject()
  {
  }


  public long getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }


  @Override
  public String toString()
  {
    return "ValueObject{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
