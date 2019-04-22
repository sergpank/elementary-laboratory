package hillel.lesson3;

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

  public static void main(String[] args)
  {
    String email = "user-name@mail23.com";
    EmailValidator emailValidator = new EmailValidator();
    System.out.println(emailValidator.isValid(email));
  }

  public boolean isValid(String email)
  {
    if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{1,})$"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
