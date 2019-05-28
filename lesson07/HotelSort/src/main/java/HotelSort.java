import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;


public class HotelSort
{
  Map<String, List<Integer>> hotelReviewRankMap = new HashMap<>();
  List<String> keyWordsList = new ArrayList<>(
      Arrays.asList("breakfast",
          "beach",
          "citycenter",
          "metro",
          "location",
          "view",
          "price",
          "staff"));

  public static void main(String[] args)
  {
    HotelSort hotelSort = new HotelSort();
    hotelSort.go();
  }

  private void go()
  {
    getHotelReviews();
    System.out.println(hotelReviewRankMap);
    sortHotels();

  }

  private void getHotelReviews()
  {
    File file = new File("ListReveiws");
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      while ((line = reader.readLine()) != null)
      {
        addHotelReviewRankMap(line);
      }
    }
    catch (java.io.IOException e)
    {
      e.printStackTrace();
    }
  }

  private void addHotelReviewRankMap(String review)
  {
    String[] words = review.toLowerCase().split(" ");
    String id = "Hotel "+ words[0];

    Integer counter = 0;
    for (String word : words)
    {
      for (String key : keyWordsList)
      {
        if (word.contains(key))
        {
          counter++;
        }
      }
    }
    hotelReviewRankMap.computeIfAbsent(id, r -> new ArrayList<>()).add(counter);
  }

  private void sortHotels()
  {
    Map<Integer, String> rankHotelMap = new TreeMap<>(new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o2.compareTo(o1);
      }
    });

    for (Map.Entry entry : hotelReviewRankMap.entrySet())
    {
      List<Integer> rankList = (List<Integer>) entry.getValue();
      Integer sumRank = 0;
      for (Integer rank : rankList)
      {
        sumRank = sumRank + rank;
      }
      rankHotelMap.put(sumRank, (String) entry.getKey());
    }
    System.out.println(rankHotelMap);
  }

}


