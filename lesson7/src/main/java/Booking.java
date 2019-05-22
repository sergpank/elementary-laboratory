import java.util.*;

public class Booking
{
  public static void main(String[] args)
  {
    Set<String> SearchKeys = new HashSet<>();
    SearchKeys.add("breakfast");
    SearchKeys.add("beach");
    SearchKeys.add("citycenter");
    SearchKeys.add("location");
    SearchKeys.add("metro");
    SearchKeys.add("view");
    SearchKeys.add("staff");
    SearchKeys.add("price");

    Map<Integer, List<String>> ReviewsMap = BookingData();
    Rank RankCalculator = new Rank ();

    Map<Integer, Integer>  HotelsRank = RankCalculator.RankCalculate ( ReviewsMap, SearchKeys );
    Map<Integer, Integer> SortedRanks = RankCalculator.SortbyRank ( HotelsRank );

    System.out.println (SortedRanks );


    for(Map.Entry<Integer, Integer> e : SortedRanks.entrySet())
    {
      System.out.printf("Rank %d : Hotel id %s\n", e.getKey(), e.getValue());
    }


  }

  private static Map<Integer, List<String>> BookingData()
  {
    Map<Integer, List<String>> ReviewsMap = new HashMap<>();

    List<String> hotel1Reviews = new ArrayList<>();
    hotel1Reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
    hotel1Reviews.add("Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.");
    hotel1Reviews.add("They said I couldn't take my dog. But there were other guests with dogs! That is not fair.");

    List<String> hotel2Reviews = new ArrayList<>();
    hotel2Reviews.add("The breakfast is ok. Regarding location, it is quite fat from the citycenter. But price is cheap, so it is ok.");
    hotel2Reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter");


    ReviewsMap.put(1, hotel1Reviews);
    ReviewsMap.put(2, hotel2Reviews);
    return ReviewsMap;
  }
}
