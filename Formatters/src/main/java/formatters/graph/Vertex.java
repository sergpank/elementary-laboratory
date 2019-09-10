package formatters.graph;

import java.util.Objects;

public class Vertex implements Comparable<Vertex>
{
  private int id;
  private String name;
  private boolean visited;

  public Vertex(int id, String name)
  {
    this.id=id;
    this.name=name;
    this.visited=false;
  }

  public int getId()
  {
    return this.id;
  }

  public void setId(int id)
  {
    this.id=id;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public boolean isVisited()
  {
    return this.visited;
  }

  public void setVisited(boolean val)
  {
    this.visited=val;
  }

  @Override
  public boolean equals(Object other)
  {
    boolean result=false;

    if(other!=null)
    {
      if(this==other)
      {
        result=true;
      }
      else if(this.getClass()==other.getClass())
      {
        Vertex v=(Vertex)other;

        result=(this.id==v.id && Objects.equals(this.name, v.name));
      }
    }

    return result;
  }

  @Override
  public int compareTo(Vertex o)
  {
    int result=0;
    if(this.id>o.id)
    {
      result=1;
    }
    else
    {
      result=-1;
    }
    return 0;
  }
}
