import java.util.*;

public class Hotel
{
  private String id;
  private List<String> reviewList;
  private int rel;

  public Hotel(String id)
  {
    this.id = id;
    this.reviewList = new ArrayList<>();
  }

  public boolean addReview(String review)
  {
    return reviewList.add(review);
  }

  public int getRel()
  {
    return rel;
  }

  public int calkRelevance(List<String> keyList)
  {
    rel = 0;

    for (int i = 0; i < keyList.size(); i++)
    {
      int value = 0;
      for (int j = 0; j < reviewList.size(); j++)
      {
        value += calcMatches(keyList.get(i), reviewList.get(j));
      }
      rel += value;

    }
    return rel;
  }

  public String getId()
  {
    return id;
  }

  private int calcMatches(String key, String str)
  {
    str = str.toLowerCase();
    key = key.toLowerCase();

    int n = 0;
    int count = 0;
    while (n != -1)
    {
      n = str.indexOf(key, n);
      if (n != -1)
      {
        count++;
        n++;
      }
    }
    return count;
  }

}
