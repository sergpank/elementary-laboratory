package homework26.entity.builder;

import homework26.entity.Doctor;
import homework26.entity.Pet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DoctorBuilder implements IDoctorBuilder
{
  private long id;
  private String name;
  private String surname;
  private String phoneNr;
  private LocalDate birthDate;
  private List<Pet> patients;

  @Override
  public IDoctorBuilder setId(long id)
  {
    this.id = id;
    return this;
  }

  @Override
  public IDoctorBuilder setName(String name)
  {
    this.name = name;
    return this;
  }

  @Override
  public IDoctorBuilder setSurname(String surname)
  {
    this.surname = surname;
    return this;
  }

  @Override
  public IDoctorBuilder setPhoneNr(String phoneNr)
  {
    this.phoneNr = phoneNr;
    return this;
  }

  @Override
  public IDoctorBuilder setBirthDate(LocalDate birthDate)
  {
    this.birthDate = birthDate;
    return this;
  }

  @Override
  public IDoctorBuilder setPatients(List<Pet> patients)
  {
    this.patients = patients;
    return this;
  }

  @Override
  public IDoctorBuilder copyProps(Doctor other)
  {
    this.name = other.getName();
    this.surname = other.getSurname();
    this.phoneNr = other.getPhoneNr();
    this.birthDate = other.getBirthDate();
    this.patients = other.getPatients();

    return this;
  }

  @Override
  public Doctor build() throws IllegalAccessException
  {
    if (name == null || surname == null || phoneNr == null || birthDate == null)
    {
      throw new IllegalAccessException();
    }
    return new Doctor(id, name, surname, phoneNr, birthDate, patients);
  }
}
