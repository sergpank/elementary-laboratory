import java.util.regex.*;

public class MsisdnValidator
{

  /**
   * Метод проверяет, что номер тлефона является валидным украинским мобильным номером
   *
   * @param msisdn Номер телефона формата +380-12-345-67-89
   * @return true если номер валиден, false в противном случае
   */
  public boolean validate(String msisdn)
  {
    String pattern = "[+]380-[0-9]{2}-[0-9]{3}(-[0-9]{2}){2}";

    msisdn = msisdn.trim();
    Pattern ptn = Pattern.compile(pattern);
    Matcher matcher = ptn.matcher(msisdn);

    return matcher.matches();
  }
}
