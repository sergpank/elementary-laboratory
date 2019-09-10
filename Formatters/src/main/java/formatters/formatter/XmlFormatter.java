package formatters.formatter;

import formatters.graph.FileGraph;
import formatters.graph.Vertex;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

public class XmlFormatter implements IFormatter
{
  public FileGraph parse(Scanner sc)
  {
    FileGraph graph=new FileGraph();
    StringBuilder sb=new StringBuilder();

    String line=null;
    while(!(line=sc.nextLine()).isEmpty())
    {
      sb.append(line);
    }

    String xml=new String(sb);
    byte[] buffer=xml.getBytes();
    try
    {
      InputStream in=new ByteArrayInputStream(buffer);
      DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
      DocumentBuilder builder=factory.newDocumentBuilder();
      Document doc=builder.parse(in);
      Element root=doc.getDocumentElement();
      addElementToGraph(root, graph, null);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    return graph;
  }

  private static void addElementToGraph(Element el, FileGraph graph, Vertex parentVert)
  {
    String fName=el.getAttribute("name");
    String fId=el.getAttribute("id");
    String tName=el.getTagName();

    Vertex v=new Vertex(Integer.parseInt(fId), fName);
    graph.addVertex(v);
    if(parentVert!=null)
    {
      graph.addEdge(parentVert, v);
    }

    if(tName.equals("dir"))
    {
      NodeList children=el.getChildNodes();
      for(int i=0; i<children.getLength(); i++)
      {
        Node child=children.item(i);
        if(child instanceof Element)
        {
          Element childElem=(Element)child;
          addElementToGraph(childElem, graph, v);
        }
      }
    }
  }

  @Override
  public String format(FileGraph g)
  {
    StringBuilder sb=new StringBuilder();
    printTag(0, g, sb, 0);
    return new String(sb);
  }

  public static void printTag(int vertexIndex, FileGraph graph, StringBuilder sb, int indent)
  {
    Vertex v=graph.getVertex(vertexIndex);
    String spaces=convertIndent(indent);
    String tag="";
    Set<Integer> children=graph.getAdjVertexList(vertexIndex);
    if(children.size()==0)
    {
      tag=String.format("%s<file name='%s' id='%d'/>\n", spaces, v.getName(), v.getId());
      sb.append(tag);
    }
    else
    {
      tag=String.format("%s<dir name='%s' id='%d'>\n", spaces, v.getName(), v.getId());
      sb.append(tag);

      for(Integer i : children)
      {
        printTag(i, graph, sb, indent+2);
      }

      tag=String.format("%s</dir>\n", spaces);
      sb.append(tag);
    }
  }

  public static String convertIndent(int indent)
  {
    StringBuilder sb=new StringBuilder();
    for(int i=0; i<indent; i++)
    {
      sb.append(" ");
    }

    return new String(sb);
  }
}
