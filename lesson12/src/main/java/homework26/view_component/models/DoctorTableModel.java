package homework26.view_component.models;

import homework26.dao.DateConverter;
import homework26.entity.Doctor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DoctorTableModel extends AbstractTableModel
{
  private List<Doctor> doctorList;
  private static String[] columnNames = {"Name", "Surname", "Birth date", "Phone number"};

  public DoctorTableModel(List<Doctor> doctortList)
  {
    this.doctorList = doctortList;
  }

  @Override
  public int getRowCount()
  {
    return doctorList.size();
  }

  @Override
  public int getColumnCount()
  {
    return columnNames.length;
  }

  @Override
  public Class<?> getColumnClass(int columnIndex)
  {
    return String.class;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Doctor doctor = doctorList.get(rowIndex);

    String result = null;

    switch (columnIndex)
    {
      case 0:
        result = doctor.getName();
        break;
      case 1:
        result = doctor.getSurname();
        break;
      case 2:
        result = DateConverter.dateToString(doctor.getBirthDate());
        break;
      case 3:
        result = doctor.getPhoneNr();
        break;
    }

    return result;
  }

  @Override
  public String getColumnName(int column)
  {
    return columnNames[column];
  }

  public Doctor getDoctor(int rowIndex)
  {
    return doctorList.get(rowIndex);
  }
}
