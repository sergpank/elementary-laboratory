import java.util.Scanner;

class IPv4Validator

{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    String enter = scanner.nextLine();

    validIP(enter);
  }

  public static boolean validIP(String ip)
  {
    try
    {
      if (ip == null || ip.isEmpty())
      {
        System.out.println("ERROR MOTHERFUCKER");
        return false;
      }

      String[] parts = ip.split("\\.");
      if (parts.length != 4)
      {
        System.out.println("ERROR MOTHERFUCKER");
        return false;
      }

      for (String s : parts)
      {
        int i = Integer.parseInt(s);
        if ((i < 0) || (i > 255))
        {
          System.out.println("INVALID");
          return false;
        }
      }
      if (ip.endsWith("."))
      {
        System.out.println("ERROR MOTHERFUCKER");
        return false;
      }
      System.out.println("VALID");
      return true;
    }
    catch (NumberFormatException nfe)
    {
      System.out.println("ERROR MOTHERFUCKER");
      return false;
    }
  }
}
