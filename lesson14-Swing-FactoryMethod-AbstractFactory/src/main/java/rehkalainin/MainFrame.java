package rehkalainin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame
{
  private static final Logger log = LogManager.getLogger(MainFrame.class);
  public JTextField textField = new JTextField("insert jdbc path here");
  List<String> tableList = new ArrayList<>();
  List<String> columnNames = new ArrayList<>();
  String [] rows;
  List<String[]> rowData = new ArrayList<>();
  Connection connection = null;
  JPanel connectPanel = null;

  public void initUI()
  {
    this.setTitle("Super cool DB client");
    this.setSize(960, 640);
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    JPanel connectionPanel = createConnectionPanel();
    JPanel tableListPanel = createTableListPanel();
    JPanel dataTablePanel = createTablePanel();

    this.add(connectionPanel, BorderLayout.NORTH);
    this.add(tableListPanel, BorderLayout.WEST);
    this.add(dataTablePanel, BorderLayout.CENTER);

    this.setVisible(true);
    log.info("UI is initialized");
  }

  public JPanel createConnectionPanel()
  {
    if (connectPanel == null)
    {
      connectPanel = new JPanel(new FlowLayout());

      connectPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
      connectPanel.add(new JLabel("JDBC URL : "));

      connectPanel.add(textField);

      JButton openButton = new JButton("Open");
      connectPanel.add(openButton);
      actionListener(openButton);
    }

    return connectPanel;

  }

  private void actionListener(JButton openButton)
  {
    openButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        try
        {

          String url = "jdbc:sqlite:" + textField.getText();
          connection = DriverManager.getConnection(url);

          JOptionPane.showMessageDialog(new JPanel(), "Connected to DB");

          String query = "SELECT * FROM sqlite_master WHERE type='table'";
          PreparedStatement statement = connection.prepareStatement(query);
          ResultSet rs = statement.executeQuery();

          while (rs.next())
          {
            String tableName = rs.getString("tbl_name");
            tableList.add(tableName);
          }
          initUI();
        }
        catch (SQLException ex)
        {
          ex.printStackTrace();
        }

      }
    });
  }


  private JPanel createTableListPanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));

    if (connection != null)
    {
      ButtonGroup buttonGroup = new ButtonGroup();

      for (int i = 1; i < tableList.size(); i++)
      {
        String tableName = tableList.get(i);
        JRadioButton radioButton = new JRadioButton(tableName);
        panel.add(radioButton);
        buttonGroup.add(radioButton);

        actionRadioButtonListener(radioButton);

      }
      return panel;
    }
    else
    {
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
    }

    return panel;
  }

  private void actionRadioButtonListener(JRadioButton radioButton)
  {
    radioButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        String query = "PRAGMA table_info(" + radioButton.getText() + ")";
        try
        {
          PreparedStatement statement = connection.prepareStatement(query);
          ResultSet rs = statement.executeQuery();

          while (rs.next())
          {
            String result = rs.getString(2);
            columnNames.add(result);
          }

          String query2 = "SELECT * FROM " + radioButton.getText();
          PreparedStatement statement1 = connection.prepareStatement(query2);
          ResultSet rs2 = statement.executeQuery();

          while (rs2.next())
          {
          String [] row = rs2.toString().split(" ");

          rowData.add(row);
          }
         // initUI();
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }
      }
    });
  }


  private JPanel createTablePanel()
  {
    if (connection == null)
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
    else
    {
      String [] columns = columnNames.toArray(new String[columnNames.size()]);
      String[][] tableData = rowData.toArray(new String[rowData.size()][columnNames.size()]);

     // ModelTable modelTable = new ModelTable(columnNames,rowData);
      //JTable table = new JTable(modelTable);
      JTable table = new JTable(tableData,columns);

      JScrollPane scrollPane = new JScrollPane(table);

      JPanel panel = new JPanel(new BorderLayout());

      panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 10));
      panel.add(table.getTableHeader(), BorderLayout.NORTH);
      panel.add(scrollPane, BorderLayout.CENTER);
      return panel;
    }
  }
}


