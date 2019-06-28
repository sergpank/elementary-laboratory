package zhuravlov;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zhuravlov.db.DbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainFrame extends JFrame
{
  private static final Logger log = LogManager.getLogger(MainFrame.class);
  private JPanel tableListPanel;
  private JPanel dataTable;

  public void initUI()
  {
    this.setTitle("Super cool DB client");
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel connectionPanel = createConnectionPanel();
    tableListPanel = createTableListPanel();
    dataTable = createMockTablePanel();

    this.add(connectionPanel, BorderLayout.NORTH);
    this.add(tableListPanel, BorderLayout.WEST);
    this.add(dataTable, BorderLayout.CENTER);

    this.pack();
    this.setSize(960, 640);
//    setResizable(false);
    this.setVisible(true);

    log.info("UI is initialized");
  }

  private JPanel createConnectionPanel()
  {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    final JLabel label = new JLabel("JDBC URL : ");
    panel.add(label, BorderLayout.WEST);

    final JTextField pathField = new JTextField("insert jdbc path here", 32);
    panel.add(pathField, BorderLayout.NORTH);

    JButton openButton = new JButton("Open");
    panel.add(openButton, BorderLayout.EAST);

    openButton.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        String dbPath = pathField.getText();
        log.info("Sqlite DB path : {}", dbPath);

        DbUtil.init(dbPath);

        try (Connection con = DbUtil.getConnection())
        {
          tableListPanel.removeAll();
          tableListPanel.setLayout(new BoxLayout(tableListPanel, BoxLayout.Y_AXIS));

          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");

          while (rs.next())
          {
            String tableName = rs.getString(1);
            System.out.println(tableName);

            JButton tableButton = new JButton(tableName);
            tableListPanel.add(tableButton);
            tableButton.addActionListener(new ActionListener()
            {
              @Override
              public void actionPerformed(ActionEvent e)
              {
                String[] columnNames = getColumnNames(dbPath, tableName);
                String[][] tableRow = getTableInfo(dbPath, tableName, columnNames);
                updateMockTablePanel(columnNames, tableRow);
              }
            });
          }
        }
        catch (SQLException ex)
        {
          log.error("{} : {}", ex.getClass(), ex.getMessage(), ex);
          ex.printStackTrace();
        }
        tableListPanel.revalidate();
      }
    });
    return panel;
  }


  private String[] getColumnNames(String dbPath, String tableName)
  {
    DbUtil.init(dbPath);
    String[] ColumNames = null;
    String query = "PRAGMA table_info(" + tableName + ");";
    Connection con = DbUtil.getConnection();


    try (PreparedStatement preparedStatement = con.prepareStatement(query))
    {
      ResultSet resultSet = preparedStatement.executeQuery();

      int NumOfCol = getArrayLength(resultSet);
      while (resultSet.next())
      {
        NumOfCol++;
      }
      log.info("Numbers of colums " + NumOfCol);

      ColumNames = new String[NumOfCol];
      int i = 0;

      resultSet = preparedStatement.executeQuery();
      while (resultSet.next())
      {
        String columnName = resultSet.getString(2);
        ColumNames[i] = columnName;
        i++;
      }
      return ColumNames;
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
      return null;
    }
  }

  private int getArrayLength(ResultSet tablesInfo)
  {
    int length = 0;
    while (true)
    {
      try
      {
        if (!tablesInfo.next())
        {
          break;
        }
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
      length++;
    }
    return length;
  }

  private String[][] getTableInfo(String path, String tableName, String[] columnNames)
  {
    String[][] data = null;
    DbUtil.init(path);
    try
    {
      Connection con = DbUtil.getConnection();
      PreparedStatement stmt = con.prepareStatement("SELECT * FROM " + tableName);
      ResultSet tablesInfo = stmt.executeQuery();

      PreparedStatement stmt2 = con.prepareStatement("select count(*) from " + tableName);
      ResultSet rs = stmt2.executeQuery();
      rs.next();
      int count = rs.getInt(1);

      data = new String[count][columnNames.length];
      tablesInfo = stmt.executeQuery();
      int i = 0;
      while (tablesInfo.next())
      {
        for (int j = 0; j < columnNames.length; j++)
        {
          data[i][j] = tablesInfo.getString(columnNames[j]);
        }
        i++;
      }
    }
    catch (SQLException ex)
    {
      log.error("{} : {}", ex.getClass(), ex.getMessage(), ex);
      ex.printStackTrace();
    }
    return data;

  }


  private JPanel createTableListPanel()
  {
    JPanel tableListPanel = new JPanel();
    tableListPanel.setLayout(new BoxLayout(tableListPanel, BoxLayout.Y_AXIS));
    final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
    panel.add(tableListPanel);
    return panel;
  }

  private JPanel createMockTablePanel()
  {
    JTable table = new JTable();

    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.add(new JScrollPane(table), BorderLayout.CENTER);

    return panel;
  }

  private void updateMockTablePanel(String[] names, String[][] data)
  {
    JTable table;
    if (names == null || data == null)
    {
      log.info("columnNames : {}", names);
      log.info("dataRow : {}", data);
      return;
    }
    else
    {
      table = new JTable(data, names);
    }
    dataTable.removeAll();
    dataTable.setLayout(new BorderLayout(10, 10));
    dataTable.add(new JScrollPane(table), BorderLayout.CENTER);
    dataTable.revalidate();
  }
}
