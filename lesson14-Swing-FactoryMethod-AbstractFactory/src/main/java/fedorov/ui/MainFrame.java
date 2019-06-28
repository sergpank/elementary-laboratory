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
  String[][] rowData;
  String[] columnNames;
  private static Connection connection;

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
          connection = connectionDB.getConnection(textField.getText());
          String query = "SELECT * FROM sqlite_master WHERE type='table'";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          ResultSet resultSet = preparedStatement.executeQuery();

          tables = new ArrayList<>();
          while(resultSet.next())
          {
            tables.add(resultSet.getString("tbl_name"));
          }
          tableListPanel.removeAll();
          tableListPanel.add(createTableListPanel());
          tableListPanel.revalidate();
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
          button.addActionListener(new ActionListener()
          {
            @Override
            public void actionPerformed(ActionEvent e)
            {
              try
              {
                String query = "PRAGMA table_info(" + e.getActionCommand() + ")";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

              while(resultSet.next())
              {
                //columnNames[0] = resultSet.getString("name");
                // сделать заполнение таблицы
              }
              }
            catch (SQLException ex)
            {
              ex.printStackTrace();
            }
            }
          });
          panel.add(button);
        }
      }
      return panel;
    }
     panel.add(new Label("NO"));
     panel.add(new Label("TABLES"));
     panel.add(new Label("AVAILABLE"));

     return panel;
  }

  private JPanel createDataPanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createLineBorder(Color.black));
    if(! (columnNames == null))
    {
      JTable table = new JTable(rowData, columnNames);
      panel.add(new JScrollPane(table));
      return panel;
    }
    return panel;
  }
}
