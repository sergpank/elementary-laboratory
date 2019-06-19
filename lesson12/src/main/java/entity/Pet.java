package entity;

import java.util.Date;

public class Pet
{
  private long id;
  private String name;
  private Date birthDate;
  private String type;
  private long master_id;



  public Pet(String name, Date birthDate, String type,long master)
  {
    this(0, name, birthDate, type,master);
  }

  public long getMaster_id()
  {
    return master_id;
  }

  public void setMaster_id(long master_id)
  {
    this.master_id = master_id;
  }

  @Override
  public String toString()
  {
    return "Pet{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", birthDate=" + birthDate +
        ", type='" + type + '\'' +
        ", master_id=" + master_id +
        '}' + "\n";
  }

  public Pet(long id, String name, Date birthDate, String type, long master)
  {
    this.master_id = master;
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

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }

    Pet pet = (Pet) o;

    if (name != null ? !name.equals(pet.name) : pet.name != null)
    {
      return false;
    }
    if (birthDate != null ? !birthDate.equals(pet.birthDate) : pet.birthDate != null)
    {
      return false;
    }
    return type != null ? type.equals(pet.type) : pet.type == null;
  }

  @Override
  public int hashCode()
  {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
    result = 31 * result + (type != null ? type.hashCode() : 0);
    return result;
  }
}
