package homework;

public class RomanConverter
{
  public static void main(String[] args)
  {
    for (int i=5; i <10; i++ )
    {
      System.out.println (i+ " " + toRoman ( i ));
    }
  }

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
    }
  }
