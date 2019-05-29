public class RomanConverter
{
  public String toRoman(int i)
  {
    if(i < 1 || i > 3999)
    {
      return "invalid value";
    }
    StringBuilder stringBuilder = new StringBuilder();
    while(i >= 1000)
    {
      stringBuilder.append("M");
      i-=1000;
    }
    while(i >= 900)
    {
      stringBuilder.append("CM");
      i-=900;
    }
    while(i >= 500)
    {
      stringBuilder.append("D");
      i-=500;
    }
    while(i >= 400)
    {
      stringBuilder.append("CD");
      i-=400;
    }
    while(i >= 100)
    {
      stringBuilder.append("C");
      i-=100;
    }
    while(i >= 90)
    {
      stringBuilder.append("XC");
      i-=90;
    }
    while(i >= 50)
    {
      stringBuilder.append("L");
      i-=50;
    }
    while(i >= 40)
    {
      stringBuilder.append("XL");
      i-=40;
    }
    while(i >= 10)
    {
      stringBuilder.append("X");
      i-=10;
    }
    if(i == 9)
    {
      stringBuilder.append("IX");
      i-=9;
    }
    while(i >= 5)
    {
      stringBuilder.append("V");
      i-=5;
    }
    while(i >= 4)
    {
      stringBuilder.append("IV");
      i-=4;
    }
    while(i >= 1)
    {
      stringBuilder.append("I");
      i-=1;
    }
    while(i >= 1000)
    {
      stringBuilder.append("M");
      i-=1000;
    }
    String result = stringBuilder.toString();
    return result;
  }
}
