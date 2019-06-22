package rehkalainin;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class ModelTable extends AbstractTableModel
{
  private List<String> columns;
  private List<String[]> rowsData;

  public ModelTable(List<String> columns, List<String[]> rowsData)
  {
    this.columns = columns;
    this.rowsData = rowsData;
  }

  @Override
  public int getRowCount()
  {
    return rowsData.size();
  }

  @Override
  public int getColumnCount()
  {
    return columns.size();
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  { String [] row = rowsData.get(rowIndex);
    return row[columnIndex];
  }
}
