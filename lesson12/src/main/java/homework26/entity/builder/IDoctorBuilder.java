package homework26.entity.builder;

import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Doctor;
import homework26.entity.Pet;

import java.time.LocalDate;
import java.util.List;

public interface IDoctorBuilder
{
  IDoctorBuilder setId(long id);

  IDoctorBuilder setName(String name);

  IDoctorBuilder setSurname(String surname);

  IDoctorBuilder setPhoneNr(String phoneNr);

  IDoctorBuilder setBirthDate(LocalDate birthDate);

  IDoctorBuilder setPatients(List<Pet> patients);

  IDoctorBuilder copyProps(Doctor other);

  Doctor build() throws IllegalAccessException;
}
