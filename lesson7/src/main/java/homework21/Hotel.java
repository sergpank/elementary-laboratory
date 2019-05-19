package homework21;

import java.util.*;

public class Hotel
{
  private static int idCounter;

  private int id;
  private String name;
  private ArrayList<String> reviews;

  public Hotel(String name)
  {
    id = ++idCounter;
    this.name = name;
    reviews = new ArrayList<>();
  }

  public void addReview(String review)
  {
    reviews.add(review);
  }

  public Collection<String> getReviews()
  {
    ArrayList<String> result = new ArrayList(reviews);
    return result;
  }

  public int getId()
  {
    return id;
  }

  @Override
  public String toString()
  {
    return String.format("ID: %d, Name: %s; ", id, name);
  }

  @Override
  public boolean equals(Object other)
  {
    boolean result = false;
    if (this == other)
    {
      result = true;
    }
    else if (other != null && getClass() == other.getClass())
    {
      Hotel hotel = (Hotel) other;
      result = Objects.equals(name, hotel.name) && id == hotel.id;
    }

    return result;

  }

  @Override
  public int hashCode()
  {
    return (id + name).hashCode();
  }
}
