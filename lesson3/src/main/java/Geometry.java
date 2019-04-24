public class Geometry extends Cylinder
{
  public static void main(String[] args)
  {
    Geometry geometry = new Geometry();
    geometry.CreatePoint(2,1);
    geometry.setRadius(3);
    System.out.println("Площадь круга равна " + geometry.AreaOfACircle(3)); // метод может принимать другой радиус
    System.out.println("Обьем цилиндра равен " + geometry.volumeOfACylinder(3)); // метод принимает либо высоту, либо высоту + новый радиус
    System.out.println("Площадь цилиндра равна " + geometry.areaOfACylinder(3,3)); // метод принимает либо высоту, либо высоту + новый радиус



  }
}
