package hillel;

import java.util.Scanner;

public class PalindromeVerifier
{
  public boolean verify(String string)
  {
    int n = string.length();

    for (int i = 0; i < (n / 2); ++i)
    {
      if (string.charAt(i) != string.charAt(n - i - 1))
      {
        return false;
      }
    }
    return true;
  }
}
