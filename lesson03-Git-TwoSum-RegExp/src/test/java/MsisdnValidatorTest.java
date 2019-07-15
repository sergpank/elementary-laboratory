import org.junit.Assert;
import org.junit.Test;

public class MsisdnValidatorTest
{
  @Test
  public void validatePositive()
  {
    MsisdnValidator validator = new MsisdnValidator();
    boolean isValid = validator.validate("+380-12-345-67-89");

    Assert.assertTrue(isValid);
  }

  @Test
  public void validateNegative1()
  {
    MsisdnValidator validator = new MsisdnValidator();
    boolean isValid = validator.validate("+373-12-345-67-89");

    Assert.assertFalse(isValid);
  }

  @Test
  public void validateNegative2()
  {
    MsisdnValidator validator = new MsisdnValidator();
    boolean isValid = validator.validate("+380-12-345-67-8");

    Assert.assertFalse(isValid);
  }

  @Test
  public void validateNegative3()
  {
    MsisdnValidator validator = new MsisdnValidator();
    boolean isValid = validator.validate("+380-12-345-67-890");

    Assert.assertFalse(isValid);
  }
}