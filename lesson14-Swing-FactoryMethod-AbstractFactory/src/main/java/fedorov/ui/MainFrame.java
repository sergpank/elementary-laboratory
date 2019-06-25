package fedorov.ui;

import fedorov.db.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainFrame extends JFrame
{
  private static final Logger log = LogManager.getLogger(rehkalainin.MainFrame.class);
  JPanel connectionPanel;
  JPanel tableListPanel;
  JPanel dataPanel;
  ArrayList<String> tables = new ArrayList<>();

  public void initUI()
  {
    this.setSize(600 ,400);
    this.setTitle("DB client");
    this.setLayout(new BorderLayout());
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    connectionPanel = createConnectionPanel();
    tableListPanel = createTableListPanel();
    dataPanel = createDataPanel();

    this.add(connectionPanel, BorderLayout.NORTH);
    this.add(tableListPanel, BorderLayout.WEST);
    this.add(dataPanel, BorderLayout.CENTER);
    log.info("UI is initialized");
  }

  private JPanel createConnectionPanel()
  {
    JPanel panel = new JPanel(new FlowLayout());
    panel.setBorder(BorderFactory.createLineBorder(Color.black));
    panel.add(new Label("JDBC URL: "));
    JTextField textField = new JTextField("jdbc:sqlite:src/main/java/fedorov/resources/lesson11.sqlite3");
    panel.add(textField);

    JButton openButton = new JButton("Open");
    panel.add(openButton);

    openButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        try
        {
          ConnectionDB connectionDB = new ConnectionDB();
          Connection connection = connectionDB.getConnection(textField.getText());
          String query = "SELECT * FROM sqlite_master WHERE type='table'";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          ResultSet resultSet = preparedStatement.executeQuery();
          while(resultSet.next())
          {
            tables.add(resultSet.getString("tbl_name"));
          }
          initUI();
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }
      }
    });

    return panel;
  }

  private JPanel createTableListPanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createLineBorder(Color.black));
    if( ! tables.isEmpty())
    {
      for(int i = 0; i < tables.size(); i++)
      {
        String temp = tables.get(i);
        if(!(temp.equals("sqlite_sequence")))
        {
          JButton button = new JButton(temp);
          panel.add(button);
          System.out.println(temp);
        }
      }
      return panel;
    }
    else
    {
      panel.add(new Label("NO"));
      panel.add(new Label("TABLES"));
      panel.add(new Label("AVAILABLE"));
    }
    return panel;
  }

  private JPanel createDataPanel()
  {
    JPanel panel = new JPanel();
    return panel;
  }
}
