import java.lang.reflect.Array;
import java.util.ArrayList;

public class Client
{
  protected long id;
  protected String name;
  protected String surname;
  protected int address_id;
  protected String date_of_birth;
  protected String phone_number;
  protected ArrayList<Pet> list;

  public Client(String name, String surname, int address_id, String date_of_birth, String phone_number, ArrayList<Pet> list)
  {
    this.name = name;
    this.surname = surname;
    this.address_id = address_id;
    this.date_of_birth = date_of_birth;
    this.phone_number = phone_number;
    this.list = list;
  }

  public Client(long id, String name, String surname, int address_id, String date_of_birth, String phone_number)
  {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.address_id = address_id;
    this.date_of_birth = date_of_birth;
    this.phone_number = phone_number;
    this.list = list;
  }

  @Override
  public String toString()
  {
    return "Client{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", address_id=" + address_id +
        ", date_of_birth='" + date_of_birth + '\'' +
        ", phone_number='" + phone_number + '\'' +
        ", list=" + list +
        '}';
  }
}
