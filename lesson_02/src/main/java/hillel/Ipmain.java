package hillel;

public class Ipmain
{
  public static void main(String[]args)
  {
    IpAddressValidator validator = new IpAddressValidator();
    validator.isValid("192.168.1.1");
  }
}
