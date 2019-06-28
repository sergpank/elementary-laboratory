package shylov.ball;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class RendeBallr implements Runnable
{

  public static final int WIDTH = 500;
  public static final int HEIGHT = 600;
  public static final String TITLE = "Soft Ball";

  public static final int CLEAR_COLOR = 0xff000000;
  public static final int NUM_BUFFERS = 3;
  public static final float UPDATE_RATE = 60.0F;
  public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;
  public static final long IDLE_TIME = 1;

  private static final Logger log = LogManager.getLogger(BallThread.class);
  private BallPanel panel;
  private int dx = 1;


  private boolean running;
  private Graphics2D graphics;


  public RendeBallr()
  {
    running = false;
    Display.create(WIDTH, HEIGHT, "TITLE", CLEAR_COLOR, NUM_BUFFERS);
    graphics = Display.getGraphics();

  }

  public synchronized void start()
  {
    if (running)
    {
      return;
    }
    running = true;
  }

  public synchronized void stop()
  {
    if (!running)
    {
      return;
    }
    running = false;
    cleanup();
  }

  private void update()
  {

  }


  private void render()
  {
    Display.clear();

    Display.swapBuffers();
  }


  private void cleanup()
  {
    Display.destroy();
  }

  @Override
  public void run()
  {
    int fps = 0;
    int upd = 0;
    int updl = 0;

    long count = 0;

    long lastTime = Time.get();
    float delta = 0;

    while (running)
    {

      long now = Time.get();
      long elapsTime = now - lastTime;
      lastTime = now;
      count += elapsTime;
      delta += (elapsTime) / UPDATE_INTERVAL;
      boolean render = false;

      while (delta > 1)
      {
        update();
        upd++;
        delta--;
        if (render)
        {
          updl++;
        }
        else
        {
          render = true;
        }
      }
      if (render)
      {
        render();
        fps++;
      }
      else
      {
        try
        {
          Thread.sleep(IDLE_TIME);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      if (count >= Time.SECOND)
      {
        Display.setTitle(TITLE + " || Fps: " + fps + " | Upd" + upd + " | Updl" + updl);
        upd = 0;
        fps = 0;
        updl = 0;
        count = 0;
      }
    }


  }


}
