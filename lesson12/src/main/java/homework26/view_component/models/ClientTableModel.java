package homework26.view_component.models;

import homework26.dao.DateConverter;
import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Pet;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientTableModel extends AbstractTableModel
{
  private List<Client> clientList;
  private static String[] columnNames = {"Name", "Surname", "Birth date", "Phone number", "Address", "Pets"};

  public ClientTableModel(List<Client> clientList)
  {
    this.clientList = clientList;
  }

  @Override
  public int getRowCount()
  {
    return clientList.size();
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
    Client client = clientList.get(rowIndex);
    Address addr = client.getAddress();
    List<Pet> pets = client.getPets();

    String addressView = String.format("%s %s, ap.: %s, zip: %d", addr.getStreet(),
        addr.getHouseNr(), addr.getAppartmentNr(), addr.getZip());

    StringBuilder sb = new StringBuilder();
    if (pets.size() > 0)
    {
      sb.append("<html>");
      for (Pet pet : pets)
      {
        sb.append(pet.toString());
        sb.append("<br>");
      }
      sb.append("</html>");
    }
    else
    {
      sb.append("none");
    }

    String result = null;

    switch (columnIndex)
    {
      case 0:
        result = client.getName();
        break;
      case 1:
        result = client.getSurname();
        break;
      case 2:
        result = DateConverter.dateToString(client.getBirthDate());
        break;
      case 3:
        result = client.getPhoneNr();
        break;
      case 4:
        result = addressView;
        break;
      case 5:
        result = sb.toString();
        break;
    }
    return result;
  }

  @Override
  public String getColumnName(int column)
  {
    return columnNames[column];
  }

  public Client getClient(int rowIndex)
  {
    return clientList.get(rowIndex);
  }
}
