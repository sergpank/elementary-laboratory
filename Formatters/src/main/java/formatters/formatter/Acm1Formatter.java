package formatters.formatter;

import formatters.graph.FileGraph;
import formatters.graph.Vertex;

import java.util.Scanner;
import java.util.Set;

public class Acm1Formatter implements IFormatter
{
  @Override
  public FileGraph parse(Scanner sc)
  {
    String nCount=sc.nextLine();
    int vertexCount=Integer.parseInt(nCount);
    FileGraph g=new FileGraph();

    for(int i=0; i<vertexCount; i++)
    {
      String line=sc.nextLine();
      line=line.trim();
      int lastSpace=line.lastIndexOf(" ");
      String idStr=line.substring(lastSpace+1);
      int vertexId=Integer.parseInt(idStr);
      String fName = line.substring(0, lastSpace);
      Vertex v=new Vertex(vertexId, fName);
      g.addVertex(v);
    }

    for(int i=0; i<vertexCount; i++)
    {
      String line=sc.nextLine();
      line=line.trim();
      String[] arr=line.split(" ");
      for(int j=1; j<=Integer.parseInt(arr[0]); j++)
      {
        Vertex parent=g.getVertex(i);
        Vertex current=g.getVertexById(Integer.parseInt(arr[j]));
        g.addEdge(parent, current);
      }
    }

    return g;
  }

  @Override
  public String format(FileGraph g)
  {
    int vCount=g.getVertexCount();
    StringBuilder sb=new StringBuilder();
    sb.append(vCount);
    sb.append("\n");

    for(int i=0; i<vCount; i++)
    {
      sb.append(g.getVertex(i).getName());
      sb.append(" ");
      sb.append(g.getVertex(i).getId());
      sb.append("\n");
    }

    for(int i=0; i<vCount; i++)
    {
      Set<Integer> list=g.getAdjVertexList(i);
      sb.append(list.size());
      for(Integer j:list)
      {
        sb.append(" ");
        sb.append(g.getVertex(j).getId());
      }
      sb.append("\n");
    }

    return new String(sb);
  }
}
