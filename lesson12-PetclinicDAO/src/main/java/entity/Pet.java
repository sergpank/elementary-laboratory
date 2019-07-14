package entity;

import java.util.Date;

public class Pet
{
  private long id;
  private String name;
  private Date birthDate;
  private String type;

  public Pet(String name, Date birthDate, String type)
  {
    this(0, name, birthDate, type);
  }

  public Pet(long id, String name, Date birthDate, String type)
  {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.type = type;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
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

  public Date getBirthDate()
  {
    return birthDate;
  }

  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }
}
