package shylov.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shylov.db.DbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainFrame extends JFrame
{
  private static final String url = "src/main/java/shylov/resource/users.db";
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

    openButton.addActionListener(new OpenButtonListener(tableListPanel,pathField));

    return panel;
  }

  private JPanel createTableListPanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


    panel.add(new JLabel("Tibles"));


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
  private class TableButtonListener implements ActionListener{
    private Connection connection;
    private String tibleName;

    public TableButtonListener(Connection connection, String tibleName)
    {
      this.connection = connection;
      this.tibleName = tibleName;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
      try
      {
        PreparedStatement statement = connection.prepareStatement("select * from" + tibleName );
      }
      catch (SQLException e1)
      {
        e1.printStackTrace();
      }
    }
  }
  private class OpenButtonListener implements ActionListener{
    private JPanel panel;
    private JTextField pathField;

    public OpenButtonListener(JPanel panel, JTextField pathField)
    {
      this.panel = panel;
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

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");

        while(rs.next())
        {
          String tableName = rs.getString(1);
          System.out.println(tableName);

          JButton tableButton = new JButton(tableName);
          tableButton.setBackground(new Color(255,255,255));
          tableButton.setSize(new Dimension(60,25));
          tableListPanel.add(tableButton);

          tableButton.addActionListener(new TableButtonListener(con,tableName));
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
