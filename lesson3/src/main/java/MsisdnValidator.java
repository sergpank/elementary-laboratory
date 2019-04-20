package lesson3.src.main.java;

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
    Pattern pattern = Pattern.compile("[+]380-[0-9]{2}-[0-9]{3}-[0-9]{2}-[0-9]{2}");
    Matcher matcher = pattern.matcher(msisdn);
    return matcher.matches();
  }
}
