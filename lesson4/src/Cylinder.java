public class Cylinder extends Circle
{
  protected int volume;
  protected int height;
  protected int area;
  protected int areaOfACylinder(int a)
  {
    height = a;
    area = (int)(2*3.14*radius*height);
    return area;
  }
  protected int areaOfACylinder(int a, int b)
  {
    height = a;
    area = (int)(2*3.14*b*height);
    return area;
  }
  protected int volumeOfACylinder(int a, int b)
  {
    height = a;
    volume = height*(AreaOfACircle(b));
    return volume;
  }
  protected int volumeOfACylinder(int a)
  {
    height = a;
    volume = height*(AreaOfACircle(radius));
    return volume;
  }
}
