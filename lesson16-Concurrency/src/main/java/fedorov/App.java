package fedorov;


import javax.swing.*;

public class App
{
  public static void main(String[] args)
  {
    // мы сейчас рисуем ball и передаем его потоку. нужно что-бы было графическое поле в которое эти шарики добавляются
    // что-бы можно было каждый из них передать новому потоку на обработку и сделать кнопку добавления шарика
    JFrame frame = new JFrame();
    Ball ball = new Ball();
    new BallThread(ball).start();


    frame.setTitle("Шарики");
    frame.setContentPane(ball);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setVisible(true);
  }
}
