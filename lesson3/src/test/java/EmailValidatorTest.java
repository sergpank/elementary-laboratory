import org.junit.Assert;
import org.junit.Test;

public class EmailValidatorTest
{
  @Test
  public void testValid1()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("user@mail.com");

    Assert.assertTrue(actual);
  }

  @Test
  public void testValid2()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("user.name@mail23.com");

    Assert.assertTrue(actual);
  }

  @Test
  public void testValid3()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("a@b.c");

    Assert.assertTrue(actual);
  }

  @Test
  public void testValid4()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("user_name.name@abcd.bde.com.ua");

    Assert.assertTrue(actual);
  }

  @Test
  public void testValid5()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("user_NAME.name@abcd.bDe.com.uA");

    Assert.assertTrue(actual);
  }

  @Test
  public void testNotValid1()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("user!name@mail23.com");

    Assert.assertFalse(actual);
  }

  @Test
  public void testNotValid2()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("-username@mail23.com");

    Assert.assertFalse(actual);
  }

  @Test
  public void testNotValid3()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid(".username@mail23.com");

    Assert.assertFalse(actual);
  }

  @Test
  public void testNotValid4()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("user@name@mail23.com");

    Assert.assertFalse(actual);
  }

  @Test
  public void testNotValid5()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("username@mail23.co3m");

    Assert.assertFalse(actual);
  }

  @Test
  public void testNotValid6()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("username@.mail23.co");

    Assert.assertFalse(actual);
  }

}
