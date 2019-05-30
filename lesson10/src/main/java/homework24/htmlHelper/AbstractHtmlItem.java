package homework24.htmlHelper;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractHtmlItem
{
  protected IHtmlTag tag;

  protected List<String> classes;

  protected Map<String, String> attributes;

  protected Map<String, String> styles;


  public AbstractHtmlItem(IHtmlTag tag)
  {
    this.tag = tag;

    classes = new ArrayList<>();

    attributes = new HashMap<>();

    styles = new HashMap<>();
  }

  public void addClasses(String... classes)
  {
    for (int i = 0; i < classes.length; i++)
    {
      if (!this.classes.contains(classes[i]))
      {
        this.classes.add(classes[i]);
      }
    }
  }

  public void setAttribute(String attrName, String attrValue)
  {
    this.attributes.put(attrName, attrValue);
  }

  public void removeAttribute(String attrName)
  {
    this.attributes.remove(attrName);
  }

  public void removeClasses(String... classes)
  {
    for (int i = 0; i < classes.length; i++)
    {
      this.classes.remove(classes[i]);
    }
  }

  public void setStyle(String name, ICssPropertyValue value)
  {
    styles.put(name, value.getPropertyValue());
  }

  public String getStyle(String name)
  {
    return styles.getOrDefault(name, "none");
  }

  public String getAttributesString()
  {
    StringBuilder sb = new StringBuilder();

    for (Map.Entry<String, String> attribute : attributes.entrySet())
    {
      sb.append(" ");
      sb.append(attribute.getKey());
      sb.append("=");
      sb.append("\"");
      sb.append(attribute.getValue());
      sb.append("\"");
    }

    return new String(sb);
  }

  public String getClassesString()
  {
    StringBuilder sb = new StringBuilder();
    if (!this.classes.isEmpty())
    {
      sb.append(this.classes.get(0));
      for (int i = 1; i < classes.size(); i++)
      {
        sb.append(" ");
        sb.append(this.classes.get(i));
      }
    }
    return new String(sb);
  }

  public String getStylesString()
  {
    StringBuilder sb = new StringBuilder();

    if (!this.styles.isEmpty())
    {
      for (Map.Entry<String, String> property : styles.entrySet())
      {
        sb.append(property.getKey());
        sb.append(":");
        sb.append(property.getValue());
        sb.append("; ");
      }
    }

    return new String(sb);
  }

  protected StringBuilder getOpeningTag()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("<");

    sb.append(tag.getTagName());

    if (!this.classes.isEmpty())
    {
      sb.append(" class=\"");
      sb.append(getClassesString());
      sb.append("\"");
    }

    if (!this.attributes.isEmpty())
    {
      sb.append(" ");
      sb.append(getAttributesString());
    }

    if (!this.styles.isEmpty())
    {
      sb.append(" style=\"");
      sb.append(getStylesString());
      sb.append("\"");
    }

    sb.append(">");

    return sb;
  }

  @Override
  public abstract String toString();

}