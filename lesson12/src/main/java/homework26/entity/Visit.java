package homework26.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Visit
{
  private long id;
  private LocalDate visitDate;
  private String description;
  private Doctor doctor;
  private Client client;
  private Pet patient;
  private long charge;

  public Visit(long id, LocalDate visitDate, String description, long charge, Doctor doctor, Client client, Pet patient)
  {
    this.id = id;
    this.visitDate = visitDate;
    this.description = description;
    this.doctor = doctor;
    this.client = client;
    this.patient = patient;
    this.charge = charge;
  }

  public long getId()
  {
    return id;
  }

  public LocalDate getVisitDate()
  {
    return visitDate;
  }

  public String getDescription()
  {
    return description;
  }

  public Doctor getDoctor()
  {
    return doctor != null ? doctor.copy() : null;
  }

  public Client getClient()
  {
    return client != null ? client.copy() : null;
  }

  public Pet getPatient()
  {
    return patient != null ? patient.copy() : null;
  }

  public long getCharge()
  {
    return charge;
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
      Visit visit = (Visit) obj;
      result = getId() == visit.getId() && getCharge() == visit.getCharge() &&
          Objects.equals(this.getDescription(), visit.getDescription()) &&
          Objects.equals(this.getVisitDate(), visit.getVisitDate()) &&
          Objects.equals(this.getDoctor(), visit.getDoctor()) &&
          Objects.equals(this.getClient(), visit.getClient()) &&
          Objects.equals(this.getPatient(), visit.getPatient());
    }

    return result;
  }
}
