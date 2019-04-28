package hillel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressValidator
{
  public boolean isValid(String ip)
  {
    Pattern p = Pattern.compile("[0-255]");
    Matcher m = p.matcher(ip);

    return true;
  }
}
