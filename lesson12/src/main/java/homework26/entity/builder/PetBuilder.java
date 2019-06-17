package homework26.entity.builder;

import homework26.entity.Client;
import homework26.entity.Pet;

import java.time.LocalDate;

public class PetBuilder implements IPetBuilder
{
  private long id;
  private String name;
  private String type;
  private LocalDate birthDate;
  private Client master;

  @Override
  public IPetBuilder setId(long id)
  {
    this.id = id;
    return this;
  }

  @Override
  public IPetBuilder setName(String name)
  {
    this.name = name;
    return this;
  }

  @Override
  public IPetBuilder setType(String type)
  {
    this.type = type;
    return this;
  }

  @Override
  public IPetBuilder setBirthDate(LocalDate birthDate)
  {
    this.birthDate = birthDate;
    return this;
  }

  @Override
  public IPetBuilder setMaster(Client master)
  {
    this.master = master;
    return this;
  }

  @Override
  public IPetBuilder copyProps(Pet other)
  {
    this.name = other.getName();
    this.type = other.getType();
    this.birthDate = other.getBirthDate();
    this.master = other.getMaster();

    return this;
  }

  @Override
  public Pet build() throws IllegalAccessException
  {
    if (name == null || type == null || birthDate == null)
    {
      throw new IllegalAccessException();
    }
    return new Pet(id, name, type, birthDate, master);
  }
}
