package homework26.entity.builder;

import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Pet;

import java.time.LocalDate;
import java.util.List;

public interface IClientBuilder
{
  IClientBuilder setId(long id);

  IClientBuilder setName(String name);

  IClientBuilder setSurname(String surname);

  IClientBuilder setPhoneNr(String phoneNr);

  IClientBuilder setBirthDate(LocalDate birthDate);

  IClientBuilder setAddress(Address address);

  IClientBuilder setPets(List<Pet> pets);

  IClientBuilder copyProps(Client other);

  Client build() throws IllegalAccessException;

}
