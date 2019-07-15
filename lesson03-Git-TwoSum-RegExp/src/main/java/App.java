public class App
{
  public static void main(String[] args)
  {
   Animal cat1 = new Animal("VAZ", 3);
    Animal cat2 = new Animal("CAT", 1);
    Animal cat3 = new Animal("KOK", 12);


    System.out.println(cat1);
    System.out.println(cat2);
    System.out.println(cat3);

    Animal.type= "Seam";

    System.out.println(cat1);
    System.out.println(cat2);
    System.out.println(cat3);


    cat1.setAge(10);
    System.out.println(cat1.getName());

    Fish zolotaya = new Fish ("ZOL", 1, "red");
    System.out.println(zolotaya);

    cat1.move();
    zolotaya.move();






  }
}
