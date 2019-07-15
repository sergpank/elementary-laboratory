package shylov;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shylov.ui.MainFrame;

import javax.swing.*;

public class ElementaryDbClient
{
  private static final Logger log = LogManager.getLogger(ElementaryDbClient.class);

  public static void main(String[] args)
  {
    log.debug("Starting application ...");
    MainFrame mainFrame = new MainFrame();

    SwingUtilities.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
        mainFrame.initUI();
      }
    });
  }
}
