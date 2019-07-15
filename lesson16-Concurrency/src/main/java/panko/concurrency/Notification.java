package panko.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Notification
{
  boolean teaReady;
  boolean omletReady;
  boolean toastReady;

  enum Dish
  {
    TEA,
    OMLET,
    TOAST
  }

  public static void main(String[] args)
  {
    Notification n = new Notification();
    Runnable teaCooker = n.makeCooker(Dish.TEA, 5);
    Runnable omletCooker = n.makeCooker(Dish.OMLET, 7);
    Runnable toastCooker = n.makeCooker(Dish.TOAST, 3);
    Runnable vasya = n.makeEater("Вася");
    Runnable petya = n.makeEater("Петя");

    ExecutorService pool = Executors.newCachedThreadPool();

    pool.execute(vasya);
    pool.execute(petya);
    pool.execute(teaCooker);
    pool.execute(omletCooker);
    pool.execute(toastCooker);

    pool.shutdown();
  }

  Runnable makeCooker(Dish dish, long delay)
  {
    return () -> {
      while(true)
      {
        if (!dishReady(dish))
        {
          System.out.printf("Start cooking [%s] ...\n", dish.name());

          try
          {
            TimeUnit.SECONDS.sleep(delay);
          }
          catch (Throwable t)
          {
            // NOTHING TO DO HERE
          }

          System.out.printf("[%s] is ready!\n", dish.name());

          switch (dish)
          {
            case TEA: teaReady = true; break;
            case OMLET: omletReady = true; break;
            case TOAST: toastReady = true; break;
          }
          synchronized (this)
          {
            notifyAll();
          }
        }
        synchronized (this)
        {
          try
          {
            wait();
          }
          catch (InterruptedException e)
          {
            e.printStackTrace();
          }
        }
      }
    };
  }

  Runnable makeEater(String name)
  {
    return () -> {
      int cnt = 0;

      while(true)
      {
        while(!catTakeBreakfast())
        {
          System.out.printf("%s : Waiting for my breakfast ...\n", name);
          synchronized (this)
          {
            try
            {
              wait();
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }
          }
        }
        cnt++;
        System.out.printf("%s : FINALLY! num - num - num ! [%d] \n", name, cnt);

        synchronized (this)
        {
          notifyAll();
        }
      }
    };
  }

  boolean catTakeBreakfast()
  {
    synchronized (this)
    {
      boolean result = teaReady && omletReady && toastReady;
      if(result)
      {
        teaReady = false;
        toastReady = false;
        omletReady = false;
      }
      return result;
    }
  }

  boolean dishReady(Dish dish)
  {
    switch (dish)
    {
      case TEA: return teaReady;
      case OMLET: return omletReady;
      case TOAST: return toastReady;
      default:return false;
    }
  }
}
