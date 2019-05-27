import org.junit.Assert;
import org.junit.Test;

public class RomanConverterTest
{

  @Test
  public void test1()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(1);
    String expected = "I";

    Assert.assertEquals("Expect 'I' !!!", expected,actual);
  }

  @Test
  public void test2()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(3);
    String expected = "III";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test4()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(4);
    String expected = "IV";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test5()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(5);
    String expected = "V";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test6()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(9);
    String expected = "IX";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test7()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(11);
    String expected = "XI";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test8()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(39);
    String expected = "XXXIX";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test9()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(41);
    String expected = "XLI";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test10()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(49);
    String expected = "XLIX";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test11()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(51);
    String expected = "LI";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test12()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(89);
    String expected = "LXXXIX";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test13()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(91);
    String expected = "XCI";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test14()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(99);
    String expected = "XCIX";

    Assert.assertEquals( expected,actual);
  }

  @Test
  public void test15()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(101);
    String expected = "CI";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test16()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(399);
    String expected = "CCCXCIX";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test17()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(401);
    String expected = "CDI";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test18()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(499);
    String expected = "CDXCIX";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test19()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(501);
    String expected = "DI";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test20()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(899);
    String expected = "DCCCXCIX";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test21()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(901);
    String expected = "CMI";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test22()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(999);
    String expected = "CMXCIX";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test23()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(1001);
    String expected = "MI";

    Assert.assertEquals( expected,actual);
  }
  @Test
  public void test24()
  {
    RomanConverter romanConverter = new RomanConverter();

    String actual = romanConverter.toRoman(3999);
    String expected = "MMMCMXCIX";

    Assert.assertEquals( expected,actual);
  }

}