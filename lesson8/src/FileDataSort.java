import java.io.*;
import java.util.*;

public class FileDataSort
{
  public static void main(String[] args)
  {
    FileDataSort fileDataSort = new FileDataSort();
    fileDataSort.getPopularNames();
    fileDataSort.getOlderAndYounger();
  }
  public int findColumn(String line, String columnName)  // метод считает номер нужного нам столбца в массиве
  {
    int temp = 0;
    int columnCounter = 1;
    while((line.indexOf(",",temp) + 1) != line.indexOf(columnName))
    {
      temp = line.indexOf(",", temp) + 1;
      columnCounter++;
      if(columnCounter >= line.length())
      {
        return -1;
      }
    }
    return columnCounter;

  }
  public void getPopularNames()
  {
    Map<String, Integer> nameRatingCount = new HashMap<>();
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Дмитрий\\IdeaProjects\\elementary-laboratory" +
        "\\lesson8\\data\\10000 Records.csv")))
    {
      String line;
      int columnCounter = -1;
      line = bufferedReader.readLine(); // по первой строке смотрим где находится нужны столбец
      columnCounter = this.findColumn(line, "First Name");
      if (columnCounter >= 0) // проверка на то что искомый столбец существует
      {
        while ((line = bufferedReader.readLine()) != null)  // заполняем карту
        {
          String[] arr = line.split(",");
          if (nameRatingCount.containsKey(arr[columnCounter]))
          {
            nameRatingCount.put(arr[columnCounter], nameRatingCount.get(arr[columnCounter]) + 1);
          }
          else
          {
            nameRatingCount.put(arr[columnCounter], 1);
          }
        }
      }

      ArrayList<Integer> arrayList = new ArrayList<>();
      for(Map.Entry<String, Integer> entry : nameRatingCount.entrySet())
      {
        arrayList.add(entry.getValue());  // поместили количество повторений каждого имени в массив
      }

      Collections.sort(arrayList);
      Collections.reverse(arrayList); // отсортировали его
      for(int i = 1; i < arrayList.size(); i++) // убираем повторения
      {
        if(arrayList.get(i) == arrayList.get(i-1))
        {
          arrayList.remove(i);
          i--;
        }
      }

      for(int i = 0; i < arrayList.size(); i++)
      {
        System.out.print("Имена, повторяющиеся " + arrayList.get(i) + " раз: ");
        for (Map.Entry<String, Integer> entry : nameRatingCount.entrySet())  // через цикл будем выводить рейтинг
        {
          if (entry.getValue() == arrayList.get(i))
          {
            System.out.print(entry.getKey() + " ");
          }
        }
        System.out.println();
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

  }
  public void getOlderAndYounger()
  {
    Map<Double, ArrayList<String>> ageCount = new TreeMap<>();
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Дмитрий\\IdeaProjects\\elementary-laboratory" +
        "\\lesson8\\data\\10000 Records.csv")))
    {
      String line;
      int NamePrefixColumnNumber = -1;
      int FirstNameColumnNumber = -1;
      int LastNameColumbNumber = -1;
      int AgeColumnNumber = -1;
      line = bufferedReader.readLine();
      NamePrefixColumnNumber = this.findColumn(line, "Name Prefix");
      FirstNameColumnNumber = this.findColumn(line, "First Name");
      LastNameColumbNumber = this.findColumn(line, "Last Name");
      AgeColumnNumber = this.findColumn(line, "Age in Yrs.");
      if (NamePrefixColumnNumber >= 0 && FirstNameColumnNumber >= 0 && LastNameColumbNumber >= 0 && AgeColumnNumber >= 0) // проверка на то что искомые столбцы существуют
      {
        while ((line = bufferedReader.readLine()) != null)  // заполгняем карту
        {
          String[] arr = line.split(",");
          ArrayList<String> arrayList = new ArrayList<>();
          arrayList.add(arr[NamePrefixColumnNumber]);
          arrayList.add(arr[FirstNameColumnNumber]);
          arrayList.add(arr[LastNameColumbNumber]);
          ageCount.put(Double.parseDouble(arr[AgeColumnNumber]), arrayList);
        }
        ArrayList<Double> arrayListTemp = new ArrayList<>();
        for(Map.Entry<Double, ArrayList<String>> entry : ageCount.entrySet())
        {
          arrayListTemp.add(entry.getKey());  // помещаем в массив ключи (возраст)
        }
        for(Map.Entry<Double, ArrayList<String>> entry : ageCount.entrySet()) // выводим самого старого и молодого по возрасту(ключу)
        {
          if(entry.getKey()==arrayListTemp.get(0))
          {
            StringBuilder sb = new StringBuilder("Самому младшему сотрулнику " + entry.getKey() +  " лет. Имя - ");
            sb.append(entry.getValue().get(0) + " ");
            sb.append(entry.getValue().get(1) + " ");
            sb.append(entry.getValue().get(2) + " ");
            String temp = sb.toString();
            System.out.println(temp);
          }
          if(entry.getKey()==arrayListTemp.get(arrayListTemp.size()-1))
          {
            StringBuilder sb = new StringBuilder("Самому старшему сотрулнику " + entry.getKey() +  " лет. Имя - ");
            sb.append(entry.getValue().get(0) + " ");
            sb.append(entry.getValue().get(1) + " ");
            sb.append(entry.getValue().get(2) + " ");
            String temp = sb.toString();
            System.out.println(temp);
          }
        }




      }
    }


















      /*
      String line;
      int columnCounter = -1;
      line = bufferedReader.readLine(); // по первой строке смотрим где находится нужны столбец
      columnCounter = this.findColumn(line, "Age in Yrs.");
      if (columnCounter >= 0) // проверка на то что искомый столбец существует
      {
        ArrayList<Double> arrayList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null)
        {
          String[] arr = line.split(",");
          arrayList.add(Double.parseDouble(arr[columnCounter]));
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        System.out.println("Самому старому человеку из списка " + arrayList.get(0) + " лет. Его зовут ");
      }
      */
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
