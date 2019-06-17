package homework26;

import homework26.dao.DoctorDao;
import homework26.entity.Doctor;
import homework26.entity.builder.DoctorBuilder;
import homework26.util.DbSQLiteUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class DoctorDaoTest
{
  public DoctorDaoTest()
  {
    DbSQLiteUtil.initDb();
  }

  @Test
  public void test1() throws IllegalAccessException
  {
    DbSQLiteUtil.clearTable("doctor");

    LocalDate d = LocalDate.of(1992, 1, 12);

    Doctor doctor = new DoctorBuilder()
        .setName("Vasya")
        .setSurname("Vasechkin")
        .setBirthDate(d)
        .setPhoneNr("332-223")
        .build();

    DoctorDao doctorDao = new DoctorDao(DbSQLiteUtil::getConnectionFromPool);


    Doctor doctor2 = doctorDao.create(doctor);

    Assert.assertNotEquals(doctor2, doctor);

    Doctor doctor3 = doctorDao.read(doctor2.getId());

    Assert.assertEquals(doctor2, doctor3);

    d = LocalDate.of(1991, 2, 2);

    Doctor doctor4 = new DoctorBuilder()
        .setName("Petya")
        .setSurname("Petrov")
        .setBirthDate(d)
        .setPhoneNr("332-223")
        .build();

    Assert.assertFalse(doctorDao.update(doctor4));

    doctor4 = new DoctorBuilder()
        .setId(doctor2.getId())
        .setName("Petya")
        .setSurname("Petrov")
        .setBirthDate(d)
        .setPhoneNr("332-223")
        .build();

    Assert.assertTrue(doctorDao.update(doctor4));

    Doctor doctor5 = doctorDao.read(doctor2.getId());

    Assert.assertEquals(doctor4, doctor5);

    List<Doctor> doctors = doctorDao.read();

    Assert.assertTrue(doctors.size() == 1);


    Assert.assertTrue(doctorDao.delete(doctor2.getId()));

    Assert.assertFalse(doctorDao.delete(doctor2.getId()));

    doctors = doctorDao.read();

    Assert.assertTrue(doctors.size() == 0);

  }
}
