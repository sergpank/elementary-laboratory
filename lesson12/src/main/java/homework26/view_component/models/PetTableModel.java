package homework26.view_component.models;

import homework26.dao.DateConverter;
import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.Pet;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PetTableModel extends AbstractTableModel
{
  private static String[] columnNames = {"Name", "Type", "Birth date", "Master surname", "Master name", "Phone number", "Address"};
  private List<Pet> petList;

  public PetTableModel(List<Pet> pets)
  {
    this.petList = pets;
  }

  @Override
  public int getRowCount()
  {
    return petList.size();
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
    Pet pet = petList.get(rowIndex);
    Client client = pet.getMaster();
    Address addr = client.getAddress();

    String addressView = String.format("%s %s, ap.: %s, zip: %d", addr.getStreet(),
        addr.getHouseNr(), addr.getAppartmentNr(), addr.getZip());

    String result = null;

    switch (columnIndex)
    {
      case 0:
        result = pet.getName();
        break;
      case 1:
        result = pet.getType();
        break;
      case 2:
        result = DateConverter.dateToString(pet.getBirthDate());
        break;
      case 3:
        result = client.getSurname();
        break;
      case 4:
        result = client.getName();
        break;
      case 5:
        result = client.getPhoneNr();
        break;
      case 6:
        result = addressView;
        break;
    }
    return result;
  }

  @Override
  public String getColumnName(int column)
  {
    return columnNames[column];
  }

  public Pet getPet(int rowIndex)
  {
    return petList.get(rowIndex);
  }
}
