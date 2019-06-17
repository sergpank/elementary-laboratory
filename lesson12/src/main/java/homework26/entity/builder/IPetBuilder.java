package homework26.entity.builder;

import homework26.entity.Client;
import homework26.entity.Pet;

import java.time.LocalDate;

public interface IPetBuilder
{
  IPetBuilder setId(long id);

  IPetBuilder setName(String name);

  IPetBuilder setType(String type);

  IPetBuilder setBirthDate(LocalDate birthDate);

  IPetBuilder setMaster(Client master);

  IPetBuilder copyProps(Pet other);

  Pet build() throws IllegalAccessException;
}
