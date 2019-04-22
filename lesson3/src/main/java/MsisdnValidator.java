import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MsisdnValidator
{
  public static void main(String[] args)
  {
    MsisdnValidator msisdnValidator = new MsisdnValidator();
    System.out.println(msisdnValidator.validate("введите номер телефона"));
  }
  public boolean validate(String string)
  {
    string = string.replaceAll("\\D","");
    Pattern pattern = Pattern.compile("^((\\+?380)([0-9]{9}))$");
    Matcher matcher = pattern.matcher(string);
    return matcher.matches();
  }
}
