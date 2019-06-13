package homework;

import org.junit.Assert;
import org.junit.Test;

public class RomanConverterTest
{
  RomanConverter converter = new RomanConverter();
  @Test
  public void test1() throws MaxException
  {


    String actual = converter.convert(1);
    String expected = "I";

    Assert.assertEquals("Expected 'I' !!!", expected, actual);
  }

  @Test
  public void test2() throws MaxException
  {

    String actual = converter.convert(2);

    String expected = "II";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test3() throws MaxException
  {


    String actual = converter.convert(3);

    String expected = "III";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test4() throws MaxException
  {


    String actual = converter.convert(4);
    String expected = "IV";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test5() throws MaxException
  {

    String actual = converter.convert(5);

    String expected = "V";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test6() throws MaxException
  {
    String actual = converter.toRoman(9);
    String expected = "IX";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test7() throws MaxException
  {
    String actual = converter.toRoman(10);
    String expected = "X";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test8() throws MaxException
  {
    String actual = converter.toRoman(40);
    String expected = "XL";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test9() throws MaxException
  {
    String actual = converter.toRoman(50);
    String expected = "L";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test10() throws MaxException
  {
    String actual = converter.toRoman(90);
    String expected = "XC";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test11() throws MaxException
  {
    String actual = converter.toRoman(100);
    String expected = "C";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test12() throws MaxException
  {
    String actual = converter.toRoman(400);
    String expected = "CD";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test13() throws MaxException
  {
    String actual = converter.toRoman(500);
    String expected = "D";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test14() throws MaxException
  {
    String actual = converter.toRoman(900);
    String expected = "CM";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test15() throws MaxException
  {
    String actual = converter.toRoman(1000);
    String expected = "M";

    Assert.assertEquals(expected, actual);
  }@Test
  public void test16() throws MaxException
  {
    String actual = converter.toRoman(3999);
    String expected = "MMMCMXCIX";

    Assert.assertEquals(expected, actual);
  }

}