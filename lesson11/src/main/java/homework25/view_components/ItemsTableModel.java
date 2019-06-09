package homework25.view_components;

import homework25.dao.AbstractDao;
import homework25.dao.UserDao;
import homework25.models.User;
import homework25.models.ValueObject;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemsTableModel extends AbstractTableModel
{
  private AbstractDao itemDao;
  private List<ValueObject> items;
  private int columnCount;
  private List<String> columnNames;


  public ItemsTableModel(AbstractDao itemDao)
  {

    this.itemDao = itemDao;
    this.items = itemDao.read();

    columnNames = items.size() > 0 ? new ArrayList<>(items.get(0).asPropertyMap().keySet()) : new ArrayList<>();
    columnCount = columnNames.size();

  }

  @Override
  public int getRowCount()
  {
    return items.size();
  }

  @Override
  public int getColumnCount()
  {
    return columnCount;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Object result = null;
    ValueObject item = items.get(rowIndex);
    result = item.asPropertyMap().get(getColumnName(columnIndex));
    return result;
  }

  @Override
  public String getColumnName(int column)
  {
    return columnNames.get(column);
  }


  public ValueObject getItem(int rowIndex)
  {
    return items.get(rowIndex);
  }
}
