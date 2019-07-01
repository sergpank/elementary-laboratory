package shylov.ball;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingBall
{
  public static void main(String[] args)
  {
    System.out.println(Math.pow(-3, 2));
    JFrame frame = new JFrame("Circle");
    int width = 800;
    int height = 900;

    List<Ball> ballList = new ArrayList<>();
    BallPanel ballPanel = new BallPanel(ballList);
    Ball ball = new Ball(0, 0, 30, 1, Direction.EAST, Color.RED);
    Ball ball1 = new Ball(0, 40, 40, 2, Direction.EAST, Color.GREEN);
    Ball ball2 = new Ball(0, 90, 25, 3, Direction.EAST, Color.BLACK);
    Ball ball3 = new Ball(0, 150, 90, 2, Direction.EAST, Color.YELLOW);
    ballList.add(ball);
    ballList.add(ball1);
    ballList.add(ball2);
    ballList.add(ball3);
    Checker checker = new Checker(width, height, ballList);
    new BallThread(ballPanel, checker, ball).start();
    new BallThread(ballPanel, checker, ball1).start();
    new BallThread(ballPanel, checker, ball2).start();
    new BallThread(ballPanel, checker, ball3).start();

    frame.setContentPane(ballPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width + 15, height + 40);
    frame.setVisible(true);

  }

}
