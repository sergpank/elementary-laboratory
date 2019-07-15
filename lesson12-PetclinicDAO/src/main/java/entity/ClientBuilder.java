package entity;

import java.util.Date;

public class ClientBuilder
{
  private long id;
  private String name;
  private String surname;
  private Address address;
  private Date birthDate;
  private String phoneNr;


  public ClientBuilder setId(long id)
  {
    this.id = id;
    return this;
  }

  public ClientBuilder setName(String name)
  {
    this.name = name;
    return this;
  }

  public ClientBuilder setSurname(String surname)
  {
    this.surname = surname;
    return this;
  }

  public ClientBuilder setAddress(Address address)
  {
    this.address = address;
    return this;
  }

  public ClientBuilder setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
    return this;
  }

  public ClientBuilder setPhoneNr(String phoneNr)
  {
    this.phoneNr = phoneNr;
    return this;
  }

  public Client build()
  {
    if (address == null)
    {
      throw new IllegalStateException("address not initialized");
    }

    return new Client(name, surname, address, birthDate, phoneNr);
  }

}
