package rehkalainin;

import javax.swing.*;

public class SwingDemo
{
  public static void main(String[] args)
  {
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
