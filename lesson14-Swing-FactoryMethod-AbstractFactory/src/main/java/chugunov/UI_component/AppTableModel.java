package chugunov.UI_component;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class AppTableModel extends AbstractTableModel
{
  private List<String> columnNames;
  private List<List<Object>> tableData;

  public AppTableModel(List<String> columnNames, List<List<Object>> tableData)
  {
    this.columnNames = columnNames;
    this.tableData = tableData;
  }

  public void setTableData(List<String> columnNames, List<List<Object>> tableData)
  {
    this.columnNames = columnNames;
    this.tableData = tableData;
    this.fireTableStructureChanged();
  }

  @Override
  public int getRowCount()
  {
    return tableData.size();
  }

  @Override
  public int getColumnCount()
  {
    return columnNames.size();
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    return tableData.get(rowIndex).get(columnIndex);
  }

  @Override
  public String getColumnName(int column)
  {
    return columnNames.get(column);
  }
}
