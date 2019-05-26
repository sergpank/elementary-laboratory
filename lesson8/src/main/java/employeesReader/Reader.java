package employeesReader;

import java.io.*;
import java.util.*;


public class Reader
{
    public static void main(String[] args)
    {
      File file = new File("10000 Records.csv");
      Reader newEmployeesReader = new Reader();
      newEmployeesReader.sortByNameCount(newEmployeesReader.readEmployees(file));
      newEmployeesReader.getMaxAndMinAge(newEmployeesReader.readEmployees(file));
    }
    public TreeMap<Integer, Set<String>> sortByNameCount(ArrayList<Employee> employees)
    {
      Map<String, Integer> nameCount = new HashMap<>();
      for(Employee e : employees)
      {
        Integer count = nameCount.get(e.getFirstName());
        if(count == null)
        {
          count = 0;

        }
        count++;
        nameCount.put(e.getFirstName(),count);
      }
      TreeMap <Integer, Set <String>> sortedByNameCount = new TreeMap<>(new Comparator<Integer>()
      {
        @Override
        public int compare(Integer o1, Integer o2)
        {
          return o2-o1;
        }
      });
      for(Map.Entry<String, Integer> entry : nameCount.entrySet())
      {
        String name = entry.getKey();
        Integer countOfNames = entry.getValue();
        Set<String> names = sortedByNameCount.get(countOfNames);
        if (names==null)
        {
          names = new TreeSet<>();
          sortedByNameCount.put(countOfNames,names);
        }
        names.add(name);

      }
      Iterator<Map.Entry<Integer,Set<String>>> iterator = sortedByNameCount.entrySet().iterator();
      while (iterator.hasNext())
      {
        System.out.println(iterator.next());
      }
      return sortedByNameCount;
    }
    public ArrayList<Employee> readEmployees(File file)
    {
      ArrayList<Employee> employees = new ArrayList<>();
      try
      {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        HashMap<String, Integer> headerIndexes = getHeaderIndexes(line);
        while ((line=reader.readLine())!=null)
        {
          String [] data = line.split(",");
          String firstName = data[headerIndexes.get("First Name")];
          String secondName = data[headerIndexes.get("Last Name")];
          Double age = Double.valueOf(data[headerIndexes.get("Age in Yrs.")]);
          employees.add(new Employee(firstName, secondName, age));
        }
      }
      catch (FileNotFoundException e)
      {
        e.printStackTrace();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      return employees;

    }
    public HashMap <String, Integer> getHeaderIndexes(String headLine)
    {
      HashMap<String, Integer> tableHead = new HashMap<>();
      for (int i = 0; i<headLine.split(",").length; i++)
      {
        tableHead.put(headLine.split(",")[i], i);
      }
      return tableHead;
    }
    public void getMaxAndMinAge(ArrayList<Employee> employees)
    {
      Collections.sort(employees, new Comparator<Employee>()
      {
        @Override
        public int compare(Employee o1, Employee o2)
        {
          return Double.compare(o1.getAge(),o2.getAge());
        }
      });
      System.out.println(employees.get(0).getAge());
      System.out.println(employees.get(employees.size()-1).getAge());
    }
  }class Employee
  {
    public String getFirstName()
    {
      return firstName;
    }

    public String getSecondName()
    {
      return secondName;
    }

    public Double getAge()
    {
      return age;
    }

    private String firstName;
    private String secondName;
    private Double age;

    public Employee(String firstName, String secondName, Double age)
    {
      this.firstName = firstName;
      this.secondName = secondName;
      this.age = age;
    }
  }

