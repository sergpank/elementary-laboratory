package shylov.ball;

import java.util.List;

public class Checker
{
  private int width;
  private int hight;
  private List<Ball> balls;

  public Checker(int width, int hight, List<Ball> balls)
  {
    this.width = width;
    this.hight = hight;
    this.balls = balls;
  }

  public synchronized boolean check(Ball checkBall)
  {
    boolean rez = false;
    if (checkBoarder(checkBall))
    {
      rez = checkContact(checkBall);
    }
    return rez;
  }

  private boolean checkContact(Ball checkBall)
  {
    boolean rez = true;
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
            newY -= speed;
            rez = contact(newX,newY,diametr,balls.get(i));
            break;
          }case SOUTH:{
            newY += speed;
            rez = contact(newX,newY,diametr,balls.get(i));
            break;
          }case WEST:{
            newX -= speed;
            rez = contact(newX,newY,diametr,balls.get(i));
            break;
          }case EAST:{
            newX += speed;
            rez = contact(newX,newY,diametr,balls.get(i));
            break;
          }case NW:{
            newY -= speed;
            newX -= speed;
            rez = contact(newX,newY,diametr,balls.get(i));
            break;
          }case NE:{
            newY -= speed;
            newX += speed;
            rez = contact(newX,newY,diametr,balls.get(i));
            break;
          }case SE:{
            newY += speed;
            newX += speed;
            rez = contact(newX,newY,diametr,balls.get(i));
            break;
          }case SW:{
            newY += speed;
            newX -= speed;
            rez = contact(newX,newY,diametr,balls.get(i));
            break;
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
    boolean rez = true;
    double gep = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    if (gep <= (r1/2 + r2/2)){
      rez = false;
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
        break;
      }
      case SOUTH:
      {
        newY += speed;
        if (newY <= hight - checkBall.getDiametr())
        {
          rez = true;
        }
        break;
      }
      case EAST:
      {
        newX += speed;
        if (newX <= width - checkBall.getDiametr())
        {
          rez = true;
        }
        break;
      }
      case WEST:
      {
        newX -= speed;
        if (newX >= 0)
        {
          rez = true;
        }
        break;
      }
      case NE:
      {
        newX += speed;
        newY -= speed;
        if (newY >= 0 && newX <= width - checkBall.getDiametr())
        {
          rez = true;
        }
        break;
      }
      case SE:
      {
        newY += speed;
        newX += speed;
        if (newY <= hight - checkBall.getDiametr() && newX <= width - checkBall.getDiametr())
        {
          rez = true;
        }
        break;
      }
      case NW:
      {
        newX -= speed;
        newY -= speed;
        if (newX >= 0 && newY >= 0)
        {
          rez = true;
        }
        break;
      }
      case SW:
      {
        newX -= speed;
        newY += speed;
        if (newX >= 0 && newY <= hight - checkBall.getDiametr())
        {
          rez = true;
        }
        break;
      }
    }
    return rez;
  }
}
