package main.entity;

public abstract class ValueObject
{
  protected long id;
  protected String name;

  public ValueObject(long id, String name)
  {
    this.id = id;
    this.name = name;
  }
  public ValueObject(String name)
  {
    this.name = name;
  }

  public long getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public ValueObject(long id)
  {
    this.id = id;
  }
}
