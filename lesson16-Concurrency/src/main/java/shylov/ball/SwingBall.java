package shylov.ball;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SwingBall
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Circle");
    int width = 500;
    int height = 600;

    List<Ball> ballList = new ArrayList<>();
    BallPanel ballPanel = new BallPanel(ballList);
    Ball ball = new Ball(0, 0, 30, 1, Direction.EAST);
    ballList.add(ball);
    Checker checker = new Checker(width,height,ballList);
    new BallThread(ballPanel,checker,ball).start();

    frame.setContentPane(ballPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height+30);
    frame.setVisible(true);


  }
}
