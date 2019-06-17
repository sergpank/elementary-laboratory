package homework26.view_component.dialog;

import homework26.dao.DateConverter;
import homework26.entity.Client;
import homework26.entity.Doctor;
import homework26.entity.Pet;
import homework26.entity.builder.DoctorBuilder;
import homework26.view_component.util.GBC;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorEditor extends EditorDialog<Doctor>
{
  protected long doctorId;

  protected JTextField name;
  protected JTextField surname;
  protected JTextField phoneNr;
  protected JTextField birthDate;
  protected JList<String> patientList;

  public DoctorEditor(Frame parent)
  {
    super(parent);
  }

  @Override
  protected void init()
  {
    super.init();

    this.setLayout(new GridBagLayout());
    this.name = new JTextField(30);
    this.surname = new JTextField();
    this.phoneNr = new JTextField();
    this.birthDate = new JTextField();
    this.patientList = new JList<>();
    this.patientList.setVisibleRowCount(4);

    this.add(new JLabel("Name: "), new GBC(0, 0, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(name, new GBC(1, 0, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Surname: "), new GBC(0, 1, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(surname, new GBC(1, 1, 1, 1).setWeight(100, 0)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(new JLabel("Phone number: "), new GBC(0, 2, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(phoneNr, new GBC(1, 2, 1, 1).setWeight(100, 0)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(new JLabel("Birth date (YYYY-MM-DD): "), new GBC(0, 3, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(birthDate, new GBC(1, 3, 1, 1).setWeight(100, 0)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(new JLabel("Patient list: "), new GBC(0, 4, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(new JScrollPane(patientList), new GBC(1, 4, 1, 1)
        .setWeight(100, 100)
        .setAnchor(GBC.CENTER).setFill(GBC.BOTH).setInsets(5).setIpad(2, 2));

    this.add(okBtn, new GBC(0, 5, 1, 1)
        .setAnchor(GBC.EAST).setFill(GBC.NONE).setInsets(20, 5, 5, 5).setIpad(2, 2));

    this.add(cancelBtn, new GBC(1, 5, 1, 1)
        .setAnchor(GBC.WEST).setFill(GBC.NONE).setInsets(20, 5, 5, 5).setIpad(2, 2));
  }

  @Override
  public void setItem(Doctor item)
  {
    List<Pet> patients = null;
    if (item != null)
    {
      doctorId = item.getId();
      name.setText(item.getName());
      surname.setText(item.getSurname());
      phoneNr.setText(item.getPhoneNr());
      birthDate.setText(DateConverter.dateToString(item.getBirthDate()));
      patients = item.getPatients();
    }
    else
    {
      doctorId = 0;
      name.setText("");
      surname.setText("");
      phoneNr.setText("");
      birthDate.setText("");
      patients = new ArrayList<>();
    }
    DefaultListModel<String> listModel = new DefaultListModel<>();
    for (Pet pet : patients)
    {
      Client master = pet.getMaster();
      String str = String.format("%s (%s); master: %s %s (%s)",
          pet.getName(),
          pet.getType(),
          master != null ? master.getSurname() : "none",
          master != null ? master.getName().substring(0, 1) + "." : "none",
          master != null ? master.getPhoneNr() : "none");

      listModel.addElement(str);
    }
    patientList.setModel(listModel);
  }

  @Override
  public Doctor getItem() throws IllegalAccessException
  {
    Doctor doctor = new DoctorBuilder()
        .setId(doctorId)
        .setName(name.getText())
        .setSurname(surname.getText())
        .setPhoneNr(phoneNr.getText())
        .setBirthDate(DateConverter.stringToDate(birthDate.getText()))
        .build();

    return doctor;
  }

  @Override
  protected boolean checkData()
  {
    boolean result = !name.getText().isEmpty() && !surname.getText().isEmpty()
        && !phoneNr.getText().isEmpty() && !birthDate.getText().isEmpty();

    return result;
  }
}
