import java.util.ArrayList;

public class Doctor
{
  protected long id;
  protected String name;
  protected String surname;
  protected String date_of_birth;
  protected String phone_number;
  protected ArrayList<Pet> list;


  public Doctor(String name, String surname, String date_of_birth, String phone_number, ArrayList<Pet> list)
  {
    this.name = name;
    this.surname = surname;
    this.date_of_birth = date_of_birth;
    this.phone_number = phone_number;
    this.list = list;
  }

  public Doctor(long id, String name, String surname, String date_of_birth, String phone_number)
  {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.date_of_birth = date_of_birth;
    this.phone_number = phone_number;
    this.list = list;
  }

  @Override
  public String toString()
  {
    return "Doctor{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", date_of_birth='" + date_of_birth + '\'' +
        ", phone_number='" + phone_number + '\'' +
        ", list=" + list +
        '}';
  }
}
