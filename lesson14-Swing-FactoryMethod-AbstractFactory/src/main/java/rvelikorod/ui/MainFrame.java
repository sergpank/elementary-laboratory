package rvelikorod.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rvelikorod.db.DbUtil;

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
        JOptionPane.showMessageDialog(panel, "Database is loaded successfully");

        try (Connection con = DbUtil.getConnection())
        {
          tableListPanel.removeAll();
          tableListPanel.setLayout(new BoxLayout(tableListPanel, BoxLayout.Y_AXIS));

          PreparedStatement stmt = con.prepareStatement("SELECT name FROM sqlite_master WHERE type='table'");
          ResultSet rs = stmt.executeQuery();

          while(rs.next())
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
                JOptionPane.showMessageDialog(MainFrame.this, "Table = " + tableName);
                updateTablePanel(getColumnNames(dbPath, tableName), getTableInfo(dbPath, tableName, getColumnNames(dbPath, tableName)));
                log.info(tableName, "is opened");
              }
            });
          }
          tableListPanel.revalidate();
        }
        catch (SQLException ex)
        {
          log.error("{} : {}", ex.getClass(), ex.getMessage(), ex);
          ex.printStackTrace();
        }
      }
    });

    return panel;
  }

  private String[] getColumnNames(String path, String tableName)
  {
    String[] columnsArray = null;
    DbUtil.init(path);
    try
    {
      PreparedStatement ps = DbUtil.getConnection().prepareStatement("PRAGMA table_info (" + tableName + ")");
      ResultSet columnNames = ps.executeQuery();
      int length = getArrayLength(columnNames);
      int i = 0;
      while (columnNames.next())
      {
        length++;
      }
      columnsArray = new String[length];
      columnNames = ps.executeQuery();
      while(columnNames.next())
      {
        columnsArray[i]=columnNames.getString("name");
        i++;
      }
    }
    catch (SQLException ex)
    {
      log.error("{} : {}", ex.getClass(), ex.getMessage(), ex);
      ex.printStackTrace();
    }
    return columnsArray;
  }

  private String[][] getTableInfo(String path, String tableName, String[] columnNames)
  {
    String[][]data = null;
    DbUtil.init(path);
    try
    {
      PreparedStatement stmt = DbUtil.getConnection().prepareStatement("SELECT * FROM " + tableName);
      ResultSet tablesInfo = stmt.executeQuery();
      int length = getArrayLength(tablesInfo);
      data = new String[length][columnNames.length];
      tablesInfo = stmt.executeQuery();
      int i = 0;
      while (tablesInfo.next())
      {
        for(int j = 0; j<columnNames.length; j++)
        {
          data [i][j] = tablesInfo.getString(columnNames[j]);
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

  private int getArrayLength(ResultSet tablesInfo)
  {
    int length = 0;
    while (true)
    {
      try
      {
        if (!tablesInfo.next()) break;
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
      length++;
    }
    return length;
  }


  private void updateTablePanel(String[] columnNames, String [][] rowData)
  {
    JTable table = new JTable(rowData, columnNames);
    dataTable.removeAll();
    dataTable.setLayout(new BorderLayout(10, 10));
    dataTable.add(new JScrollPane(table), BorderLayout.CENTER);
    dataTable.revalidate();
  }

  private JPanel createTableListPanel()
  {
    JPanel tableListPanel = new JPanel();
    tableListPanel.setLayout(new BoxLayout(tableListPanel, BoxLayout.Y_AXIS));

    tableListPanel.add(new JLabel("Table_01"));
    tableListPanel.add(new JLabel("Table_02"));
    tableListPanel.add(new JLabel("Table_03"));
    tableListPanel.add(new JLabel("Table_04"));
    tableListPanel.add(new JLabel("Table_05"));
    tableListPanel.add(new JLabel("Table_06"));
    tableListPanel.add(new JLabel("Table_07"));

    final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
    panel.add(tableListPanel);
    return panel;
  }

  private JPanel createMockTablePanel()
  {
    String[] columnNames = new String[] {"Column A", "Column B", "Column C"};
    String[][] rowData = new String[][]{
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"}
    };

    JTable table = new JTable(rowData, columnNames);

    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.add(new JScrollPane(table), BorderLayout.CENTER);

    return panel;
  }

}
