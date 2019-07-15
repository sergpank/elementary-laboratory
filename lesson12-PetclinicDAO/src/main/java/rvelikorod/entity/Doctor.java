package rvelikorod.entity;

import java.util.ArrayList;
import java.util.Date;

public class Doctor
{
  private Long id;
  private String name;
  private String surname;
  private Date birthDate;
  private String phoneNr;
  private ArrayList<Pet> patients;

  public Doctor(Long id, String name, String surname, Date birthDate, String phoneNr, ArrayList<Pet> patients)
  {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
    this.phoneNr = phoneNr;
    this.patients = patients;
  }

  public Doctor(String name, String surname, Date birthDate, String phoneNr, ArrayList<Pet> patients)
  {
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
    this.phoneNr = phoneNr;
    this.patients = patients;
  }

  public Long getId()
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

  public Date getBirthDate()
  {
    return birthDate;
  }

  public String getPhoneNr()
  {
    return phoneNr;
  }

  public ArrayList<Pet> getPatients()
  {
    return patients;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }

  public void setPhoneNr(String phoneNr)
  {
    this.phoneNr = phoneNr;
  }

  public void setPatients(ArrayList<Pet> patients)
  {
    this.patients = patients;
  }
}
