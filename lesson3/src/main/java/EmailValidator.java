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
    final String REGEX = "[._\\-0-9a-z]*@[._\\-0-9a-z]*.[a-z]*";
    return email.matches(REGEX);
  }
}
