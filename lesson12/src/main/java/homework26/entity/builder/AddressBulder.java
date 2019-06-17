package homework26.entity.builder;

import homework26.entity.Address;

public class AddressBulder implements IAddressBuilder
{
  private long id;
  private String street;
  private String houseNr;
  private String appartmentNr;
  private int zip;

  @Override
  public IAddressBuilder setId(long id)
  {
    this.id = id;
    return this;
  }

  @Override
  public IAddressBuilder setStreet(String street)
  {
    this.street = street;
    return this;
  }

  @Override
  public IAddressBuilder setHouse(String houseNr)
  {
    this.houseNr = houseNr;
    return this;
  }

  @Override
  public IAddressBuilder setAppartment(String appartmentNr)
  {
    this.appartmentNr = appartmentNr;
    return this;
  }

  @Override
  public IAddressBuilder setZip(int zip)
  {
    this.zip = zip;
    return this;
  }

  @Override
  public IAddressBuilder copyProps(Address other)
  {
    street = other.getStreet();
    houseNr = other.getHouseNr();
    appartmentNr = other.getAppartmentNr();
    zip = other.getZip();

    return this;
  }

  @Override
  public Address build() throws IllegalAccessException
  {
    if (street == null || houseNr == null || appartmentNr == null)
    {
      throw new IllegalAccessException();
    }

    return new Address(id, street, houseNr, appartmentNr, zip);
  }
}
