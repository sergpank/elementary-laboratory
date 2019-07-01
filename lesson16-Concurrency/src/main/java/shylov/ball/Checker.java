package shylov.ball;

import java.util.List;

public class Checker
{
  private int width;
  private int hight;
  private List<Ball> balls;

  public boolean check(Ball checkBall)
  {
    boolean rez = false;
    if (checkBoarder(checkBall))
    {
      rez = !checkContact(checkBall);
    }
    return rez;
  }

  private boolean checkContact(Ball checkBall)
  {
    boolean rez = false;
    for (int i = 0; i < balls.size(); i++)
    {
      if (!checkBall.equals(balls.get(i)))
      {

        int newX = checkBall.getX();
        int newY = checkBall.getY();
        int speed = checkBall.getSpeed();
        int diametr = checkBall.getDiametr();
        switch (checkBall.getHeading()){
          case NORTH:{
            
          }
        }
      }
    }
    return rez;
  }

  private boolean contact(int x1, int y1, int r1,Ball ball)
  {
    int x2 = ball.getX();
    int y2 = ball.getY();
    int r2 = ball.getDiametr();
    boolean rez = false;
    double gep = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    if (gep <= (r1/2 + r2/2)){
      rez = true;
    }
    return rez;

  }

  private boolean checkBoarder(Ball checkBall)
  {
    int newX = checkBall.getX();
    int newY = checkBall.getY();
    int speed = checkBall.getSpeed();
    boolean rez = false;
    switch (checkBall.getHeading())
    {
      case NORTH:
      {
        newY -= speed;
        if (newY >= 0)
        {
          rez = true;
        }
      }
      case SOUTH:
      {
        newY += speed;
        if (newY < hight - checkBall.getDiametr())
        {
          rez = true;
        }
      }
      case EAST:
      {
        newX += speed;
        if (newX < width - checkBall.getDiametr())
        {
          rez = true;
        }
      }
      case WEST:
      {
        newX -= speed;
        if (newX >= 0)
        {
          rez = true;
        }
      }
      case NE:
      {
        newX += speed;
        newY -= speed;
        if (newY >= 0 && newX < width - checkBall.getDiametr())
        {
          rez = true;
        }
      }
      case SE:
      {
        newY += speed;
        newX += speed;
        if (newY < hight - checkBall.getDiametr() && newX < width - checkBall.getDiametr())
        {
          rez = true;
        }
      }
      case NW:
      {
        newX -= speed;
        newY -= speed;
        if (newX >= 0 && newY >= 0)
        {
          rez = true;
        }
      }
      case SW:
      {
        newX -= speed;
        newY += speed;
        if (newX >= 0 && newY < hight - checkBall.getDiametr())
        {
          rez = true;
        }
      }
    }
    return rez;
  }
}
