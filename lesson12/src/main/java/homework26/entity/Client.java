package homework26.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Client extends Person
{
  private Address address;
  private List<Pet> pets;

  public Client(long id, String name, String surname, String phoneNr, LocalDate birthDate, Address address, List<Pet> pets)
  {
    super(id, name, surname, phoneNr, birthDate);
    this.pets = pets;
    this.address = address;
  }

  public Address getAddress()
  {
    Address result = null;
    if (address != null)
    {
      result = address.copy();
    }
    return result;
  }

  public List<Pet> getPets()
  {
    List<Pet> petList = this.pets != null ? new ArrayList<Pet>(this.pets) : new ArrayList<Pet>();

    return petList;
  }


  public Client copy()
  {
    Client copy = new Client(getId(), getName(), getSurname(), getPhoneNr(), getBirthDate(), getAddress(), getPets());

    return copy;
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
      Client client = (Client) obj;
      result = getId() == client.getId() &&
          Objects.equals(this.getName(), client.getName()) &&
          Objects.equals(this.getSurname(), client.getSurname()) &&
          Objects.equals(this.getPhoneNr(), client.getPhoneNr()) && Objects.equals(this.getAddress(), client.getAddress());
    }

    return result;
  }

  @Override
  public String toString()
  {
    return String.format("%s %s, %s %s, %s",
        getName(),
        getSurname(),
        address.getStreet(),
        address.getHouseNr(),
        address.getAppartmentNr());
  }
}
