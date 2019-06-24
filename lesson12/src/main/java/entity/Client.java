package entity;

import java.util.Date;
import java.util.List;

public class Client
{
  private long id;
  private String name;
  private String surname;
  private Address address;
  private Date birthDate;
  private String phoneNr;
  private List<Pet> pets;

  public Client(String name, String surname, Address address, Date birthDate, String phoneNr,List<Pet>pets)

  {
    this(0, name, surname, address, birthDate, phoneNr, pets);
  }

  public Client(long id, String name, String surname, Address address, Date birthDate, String phoneNr,List<Pet>pets)
  {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.birthDate = birthDate;
    this.phoneNr = phoneNr;
    this.pets = pets;
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

  public String getSurname()
  {
    return surname;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  public Address getAddress()
  {
    return address;
  }

  public void setAddress(Address address)
  {
    this.address = address;
  }

  public Date getBirthDate()
  {
    return birthDate;
  }

  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }

  public String getPhoneNr()
  {
    return phoneNr;
  }

  public void setPhoneNr(String phoneNr)
  {
    this.phoneNr = phoneNr;
  }

  public List<Pet> getPets()
  {
    return pets;
  }

  public void setPets(List<Pet> pets)
  {
    this.pets = pets;
  }

  @Override
  public String toString()
  {
    return "Client{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", address=" + address +
        ", birthDate=" + birthDate +
        ", phoneNr='" + phoneNr + '\'' +
        ", pets=" + pets +
        '}' + "\n";
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

    Client client = (Client) o;

    if (name != null ? !name.equals(client.name) : client.name != null)
    {
      return false;
    }
    if (surname != null ? !surname.equals(client.surname) : client.surname != null)
    {
      return false;
    }
    return phoneNr != null ? phoneNr.equals(client.phoneNr) : client.phoneNr == null;
  }

  @Override
  public int hashCode()
  {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (phoneNr != null ? phoneNr.hashCode() : 0);
    return result;
  }
}
