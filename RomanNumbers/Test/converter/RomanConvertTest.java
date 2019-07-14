package converter;

import org.junit.Assert;
import org.junit.Test;

public class RomanConvertTest
{

  @Test
  public void test1()
  {
    RomanConvert convert = new RomanConvert();
    String actual = convert.toRoman(1, sb);
    String expected = "I";

    Assert.assertEquals(expected,actual);
  }
@Test
  public void test2()
{
  RomanConvert convert = new RomanConvert();
  String actual = convert.toRoman(2, sb);
  String expected = "II";
  Assert.assertEquals(expected,actual);
}
}