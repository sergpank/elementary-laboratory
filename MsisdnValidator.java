package hillel.lesson3;

public class MsisdnValidator
{
  /**
   * Проверить что номер тлефона является валидным украинским мобильным номером
   *
   * @param msisdn Номер телефона формата +380-12-345-67-89
   * @return true если номер валиден, false в противном случае
   */
  public static void main(String[] args)
  {
    String phone = "+380-12-345-67-89";
    MsisdnValidator msisdnValidator = new MsisdnValidator();
    System.out.println(msisdnValidator.validate(phone));
  }

  public boolean validate(String msisdn)
  {
    String phone = msisdn.replaceAll("\\-+", "");
    if (phone.matches("(\\+380)\\d{9}"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
