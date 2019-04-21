import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Проверить что номер тлефона является валидным украинским мобильным номером
 *
 * @param msisdn Номер телефона формата +380-12-345-67-89
 * @return true если номер валиден, false в противном случае
 */

public class MsisdnValidator
{
  public static void main(String[] args)
  {
  }

  public boolean validate(String msisdn)
  {
    String phoneNumber = "+380639962399";
    Pattern pattern = Pattern.compile("^((\\+?380)([0-9]{9}))$");
    Matcher matcher = pattern.matcher(phoneNumber);
    if (matcher.matches())
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}

