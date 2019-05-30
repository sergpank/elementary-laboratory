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
    String expected = "IX";

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
  public void test12()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(20);
    String expected = "XX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test13()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(30);
    String expected = "XXX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test14()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(40);
    String expected = "XL";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test15()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(50);
    String expected = "L";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test16()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(60);
    String expected = "LX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test17()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(70);
    String expected = "LXX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test18()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(80);
    String expected = "LXXX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test19()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(90);
    String expected = "XC";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test20()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(100);
    String expected = "C";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test21()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(399);
    String expected = "CCCXCIX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test22()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(400);
    String expected = "CD";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test23()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(401);
    String expected = "CDI";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test24()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(499);
    String expected = "CDXCIX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test25()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(500);
    String expected = "D";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test26()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(501);
    String expected = "DI";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test27()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(899);
    String expected = "DCCCXCIX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test28()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(900);
    String expected = "CM";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test29()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(901);
    String expected = "CMI";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test30()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(999);
    String expected = "CMXCIX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test31()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(1000);
    String expected = "M";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test32()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(3999);
    String expected = "MMMCMXCIX";

    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test33()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(4000);
    String expected = "";

    Assert.assertEquals(expected, actual);
  }




}