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

  public void getPopularNames()
  {
    Map<String, Integer> nameRatingCount = new HashMap<>();
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Дмитрий\\IdeaProjects\\elementary-laboratory" +
        "\\lesson8\\data\\10000 Records.csv")))
    {
      String line;
      line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null)  // заполняем карту
        {
          String[] arr = line.split(",");
          if (nameRatingCount.containsKey(arr[2]))
          {
            nameRatingCount.put(arr[2], nameRatingCount.get(arr[2]) + 1);
          }
          else
          {
            nameRatingCount.put(arr[2], 1);
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
    Map<Double, ArrayList<ArrayList<String>>> ageCount = new TreeMap<>();
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Дмитрий\\IdeaProjects\\elementary-laboratory" +
        "\\lesson8\\data\\10000 Records.csv")))
    {
      String line;
      line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null)  // заполняем карту
        {
          String[] arr = line.split(",");
          ArrayList<ArrayList<String>> mainArrayList = new ArrayList<>();
          ArrayList<String> arrayList = new ArrayList<>();
          arrayList.add(arr[1]);
          arrayList.add(arr[2]);
          arrayList.add(arr[4]);
          if(ageCount.containsKey(Double.parseDouble(arr[12])))
          {
            ageCount.get(Double.parseDouble(arr[12])).add(arrayList);
          }
          else
          {
            mainArrayList.add(arrayList);
            ageCount.put(Double.parseDouble(arr[12]), mainArrayList);
          }
        }
        ArrayList<Double> arrayListTemp = new ArrayList<>();
        for(Map.Entry<Double, ArrayList<ArrayList<String>>> entry : ageCount.entrySet())
        {
          arrayListTemp.add(entry.getKey());  // помещаем в массив ключи (возраст)
        }
      for(Map.Entry<Double, ArrayList<ArrayList<String>>> entry : ageCount.entrySet()) // выводим самого старого и молодого по возрасту(ключу)
        {
          if(entry.getKey()==arrayListTemp.get(0))
          {
            for(int i = 0; i < entry.getValue().size(); i++)
            {
              StringBuilder sb = new StringBuilder("Самому младшему сотруднику " + entry.getKey() + " лет. Имя - ");
              sb.append(entry.getValue().get(i).get(0) + " ").append(entry.getValue().get(i).get(1) + " ")
                  .append(entry.getValue().get(i).get(2) + " ");
              System.out.println(sb.toString());
            }
          }
          if(entry.getKey()==arrayListTemp.get(arrayListTemp.size()-1))
          {
            for(int i = 0; i < entry.getValue().size(); i++)
            {
              StringBuilder sb = new StringBuilder("Самому старшему сотруднику " + entry.getKey() + " лет. Имя - ");
              sb.append(entry.getValue().get(i).get(0) + " ").append(entry.getValue().get(i).get(1) + " ")
                  .append(entry.getValue().get(i).get(2) + " ");
              System.out.println(sb.toString());
            }
          }
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
}
