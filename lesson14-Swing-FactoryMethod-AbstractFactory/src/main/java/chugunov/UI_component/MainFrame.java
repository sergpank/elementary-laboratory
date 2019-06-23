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

  JTextField pathField;
  JTable table;
  JList<String> tableList;
  JButton openButton;

  DbUtil dbUtil;

  public void initUI()
  {
    this.setTitle("Super cool DB client");
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel connectionPanel = createConnectionPanel();
    JPanel tableListPanel = createTableListPanel();
    JPanel tableContentPanel = createMockTablePanel();

    this.add(connectionPanel, BorderLayout.NORTH);
    this.add(tableListPanel, BorderLayout.WEST);
    this.add(tableContentPanel, BorderLayout.CENTER);

    this.pack();
    this.setPreferredSize(new Dimension(960, 640));
    this.setMinimumSize(new Dimension(600, 300));

    this.setVisible(true);

    log.info("UI is initialized");
  }

  private JPanel createConnectionPanel()
  {
    ConnectionPanel panel = new ConnectionPanel();

    this.openButton = panel.getOpenButton();
    this.pathField = panel.getPathField();

    openButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String path = pathField.getText();
        if (!path.isEmpty())
        {
          connectDb(path);
        }
        else
        {
          JOptionPane.showMessageDialog(null, "The field \"JDBC URL\" must be filled in");
        }
      }
    });

    return panel;
  }

  private JPanel createTableListPanel()
  {
    TableListPanel panel = new TableListPanel();

    this.tableList = panel.getTableList();

    this.tableList.addListSelectionListener(e -> {
      String tableName = tableList.getSelectedValue();
      setTableData(tableName);
    });

    return panel;
  }

  private JPanel createMockTablePanel()
  {
    TableContentPanel panel = new TableContentPanel();

    this.table = panel.getTable();

    return panel;
  }

  private void connectDb(String path)
  {
    this.dbUtil = new SQLiteDbUtil(path);

    setTableNames();
  }

  private void setTableNames()
  {
    List<String> tables = dbUtil.getTableNames();

    DefaultListModel<String> model = (DefaultListModel<String>) tableList.getModel();
    model.clear();
    for (String str : tables)
    {
      model.addElement(str);
    }
    if (tables.size() > 0)
    {
      tableList.setSelectedIndex(0);
      setTableData(tables.get(0));
    }
    tableList.validate();
  }


  private void setTableData(String tableName)
  {
    List<String> colNames = dbUtil.getColumnNames(tableName);

    List<Object[]> data = dbUtil.getTabledata(tableName, colNames);
    if (table.getModel() instanceof AppTableModel)
    {
      AppTableModel tableModel = (AppTableModel) table.getModel();
      tableModel.setTableData(colNames, data);
    }
  }
}
