package panko.concurrency;

public class DeadlockDemo
{
  private final Object lock1 = new Object();
  private final Object lock2 = new Object();

  public void instanceMethod1()
  {
    synchronized (lock1)
    {
      System.out.println("A :: lock1 hodl");
      synchronized (lock2)
      {
        System.out.println("A :: lock2 hodl");
        // critical section guarded first by
        // lock1 and then by lock2
      }
      System.out.println("A :: lock2 release");
    }
    System.out.println("A :: lock1 release");
  }

  public void instanceMethod2()
  {
    synchronized (lock2)
    {
      System.out.println("B :: lock2 hodl");
      synchronized (lock1)
      {
        System.out.println("B :: lock1 hodl");
        // critical section guarded first by
        // lock2 and then by lock1
      }
      System.out.println("A :: lock1 release");
    }
    System.out.println("A :: lock2 release");
  }

  public static void main(String[] args)
  {
    final DeadlockDemo dld = new DeadlockDemo();

    Runnable r1 = () -> {
      while(true)
      {
        dld.instanceMethod1();
        try
        {
          Thread.sleep(50);
        }
        catch (InterruptedException ie)
        {
        }
      }
    };

    Runnable r2 = () -> {
      while(true)
      {
        dld.instanceMethod2();
        try
        {
          Thread.sleep(50);
        }
        catch (InterruptedException ie)
        {
        }
      }
    };

    Thread thdA = new Thread(r1);
    Thread thdB = new Thread(r2);
    thdA.start();
    thdB.start();
  }
}
