import java.util.*;

public class HomeTask
{
  public static void main(String[] args)
  {
    List<String> keyList = new ArrayList<>();
    keyList.add("breakfast");
    keyList.add("beach");
    keyList.add("citycenter");
    keyList.add("location");
    keyList.add("metro");
    keyList.add("view");
    keyList.add("staff");
    keyList.add("price");

    List<String> hotel1List = new ArrayList<>();
    hotel1List.add("This hotel has a nice view of the citycenter. The location is perfect.");
    hotel1List.add("Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
    hotel1List.add("They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");

    List<String> hotel2List = new ArrayList<>();
    hotel2List.add("The breakfast is ok. Regaring location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    hotel2List.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

    Map<Integer, List<String>> hotelMap = new HashMap<>();

    hotelMap.put(1, hotel1List);
    hotelMap.put(2, hotel2List);

    Map<Integer, List<Integer>> hotelRank = new HashMap<>();

    for (Map.Entry<Integer, List<String>> entry : hotelMap.entrySet())
    {
      Integer id = entry.getKey();
      for (String review : entry.getValue())
      {
        int counter = 0;
        String[] words = review.toLowerCase().split(" ");
        for (String word : words)
        {
          for (String key : keyList)
          {
            if (word.contains(key))
            {
              counter++;
            }
          }
        }
        hotelRank.computeIfAbsent(id, rank -> new ArrayList<>()).add(counter);
      }
    }
    System.out.println(hotelRank);

    Map <Integer, Integer> sortedHotel = new TreeMap<>(new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o2.compareTo(o1);
      }
    });

    for (Map.Entry<Integer, List<Integer>> entry : hotelRank.entrySet())
    {
      Integer id = entry.getKey();
      Integer sum = 0;
      for (Integer rank : entry.getValue())
      {
        sum = sum + rank;
      }
      sortedHotel.put(sum, id);
    }
    System.out.println(sortedHotel);
  }
}