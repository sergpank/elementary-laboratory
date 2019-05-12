import java.util.regex.*;


public class EmailValidator
{

  /**
   * Проверить что емейл соответствует формату username@companyname.domain
   * - username, companyname  -- могут содержать только символы латинского алфавита, ".", "_", "-" и цифры
   * от себя добавил:  - username, companyname не могут начинаться с "." или "-"
   * - domain -- может содержать только символы латинского алфавита
   *
   * @param email электронный адрес для проверки
   * @return true если email валиден, false в противном случае АААААААААААА
   */
  public boolean isValid(String email)
  {
    String pattern = "[a-z_0-9]+[a-z_0-9.-]*@[a-z_0-9]+[a-z_0-9.-]*[.][a-z]+";

    email = email.trim();
    Pattern ptn = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
    Matcher matcher = ptn.matcher(email);

    return matcher.matches();
  }
}
