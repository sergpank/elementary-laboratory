package homework;

public class RomanConverter
{
  int[] arab = new int[]        { 10_000, 5000, 4000, 1000, 900,  500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1};
  String[] roman = new String[] { "T",    "P",  "MP", "M",  "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  public String convert(int i)
  {
    return convertSmart(i);
//    return convertStupid(i, null);
  }

  public String convertSmart(int number)
  {
    StringBuilder sb = new StringBuilder();

    while (number > 0)
    {
      for (int i = 0; i < arab.length; i++)
      {
        int level = arab[i];
        if (number >= level)
        {
          sb.append(roman[i]);
          number -= level;
          break;
        }
      }
    }

    return sb.toString();
  }


  public String convertStupid(int i, StringBuilder sb)
  {
    if (sb == null)
    {
      sb = new StringBuilder();
    }

    if (i == 0)
    {
      return sb.toString();
    }
    if (i >= 1000)
    {
      sb.append("M");
      convertStupid(i - 1000, sb);
    }
    else if (i >= 900)
    {
      sb.append("CM");
      convertStupid(i - 900, sb);
    }
    else if (i >= 500)
    {
      sb.append("D");
      convertStupid(i - 500, sb);
    }
    else if (i >= 400)
    {
      sb.append("CD");
      convertStupid(i - 400, sb);
    }
    else if (i >= 100)
    {
      sb.append("C");
      convertStupid(i - 100, sb);
    }
    else if (i >= 90)
    {
      sb.append("XC");
      convertStupid(i - 90, sb);
    }
    else if (i >= 50)
    {
      sb.append("L");
      convertStupid(i - 50, sb);
    }
    else if (i >= 40)
    {
      sb.append("XL");
      convertStupid(i - 40, sb);
    }
    else if (i >= 10)
    {
      sb.append("X");
      convertStupid(i - 10, sb);
    }
    else if (i >= 9)
    {
      sb.append("IX");
      convertStupid(i - 9, sb);
    }
    else if (i >= 5)
    {
      sb.append("V");
      convertStupid(i - 5, sb);
    }
    else if (i >= 4)
    {
      sb.append("IV");
      convertStupid(i - 4, sb);
    }
    else if (i >= 1)
    {
      sb.append("I");
      convertStupid(i - 1, sb);
    }

    return sb.toString();
  }
}
