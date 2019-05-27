public class RomanConverter
{
  public String toRoman(int number) throws NumberFormatException
  {
    StringBuilder sb = new StringBuilder();

    if (number < 1 || number > 3999)
    {
      throw new NumberFormatException("Invalid format, enter number between 1 to 3999 ");
    }
      while (number >= 1000)
      {
        sb.append("M");
        number= number-1000;
      }
      while (number >= 900)
      {
        sb.append("CM");
        number= number-900;
      }
      while (number >= 500)
      {
        sb.append("D");
        number= number-500;
      }
      while (number >= 400)
      {
        sb.append("CD");
        number= number-400;
      }
      while (number >= 100)
      {
        sb.append("C");
        number= number-100;
      }
      while (number >= 90)
      {
        sb.append("XC");
        number= number-90;
      }
      while (number >= 50)
      {
        sb.append("L");
        number= number-50;
      }
      while (number >= 40)
      {
        sb.append("XL");
        number= number-40;
      }
      while (number >= 10)
      {
        sb.append("X");
        number= number-10;
      }
      while (number >= 9)
      {
        sb.append("IX");
        number= number-9;
      }
      while (number >= 5)
      {
        sb.append("V");
        number= number-5;
      }
      while (number >= 4)
      {
        sb.append("IV");
        number= number-4;
      }
      while (number >= 1)
      {
        sb.append("I");
        number= number-1;;
      }
    return sb.toString();
    }
  }

