package chugunov.UI_component;

import chugunov.util.DbUtil;
import chugunov.util.SQLiteDbUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame
{
  private static final Logger log = LogManager.getLogger(MainFrame.class);

  JPanel connectionPanel;
  JPanel tableListPanel;
  JPanel dataTable;
  JTextField pathField;
  JTable table;
  JList<String> tableNames;

  DbUtil dbUtil;

  public void initUI()
  {
    this.setTitle("Super cool DB client");
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    connectionPanel = createConnectionPanel();
    tableListPanel = createTableListPanel();
    dataTable = createMockTablePanel();

    this.add(connectionPanel, BorderLayout.NORTH);
    this.add(tableListPanel, BorderLayout.WEST);
    this.add(dataTable, BorderLayout.CENTER);

    this.pack();
    this.setPreferredSize(new Dimension(960, 640));
//    setResizable(false);
    this.setVisible(true);

    log.info("UI is initialized");
  }

  private JPanel createConnectionPanel()
  {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    final JLabel label = new JLabel("JDBC URL : ");
    panel.add(label, BorderLayout.WEST);

    pathField = new JTextField("insert jdbc path here", 32);
    panel.add(pathField, BorderLayout.NORTH);

    JButton openButton = new JButton("Open");
    panel.add(openButton, BorderLayout.EAST);

    openButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String path = pathField.getText();
        if (!path.isEmpty())
        {
          setDbUtil(new SQLiteDbUtil(path));
        }
      }
    });

    return panel;
  }

  private JPanel createTableListPanel()
  {
    tableListPanel = new JPanel();
    tableListPanel.setLayout(new BoxLayout(tableListPanel, BoxLayout.Y_AXIS));

    tableListPanel.add(new JLabel("Tables: "));

    tableNames = new JList<>();
    tableNames.setPrototypeCellValue("table name");
    tableNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableNames.addListSelectionListener(e -> {
      String tableName = tableNames.getSelectedValue();
      setTableData(tableName);
    });

    tableListPanel.add(new JScrollPane(tableNames));

    final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
    panel.add(tableListPanel);

    return panel;
  }

  private JPanel createMockTablePanel()
  {
    table = new JTable();
    table.getModel().addTableModelListener(table);

    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.add(new JScrollPane(table), BorderLayout.CENTER);

    return panel;
  }

  private void setDbUtil(DbUtil dbUtil)
  {
    this.dbUtil = dbUtil;
    List<String> tables = dbUtil.getTableNames();

    DefaultListModel<String> model = new DefaultListModel<>();
    for (String str : tables)
    {
      model.addElement(str);
    }
    tableNames.setSelectedIndex(0);
    tableNames.setModel(model);

    setTableData(tables.get(0));

  }

  private void setTableData(String tableName)
  {
    List<String> colNames = dbUtil.getColumnNames(tableName);

    List<List<Object>> data = dbUtil.getTabledata(tableName, colNames);
    if (table.getModel() instanceof AppTableModel)
    {
      AppTableModel tableModel = (AppTableModel) table.getModel();
      tableModel.setTableData(colNames, data);
    }
    else
    {
      table.setModel(new AppTableModel(colNames, data));
      table.getModel().addTableModelListener(table);
    }
  }
}
