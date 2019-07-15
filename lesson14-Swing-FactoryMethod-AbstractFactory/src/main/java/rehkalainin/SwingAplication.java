package rehkalainin;

import rehkalainin.ui.MainFrame;

import javax.swing.*;

public class SwingAplication
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
