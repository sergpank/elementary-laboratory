package homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda
{
  private String field = "Lambda";

  public static void main(String[] args)
  {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("ZZZ", "AAA", 100, "M"));
    employees.add(new Employee("YYY", "BBB", 99, "F"));
    employees.add(new Employee("XXX", "CCC", 101, "M"));
    employees.add(new Employee("WWW", "DDD", 98, "F"));

    List<String> upperNames = new ArrayList<>();

    System.out.println("Old school : ");
    for (Employee e : employees)
    {
      if(e.getAge() < 100)
      {
        upperNames.add(e.getFirstName().toUpperCase());
      }
    }
    for (String un : upperNames)
    {
      System.out.println(un);
    }

    System.out.println("Lambda : ");
    employees.stream()
        .filter((e) -> e.getAge() < 100)
        .map((e) -> e.getFirstName().toUpperCase())
        .forEach(System.out::println);


//    Function<Double> sum = (a, b) -> a + b;
//    Function<Double> sub = (a, b) -> a - b;
//    Function<Double> mul = (a, b) -> a * b;
//    Function<Double> div = (a, b) -> a / b;
//
//    execute(10.0, 5.0, sum);
//    execute(10.0, 5.0, sub);
//    execute(10.0, 5.0, mul);
//    execute(10.0, 5.0, div);
  }

  public static Double execute(Double a, Double b, Function<Double> f)
  {
    Double result = f.doStmt(a, b);
    System.out.println(result);
    return result;
  }

}
