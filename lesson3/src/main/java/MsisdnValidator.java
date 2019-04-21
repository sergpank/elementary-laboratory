import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MsisdnValidator
{
  public static void main(String[] args)
  {
    Scanner Numb = new Scanner(System.in);
    System.out.println("Введите телефонный номер: ");
    String msisdn = Numb.nextLine();
    validate(msisdn);
    if (validate(msisdn))
    {
      System.out.println("Телефон валиден");
    }
    else
    {
      System.out.println("Телефон не валиден");
    }
    System.out.println();
  }

  public static boolean validate(String msisdn)
  {
    for (int i = 0; i < msisdn.length(); i++)
    {
      try
      {
        Pattern number = Pattern.compile("^(\\+?380)(-\\d{2}-\\d{3}-\\d{2}-\\d{2})$");
        Matcher m = number.matcher(msisdn);
        return m.matches();
      }
      catch (PatternSyntaxException ex)
      {
        return false;
      }
    }
    return true;
  }
}