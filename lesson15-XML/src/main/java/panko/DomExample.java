package panko;

import panko.generated.Osm;
import panko.generated.WayType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class DomExample
{
  public static void main(String[] args)
  {
    File xmlFile = new File("lesson15-XML/xml/map_hillel.osm");

    JAXBContext jaxbContext;
    try
    {
      jaxbContext = JAXBContext.newInstance(Osm.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Osm osm = (Osm) jaxbUnmarshaller.unmarshal(xmlFile);
      List<WayType> ways = osm.getWay();

      for (WayType way : ways)
      {
        System.out.println(way.getId());
      }
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
  }
}
