package homework;

public class RomanConverter
{
  public String toRoman(int i) throws MaxException
  {

    StringBuilder sb = new StringBuilder();
    toRoman(i, sb);

    return sb.toString();
  }


  public void toRoman(int i, StringBuilder sb) throws MaxException
  {
    if (i >= 4000)
    {
      throw new MaxException("limit is exceeded " + i);
    }
    if (i == 0)
    {
      return;
    }

    if (i <= 3)
    {
      sb.append('I');
      toRoman(i - 1, sb);
    }
    else if (i == 4)
    {
      sb.append("IV");
      toRoman(i - 4, sb);
    }
    else if (i < 9)
    {
      sb.append("V");
      toRoman(i - 5, sb);
    }
    else if (i == 9)
    {
      sb.append("IX");
      toRoman(i - 9, sb);
    }
    else if (i == 10)
    {
      sb.append("X");
      toRoman(i - 10, sb);
    }
    else if (i < 40)
    {
      sb.append("X");
      toRoman(i - 10, sb);
    }
    else if (i < 50)
    {
      sb.append("XL");
      toRoman(i - 40, sb);
    }
    else if (i < 90)
    {
      sb.append("L");
      toRoman(i - 50, sb);
    }
    else if (i < 100)
    {
      sb.append("XC");
      toRoman(i - 90, sb);
    }
    else if (i < 400)
    {
      sb.append("C");
      toRoman(i - 100, sb);
    }
    else if (i < 500)
    {
      sb.append("CD");
      toRoman(i - 400, sb);
    }
    else if (i < 900)
    {
      sb.append("D");
      toRoman(i - 500, sb);
    }
    else if (i < 1000)
    {
      sb.append("CM");
      toRoman(i - 900, sb);
    }
    else if (i < 4000)
    {
      sb.append("M");
      toRoman(i - 1000, sb);
    }


  }
}
