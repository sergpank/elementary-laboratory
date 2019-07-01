package fedorov;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame
{
  public App()
  {
    setTitle("Шарики");
    setSize(600,400);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void paint(Graphics g)
  {
    g.setColor(Color.RED);
    g.fillOval(10,40,100,100);
  }

  public static void main(String[] args)
  {
    App app = new App();
  }
}
