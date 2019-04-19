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
  public void testNotValid1()
  {
    EmailValidator validator = new EmailValidator();

    boolean actual = validator.isValid("user!name@mail23.com");

    Assert.assertFalse(actual);
  }
}
