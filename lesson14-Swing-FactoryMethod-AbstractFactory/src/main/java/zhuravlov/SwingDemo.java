package zhuravlov;


import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SwingDemo
{
  private static final Logger log = LogManager.getLogger(SwingDemo.class);

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
