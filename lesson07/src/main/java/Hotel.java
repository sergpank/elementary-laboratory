public class Hotel implements Comparable<Hotel>
{
  private final int ID;
  private int relevantValue;

  public Hotel(int ID)
  {
    this.ID = ID;

  }

  public int getID()
  {
    return ID;
  }

  public int getRelevantValue()
  {
    return relevantValue;
  }

  public void increaseRelevantValue()
  {
    this.relevantValue++;
  }

  public boolean isMyID(String [] in)
  {

    for (String s : in)
    {

      String id=""+this.ID;

        if (id.equals(s))
        {
          return true;
        }
      }
    return false;
  }

  public int compareTo(Hotel another)
  {
    if (this.relevantValue == another.getRelevantValue())
    {

      return compareID(another);

    }
    else if (this.relevantValue > another.getRelevantValue())
    {
      return -1;
    }
    else
    {
      return 1;
    }
  }

  private int compareID(Hotel another)
  {
    if (this.ID == another.getID())
    {
      return 0;
    }
    else if (this.ID <another.getID())
    {
      return -1;
    }
    else
    {
      return 1;
    }
  }

  @Override
  public String toString()
  {
    return  "ID :" + ID;
  }
}
