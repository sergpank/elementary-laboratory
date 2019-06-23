package shylov.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shylov.db.DbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    openButton.addActionListener(new OpenButtonListener(pathField));

    return panel;
  }

  private JPanel createTableListPanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.add(new JLabel("Tibles"));
    return panel;
  }

  private JPanel createMockTablePanel()
  {
    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.add(new JScrollPane(new JTable()), BorderLayout.CENTER);
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

  private class TableButtonListener implements ActionListener
  {
    private String tableName;

    public TableButtonListener(String tableName)
    {
      this.tableName = tableName;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
      String[] columnNames = getColumnNames(tableName);
      String[][] tableRow = getRowData(columnNames.length);
      updateMockTablePanel(columnNames, tableRow);

    }

    private String[][] getRowData(int size)
    {
      String[][] tableRow = null;
      try (Connection connection = DbUtil.getConnection())
      {

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName);
        ResultSet resultSet = statement.executeQuery();

        List<String[]> rowList = new ArrayList<>();

        while (resultSet.next())
        {
          String[] row = new String[size];
          for (int x = 0, i = 1; x < size; i++, x++)
          {
            row[x] = resultSet.getString(i);
          }
          rowList.add(row);
        }
        if (rowList.size() > 0)
        {
          tableRow = new String[rowList.size()][rowList.get(0).length];
        }
        else
        {
          return tableRow;
        }
        int columnSize = tableRow.length;
        int rowSise = tableRow[0].length;
        for (int i = 0; i < columnSize; i++)
        {
          for (int j = 0; j < rowSise; j++)
          {
            tableRow[i][j] = rowList.get(i)[j];
          }

        }
      }
      catch (SQLException ex)
      {
        ex.printStackTrace();
      }
      return tableRow;
    }

  }

  private String[] getColumnNames(String tableName)
  {
    try (Connection connection = DbUtil.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("PRAGMA table_info('" + tableName + "');");
      ResultSet set = statement.executeQuery();

      //JOptionPane.showMessageDialog(MainFrame.this, "Table = " + tableName);
      ArrayList<String> list = new ArrayList<>();

      while (set.next())
      {
        String str = set.getString(2);
        list.add(str);
      }
      String[] str = new String[list.size()];
      for (int i = 0; i < str.length; i++)
      {
        str[i] = list.get(i);
      }
      return str;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  private class OpenButtonListener implements ActionListener
  {

    private JTextField pathField;

    public OpenButtonListener(JTextField pathField)
    {

      this.pathField = pathField;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

      String dbPath = pathField.getText();

      log.info("Sqlite DB path : {}", dbPath);

      DbUtil.init(dbPath);
      // JOptionPane.showMessageDialog(panel, "Database is loaded successfully");

      try (Connection con = DbUtil.getConnection())
      {
        tableListPanel.removeAll();
        tableListPanel.setLayout(new BoxLayout(tableListPanel, BoxLayout.Y_AXIS));
        tableListPanel.add(new JLabel("Tables"));
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");

        while (rs.next())
        {
          String tableName = rs.getString(1);

          JButton tableButton = new JButton(tableName);
          tableListPanel.add(tableButton);

          tableButton.addActionListener(new TableButtonListener(tableName));
        }
        tableListPanel.revalidate();
      }
      catch (SQLException ex)
      {
        log.error("{} : {}", ex.getClass(), ex.getMessage(), ex);
        ex.printStackTrace();
      }
    }
  }


}
