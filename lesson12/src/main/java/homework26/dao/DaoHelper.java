package homework26.dao;

import homework26.entity.*;
import homework26.entity.builder.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static homework26.dao.DateConverter.stringToDate;

public class DaoHelper
{
  public static Client readClient(ResultSet rs, List<Pet> pets) throws SQLException, IllegalAccessException
  {
    Address addr = new AddressBulder()
        .setId(rs.getLong("addressId"))
        .setHouse(rs.getString("houseNr"))
        .setStreet(rs.getString("street"))
        .setAppartment(rs.getString("appartmentNr"))
        .setZip(rs.getInt("zip"))
        .build();

    Client client = new ClientBuilder()
        .setId(rs.getLong("masterId"))
        .setName(rs.getString("masterName"))
        .setSurname(rs.getString("surname"))
        .setPhoneNr(rs.getString("phoneNr"))
        .setBirthDate(stringToDate(rs.getString("birthDate")))
        .setAddress(addr)
        .setPets(pets)
        .build();

    return client;
  }

  public static Pet readPet(ResultSet rs, Client master) throws SQLException, IllegalAccessException
  {
    Pet pet = new PetBuilder()
        .setId(rs.getLong("petId"))
        .setName(rs.getString("petName"))
        .setType(rs.getString("petType"))
        .setBirthDate(stringToDate(rs.getString("petBirthDate")))
        .setMaster(master)
        .build();

    return pet;
  }

  public static Doctor readDoctor(ResultSet rs, List<Pet> patients) throws SQLException, IllegalAccessException
  {
    Doctor doctor = new DoctorBuilder()
        .setId(rs.getLong("doctorId"))
        .setName(rs.getString("doctorName"))
        .setSurname(rs.getString("doctorSurname"))
        .setPhoneNr(rs.getString("doctorPhoneNr"))
        .setBirthDate(stringToDate(rs.getString("doctorBirthDate")))
        .setPatients(patients)
        .build();

    return doctor;
  }

  public static Visit readVisit(ResultSet rs) throws SQLException, IllegalAccessException
  {
    Client client = readClient(rs, null);
    Pet pet = readPet(rs, client);
    Doctor doctor = readDoctor(rs, null);

    Visit visit = new VisitBuilder()
        .setId(rs.getLong("visitId"))
        .setVisitDate(stringToDate(rs.getString("visitDate")))
        .setDescription(rs.getString("description"))
        .setCharge(rs.getLong("charge"))
        .setDoctor(doctor)
        .setPatient(pet)
        .setClient(client)
        .build();

    return visit;
  }
}
