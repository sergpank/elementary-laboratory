
public class Application
{
  public static void main(String[] args)
  {
    Car BMW = new Car("BMW", 4, "black");
    Car Volvo = new Car("Volvo", 5, "blue");
    Car KIA = new Car("KIA", 3, "red");

    System.out.println("Marka: ");
    System.out.println(BMW +"\n" + Volvo + "\n" + KIA);

    KIA.setColor("gray");

    System.out.println("Marka: ");
    System.out.println(BMW +"\n" + Volvo + "\n" + KIA);

    Lkw fura = new Lkw("Merc", 6, "black", "2,5meter");
    System.out.println(fura);

    BMW.speed();
    fura.speed();

  }
}
