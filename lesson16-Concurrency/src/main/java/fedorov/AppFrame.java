package fedorov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AppFrame extends JFrame
{
  private List<Ball> balls;
  private List<Ball> ballsStorage;
  private JPanel ballPanel;
  private int ballsCount = 0;


  public AppFrame()
  {
    balls = new ArrayList<>();
    ballsStorage = fillBallsStorage();
    setTitle("Шарики");
    init();

  }

  private void init()
  {
    ballPanel = new BallPanel(balls);
    add(ballPanel, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();

    JButton addBallButton = new JButton("Add ball");
    addBallButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        addBall();
        ballsCount++;
        ballPanel.repaint();
        if(ballsCount == 5)
        {
          addBallButton.setEnabled(false);
        }
      }
    });

    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });


    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.add(addBallButton);
    buttonPanel.add(closeButton);

    add(buttonPanel, BorderLayout.SOUTH);
  }

  private void addBall()
  {
    Ball temp = ballsStorage.get(ballsCount);
    balls.add(temp);
    new BallThread(temp, ballPanel).start();
  }

  private List<Ball> fillBallsStorage()
  {
    List<Ball> temp = new ArrayList<>();
    temp.add(new Ball(0,0, 6,50, Color.RED));
    temp.add(new Ball(0,50, 4,75, Color.GREEN));
    temp.add(new Ball(0,125, 8,40, Color.BLUE));
    temp.add(new Ball(0,165, 10,30, Color.CYAN));
    temp.add(new Ball(0,195, 2,90, Color.MAGENTA));

    return temp;
  }
}
