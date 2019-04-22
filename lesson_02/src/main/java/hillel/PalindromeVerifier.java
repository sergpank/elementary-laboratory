package hillel;

public class PalindromeVerifier
{
  public boolean verify(String string)
  {
    int wordSize = string.length();
    int midpoint = wordSize / 2;

    for (int i = 0; i < midpoint; i++)
    {
      if (string.charAt(i) != string.charAt(wordSize - 1 - i))
      {
        return false;
      }
    }
    return true;
  }
}

