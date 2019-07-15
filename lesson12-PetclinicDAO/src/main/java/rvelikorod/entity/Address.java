package rvelikorod.entity;

public class Address
{
  private long id;
  private String street;
  private String house;
  private long apartmentNr;
  private long zip;

  public Address(String street, String house, long apartmentNr, long zip)
  {
    this(0L, street, house, apartmentNr, zip);
  }

  public Address(long id, String street, String house, long apartmentNr, long zip)
  {
    this.id = id;
    this.street = street;
    this.house = house;
    this.apartmentNr = apartmentNr;
    this.zip = zip;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getStreet()
  {
    return street;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  public String getHouse()
  {
    return house;
  }

  public void setHouse(String house)
  {
    this.house = house;
  }

  public long getApartmentNr()
  {
    return apartmentNr;
  }

  public void setApartmentNr(long apartmentNr)
  {
    this.apartmentNr = apartmentNr;
  }

  public long getZip()
  {
    return zip;
  }

  public void setZip(long zip)
  {
    this.zip = zip;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("Address{");
    sb.append("id=").append(id);
    sb.append(", street='").append(street).append('\'');
    sb.append(", house='").append(house).append('\'');
    sb.append(", apartmentNr=").append(apartmentNr);
    sb.append(", zip=").append(zip);
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

    Address address = (Address) o;

    if(id != address.id)
    {
      return false;
    }
    if(apartmentNr != address.apartmentNr)
    {
      return false;
    }
    if(zip != address.zip)
    {
      return false;
    }
    if(street != null ? !street.equals(address.street) : address.street != null)
    {
      return false;
    }
    return house != null ? house.equals(address.house) : address.house == null;
  }

  @Override
  public int hashCode()
  {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (street != null ? street.hashCode() : 0);
    result = 31 * result + (house != null ? house.hashCode() : 0);
    result = 31 * result + (int) (apartmentNr ^ (apartmentNr >>> 32));
    result = 31 * result + (int) (zip ^ (zip >>> 32));
    return result;
  }
}
