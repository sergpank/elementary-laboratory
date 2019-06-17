package homework26;

import homework26.dao.ClientDao;
import homework26.dao.DoctorDao;
import homework26.dao.PetDao;
import homework26.dao.VisitDao;
import homework26.entity.*;
import homework26.entity.builder.*;
import homework26.util.DbSQLiteUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class VisitDaoTest
{
  public VisitDaoTest()
  {
    DbSQLiteUtil.initDb();
  }

  @Test
  public void test1() throws IllegalAccessException
  {
    DbSQLiteUtil.clearTable("doctor");
    DbSQLiteUtil.clearTable("address");
    DbSQLiteUtil.clearTable("pet");
    DbSQLiteUtil.clearTable("visit");


    LocalDate d = LocalDate.of(1992, 1, 12);

    Doctor doctor = new DoctorBuilder()
        .setName("Vasya")
        .setSurname("Vasechkin")
        .setBirthDate(d)
        .setPhoneNr("332-223")
        .build();

    DoctorDao doctorDao = new DoctorDao(DbSQLiteUtil::getConnectionFromPool);

    doctor = doctorDao.create(doctor);

    LocalDate d2 = LocalDate.of(1992, 1, 12);

    Address addr = new AddressBulder()
        .setStreet("Sadovaya")
        .setZip(65072)
        .setHouse("23/2")
        .setAppartment(11 + "")
        .build();

    Client client = new ClientBuilder()
        .setName("Petya")
        .setSurname("Petrov")
        .setAddress(addr)
        .setBirthDate(d)
        .setPhoneNr("332-223")
        .build();

    ClientDao clientDao = new ClientDao(DbSQLiteUtil::getConnectionFromPool);
    client = clientDao.create(client);

    Pet pet1 = new PetBuilder()
        .setName("cat")
        .setType("cat")
        .setBirthDate(LocalDate.of(2015, 10, 20))
        .setMaster(client)
        .build();

    Pet pet2 = new PetBuilder()
        .setName("dog")
        .setType("dog")
        .setBirthDate(LocalDate.of(2016, 1, 2))
        .setMaster(client)
        .build();

    PetDao petDao = new PetDao(DbSQLiteUtil::getConnectionFromPool);

    pet1 = petDao.create(pet1);

    pet2 = petDao.create(pet2);

    VisitDao visitDao = new VisitDao(DbSQLiteUtil::getConnectionFromPool);

    LocalDate d3 = LocalDate.of(2018, 1, 12);

    Visit visit = new VisitBuilder()
        .setVisitDate(d3)
        .setDescription("description")
        .setCharge(100)
        .setDoctor(doctor)
        .setClient(client)
        .setPatient(pet1)
        .build();

    visit = visitDao.create(visit);

    Visit visitSame = visitDao.read(visit.getId());

    Assert.assertEquals(visit, visitSame);

    Doctor doc = visitSame.getDoctor();

    Assert.assertEquals(doc, doctor);
    Doctor doc2 = doctorDao.read(doc.getId());
    Assert.assertTrue(doc2.getPatients().size() == 1);

    Visit visit2 = new VisitBuilder()
        .setId(visit.getId())
        .setVisitDate(d3.plusMonths(2).plusDays(5))
        .setDescription("description2")
        .setCharge(90)
        .setDoctor(doctor)
        .setClient(client)
        .setPatient(pet2)
        .build();

    Assert.assertTrue(visitDao.update(visit2));

    visit = visitDao.read(visit.getId());
    Assert.assertEquals(visit, visit2);

    visit2 = new VisitBuilder()
        .setVisitDate(d3)
        .setDescription("description")
        .setCharge(100)
        .setDoctor(doctor)
        .setClient(client)
        .setPatient(pet1)
        .build();

    Assert.assertFalse(visitDao.update(visit2));

    visit2 = visitDao.create(visit2);

    Assert.assertTrue(visitDao.read().size() == 2);

    Assert.assertTrue(visitDao.delete(visit.getId()));

    Assert.assertFalse(visitDao.delete(visit.getId()));

    Assert.assertTrue(visitDao.delete(visit2.getId()));

  }
}
