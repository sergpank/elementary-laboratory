package converter;

  public class RomanConverter
  {
//    String[] roman = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//    int[] arab = new int[]        {1000, 900, 500, 400,  100,  90,   50,  40,   10,   9,   5,   4,   1};
//
//    public String convert(int i)
//    {
//      StringBuilder sb = new StringBuilder();
//
//      return convertNumber(i);
//    }
//
//    public String convertNumber (int number)
//    {
//      StringBuilder sb = new StringBuilder();
//
//      while (number > 0)
//      {
//        for (int i = 0; i < arab.length; i++)
//        {
//          int level = arab[i];
//          if (number >= level)
//          {
//            sb.append(roman[i]);
//            number -= level;
//            break;
//          }
//        }
//      }
//      return sb.toString();
//    }


  public String toRoman(int i) throws NumberFormatException
  {
    StringBuilder sb = new StringBuilder();
    toRoman(i, sb);

    if (i < 1 || i > 3999)
    {
      throw new NumberFormatException("Invalid format, enter number between 1 till 3999");
    }

    return sb.toString();
  }


  public void toRoman(int i, StringBuilder sb)
  {
    if (i >= 1000)
    {
      sb.append("M");
      toRoman(i - 1000, sb);
    }

    else if (i >= 900)
    {
      sb.append("CM");
      toRoman(i - 900, sb);
    }

    else if (i >= 500)
    {
      sb.append("D");
      toRoman(i - 500, sb);
    }

    else if (i >= 400)
    {
      sb.append("CD");
      toRoman(i - 400, sb);
    }

    else if (i >= 100)
    {
      sb.append("C");
      toRoman(i - 100, sb);
    }

    else if (i >= 90)
    {
      sb.append("XC");
      toRoman(i - 90, sb);
    }

    else if (i >= 50)
    {
      sb.append("L");
      toRoman(i - 50, sb);
    }

    else if (i >= 40)
    {
      sb.append("XL");
      toRoman(i - 40, sb);
    }

    else if (i >= 10)
    {
      sb.append("X");
      toRoman(i - 10, sb);
    }

    else if (i >= 5)
    {
      sb.append("V");
      toRoman(i - 5, sb);
    }

    else if (i >= 4)
    {
      sb.append("IV");
      toRoman(i - 4, sb);
    }

    else if (i >= 1)
    {
      sb.append('I');
      toRoman(i - 1, sb);
    }
  }
}