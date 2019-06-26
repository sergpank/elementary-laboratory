package zhuravlov;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import panko.db.DbUtil;

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
        //String dbPath = pathField.getText();
        String dbPath = "D:\\elementary-laboratory\\lesson12\\resources\\DB.sqlite3";
        log.info("Sqlite DB path : {}", dbPath);

        DbUtil.init(dbPath);
        JOptionPane.showMessageDialog(panel, "Database is loaded successfully");

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
                String query = "PRAGMA table_info(" + tableName + ");";
                Connection con = DbUtil.getConnection();

                try (PreparedStatement preparedStatement = con.prepareStatement(query))
                {
                  ResultSet resultSet = preparedStatement.executeQuery();
                  ResultSetMetaData rsmd = resultSet.getMetaData();
                  int NumOfCol = 0;
                  NumOfCol = rsmd.getColumnCount();

                  String[] colums = new String[NumOfCol];
                  while (resultSet.next())
                  {
                    int i = 0;
                    String columnName = resultSet.getString(2);
                    colums[i] = columnName;
                  }
                }
                catch (SQLException ex)
                {
                  ex.printStackTrace();
                }
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


  private class OpenButtonListener implements ActionListener
  {

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
    String[] columnNames = new String[]{"Column A", "Column B", "Column C"};
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
