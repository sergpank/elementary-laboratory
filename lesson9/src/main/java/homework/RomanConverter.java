package homework;

public class RomanConverter
{
<<<<<<< HEAD
  public static void main(String[] args)
  {
    for (int i=5; i <10; i++ )
    {
      System.out.println (i+ " " + toRoman ( i ));
=======
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
>>>>>>> master
    }
  }

<<<<<<< HEAD
    public static String toRoman ( int i)
    {
      StringBuilder sb = new StringBuilder ( );
      toRoman ( i , sb );

      return sb.toString ( );
    }


    public static void toRoman ( int i, StringBuilder sb)
    {
      if (i == 0)
      {
        return;
      }

      if (i <= 3)
      {
        sb.append ( 'I' );
        toRoman ( i - 1 , sb );
      }
      if (i == 4)
      {
        sb.append ( "IV" );
        toRoman ( i - 4 , sb );
      }
      if (i == 5)
      {
        sb.append ( "V" );
        toRoman ( i - 5 , sb );
      }

      if (i>5 && i<=8)
      {
        sb.append ( "V" );
        toRoman ( i - 5 , sb );
      }

      if (i==9)
      {
        sb.append ( "IX" );
        toRoman ( i - 9 , sb );
      }


      if (i>9 && i<20)
      {
        sb.append ( "X" );
        toRoman ( i - 10 , sb );
      }

        if (i>19 && i<40)
        {
          sb.append ( "XX" );
          toRoman ( i - 20 , sb );
        }


      if (i==40)
      {
        sb.append ( "XL" );
        toRoman ( i - 40 , sb );
      }

      if (i>40 && i<50)
      {
        sb.append ( "XL" );
        toRoman ( i - 40 , sb );
      }


      if (i>49 && i<90)
      {
        sb.append ( "L" );
        toRoman ( i - 50 , sb );
      }

      if (i>89 && i<100)
      {
        sb.append ( "XC" );
        toRoman ( i - 90 , sb );
      }

      if (i>99 && i<400)
      {
        sb.append ( "C" );
        toRoman ( i - 100 , sb );
      }

      if (i>399 && i<500)
      {
        sb.append ( "CD" );
        toRoman ( i - 400 , sb );
      }

      if (i>399 && i<500)
      {
        sb.append ( "CD" );
        toRoman ( i - 400 , sb );
      }

      if (i>499 && i<600)
      {
        sb.append ( "D" );
        toRoman ( i - 500 , sb );
      }

      if (i>599 && i<700)
      {
        sb.append ( "DC" );
        toRoman ( i - 600 , sb );
      }

      if (i>699 && i<800)
      {
        sb.append ( "DCC" );
        toRoman ( i - 700 , sb );
      }

      if (i>799 && i<900)
      {
        sb.append ( "DCCC" );
        toRoman ( i - 800 , sb );
      }

      if (i>899 && i<1000)
      {
        sb.append ( "CM" );
        toRoman ( i - 900 , sb );
      }

      if (i>999 && i<2000)
      {
        sb.append ( "M" );
        toRoman ( i - 1000 , sb );
      }

      if (i>1999 && i<3000)
      {
        sb.append ( "MM" );
        toRoman ( i - 2000 , sb );
      }

      if (i>2999 && i<4000)
      {
        sb.append ( "MMM" );
        toRoman ( i - 3000 , sb );
      }
=======
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
>>>>>>> master
    }
    else if (i >= 1)
    {
      sb.append("I");
      convertStupid(i - 1, sb);
    }

    return sb.toString();
  }
