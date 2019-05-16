public class StackOverflow
{
  public static void main(String[] args)
  {
    StackOverflow stackOverflow = new StackOverflow();
    stackOverflow.call(0);
  }
  public void call(int i)
  {
    System.out.println(i);
    i++;
    call(i);
  }
}

// 10341, 12, i7-8550U
