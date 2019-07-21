package homework_36.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeReader implements AutoCloseable
{
  private  Stream<Employee> employees=null;

  private String pathToFile;

  public EmployeeReader(String pathToFile)
  {
    this.pathToFile = pathToFile;
  }

  public Stream<Employee> getEmployeesAsStream() throws IOException
  {
    if(employees==null)
    {
      readEmployeeList();
    }

    return employees;
  }

  @Override
  public void close() throws Exception
  {
    if(employees!=null)
    {
      employees.close();
      employees=null;
    }
  }

  private  void readEmployeeList() throws IOException
  {
    String[] headers= getHeaders();
    Map<String,Integer> headerMap=mapHeaderNames(headers);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    Path path= Paths.get(pathToFile);

    Stream<String> lines= Files.lines(path);

    employees = lines.skip(1).map(s->{
      String[] values=s.split(",");
      Employee e=new Employee(
          values[headerMap.get("First Name")],
          values[headerMap.get("Last Name")],
          values[headerMap.get("Name Prefix")],
          values[headerMap.get("Middle Initial")],
          LocalDate.parse(values[headerMap.get("Date of Birth")], formatter),
          values[headerMap.get("Gender")],
          Double.parseDouble(values[headerMap.get("Salary")])
      );
      return e;
    });

  }

  private String[] getHeaders() throws IOException
  {
    Path path= Paths.get(pathToFile);
    Stream<String> lines= Files.lines(path).map(s->s.trim());

    return lines.findFirst().get().split(",");
  }
  private  Map<String,Integer> mapHeaderNames(String[] headers)
  {
    Map<String,Integer> map=new HashMap<>();
    for(int i=0;i<headers.length; i++)
    {
      map.putIfAbsent(headers[i],i);
    }
    return map;
  }
}
