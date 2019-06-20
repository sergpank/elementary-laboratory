package rehkalainin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.xml.bind.SchemaOutputResolver;
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
  Connection connection = null;
  JPanel panel = null;

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
    if (panel == null)
    {
      panel = new JPanel(new FlowLayout());

      panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
      panel.add(new JLabel("JDBC URL : "));

      panel.add(textField);

      JButton openButton = new JButton("Open");
      panel.add(openButton);
      actionListener(openButton);
    }

    return panel;

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
          System.out.println(textField.getText());
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
      for (int i = 1; i < tableList.size(); i++)
      {
        String tableName = tableList.get(i);
        panel.add(new JLabel(tableName));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

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

  private JPanel createTablePanel()
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
    JScrollPane scrollPane = new JScrollPane(table);

    JPanel panel = new JPanel(new BorderLayout());

    panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 10));
    panel.add(table.getTableHeader(), BorderLayout.NORTH);
    panel.add(scrollPane, BorderLayout.CENTER);

    return panel;
  }


}
