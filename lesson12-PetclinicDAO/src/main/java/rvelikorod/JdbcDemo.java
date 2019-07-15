package rvelikorod;

import rvelikorod.dao.ClientDAO;
import rvelikorod.dao.DoctorDAO;
import rvelikorod.dao.PetDAO;
import rvelikorod.dao.VisitDAO;
import rvelikorod.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
    ArrayList<Pet> pets = new ArrayList<>();
    Pet cat = new Pet(1, "The Cat", new Date(12345), "Cat", 1L);
    Pet dog = new Pet(2, "Doggy Dog", new Date(4321), "Dog", 2L);
    Pet rabbit = new Pet(3, "White Rabbit", new Date(543), "Rabbit", 3L);
    pets.add(cat);
    pets.add(dog);
    pets.add(rabbit);
    Address address = new Address("Sadovaya", "14a", 55, 65000);
    Client client = new Client(1L,"Sergey", "Panko", address, new Date(), "+380-1234-56-78", pets);
    Doctor doctor = new Doctor(1L, "Ivan", "Ivanov", new Date(22),"722-23-23", pets);
    Visit visit = new Visit(1L, new Date(20771212), doctor, client, cat, "trauma", 12L);


    ClientDAO clientDAO = new ClientDAO();

//    clientDAO.create(new Client("Stas", "Frolov", address, new Date(), "phone-number", pets));
//    System.out.println(client);
//
//    Client dbClient = clientDAO.read(1);
//    System.out.println(dbClient);
//    System.out.println(client);
//
//    System.out.println(client.equals(dbClient));
//
//    ArrayList<Client> clients = clientDAO.readAll();
//    clients.forEach(System.out::println);
//    Client c = new Client(3,"Petya", "Petrov", address, new Date(), "765-56-78", pets);
//
//    clientDAO.delete(c);
//
//    clientDAO.update(c);
//    clientDAO.create(new Client(5,"Alexandr", "Petrov", address, new Date(), "722-56-78", pets));


    PetDAO petDAO = new PetDAO();
//    petDAO.create(cat);
//    petDAO.create(dog);
    Pet p = new Pet("Stevie", new Date(), "turtle", 7L);
    petDAO.create(p);
//    Pet mouse = petDAO.create(new Pet(1, "Bob", new Date(22), "mouse", 4L));
//    System.out.println(petDAO.read(1));
//    ArrayList<Pet> pets1 = petDAO.readAll();
//    System.out.println();
//    pets1.forEach(System.out::println);
//    Pet p = new Pet(2, "Murzik", new Date(22), "cat", 1L);
//    petDAO.update(p);
//    petDAO.delete(p);
    ArrayList<Pet> newPets = new ArrayList<>();
    newPets.add(p);
    DoctorDAO doctorDAO = new DoctorDAO();

//    Doctor doctor1 = new Doctor(1L, "Semen", "Semonov", new Date(), "000000", pets1);
//    doctorDAO.create(doctor1);
    doctorDAO.create(new Doctor("Mikhail", "Ivanov", new Date(), "phone", newPets));
//    System.out.println(doctorDAO.read(doctor1.getId()));
//    System.out.println();
//    ArrayList<Doctor>doctors = doctorDAO.readAll();
//    doctors.forEach(System.out::println);
//    doctorDAO.update(new Doctor(1L, "Denis", "Semonov", new Date(), "300000", pets1));
//
    VisitDAO visitDAO = new VisitDAO();
//    visitDAO.create(visit);
//    System.out.println(visitDAO.read(1));
//    visitDAO.update(new Visit(1L, new Date(22222), doctor, client, dog, "trauma", 200L));
//    visitDAO.delete(visit);
  }
}
