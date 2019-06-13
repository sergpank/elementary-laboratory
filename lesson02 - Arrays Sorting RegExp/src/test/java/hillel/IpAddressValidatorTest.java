package hillel;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IpAddressValidatorTest
{
  @Test
  public void testPositive()
  {
    IpAddressValidator validator = new IpAddressValidator();
    assertTrue(validator.isValid("192.168.1.0"));
  }

  @Test
  public void testNegative()
  {
    IpAddressValidator validator = new IpAddressValidator();
    assertFalse(validator.isValid("192.168.1.256"));
  }
}