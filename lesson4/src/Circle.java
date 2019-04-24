public class Circle extends Point
{
  protected int radius;
  protected int area;

  protected void setRadius(int a)
  {
    radius = a;
  }
  protected int AreaOfACircle()
  {
    area = (int)(3.14*radius*radius);
    return area;
  }
  protected int AreaOfACircle(int a)
  {
    int result = (int)(3.14*a*a);
    return result;
  }
}
