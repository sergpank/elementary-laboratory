package main.java.hillel.clock;

public class App
{
  public static void main(String[] args)
  {
Clock clock1 = new Clock(23,59,59);

    clock1.printAmericanTime();
    clock1.printStandardTime();
    clock1.tick();

  }
}
