package entity;

import java.util.Date;

public class Client
{
  private long id;
  private String name;
  private String surname;
  private Address address;
  private Date birthDate;
  private String phoneNr;

  public Client(String name, String surname, Address address, Date birthDate, String phoneNr)
  {
    this(0, name, surname, address, birthDate, phoneNr);
  }

  public Client(long id, String name, String surname, Address address, Date birthDate, String phoneNr)
  {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.birthDate = birthDate;
    this.phoneNr = phoneNr;
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

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("Client{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", surname='").append(surname).append('\'');
    sb.append(", address=").append(address);
    sb.append(", birthDate=").append(birthDate);
    sb.append(", phoneNr='").append(phoneNr).append('\'');
    sb.append('}');
    return sb.toString();
  }

  @Override
  public boolean equals(Object o)
  {
    if(this == o)
    {
      return true;
    }
    if(o == null || getClass() != o.getClass())
    {
      return false;
    }

    Client client = (Client) o;

    if(id != client.id)
    {
      return false;
    }
    if(name != null ? !name.equals(client.name) : client.name != null)
    {
      return false;
    }
    if(surname != null ? !surname.equals(client.surname) : client.surname != null)
    {
      return false;
    }
    if(address != null ? !address.equals(client.address) : client.address != null)
    {
      return false;
    }
    if(birthDate != null ? !birthDate.equals(client.birthDate) : client.birthDate != null)
    {
      return false;
    }
    return phoneNr != null ? phoneNr.equals(client.phoneNr) : client.phoneNr == null;
  }

  @Override
  public int hashCode()
  {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
    result = 31 * result + (phoneNr != null ? phoneNr.hashCode() : 0);
    return result;
  }
}
