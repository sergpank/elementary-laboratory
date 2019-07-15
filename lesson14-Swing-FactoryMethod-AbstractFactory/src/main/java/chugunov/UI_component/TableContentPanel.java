package chugunov.UI_component;

import javax.swing.*;
import java.awt.*;

public class TableContentPanel extends JPanel
{
  JTable table;

  public TableContentPanel()
  {
    this.setLayout(new BorderLayout(10, 10));

    table = new JTable(new AppTableModel());
    table.getModel().addTableModelListener(table);

    this.add(new JScrollPane(table), BorderLayout.CENTER);

  }

  public JTable getTable()
  {
    return table;
  }
}
