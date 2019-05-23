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
      toRoman(i - 5, sb);
    }
  }
}
