package hillel;

import java.util.Scanner;

public class PalindromeVerifier
{
  Scanner scan = new Scanner(System.in);
  String exp = scan.nextLine();

  public static void main(String[] args)
  {
    System.out.println("Enter a string to verify");
    PalindromeVerifier verifier = new PalindromeVerifier();
    verifier.verify("");
  }
  public boolean verify(String string)
  {
    String expLow = exp.toLowerCase().replaceAll("\\s+","");
    int firstPos = 0;
    int lastPos = expLow.length() - 1;
    boolean itsPall = true;
    while (firstPos < lastPos)
    {
      String firstLet = expLow.substring(firstPos, firstPos + 1);
      String lastLet = expLow.substring(lastPos, lastPos + 1);
      if (firstLet.equals(lastLet) == false)
      {
        itsPall = false;
        break;
      }
      firstPos++;
      lastPos--;
    }
    System.out.println((itsPall == true) ? " it`s a palindrome=)" : "it`s not a palindrome=(");
    return true;
  }
}