package homework26.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Doctor extends Person
{

  private List<Pet> patients;

  public Doctor(long id, String name, String surname, String phoneNr, LocalDate birthDate, List<Pet> patients)
  {
    super(id, name, surname, phoneNr, birthDate);
    this.patients = patients;
  }

  public List<Pet> getPatients()
  {
    List<Pet> patientList = this.patients != null ? new ArrayList<Pet>(this.patients) : new ArrayList<Pet>();

    return patientList;
  }

  public Doctor copy()
  {
    Doctor copy = new Doctor(getId(), getName(), getSurname(), getPhoneNr(), getBirthDate(), getPatients());

    return copy;
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
      Doctor doctor = (Doctor) obj;
      result = getId() == doctor.getId() &&
          Objects.equals(this.getName(), doctor.getName()) &&
          Objects.equals(this.getSurname(), doctor.getSurname()) &&
          Objects.equals(this.getPhoneNr(), doctor.getPhoneNr());
    }

    return result;
  }
}
