package fedorov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeReader
{
  public static List<Employee> readEmployee()
  {
    List<Employee> employees = new ArrayList<>();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("csv/10000 Records.csv")))
    {
      String line;
      line = bufferedReader.readLine();
      Map<String, Integer> indexes = getIndexes(line);
      while((line = bufferedReader.readLine()) != null)
      {
        String[] split = line.split(",");
        String firstName = split[indexes.get("First Name")];
        String lastName = split[indexes.get("Last Name")];
        double age = Double.valueOf(split[indexes.get("Age in Yrs.")]);
        String gender = split[indexes.get("Gender")];
        int salary = Integer.valueOf(split[indexes.get("Salary")]);

        employees.add(new Employee(firstName, lastName, age, gender, salary));
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return employees;
  }

  public static Map<String, Integer> getIndexes(String line)
  {
    Map<String, Integer> indexes = new HashMap<>();
    String[] split = line.split(",");
    for(int i=0; i<split.length; i++)
    {
      indexes.put(split[i],i);
    }
    return indexes;
  }
}
