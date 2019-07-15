package rehkalainin.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rehkalainin.DB.DbUtil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame
{
  private static final Logger log = LogManager.getLogger(MainFrame.class);

  JPanel connectionPanel;
  JPanel tableListPanel;
  JPanel dataTablePanel;

  public void initUI()
  {
    this.setTitle("Super cool DB client");
    this.setSize(960, 640);
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    connectionPanel = createConnectionPanel();
    tableListPanel = createTableListPanel();
    dataTablePanel = createTablePanel();

    this.add(connectionPanel, BorderLayout.NORTH);
    this.add(tableListPanel, BorderLayout.WEST);
    this.add(dataTablePanel, BorderLayout.CENTER);

    this.setVisible(true);
    log.info("UI is initialized");
  }

  public JPanel createConnectionPanel()
  {
      connectionPanel = new JPanel(new FlowLayout());

      connectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
      connectionPanel.add(new JLabel("JDBC URL : "));

      JTextField textField = new JTextField("insert jdbc path here");
      connectionPanel.add(textField);

      JButton openButton = new JButton("Open");
      connectionPanel.add(openButton);
      createOpenButtonListeber(openButton,textField);

    return connectionPanel;
  }

  private void createOpenButtonListeber(JButton openButton, JTextField textField)
  {
    openButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        DbUtil.init(textField.getText());
        try
        {
          Connection connection;
          connection = DbUtil.getConnection();

          JOptionPane.showMessageDialog(new JPanel(), "Connected to DB");
          log.info("Connected to DB");

          tableListPanel.removeAll();
          tableListPanel.setLayout(new BoxLayout(tableListPanel, BoxLayout.Y_AXIS));
          ButtonGroup buttonGroup = new ButtonGroup();

          String query = "SELECT * FROM sqlite_master WHERE type='table'";
          PreparedStatement statement = connection.prepareStatement(query);
          ResultSet rs = statement.executeQuery();

          while (rs.next())
          {
            String tableName = rs.getString("tbl_name");
            JRadioButton jRadioButton = new JRadioButton(tableName);
            tableListPanel.add(jRadioButton);
            buttonGroup.add(jRadioButton);

            createRadioButtonListener(jRadioButton,textField);

          }
          tableListPanel.revalidate();
        }
        catch (SQLException ex)
        {
          ex.printStackTrace();
        }
      }
    });
  }

  private void createRadioButtonListener(JRadioButton radioButton, JTextField pathField)
  {
    radioButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        DbUtil.init(pathField.getText());

        log.info("was pressed table:"+ radioButton.getText());

        List<String> columnNames = new ArrayList<>();
        List<String[]> dataTable = new ArrayList<>();

        String query = "PRAGMA table_info(" + radioButton.getText() + ")";
        try
        {
          Connection connection;
          connection = DbUtil.getConnection();
          PreparedStatement statement = connection.prepareStatement(query);
          ResultSet rs = statement.executeQuery();

          while (rs.next())
          {
            String result = rs.getString(2);
            columnNames.add(result);
          }

          String query2 = "SELECT * FROM " + radioButton.getText();
          PreparedStatement statement1 = connection.prepareStatement(query2);
          ResultSet rs2 = statement1.executeQuery();

          while (rs2.next())
          {
            List<String> rowData= new ArrayList<>();

            for(int i=1; i<=columnNames.size();i++)
            {
              String data = rs2.getString(i);
              rowData.add(data);
            }

            String [] rows = rowData.toArray(new String[rowData.size()]);
            dataTable.add(rows);
          }
          editTablePanel(columnNames,dataTable);

        }
        catch (SQLException e1)
        {
          e1.printStackTrace();
        }
      }
    });
  }

  private JPanel createTableListPanel()
  {
     JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));

      panel.add(new JLabel("Table_01"));
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(new JLabel("Table_02"));
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(new JLabel("Table_03"));
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(new JLabel("Table_04"));
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(new JLabel("Table_05"));
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(new JLabel("Table_06"));
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(new JLabel("Table_07"));

    return panel;
  }

  private JPanel createTablePanel()
  {
      String[] emptyColumnNames = new String[]{"Column A", "Column B", "Column C"};
      String[][] emptyRowData = new String[][]{
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

      JTable table = new JTable(emptyRowData, emptyColumnNames);
      JScrollPane scrollPane = new JScrollPane(table);

      JPanel panel = new JPanel(new BorderLayout());

      panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 10));
      panel.add(table.getTableHeader(), BorderLayout.NORTH);
      panel.add(scrollPane, BorderLayout.CENTER);

      return panel;
  }

  public void editTablePanel(List<String> columnNames, List<String[]> rowData)
  {
    String [] columns = columnNames.toArray(new String[columnNames.size()]);
    String[][] dataTable = rowData.toArray(new String[rowData.size()][columnNames.size()]);

    dataTablePanel.removeAll();
    JTable table = new JTable(dataTable,columns);

    dataTablePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 10));
    dataTablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
    dataTablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
    dataTablePanel.revalidate();
    log.info("displayed data from table");
  }
}


