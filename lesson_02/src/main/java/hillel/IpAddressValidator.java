package hillel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressValidator
{
  public boolean isValid(String ip)
  {
    Pattern pattern = Pattern.compile(
            "(([0-1]?[0-9]?[0-9])|(2[0-5][0-5]))." +
            "(([0-1]?[0-9]?[0-9])|(2[0-5][0-5]))." +
            "(([0-1]?[0-9]?[0-9])|(2[0-5][0-5]))." +
            "(([0-1]?[0-9]?[0-9])|(2[0-5][0-5]))");
    Matcher matcher = pattern.matcher(ip);
    return matcher.matches();
  }
}
