package hillel.lesson04a;

public class Cylinder extends Circle
{
  private int height;
  private double vol;
  private double area;
  //private Circle c;


  public Cylinder(int x, int y, int radius,  int height)
  {
    super(x, y,radius);
    super.calcAria();
    this.height=height;

  }

  public double calcCylVolume(){
    double v = super.getArea()*height;
    return this.vol=v;
  }

  @Override
  public double calcAria(){

    double s =2*super.getArea()+2*Math.PI*super.getRadius()*height;

    return this.area=s;

  }

  public int getHeight()
  {
    return height;
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
        "heiht=" + height +
        ", vol=" + vol +
        ", area=" + area +
        '}';
  }
}
