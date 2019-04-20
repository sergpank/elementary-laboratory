

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator
{
  /**
   * Проверить что емейл соответствует формату username@companyname.domain
   * - username, companyname  -- могут содержать только символы латинского алфавита, ".", "_", "-" и цифры
   *  - domain -- может содержать только символы латинского алфавита
   * @param email электронный адрес для проверки
   * @return true если email валиден, false в противном случае
   */
  public boolean isValid(String email)
  {
    Pattern pattern = Pattern.compile("[a-z[0-9][/./_/-]]+@[a-z[0-9][/./_/-]]+.[a-z]+");
    Matcher matcher= pattern.matcher(email);
    return matcher.matches();
  }
}
