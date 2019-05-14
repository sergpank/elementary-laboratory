package hillel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IpAddressValidator
{
  public boolean isValid(String ip)
  {
    Pattern p = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$"); //TODO честно нашел в нете, у самого не получалось
    Matcher m = p.matcher(ip);

    while (m.find())
    {
      //System.out.println("true");
      return true;
    }
    return false;
  }
}
