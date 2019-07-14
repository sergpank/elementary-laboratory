package panko.ball;

import javax.swing.*;

public class SwingBall
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Circle");

    BallPanel ballPanel = new BallPanel();
    new BallThread(ballPanel).start();

    frame.setContentPane(ballPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 600);
    frame.setVisible(true);
  }
}
