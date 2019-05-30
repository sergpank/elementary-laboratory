package homework25;

import java.util.*;

public class RankCalculator
{

  private Map<Integer, List<String>> reviewMap;

  private Set<String> keys;


  public RankCalculator(Set<String> keys, Map<Integer, List<String>> reviewMap)
  {
    this.keys = keys;
    this.reviewMap = reviewMap;
  }


  /**
   * Метод создает отображение id отелей на их рейтинги
   */
  private Map<Integer, Integer> buildHotelToRankMap()
  {
    Map<Integer, Integer> idToRankMap = new HashMap<>();

    for (Map.Entry<Integer, List<String>> entry : reviewMap.entrySet())
    {
      Integer hotelId = entry.getKey();

      Integer hotelRank = calculateRank(entry.getValue());

      idToRankMap.putIfAbsent(hotelId, hotelRank);

    }

    return idToRankMap;
  }

  /**
   * Метод создает отображение рейтингов на списки соответствующих им отелей
   * из отображения id отелей на их рейтинги
   *
   * @return отсортированное по убыванию рейтинга отображение последних на списки соответствующих им отелей
   */
  public Map<Integer, Set<Integer>> calculate()
  {
    Map<Integer, Set<Integer>> rankToHotelsTree = new TreeMap<>((a, b) -> b.compareTo(a));

    Map<Integer, Integer> hotelToRankMap = buildHotelToRankMap();

    for (Integer id : hotelToRankMap.keySet())
    {
      Integer rank = hotelToRankMap.get(id);

      Set<Integer> ids = rankToHotelsTree.computeIfAbsent(rank, k -> new TreeSet<>());
      ids.add(id);
    }

    return rankToHotelsTree;
  }

  /**
   * Метод рассчитывает рейтинг отеля исходя из отзывов
   *
   * @param reviews список отзывов на отель
   * @return рейтинг отеля
   */
  private int calculateRank(List<String> reviews)
  {
    int rank = 0;

    for (String review : reviews)
    {
      String[] tokens = review.toLowerCase().split("[^a-zа-яё]");

      for (String token : tokens)
      {
        if (keys.contains(token))
        {
          rank++;
        }
      }
    }

    return rank;
  }
}
