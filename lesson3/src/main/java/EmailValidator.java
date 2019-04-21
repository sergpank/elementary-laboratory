/**
 * Проверить что емейл соответствует формату username@companyname.domain
 * - username, companyname  -- могут содержать только символы латинского алфавита, ".", "_", "-" и цифры
 * - domain -- может содержать только символы латинского алфавита
 *
 * @param email электронный адрес для проверки
 * @return true если email валиден, false в противном случае
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator
{
  public static void main(String[] args)
  {

  }

  private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

  private static Pattern pattern;
  private Matcher matcher;

  public EmailValidator()
  {

    pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
  }

  public boolean isValid(String email)
  {
    matcher = pattern.matcher(email);
    return this.matcher.matches();
  }
}
