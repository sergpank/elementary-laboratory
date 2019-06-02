package homework;

import org.junit.Assert;
import org.junit.Test;

public class RomanConverterTest
{
  @Test
  public void test1()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(1);
    String expected = "I";

    Assert.assertEquals("Expected 'I' !!!", expected, actual);
  }

  @Test
  public void test2()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(2);
    String expected = "II";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test3()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(3);
    String expected = "III";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test4()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(4);
    String expected = "IV";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test5()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(5);
    String expected = "V";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test6()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(6);
=======
    String actual = converter.convert(6);
>>>>>>> master
    String expected = "VI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test7()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(7);
=======
    String actual = converter.convert(7);
>>>>>>> master
    String expected = "VII";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD

=======
>>>>>>> master
  @Test
  public void test8()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(8);
=======
    String actual = converter.convert(8);
>>>>>>> master
    String expected = "VIII";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD

=======
>>>>>>> master
  @Test
  public void test9()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(9);
    String expected = "VIIII";
=======
    String actual = converter.convert(9);
    String expected = "IX";
>>>>>>> master

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD

=======
>>>>>>> master
  @Test
  public void test10()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(10);
=======
    String actual = converter.convert(10);
>>>>>>> master
    String expected = "X";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test11()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(11);
=======
    String actual = converter.convert(11);
>>>>>>> master
    String expected = "XI";

    Assert.assertEquals(expected, actual);
  }

  @Test
<<<<<<< HEAD
  public void test20()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(20);
    String expected = "XX";
=======
  public void test39()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(39);
    String expected = "XXXIX";
>>>>>>> master

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test40()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(40);
=======
    String actual = converter.convert(40);
>>>>>>> master
    String expected = "XL";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD
=======
  @Test
  public void test41()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(41);
    String expected = "XLI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test49()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(49);
    String expected = "XLIX";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master

  @Test
  public void test50()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(50);
=======
    String actual = converter.convert(50);
>>>>>>> master
    String expected = "L";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD

  @Test
  public void test60()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(60);
    String expected = "LX";
=======
  @Test
  public void test51()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(51);
    String expected = "LI";
>>>>>>> master

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD
=======
  @Test
  public void test89()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(89);
    String expected = "LXXXIX";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master

  @Test
  public void test90()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(90);
=======
    String actual = converter.convert(90);
>>>>>>> master
    String expected = "XC";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD
=======
  @Test
  public void test91()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(91);
    String expected = "XCI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test99()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(99);
    String expected = "XCIX";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master

  @Test
  public void test100()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(100);
=======
    String actual = converter.convert(100);
>>>>>>> master
    String expected = "C";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD
=======
  @Test
  public void test101()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(101);
    String expected = "CI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test390()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(390);
    String expected = "CCCXC";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master

  @Test
  public void test400()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(400);
=======
    String actual = converter.convert(400);
>>>>>>> master
    String expected = "CD";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD
=======
  @Test
  public void test401()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(401);
    String expected = "CDI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test499()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(499);
    String expected = "CDXCIX";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master

  @Test
  public void test500()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(500);
=======
    String actual = converter.convert(500);
>>>>>>> master
    String expected = "D";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD

  @Test
  public void test600()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.toRoman(600);
    String expected = "DC";
=======
  @Test
  public void test501()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(501);
    String expected = "DI";
>>>>>>> master

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD
=======
  @Test
  public void test899()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(899);
    String expected = "DCCCXCIX";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master

  @Test
  public void test900()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(900);
=======
    String actual = converter.convert(900);
>>>>>>> master
    String expected = "CM";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD
=======
  @Test
  public void test901()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(901);
    String expected = "CMI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test999()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(999);
    String expected = "CMXCIX";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master

  @Test
  public void test1000()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(1000);
=======
    String actual = converter.convert(1000);
>>>>>>> master
    String expected = "M";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD
=======
  @Test
  public void test1001()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(1001);
    String expected = "MI";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master

  @Test
  public void test3999()
  {
    RomanConverter converter = new RomanConverter();

<<<<<<< HEAD
    String actual = converter.toRoman(3999);
=======
    String actual = converter.convert(3999);
>>>>>>> master
    String expected = "MMMCMXCIX";

    Assert.assertEquals(expected, actual);
  }

<<<<<<< HEAD

=======
  @Test
  public void test4000()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(4000);
    String expected = "MP";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test4001()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(4001);
    String expected = "MPI";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test5000()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(5000);
    String expected = "P";

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void test898()
  {
    RomanConverter converter = new RomanConverter();

    String actual = converter.convert(898);
    String expected = "DCCCXCVIII";

    Assert.assertEquals(expected, actual);
  }
>>>>>>> master
}