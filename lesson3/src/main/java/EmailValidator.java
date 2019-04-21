
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EmailValidator
{
  public static void main(String[] args)
  {
    Scanner mail = new Scanner(System.in);
    System.out.println("Введите Email адрес: ");
    String email = mail.nextLine();
    isValid(email);
    if (isValid(email))
    {
      System.out.println("Email валиден");
    }
    else
    {
      System.out.println("Email не валиден");
    }
    System.out.println();
  }

  public static boolean isValid(String email)
  {
    for (int i = 0; i < email.length(); i++)
    {
      try
      {
        Pattern emailurl = Pattern.compile("^((\\w|[_-])+(\\.[\\w-]+)*@[\\w-]+((\\.[\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$");
        Matcher m = emailurl.matcher(email);
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