package homework24.htmlHelper;

import java.util.List;
import java.util.ArrayList;

public class HtmlItem extends AbstractHtmlItem
{
  protected List<AbstractHtmlItem> children;

  protected String textContent;

  public HtmlItem(HtmlTag tag)
  {
    super(tag);
    children = new ArrayList<>();
    this.textContent = "";
  }

  public void setText(String textContent)
  {
    this.textContent = textContent;
  }

  public void addChildren(AbstractHtmlItem... children)
  {
    for (int i = 0; i < children.length; i++)
    {

      this.children.add(children[i]);
    }
  }

  public boolean hasChildren()
  {
    return !this.children.isEmpty();
  }

  public void empty()
  {
    this.children.clear();
  }

  @Override
  public String toString()
  {
    StringBuilder sb = getOpeningTag();

    sb.append(textContent);

    if (!this.children.isEmpty())
    {
      sb.append("\n");

      for (AbstractHtmlItem child : this.children)
      {
        sb.append(child.toString());
      }
    }

    sb.append(getClosingTag());

    return new String(sb);
  }

  protected StringBuilder getClosingTag()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("</");
    sb.append(tag.getTagName());
    sb.append(">\n");

    return sb;
  }

}