public class Address
{
  protected long id;
  protected String street;
  protected int house;
  protected int apartments;
  protected int zip;

  public Address(String street, int house, int apartments, int zip)
  {
    this.street = street;
    this.house = house;
    this.apartments = apartments;
    this.zip = zip;
  }

  public Address(long id,String street, int house, int apartments, int zip)
  {
    this.id = id;
    this.street = street;
    this.house = house;
    this.apartments = apartments;
    this.zip = zip;
  }

  @Override
  public String toString()
  {
    return "Address{" +
        "id=" + id +
        ", street='" + street + '\'' +
        ", house=" + house +
        ", apartments=" + apartments +
        ", zip=" + zip +
        '}';
  }
}