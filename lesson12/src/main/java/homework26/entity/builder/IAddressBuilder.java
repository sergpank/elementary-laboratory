package homework26.entity.builder;

import homework26.entity.Address;

public interface IAddressBuilder
{
  IAddressBuilder setId(long id);

  IAddressBuilder setStreet(String street);

  IAddressBuilder setHouse(String houseNr);

  IAddressBuilder setAppartment(String appartmentNr);

  IAddressBuilder setZip(int zip);

  IAddressBuilder copyProps(Address other);

  Address build() throws IllegalAccessException;
}
