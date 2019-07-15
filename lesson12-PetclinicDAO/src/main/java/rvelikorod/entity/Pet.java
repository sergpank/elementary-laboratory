package rvelikorod.entity;

import java.util.Date;
import java.util.List;

public class Pet
{
  private long id;
  private String name;
  private Date birthDate;
  private String type;
  private Long masterId;

  public Pet(String name, Date birthDate, String type, Long masterId)
  {
    this(0, name, birthDate, type, masterId);
  }

  public Pet(long id, String name, Date birthDate, String type, Long masterId)
  {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.type = type;
    this.masterId = masterId;
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

  public void setMasterId(Long masterId)
  {
    this.masterId = masterId;
  }

  public Long getMasterId()
  {
    return masterId;
  }

  @Override
  public String toString()
  {
    return "Pet{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", birthDate=" + birthDate +
        ", type='" + type + '\'' +
        ", masterId=" + masterId +
        '}';
  }
}
