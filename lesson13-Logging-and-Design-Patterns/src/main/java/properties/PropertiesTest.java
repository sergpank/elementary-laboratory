package properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest
{
  public static final Logger log = LogManager.getLogger(PropertiesTest.class);

  public static final String USER_NAME = "user.name";

  public static void main(String[] args) throws IOException
  {
    Properties properties = new Properties();

    String propsFilePath = PropertiesTest.class
      .getClassLoader()
      .getResource("app.properties")
      .getFile();

    log.debug("Properties file path: {}", propsFilePath);

    properties.load(new FileReader(propsFilePath));

    log.debug(properties.keySet());

    log.debug("user name = {}", properties.get(USER_NAME));
  }
}
