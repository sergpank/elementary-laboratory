package homework13;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeClassTest
{
  @Test
  public void test1()
  {
    TimeClass t = new TimeClass(72 + 69 * 60 + 60 * 60 * 8);
    String expectedTimeString = "09:10:12";

    assertTrue(expectedTimeString.equals(t.getStandardTime()));

    t.setSeconds(115);

    expectedTimeString = "09:11:55";

    assertTrue(expectedTimeString.equals(t.getStandardTime()));

    t.setMinutes(115);

    expectedTimeString = "10:55:55";

    assertTrue(expectedTimeString.equals(t.getStandardTime()));

  }

  @Test
  public void test2()
  {
    TimeClass t = new TimeClass(72 + 69 * 60 + 60 * 60 * 8);
    String expectedTimeString = "09:10:12 AM";

    assertTrue(expectedTimeString.equals(t.getAmericanTime()));

  }

  @Test
  public void test3()
  {
    TimeClass t = new TimeClass(67, 67);

    assertTrue("01:08:07".equals(t.getStandardTime()));
  }

  @Test
  public void test4()
  {
    TimeClass t = new TimeClass(23, 59, 58);

    assertTrue("11:59:58 PM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("11:59:59 PM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("00:00:00 AM".equals(t.getAmericanTime()));
  }

  @Test
  public void test5()
  {
    TimeClass t = new TimeClass(11, 59, 58);

    assertTrue("11:59:58 AM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("11:59:59 AM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("12:00:00 PM".equals(t.getAmericanTime()));
  }

  @Test
  public void test6()
  {
    TimeClass t = new TimeClass(12, 59, 58);

    assertTrue("12:59:58 PM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("12:59:59 PM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("01:00:00 PM".equals(t.getAmericanTime()));
  }

  @Test
  public void test7()
  {
    TimeClass t = new TimeClass(11, 29, 58);

    assertTrue("11:29:58 AM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("11:29:59 AM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("11:30:00 AM".equals(t.getAmericanTime()));

    t.tick();

    assertTrue("11:30:01 AM".equals(t.getAmericanTime()));
  }
}
