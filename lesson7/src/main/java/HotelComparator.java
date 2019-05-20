import java.util.Comparator;

public class HotelComparator implements Comparator<Hotel>
{
  public int compare(Hotel o1, Hotel o2)
  {
    return o2.getRel() - o1.getRel();
  }
}
