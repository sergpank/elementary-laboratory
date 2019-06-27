package shylov.ball;



import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {
    private static boolean created = false;//Для проверки на создания окна
    private static JFrame window; //Ссылка на объект окна
    private static Canvas content;//Ссылка на объект листа в окне
    private static BufferedImage buffer;
    private static int[] buffereData;
    private static Graphics bufferGraphics;
    private static int clearColor;
    private static BufferStrategy bufferStrategy;

    public static void create(int width, int height, String title,int _clearColor,int numBuffers){
      if (created)//проверка наличия созданных окон
        return;
      window = new JFrame(title);// создан объект окноб конструктор принимает название окна
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//нажатие на крестик закрывает окно и программу
      content = new Canvas();

      Dimension size = new Dimension(width,height);//формирование размеров полотна
      content.setPreferredSize(size);//установка размера полотна

      window.setResizable(false);
      window.getContentPane().add(content);
      window.pack();
      window.setLocationRelativeTo(null);
      window.setVisible(true);
      buffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
      buffereData = ((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
      bufferGraphics = buffer.getGraphics();
      ((Graphics2D) bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      clearColor = _clearColor;

      content.createBufferStrategy(numBuffers);
      bufferStrategy = content.getBufferStrategy();
      created = true;
    }
    public static void clear(){
      Arrays.fill(buffereData,clearColor);
    }
    public static void swapBuffers(){
      Graphics g = bufferStrategy.getDrawGraphics();
      g.drawImage(buffer,0,0,null);
      bufferStrategy.show();

    }
    public static Graphics2D getGraphics(){
      return (Graphics2D)bufferGraphics;
    }
    public static void destroy(){
      if (!created)
        return;
      window.dispose();
    }

    public static void setTitle(String title){
      window.setTitle(title);
    }


    public static JFrame getWindow() {
      return window;
    }
}
