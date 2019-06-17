package homework26;

import homework26.dao.ClientDao;
import homework26.dao.PetDao;
import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Pet;
import homework26.entity.builder.AddressBulder;
import homework26.entity.builder.ClientBuilder;
import homework26.entity.builder.PetBuilder;
import homework26.util.DbSQLiteUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PetDaoTest
{
  public PetDaoTest()
  {
//    DbSQLiteUtil.clearDb();
    DbSQLiteUtil.initDb();
  }

  @Test
  public void test1() throws IllegalAccessException
  {
    DbSQLiteUtil.clearTable("address");
    DbSQLiteUtil.clearTable("pet");


    LocalDate d = LocalDate.of(1992, 1, 12);

    Address addr = new AddressBulder()
        .setStreet("Sadovaya")
        .setZip(65072)
        .setHouse("23/2")
        .setAppartment(11 + "")
        .build();

    Client client = new ClientBuilder()
        .setName("Vasya")
        .setSurname("Vasechkin")
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

    Pet pet3 = petDao.create(pet1);

    pet2 = petDao.create(pet2);

    Assert.assertNotEquals(pet1, pet3);

    client = clientDao.read(client.getId());

    Assert.assertTrue(client.getPets().size() == 2);

    Assert.assertTrue(petDao.read().size() == 2);

    Assert.assertTrue(petDao.delete(pet3.getId()));

    Assert.assertTrue(petDao.read().size() == 1);

    Address addr2 = new AddressBulder()
        .setStreet("Pirogovskaya")
        .setZip(65073)
        .setHouse("2/21")
        .setAppartment(9 + "")
        .build();

    Client client2 = new ClientBuilder()
        .setName("Petya")
        .setSurname("Petrov")
        .setAddress(addr2)
        .setBirthDate(d)
        .setPhoneNr("332-223")
        .build();

    client2 = clientDao.create(client2);

    Pet pet4 = new PetBuilder()
        .setId(pet2.getId())
        .setName("dog2")
        .setType("big dog")
        .setBirthDate(LocalDate.of(2016, 1, 1))
        .setMaster(client2)
        .build();

    Assert.assertTrue(petDao.update(pet4));

    Assert.assertNotEquals(pet2, pet4);

    Assert.assertEquals(pet4.getMaster(), client2);

  }
}
