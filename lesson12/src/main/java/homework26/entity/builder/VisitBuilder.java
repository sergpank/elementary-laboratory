package homework26.entity.builder;

import homework26.entity.Client;
import homework26.entity.Doctor;
import homework26.entity.Pet;
import homework26.entity.Visit;

import java.time.LocalDate;

public class VisitBuilder implements IVisitBuilder
{
  private long id;
  private LocalDate visitDate;
  private String description;
  private long charge;
  private Doctor doctor;
  private Pet patient;
  private Client client;

  @Override
  public IVisitBuilder setId(long id)
  {
    this.id = id;
    return this;
  }

  @Override
  public IVisitBuilder setVisitDate(LocalDate visitDate)
  {
    this.visitDate = visitDate;
    return this;
  }

  @Override
  public IVisitBuilder setDescription(String description)
  {
    this.description = description;
    return this;
  }

  @Override
  public IVisitBuilder setCharge(long charge)
  {
    this.charge = charge;
    return this;
  }

  @Override
  public IVisitBuilder setDoctor(Doctor doctor)
  {
    this.doctor = doctor;
    return this;
  }

  @Override
  public IVisitBuilder setPatient(Pet patient)
  {
    this.patient = patient;
    return this;
  }

  @Override
  public IVisitBuilder setClient(Client client)
  {
    this.client = client;
    return this;
  }

  @Override
  public IVisitBuilder copyProps(Visit other)
  {
    this.visitDate = other.getVisitDate();
    this.description = other.getDescription();
    this.charge = other.getCharge();
    this.doctor = other.getDoctor();
    this.patient = other.getPatient();
    this.client = other.getClient();

    return this;
  }

  @Override
  public Visit build() throws IllegalAccessException
  {
    if (visitDate == null || description == null || doctor == null || patient == null || client == null)
    {
      throw new IllegalAccessException();
    }
    return new Visit(id, visitDate, description, charge, doctor, client, patient);
  }
}
