public class Fibonacci
{
  public static void main(String[] args)
  {
    Fibonacci fibonacci = new Fibonacci();
    long start = System.currentTimeMillis();
    System.out.println(fibonacci.fibonacciCount(47));
    long finish = System.currentTimeMillis();
    long time = finish - start;
    System.out.println("Время выполнения программы - " + time + " миллисекунд");
  }
  public int fibonacciCount(int number)
  {
    if(number == 0 || number == 1)
    {
      return number;
    }
    else
    {
      return ((fibonacciCount(number-1))+(fibonacciCount(number-2)));
    }
  }
}
// 45 номер - 4176 миллисекунды
// 46 номер - 6760 миллисекунды
// 47 номер - 10793 миллисекунды

