package homework26.entity.builder;

import homework26.entity.Client;
import homework26.entity.Doctor;
import homework26.entity.Pet;
import homework26.entity.Visit;

import java.time.LocalDate;

public interface IVisitBuilder
{
  IVisitBuilder setId(long id);

  IVisitBuilder setVisitDate(LocalDate visitDate);

  IVisitBuilder setDescription(String description);

  IVisitBuilder setCharge(long charge);

  IVisitBuilder setDoctor(Doctor doctor);

  IVisitBuilder setPatient(Pet patient);

  IVisitBuilder setClient(Client client);

  IVisitBuilder copyProps(Visit other);

  Visit build() throws IllegalAccessException;
}
