package panko;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class XpathExample
{
  public static void main(String[] args)
  {
    XpathExample sample = new XpathExample();

    Document doc = sample.parseDocument("lesson15-XML/xml/map_hillel.osm");
    NodeList bounds = getNodeList(doc, "/osm/bounds");

    System.out.println(bounds.item(0).getAttributes().item(0).getNodeValue());
  }

  private static XPath xPath = XPathFactory.newInstance().newXPath();

  public static Document parseDocument(String xmlFile)
  {
    Document doc = null;
    try
    {
      doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
    }
    catch (SAXException | IOException | ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    return doc;
  }

  public static NodeList getNodeList(Document doc, String query)
  {
    NodeList nodeList = null;
    try
    {
      nodeList = (NodeList) xPath.compile(query).evaluate(doc, XPathConstants.NODESET);
    }
    catch (XPathExpressionException e)
    {
      e.printStackTrace();
    }
    return nodeList;
  }

  public static NodeList getNodeList(Node node, String query)
  {
    NodeList nodeList = null;
    try
    {
      nodeList = (NodeList) xPath.compile(query).evaluate(node, XPathConstants.NODESET);
    }
    catch (XPathExpressionException e)
    {
      e.printStackTrace();
    }
    return nodeList;
  }
}
