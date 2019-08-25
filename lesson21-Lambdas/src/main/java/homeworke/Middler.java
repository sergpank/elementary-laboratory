package homeworke;

import java.util.List;
import java.util.stream.Collectors;

public class Middler
{
  public int getmiddle(List<Employee> employees)
  {
    int size = employees.size();
    List<Employee> list = employees.stream()
        .sorted().collect(Collectors.toList());
    if (size%2 != 0){
    return  (list.stream()
        .skip(size/2)
        .findFirst().get().getSalary());
    }else {
      return list.stream()
          .skip((size/2)-1)
          .limit(2)
          .mapToInt(value -> value.getSalary())
          .sum()/2;
    }


  }

  public int getmiddle(List<Employee> employees, String gender)
  {
    List<Employee> list =employees.stream()
        .filter(employee -> employee.getGender().equals(gender))
        .collect(Collectors.toList());
    return getmiddle(list);

  }

  public int getmiddle(List<Employee> employees, int cutP)
  {
    int cut = employees.size()*cutP/100;
    List<Employee> list = (employees.stream()
        .sorted(new ComporatorAge())
        .skip(cut)
        .limit(employees.size() - cut)
        .collect(Collectors.toList()));
    return getmiddle(list);

  }

  public int getmiddle(List<Employee> employees, int min, int max)
  {
    List<Employee> employeesFilter = employees.stream()
        .filter(employee -> employee.getAge() > min && employee.getAge() <= max)
        .collect(Collectors.toList());

       return getmiddle(employeesFilter);

  }
}
