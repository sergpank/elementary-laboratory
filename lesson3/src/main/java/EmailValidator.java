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


    boolean isEmailValid = Pattern.compile("^((\\w|[_-]|\\.)+@[\\w]+\\.[a-zA-Z]+)$").matcher(email).matches();

    return isEmailValid;


  }

//  public static void main(String[] args)
//  {
//    EmailValidator a = new EmailValidator();
//    System.out.println(a.isValid("..k.@mail.com"));
//  }
}


