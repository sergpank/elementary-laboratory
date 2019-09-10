package formatters.formatter;

public class FormatterFactory
{
  public static IFormatter getFormatter(String type)
  {
    IFormatter result=null;

    switch(type)
    {
      case "find":
        result=new FindFormatter();
        break;
      case "pyton":
        result=new PytonFormatter();
        break;
      case "acm1":
        result=new Acm1Formatter();
        break;
      case "acm2":
        result=new Acm2Formatter();
        break;
      case "acm3":
        result=new Acm3Formatter();
        break;
      case "xml":
        result=new XmlFormatter();
        break;
    }

    return result;
  }
}
