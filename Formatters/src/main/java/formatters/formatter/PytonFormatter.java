package formatters.formatter;

import formatters.graph.FileGraph;
import formatters.graph.Vertex;

import java.util.Scanner;
import java.util.Stack;

public class PytonFormatter implements IFormatter
{
  public FileGraph parse(Scanner sc)
  {
    String nCount=sc.nextLine();
    int vertexCount=Integer.parseInt(nCount);
    FileGraph g=new FileGraph();
    Stack<Vertex> st=new Stack<>();


    for(int i=0; i<vertexCount; i++)
    {
      String line=sc.nextLine();
      int lastSpace=line.lastIndexOf(" ");
      String idStr=line.substring(lastSpace+1);
      int vertexId=Integer.parseInt(idStr);
      line = line.substring(0, lastSpace);

      if(vertexId==0)
      {
        Vertex root=new Vertex(0, line);
        g.addVertex(root);
        st.push(root);
      }
      else
      {
        lastSpace=line.lastIndexOf(" ");
        String spaces=line.substring(0, lastSpace+1);
        int k=spaces.length()/4;
        String fName=line.substring(lastSpace+1);
        while(true)
        {
          if(k==st.size())
          {
            Vertex parent=st.peek();
            Vertex v=new Vertex(vertexId, fName);
            g.addVertex(v);
            g.addEdge(parent, v);
            st.push(v);
            break;
          }
          else
          {
            st.pop();
          }
        }
      }
    }

    return g;
  }

  @Override
  public String format(FileGraph g)
  {
    Stack<Integer> st=new Stack<>();
    st.push(0);
    g.getVertex(0).setVisited(true);
    StringBuilder sb=new StringBuilder();

    sb.append(g.getVertexCount());
    sb.append("\n");

    sb.append(g.getVertex(0).getName());
    sb.append(" ");
    sb.append(g.getVertex(0).getId());
    sb.append("\n");

    while(!st.isEmpty())
    {
      int v=g.getAdjUnvisitedVertex(st.peek());
      if(v!=-1)
      {
        g.getVertex(v).setVisited(true);

        for(int i=0; i<st.size(); i++)
        {
          sb.append("    ");
        }
        sb.append(g.getVertex(v).getName());
        sb.append(" ");
        sb.append(g.getVertex(v).getId());
        st.push(v);
        sb.append("\n");
      }
      else
      {
        st.pop();
      }
    }

    for(int i=0; i<g.getVertexCount(); i++)
    {
      g.getVertex(i).setVisited(false);
    }

    return new String(sb);
  }
}
