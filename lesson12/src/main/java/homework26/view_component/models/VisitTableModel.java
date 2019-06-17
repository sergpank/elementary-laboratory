package homework26.view_component.models;

import homework26.dao.DateConverter;
import homework26.entity.Client;
import homework26.entity.Doctor;
import homework26.entity.Pet;
import homework26.entity.Visit;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VisitTableModel extends AbstractTableModel
{
  private List<Visit> visitList;
  private static String[] columnNames = {"Visit date", "Charge", "Doctor", "Patient", "Client"};

  public VisitTableModel(List<Visit> visitList)
  {
    this.visitList = visitList;

  }

  @Override
  public int getRowCount()
  {
    return visitList.size();
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
    Visit visit = visitList.get(rowIndex);
    Doctor doctor = visit.getDoctor();

    Pet patient = visit.getPatient();
    Client client = visit.getClient();


    String doctorView = doctor.toString();

    String patientView = patient.toString();

    String clientView = String.format("%s %s (%s)",
        client.getSurname(), client.getName(), client.getPhoneNr());


    String result = null;
    switch (columnIndex)
    {
      case 0:
        result = DateConverter.dateToString(visit.getVisitDate());
        break;
      case 1:
        result = visit.getCharge() + "";
        break;
      case 2:
        result = doctorView;
        break;
      case 3:
        result = patientView;
        break;
      case 4:
        result = clientView;
        break;


    }
    return result;
  }

  @Override
  public String getColumnName(int column)
  {
    return columnNames[column];
  }

  public Visit getVisit(int rowIndex)
  {
    return visitList.get(rowIndex);
  }
}
