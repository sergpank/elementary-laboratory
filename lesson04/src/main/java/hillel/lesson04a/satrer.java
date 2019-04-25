package hillel.lesson04a;

public class satrer
{
  public static void main(String[] args)
  {

    Circle b =new Circle(10,20,15);
   b.calcAria();

    Cylinder a = new Cylinder(10,20,15,20);
    a.calcAria();
    a.calcCylVolume();



    System.out.println(b+"\n"+a);
  }
}
