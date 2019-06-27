package rvelikorod;


import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rvelikorod.ui.MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteClient
{
  private static final Logger log = LogManager.getLogger(SqliteClient.class);

  public static void main(String[] args)
  {
    log.debug("Starting application ...");
    try
    {
      Class.forName("org.sqlite.JDBC");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }

    Connection connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    String dbpath = "C:\\Users\\roma_velik\\javaElementary\\elementary-laboratory - копия\\lesson14-Swing-FactoryMethod-AbstractFactory\\database.db";

    MainFrame mainFrame = new MainFrame();

    SwingUtilities.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
        mainFrame.initUI();
      }
    });
  }
}
