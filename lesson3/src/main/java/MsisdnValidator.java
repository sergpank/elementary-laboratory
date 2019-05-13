import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MsisdnValidator
{
  /**
   * Проверить что номер тлефона является валидным украинским мобильным номером
   *
   * @param msisdn Номер телефона формата +380-12-345-67-89
   * @return true если номер валиден, false в противном случае
   */
  public boolean validate(String msisdn)
  {


    boolean isPhoneValid = Pattern.compile("^((\\+380)[-](\\d{2})[-](\\d{3})[-](\\d{2})[-](\\d{2}))$").matcher(msisdn).matches();

    return isPhoneValid;

  }

  public static void main(String[] args)
  {
    MsisdnValidator test = new MsisdnValidator();
    System.out.println(test.validate("+380-12-325-67-89"));
  }

}
