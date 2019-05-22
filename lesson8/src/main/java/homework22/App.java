package homework22;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class App
{
  public static void main(String[] args)
  {

    String pathToFile = "/home/boris/javacore/elementary-laboratory/lesson8/10000 Records.csv";

    Map<String, Integer> map = new HashMap<>();
    List<String[]> list = new ArrayList<>();

    if (readCsvFile(pathToFile, map, list))
    {
      System.out.println("\n\n");
      printYangestAndOldestEmployees(map, list);

      printThreeMostPopularNames(map, list);
    }

  }


  public static boolean readCsvFile(String pathToFile, Map<String, Integer> map, List<String[]> list)
  {
    File csv = new File(pathToFile);
    boolean result = false;

    if (csv.exists() && csv.isFile())
    {
      try (BufferedReader reader = new BufferedReader(new FileReader(csv));)
      {
        String string = reader.readLine();
        String[] strings = string.split(",");

        for (int i = 0; i < strings.length; i++)
        {
          map.put(strings[i], i);
        }

        while ((string = reader.readLine()) != null)
        {
          strings = string.split(",");
          list.add(strings);
        }

        result = true;
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    return result;
  }

  public static void printYangestAndOldestEmployees(Map<String, Integer> map, List<String[]> list)
  {
    list.sort(Comparator.comparing(el -> {
      return LocalDateTime.parse(el[map.get("Date of Birth")] + " " +
          el[map.get("Time of Birth")], DateTimeFormatter.ofPattern("M/d/uuuu h:m:s a"));
    }, (a, b) -> b.compareTo(a)));

    System.out.printf("The yangest employee is %s %s %s. %s. ",
        list.get(0)[map.get("Name Prefix")],
        list.get(0)[map.get("First Name")],
        list.get(0)[map.get("Middle Initial")],
        list.get(0)[map.get("Last Name")]);
    String gender = list.get(0)[map.get("Gender")].equals("F") ? "She" : "He";
    System.out.printf("%s is %d years old.\n\n", gender, calculateAge(list.get(0)[map.get("Date of Birth")]));

    System.out.printf("The oldest employee is %s %s %s. %s. ",
        list.get(list.size() - 1)[map.get("Name Prefix")],
        list.get(list.size() - 1)[map.get("First Name")],
        list.get(list.size() - 1)[map.get("Middle Initial")],
        list.get(list.size() - 1)[map.get("Last Name")]);

    gender = list.get(list.size() - 1)[map.get("Gender")].equals("F") ? "She" : "He";
    System.out.printf("%s is %d years old.\n\n", gender, calculateAge(list.get(list.size() - 1)[map.get("Date of Birth")]));
  }

  public static void printThreeMostPopularNames(Map<String, Integer> map, List<String[]> list)
  {
    Map<String, Integer> counts = new HashMap<>();

    list.forEach(el -> {
      String name = el[map.get("First Name")];
      counts.put(name, counts.getOrDefault(name, 0) + 1);
    });

    List<Map.Entry<String, Integer>> names = new ArrayList<>(counts.entrySet());

    names.sort(Comparator.comparing(el -> el.getValue(), (a, b) -> b.compareTo(a)));

    System.out.printf("The three most popular names: %s (%d), %s (%d), %s (%d).\n\n",
        names.get(0).getKey(), names.get(0).getValue(),
        names.get(1).getKey(), names.get(1).getValue(),
        names.get(2).getKey(), names.get(2).getValue());
  }

  public static int calculateAge(String date)
  {
    LocalDate now = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/uuuu");
    LocalDate birthDate = LocalDate.parse(date, formatter);

    return (now.getMonth().getValue() >= birthDate.getMonth().getValue() &&
        now.getDayOfMonth()>=birthDate.getDayOfMonth()) ? now.getYear() - birthDate.getYear() :
        now.getYear() - birthDate.getYear() - 1;
  }
}
