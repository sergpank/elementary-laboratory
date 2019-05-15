package homework19;

public class StackOverflow
{
  public static void main(String[] args)
  {

    func(1);

  }

    /*
        10608
        10609
        10610
        10611
        10612
        10613
        Exception in thread "main" java.lang.StackOverflowError
                at java.base/java.io.PrintStream.write(PrintStream.java:559)
                at java.base/sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:233)
                at java.base/sun.nio.cs.StreamEncoder.implFlushBuffer(StreamEncoder.java:312)
                at java.base/sun.nio.cs.StreamEncoder.flushBuffer(StreamEncoder.java:104)
                at java.base/java.io.OutputStreamWriter.flushBuffer(OutputStreamWriter.java:184)
                at java.base/java.io.PrintStream.write(PrintStream.java:606)
                at java.base/java.io.PrintStream.print(PrintStream.java:676)
                at java.base/java.io.PrintStream.println(PrintStream.java:812)
                at Main.func(Main.java:15)
                at Main.func(Main.java:17)
                at Main.func(Main.java:17)
                at Main.func(Main.java:17)
                at Main.func(Main.java:17)
                at Main.func(Main.java:17)

    */

  public static void func(int n)
  {
    System.out.println(n);

    func(n + 1);
  }
} 
