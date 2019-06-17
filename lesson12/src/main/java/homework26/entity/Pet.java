package homework26.entity;

import homework26.dao.DateConverter;

import java.time.LocalDate;
import java.util.Objects;

public class Pet
{
  private long id;
  private String name;
  private String type;
  private LocalDate birthDate;
  private Client master;

  public Pet(long id, String name, String type, LocalDate birthDate, Client master)
  {
    this.id = id;
    this.name = name;
    this.type = type;
    this.birthDate = birthDate;
    this.master = master;
  }

  public long getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }

  public LocalDate getBirthDate()
  {
    return birthDate;
  }

  public Client getMaster()
  {
    return master != null ? master.copy() : null;
  }

  public Pet copy()
  {
    Pet clone = new Pet(id, name, type, birthDate, master);

    return clone;
  }

  @Override
  public boolean equals(Object obj)
  {
    boolean result = false;

    if (this == obj)
    {
      result = true;
    }
    else if (obj != null && getClass() == obj.getClass())
    {
      Pet pet = (Pet) obj;
      result = this.getId() == pet.getId() &&
          Objects.equals(this.getName(), pet.getName()) &&
          Objects.equals(this.getType(), pet.getType());
    }

    return result;
  }

  @Override
  public String toString()
  {
    return String.format("%s (%s), birth: %s", getName(), getType(), DateConverter.dateToString(getBirthDate()));
  }
}
