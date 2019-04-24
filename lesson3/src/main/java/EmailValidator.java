import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator
{
  public static void main(String[] args)
  {
    EmailValidator emailValidator = new EmailValidator();
    System.out.println(emailValidator.validate("user@mail123.c"));
  }
  public boolean validate(String string)
  {
    Pattern pattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]$");
    Matcher matcher = pattern.matcher(string);
    return matcher.matches();
  }
}
