package Task_13;

public class Appmain
{
  public static void main(String[] args)
  {
    Clock clock = new Clock(22,50,7);

    clock.printStandardTime();

    clock.setTime(22);
    clock.printAmericanTime();
    clock.setTime(10);
    clock.printAmericanTime();

    clock.setSecond(59);
    clock.setMinute(59);
    clock.tick();
  }
}
