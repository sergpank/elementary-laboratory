package homework;

public class RunnableImpl implements Runnable
{
  @Override
  public void run()
  {
    System.out.println("Hello Lambda!" + this.getClass());
  }
}
