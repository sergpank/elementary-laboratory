import java.util.TreeSet;

public class RelevanceChecker
{
  enum Keys
  {
    location, citycenter, beach, breakfast, metro, view, price, staff
  }



  private static String[] commentsDataBase(){
    String[] comments = {"1 This hotel has a nice view of the citycenter. The location is perfect.",
        "2 The breakfast is ok. Regarding location, it is quite far from the citycenter. But price is cheap, so it is ok.",
        "1 Location is excellent, 5 min from citycenter. There is also a metro station pretty close to the hotel.",
        "1 They said I couldn't take my dog. But there were other guests with dogs! That is not fair.",
        "2 Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."};

    return comments;
  }


  public static void main(String[] args)
  {
    Hotel a = new Hotel(1);
    Hotel b = new Hotel(2);


    printMostRelevantID(a,b);


  }

private static void printMostRelevantID(Hotel...e){
  TreeSet <Hotel> t = new TreeSet<>();


  for (Hotel hotel : e)
  {
    valueSort(hotel, commentsDataBase());
    t.add(hotel);
  }
  System.out.println(t);
}
  private static void valueSort(Hotel h, String[] comment)
  {

    for (String str : comment)
    {


      String[] tmp = str.split("[\\s\\W]");

      if (h.isMyID(tmp))
      {
        for (Keys k : Keys.values())
        {
          String a = ""+k;
          for (String s : tmp)
          {
            if (a.equalsIgnoreCase(s))
            {

              h.increaseRelevantValue();

            }
          }

        }

      }

    }

  }


}
