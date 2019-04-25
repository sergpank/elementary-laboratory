package hillel.lesson04a;

public class Cylinder extends Circle
{
  private int heiht;
  private double vol;
  private double area;

  public Cylinder(int x, int y, int radius, int heiht)
  {
    super(x, y, radius);
    this.heiht=heiht;
  }

  protected double calcCylVolume(){
    double v = super.getArea()*heiht;
    return this.vol=v;
  }

  @Override
  protected double calcAria(){

    double s =2*super.getArea()+2*Math.PI*super.getRadius()*heiht;

    return this.area=s;

  }

  public double getVol()
  {
    return vol;
  }


  public double getArea()
  {
    return area;
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
