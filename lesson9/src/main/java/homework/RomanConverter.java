package homework;


public class RomanConverter
{
  public String toRoman(int i)
  {
    StringBuilder sb = new StringBuilder();
    toRoman(i, sb);

    return sb.toString();
  }


  public void toRoman(int i, StringBuilder sb)
  {
    if (i == 0)
    {
      return;
    }

    if (i <= 3)
    {
      sb.append('I');
      toRoman(i - 1, sb);
    }
    if (i == 4)
    {
      sb.append("IV");
      toRoman(i - 4, sb);
    }
    if (i == 5)
    {
      sb.append("V");
      toRoman(i - 5,sb);
    }
    if(i>5&&i<9)
    {
      sb.append("VI");
      toRoman(i-6, sb);
    }
    if(i==9)
    {
      sb.append("I");
      toRoman(i+1,sb);
    }
    if (i == 10)
    {
      sb.append("X");
      toRoman(i-10,sb);
    }
    if(i>10&&i<40)
    {
      sb.append("X");
      toRoman(i-10,sb);
    }
    if(i>=40&&i<50)
    {
      sb.append("XL");
      toRoman(i-40,sb);
    }
    if(i>=50&&i<90)
    {
      sb.append("L");
      toRoman(i-50, sb);
    }
    if (i>=90&&i<100)
    {
      sb.append("XC");
      toRoman(i-90,sb);
    }
    if(i>=100&&i<400)
    {
      sb.append("C");
      toRoman(i-100,sb);
    }
    if(i>=400&&i<500)
    {
      sb.append("CD");
      toRoman(i-400, sb);
    }
    if (i>=500&&i<900)
    {
      sb.append("D");
      toRoman(i-500,sb);
    }
    if(i>=900&&i<1000)
    {
      sb.append("CM");
      toRoman(i-900,sb);
    }
    if (i>=1000&&i<4000)
    {
      sb.append("M");
      toRoman(i-1000, sb);
    }
  }
}
