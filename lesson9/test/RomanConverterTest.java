import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanConverterTest
{

  @Test
  public void test1()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(1);
    String expected = "I";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test2()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(2);
    String expected = "II";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test4()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(4);
    String expected = "IV";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test5()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(5);
    String expected = "V";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test6()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(6);
    String expected = "VI";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test9()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(9);
    String expected = "IX";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test10()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(10);
    String expected = "X";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test11()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(11);
    String expected = "XI";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test49()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(49);
    String expected = "XLIX";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test50()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(50);
    String expected = "L";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test51()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(51);
    String expected = "LI";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test99()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(99);
    String expected = "XCIX";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test100()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(100);
    String expected = "C";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test101()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(101);
    String expected = "CI";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test499()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(499);
    String expected = "CDXCIX";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test500()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(500);
    String expected = "D";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test501()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(501);
    String expected = "DI";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test999()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(999);
    String expected = "CMXCIX";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test1000()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(1000);
    String expected = "M";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test1001()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(1001);
    String expected = "MI";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test3999()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(3999);
    String expected = "MMMCMXCIX";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test4000()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(4000);
    String expected = "invalid value";
    Assert.assertEquals(expected, actual);
  }
  @Test
  public void test4548()
  {
    RomanConverter romanConverter = new RomanConverter();
    String actual = romanConverter.toRoman(4548);
    String expected = "invalid value";
    Assert.assertEquals(expected, actual);
  }

}