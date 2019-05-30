package homework24.htmlHelper;

public class SelfClosingHtmlItem extends AbstractHtmlItem
{
  public SelfClosingHtmlItem(SelfClosingHtmlTag tag)
  {
    super(tag);
  }

  @Override
  public String toString()
  {
    return new String(getOpeningTag());
  }

  @Override
  protected StringBuilder getOpeningTag()
  {
    StringBuilder sb = super.getOpeningTag();

    int closingQuoteIndex = sb.lastIndexOf(">");

    if (closingQuoteIndex != -1)
    {
      sb.insert(closingQuoteIndex, " /");
    }

    return sb;
  }
}