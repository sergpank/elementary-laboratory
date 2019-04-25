package hillel.lab4.Clock;

import hillel.lab4.Clock.Clock;

public class Time
{
  public static void main(String[] args)
  {
    Clock clock = new Clock(23,59,59);
    clock.printStandartTime();
    clock.printAmericanTime();
    clock.Tick();
  }
}
