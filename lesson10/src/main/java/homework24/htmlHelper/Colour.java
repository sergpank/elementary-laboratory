package homework24.htmlHelper;

import java.util.Locale;

public class Colour implements ICssPropertyValue
{
  private int red;

  private int green;

  private int blue;

  private double opacity;

  public Colour(int red, int green, int blue)
  {
    this(red, green, blue, 1.0);
  }

  public Colour(int red, int green, int blue, double opacity)
  {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.opacity = opacity;
  }

  public String getPropertyValue()
  {
    return String.format(Locale.US, "rgba(%d, %d, %d, %.2f)", red, green, blue, opacity);
  }
}