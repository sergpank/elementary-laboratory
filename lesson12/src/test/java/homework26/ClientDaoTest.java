package homework26;

import homework26.dao.ClientDao;
import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.builder.AddressBulder;
import homework26.entity.builder.ClientBuilder;
import homework26.util.DbSQLiteUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ClientDaoTest
{
  public ClientDaoTest()
  {
//        DbSQLiteUtil.clearDb();
    DbSQLiteUtil.initDb();
  }

  @Test
  public void test1() throws IllegalAccessException
  {
    DbSQLiteUtil.clearTable("address");

    Address addr = new AddressBulder()
        .setStreet("Sadovaya")
        .setZip(65072)
        .setHouse("23/2")
        .setAppartment(11 + "")
        .build();

    LocalDate d = LocalDate.of(1992, 1, 12);

    Client client = new ClientBuilder()
        .setName("Vasya")
        .setSurname("Vasechkin")
        .setAddress(addr)
        .setBirthDate(d)
        .setPhoneNr("332-223")
        .build();

    ClientDao clientDao = new ClientDao(DbSQLiteUtil::getConnectionFromPool);

    Client client2 = clientDao.create(client);

    Client client3 = clientDao.read(client2.getId());

    Assert.assertEquals(client2, client3);

    d = LocalDate.of(1991, 2, 2);

    addr = new AddressBulder()
        .setId(client2.getAddress().getId())
        .setStreet("Pirogovskaya")
        .setZip(65073)
        .setHouse("2/21")
        .setAppartment(9 + "")
        .build();

    Client client4 = new ClientBuilder()
        .setId(client2.getId())
        .setName("Petya")
        .setSurname("Petrov")
        .setAddress(addr)
        .setBirthDate(d)
        .setPhoneNr("332-223")
        .build();

    Assert.assertTrue(clientDao.update(client4));

    Client client5 = clientDao.read(client2.getId());

    Assert.assertEquals(client5, client4);

    List<Client> clients = clientDao.read();

    Assert.assertTrue(clients.size() == 1);


    Assert.assertTrue(clientDao.delete(client2.getId()));

    clients = clientDao.read();

    Assert.assertTrue(clients.size() == 0);

  }
}
