package homework26.view_component.dialog;

import homework26.dao.ClientDao;
import homework26.dao.DateConverter;
import homework26.entity.Client;
import homework26.entity.Pet;
import homework26.entity.builder.PetBuilder;
import homework26.view_component.util.GBC;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PetEditor extends EditorDialog<Pet>
{
  protected long petId;

  protected JTextField name;
  protected JTextField type;
  protected JTextField birthDate;
  protected JLabel master;
  protected JComboBox<Client> masterList;

  protected ClientDao clientDao;

  public PetEditor(Frame parent, ClientDao clientDao)
  {
    super(parent);

    this.clientDao = clientDao;
  }

  @Override
  protected void init()
  {
    super.init();

    this.setLayout(new GridBagLayout());
    this.name = new JTextField(30);
    this.type = new JTextField();
    this.birthDate = new JTextField();
    this.master = new JLabel("none");
    this.masterList = new JComboBox<>();

    this.add(new JLabel("Name: "), new GBC(0, 0, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(name, new GBC(1, 0, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Type: "), new GBC(1, 0, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(type, new GBC(1, 1, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Birth date (YYYY-MM-DD): "), new GBC(0, 2, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(birthDate, new GBC(1, 2, 1, 1).setWeight(100, 0)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(new JLabel("Master: "), new GBC(0, 3, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(master, new GBC(1, 3, 1, 1).setWeight(100, 0)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(new JLabel("Master list: "), new GBC(0, 4, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(masterList, new GBC(1, 4, 1, 1).setWeight(100, 0)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(okBtn, new GBC(0, 5, 1, 1)
        .setAnchor(GBC.EAST).setFill(GBC.NONE).setInsets(20, 5, 5, 5).setIpad(2, 2));

    this.add(cancelBtn, new GBC(1, 5, 1, 1)
        .setAnchor(GBC.WEST).setFill(GBC.NONE).setInsets(20, 5, 5, 5).setIpad(2, 2));
  }

  @Override
  protected void setHandlers()
  {
    super.setHandlers();
    masterList.addActionListener(e -> {
      int index = masterList.getSelectedIndex();
      if (index != -1)
      {
        master.setText(masterList.getItemAt(masterList.getSelectedIndex()).toString());
      }
      else
      {
        master.setText("none");
      }

    });
  }

  @Override
  public void setItem(Pet item)
  {
    Client current = null;

    if (item != null)
    {
      petId = item.getId();
      name.setText(item.getName());
      type.setText(item.getType());
      birthDate.setText(DateConverter.dateToString(item.getBirthDate()));
      current = item.getMaster();
      master.setText(current != null ? current.toString() : "none");
    }
    else
    {
      petId = 0;
      name.setText("");
      type.setText("");
      birthDate.setText("");
      master.setText("none");
    }

    setComboItems(current, clientDao, masterList);
  }

  @Override
  public Pet getItem() throws IllegalAccessException
  {
    Pet pet = new PetBuilder()
        .setId(petId)
        .setName(name.getText())
        .setType(type.getText())
        .setBirthDate(DateConverter.stringToDate(birthDate.getText()))
        .setMaster(masterList.getItemAt(masterList.getSelectedIndex()))
        .build();

    return pet;
  }

  @Override
  protected boolean checkData()
  {
    boolean result = !name.getText().isEmpty() && !type.getText().isEmpty()
        && !birthDate.getText().isEmpty() && masterList.getSelectedIndex() != -1;

    return result;
  }

}
