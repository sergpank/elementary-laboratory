package formatters.graph;

import java.util.*;

public class FileGraph
{
  private List<Vertex> vertexList;
  private List<Set<Integer>> adjacencyList;
  private int vertexCount;

  public FileGraph()
  {
    vertexList=new ArrayList<>();
    adjacencyList=new ArrayList<Set<Integer>>();
    vertexCount=0;
  }

  public void addVertex(Vertex v)
  {
    vertexList.add(v);
    vertexCount++;
    adjacencyList.add(new TreeSet<Integer>());
  }

  public Vertex getVertex(int index)
  {
    return vertexList.get(index);
  }

  public Vertex getVertexById(int vertId)
  {
    int k=getVertexIndex(vertId);
    Vertex v=null;
    if(k!=-1)
    {
      v=vertexList.get(k);
    }
    return v;
  }

  public int getVertexCount()
  {
    return vertexCount;
  }

  public void addEdge(Vertex from, Vertex to)
  {
    int indexFrom=getVertexIndex(from);
    int indexTo=getVertexIndex(to);
    adjacencyList.get(indexFrom).add(indexTo);
  }

  public void addEdge(int from, int to)
  {
    adjacencyList.get(from).add(to);
  }

  public int getVertexIndex(Vertex v)
  {
    int index=-1;
    for(int i=0; i<vertexCount; i++)
    {
      if(vertexList.get(i).equals(v))
      {
        index=i;
      }
    }

    return index;
  }

  public int getVertexIndex(int vertexId)
  {
    int index=-1;
    for(int i=0; i<vertexCount; i++)
    {
      if(vertexList.get(i).getId()==vertexId)
      {
        index=i;
      }
    }

    return index;
  }

  public void display()
  {
    for(int i=0; i<vertexCount; i++)
    {
      System.out.print(vertexList.get(i).getName()+":"+vertexList.get(i).getId());
      for(int j : adjacencyList.get(i))
      {
        System.out.print("->"+vertexList.get(j).getName()+":"+vertexList.get(j).getId());
      }
      System.out.println();
    }
  }

  public int getAdjUnvisitedVertex(int v)
  {
    int index=-1;
    Set<Integer> list=adjacencyList.get(v);

    for(Integer i : list)
    {
      Vertex adjVert=vertexList.get(i);
      if(!adjVert.isVisited())
      {
        index = i;
        break;
      }
    }

    return index;
  }



  public Set<Integer> getAdjVertexList(int index)
  {
    return adjacencyList.get(index);
  }

  public Vertex getParentVertex(int currentVertId)
  {
    int k=getVertexIndex(currentVertId);
    Vertex v=null;
    for(int i=0; k!=-1 && i<vertexCount; i++)
    {
      Set<Integer> list=adjacencyList.get(i);
      if(list.contains(k))
      {
        v=vertexList.get(i);
        break;
      }
    }
    return v;
  }
}
