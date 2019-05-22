import java.util.Scanner;

public class Fibonacci_hometask
{
  public static void main(String[] args)
  {
    int n;

    System.out.println("Insert the number :");
    Scanner s = new Scanner(System.in);
    n = s.nextInt() + 2;
    int fib[] = new int[n];

    fib[0] = 0;
    fib[1] = 1;

    for (int i = 1; i < n - 1; i++)
    {
      fib[i + 1] = fib[i] + fib[i - 1];
      System.out.print(fib[i] + " ");
    }
  }
}
