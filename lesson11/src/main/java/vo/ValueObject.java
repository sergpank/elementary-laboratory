package vo;

public abstract class ValueObject
{
  protected int id;
  protected String name;

  public ValueObject(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public ValueObject(String name)
  {
    this.name = name;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "vo.ValueObject{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
