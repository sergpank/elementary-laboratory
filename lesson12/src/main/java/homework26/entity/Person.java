package homework26.entity;

import java.time.LocalDate;

public class Person
{
  private long id;
  private String name;
  private String surname;
  private String phoneNr;
  private LocalDate birthDate;

  public Person(long id, String name, String surname, String phoneNr, LocalDate birthDate)
  {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phoneNr = phoneNr;
    this.birthDate = birthDate;
  }

  public long getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getSurname()
  {
    return surname;
  }

  public String getPhoneNr()
  {
    return phoneNr;
  }

  public LocalDate getBirthDate()
  {
    return birthDate;
  }

  @Override
  public String toString()
  {
    return String.format("%s %s (%s)", getSurname(), getName(), getPhoneNr());
  }
}
