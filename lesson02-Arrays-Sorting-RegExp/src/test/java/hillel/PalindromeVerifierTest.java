package hillel;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeVerifierTest
{
  @Test
  public void testPositive()
  {
    PalindromeVerifier verifier = new PalindromeVerifier();

    Assert.assertTrue(verifier.verify("abcba"));
  }

  @Test
  public void testNegative()
  {
    PalindromeVerifier verifier = new PalindromeVerifier();

    Assert.assertFalse(verifier.verify("abcab"));
    Assert.assertFalse(verifier.verify("abcab"));
  }
}
