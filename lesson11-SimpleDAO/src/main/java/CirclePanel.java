import javax.swing.*;
import java.awt.*;

/**
 * Created by sergpank on 08.02.2015.
 */
public class CirclePanel
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Circle");

    frame.add(new Panel());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 600);
    frame.setVisible(true);
  }

  private static class Panel extends JPanel
  {
    int radius = 100;

    @Override
    protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);

      for (int x = -100; x <= 100; x = x + 10)
      {
        int y = (int) Math.sqrt((radius * radius) - (x * x));
        drawPoint(g, x, y, 150);
        drawPoint(g, x, -y, 150);
      }

      for (int i = 0; i < 360; i = i + 6)
      {
        double sin = Math.sin(Math.toRadians(i));
        double cos = Math.cos(Math.toRadians(i));
        int x = (int) (radius * cos);
        int y = (int) (radius * sin);
        drawPoint(g, x, y, 300);
      }
    }

    private void drawPoint(Graphics g, int x, int y, int shift)
    {
      int diameter = 7;
      int x1 = x + shift - diameter / 2;
      int y1 = y + shift - diameter / 2;
      g.fillOval(x1, y1, diameter, diameter);
    }
  }
}
