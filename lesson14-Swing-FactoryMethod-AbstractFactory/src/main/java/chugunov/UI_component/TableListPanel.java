package chugunov.UI_component;

import javax.swing.*;
import java.awt.*;

public class TableListPanel extends JPanel
{
  JList<String> tableList;

  public TableListPanel()
  {
    JPanel tableListPanel = new JPanel();
    tableListPanel.setLayout(new BoxLayout(tableListPanel, BoxLayout.Y_AXIS));
    tableListPanel.add(new JLabel("Tables: "));
    tableList = new JList<>(new DefaultListModel<String>());
    tableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableList.setPrototypeCellValue("table name list ");
    tableList.setVisibleRowCount(10);
    tableListPanel.add(new JScrollPane(tableList));

    this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    this.add(tableListPanel);
  }

  public JList<String> getTableList()
  {
    return tableList;
  }
}
