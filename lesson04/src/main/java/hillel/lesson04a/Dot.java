package hillel.lesson04a;

public class Dot
{
  private int x,y;

  public Dot(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString()
  {

    return "Dot{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
