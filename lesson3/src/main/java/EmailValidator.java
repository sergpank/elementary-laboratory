import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator
{
  /**
   * Проверить что емейл соответствует формату username@companyname.domain
   * - username, companyname  -- могут содержать только символы латинского алфавита, ".", "_", "-" и цифры
   * - domain -- может содержать только символы латинского алфавита
   *
   * @param email электронный адрес для проверки
   * @return true если email валиден, false в противном случае
   */
  public boolean isValid(String email)
  {
    Pattern p = Pattern.compile("^([a-z]+[._-])*[a-z]+@[a-z0-9]+\\.[a-z]*$");
    Matcher m = p.matcher(email);

    while (m.find())
    {
      //System.out.println("true");
      return true;
    }
    return false;
  }
}
