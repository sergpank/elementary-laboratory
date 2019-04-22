import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MsisdnValidator
{
  /**
   * Проверить что номер тлефона является валидным украинским мобильным номером
   * @param msisdn Номер телефона формата +380-12-345-67-89
   * @return true если номер валиден, false в противном случае
   */
  public boolean validate(String msisdn)
  {
    Pattern p = Pattern.compile("^\\+380-\\d{2}-\\d{3}-\\d{2}-\\d{2}$");
    Matcher m = p.matcher(msisdn);

    while (m.find())
    {
      return true;
    }
    return false;
  }
}
