package homework24.htmlHelper;

public enum HtmlTag implements IHtmlTag
{
  DIV("div"),
  TABLE("table"),
  TR("tr"),
  TH("th"),
  TD("td"),
  TBODY("tbody"),
  A("a"),
  SPAN("span"),
  OL("ol"),
  UL("ul"),
  LI("li");

  private String tagName;

  HtmlTag(String tagName)
  {
    this.tagName = tagName;
  }

  public String getTagName()
  {
    return tagName;
  }
}