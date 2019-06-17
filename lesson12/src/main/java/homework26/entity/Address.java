package homework26.entity;

import java.util.Objects;

public class Address
{
  private long id;
  private String street;
  private String houseNr;
  private String appartmentNr;
  private int zip;

  public Address(long id, String street, String houseNr, String appartmentNr, int zip)
  {
    this.id = id;
    this.street = street;
    this.houseNr = houseNr;
    this.appartmentNr = appartmentNr;
    this.zip = zip;
  }

  public long getId()
  {
    return id;
  }

  public String getStreet()
  {
    return street;
  }

  public String getHouseNr()
  {
    return houseNr;
  }

  public String getAppartmentNr()
  {
    return appartmentNr;
  }

  public int getZip()
  {
    return zip;
  }

  public Address copy()
  {
    return new Address(id, street, houseNr, appartmentNr, zip);
  }

  public void copyPropsWitoutId(Address other)
  {
    street = other.street;
    houseNr = other.houseNr;
    appartmentNr = other.appartmentNr;
    zip = other.zip;
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
      Address address = (Address) obj;
      result = this.getId() == address.getId() && this.getZip() == address.getZip() &&
          Objects.equals(this.getStreet(), address.getStreet()) &&
          Objects.equals(this.getHouseNr(), address.getHouseNr()) &&
          Objects.equals(this.getAppartmentNr(), address.getAppartmentNr());
    }

    return result;
  }
}
