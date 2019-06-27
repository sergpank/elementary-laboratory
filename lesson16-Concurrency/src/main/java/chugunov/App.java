package chugunov;

import javax.swing.*;
import java.awt.*;

public class App
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(() -> {
      JFrame frame = new AppFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }
}
