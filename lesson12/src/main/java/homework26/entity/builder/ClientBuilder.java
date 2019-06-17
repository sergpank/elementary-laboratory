package homework26.entity.builder;

import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Pet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientBuilder implements IClientBuilder
{
  private long id;
  private String name;
  private String surname;
  private String phoneNr;
  private LocalDate birthDate;
  private Address address;
  private List<Pet> pets;

  @Override
  public IClientBuilder setId(long id)
  {
    this.id = id;
    return this;
  }

  @Override
  public IClientBuilder setName(String name)
  {
    this.name = name;
    return this;
  }

  @Override
  public IClientBuilder setSurname(String surname)
  {
    this.surname = surname;
    return this;
  }

  @Override
  public IClientBuilder setPhoneNr(String phoneNr)
  {
    this.phoneNr = phoneNr;
    return this;
  }

  @Override
  public IClientBuilder setBirthDate(LocalDate birthDate)
  {
    this.birthDate = birthDate;
    return this;
  }

  @Override
  public IClientBuilder setAddress(Address address)
  {
    this.address = address;
    return this;
  }

  @Override
  public IClientBuilder setPets(List<Pet> pets)
  {
    this.pets = pets;
    return this;
  }

  @Override
  public IClientBuilder copyProps(Client other)
  {
    this.name = other.getName();
    this.surname = other.getSurname();
    this.phoneNr = other.getPhoneNr();
    this.birthDate = other.getBirthDate();
    this.address = other.getAddress();
    this.pets = other.getPets();

    return this;
  }

  @Override
  public Client build() throws IllegalAccessException
  {
    if (name == null || surname == null || phoneNr == null || birthDate == null || address == null)
    {
      throw new IllegalAccessException();
    }
    return new Client(id, name, surname, phoneNr, birthDate, address, pets);
  }
}
