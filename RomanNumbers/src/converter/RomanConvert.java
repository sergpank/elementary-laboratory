package converter;

public class RomanConvert
{
  public String toRoman(int i, StringBuilder sb)
  {
   if (i==0)
   {
     return;
   }
    if (i<=3)
    {
      sb.append('I');
      toRoman(i-1,sb);
    }
  }
}
