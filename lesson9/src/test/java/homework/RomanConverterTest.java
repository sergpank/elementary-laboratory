package homework;

import org.junit.Assert;
import org.junit.Test;

public class RomanConverterTest
{
  @Test
  public void test1()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(1);
    String expected = "I";

    Assert.assertEquals("Expected 'I' !!!", expected, actual);
  }

  @Test
  public void test2()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(2);
    String expected = "II";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test3()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(3);
    String expected = "III";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test4()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(4);
    String expected = "IV";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test5()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(5);
    String expected = "V";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test6()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(6);
    String expected = "VI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test7()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(7);
    String expected = "VII";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test8()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(8);
    String expected = "VIII";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test9()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(9);
    String expected = "VIIII";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test10()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(10);
    String expected = "X";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test11()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(11);
    String expected = "XI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test20()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(20);
    String expected = "XX";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test40()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(40);
    String expected = "XL";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test50()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(50);
    String expected = "L";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test60()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(60);
    String expected = "LX";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test90()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(90);
    String expected = "XC";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test100()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(100);
    String expected = "C";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test400()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(400);
    String expected = "CD";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test500()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(500);
    String expected = "D";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test600()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(600);
    String expected = "DC";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test900()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(900);
    String expected = "CM";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test1000()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(1000);
    String expected = "M";

    Assert.assertEquals(expected, actual);
  }


  @Test
  public void test3999()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(3999);
    String expected = "MMMCMXCIX";

    Assert.assertEquals(expected, actual);
  }


}