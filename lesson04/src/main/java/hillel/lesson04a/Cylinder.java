package hillel.lesson04a;

public class Cylinder extends Circle
{
  private int heiht;
  private double vol;

  public Cylinder(int x, int y, int radius, int heiht)
  {
    super(x, y, radius);
    this.heiht=heiht;
  }

  protected double calcCylVolume(){
    double v = super.getArea()*heiht;
    return this.vol=v;
  }

  public double getVol()
  {
    return vol;
  }

  @Override
  public String toString()
  {

    return "Cylinder{" +
        "heiht=" + heiht +
        ", vol=" + vol +
        '}';
  }
}
