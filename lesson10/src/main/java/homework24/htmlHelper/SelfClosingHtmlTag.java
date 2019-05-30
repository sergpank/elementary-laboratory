package homework24.htmlHelper;

public enum SelfClosingHtmlTag implements IHtmlTag
{
  INPUT("input"),
  BR("br"),
  HR("hr");

  private String tagName;

  SelfClosingHtmlTag(String tagName)
  {
    this.tagName = tagName;
  }

  public String getTagName()
  {
    return tagName;
  }
}