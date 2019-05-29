package exercise25;
import java.util.*;

public class TEST
{
  public static void main(String[] args)
  {
    Set<String> keys = new HashSet<>();
    keys.add("breakfast");
    keys.add("beach");
    keys.add("citycenter");
    keys.add("location");
    keys.add("metro");
    keys.add("view");
    keys.add("staff");
    keys.add("price");

    Map<Integer, List<String>> reviewMap = createData();

    RankCalculator rankCalculator = new RankCalculator();

    Map<Integer, Set<Integer>> rankMap = rankCalculator.calculateRank(keys, reviewMap);

    for(Map.Entry<Integer, Set<Integer>> e : rankMap.entrySet())
    {
      System.out.printf("Hotels with rank %d : %s\n", e.getKey(), e.getValue());
    }

  }

  private static Map<Integer, List<String>> createData()
  {
    Map<Integer, List<String>> reviewMap = new HashMap<>();

    List<String> hotel1Reviews = new ArrayList<>();
    hotel1Reviews.add("The breakfast is ok. Regarding location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    hotel1Reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter");

    List<String> hotel2Reviews = new ArrayList<>();
    hotel2Reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
    hotel2Reviews.add("Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
    hotel2Reviews.add("They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");


    reviewMap.put(1, hotel1Reviews);
    reviewMap.put(2, hotel2Reviews);
    return reviewMap;
  }
}