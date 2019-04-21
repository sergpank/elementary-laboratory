public class MsisdnValidator
{
  /**
   * Проверить что номер тлефона является валидным украинским мобильным номером
   * @param msisdn Номер телефона формата +380-12-345-67-89
   * @return true если номер валиден, false в противном случае
   */
  public boolean validate(String msisdn)
  {
    final String REGEX = "^\\+380([0-9]{9})";
    String number = msisdn.replaceAll("-", "");
    return number.matches(REGEX);
  }
}
