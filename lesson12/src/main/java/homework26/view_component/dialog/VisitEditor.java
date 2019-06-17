package homework26.view_component.dialog;

import homework26.dao.ClientDao;
import homework26.dao.DateConverter;
import homework26.dao.DoctorDao;
import homework26.dao.PetDao;
import homework26.entity.Client;
import homework26.entity.Doctor;
import homework26.entity.Pet;
import homework26.entity.Visit;
import homework26.entity.builder.VisitBuilder;
import homework26.view_component.util.GBC;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitEditor extends EditorDialog<Visit>
{
  protected long visitId;

  protected DoctorDao doctorDao;
  //  protected PetDao petDao;
  protected ClientDao clientDao;

  protected JTextField visitDate;
  protected JTextField charge;
  protected JTextArea description;
  protected JComboBox<Doctor> doctorList;
  protected JComboBox<Pet> patientList;
  protected JComboBox<Client> clientList;
  protected JLabel doctor;
  protected JLabel patient;
  protected JLabel client;

  public VisitEditor(Frame parent, DoctorDao doctorDao, ClientDao clientDao)
  {
    super(parent);

    this.doctorDao = doctorDao;
    this.clientDao = clientDao;
  }

  @Override
  protected void init()
  {
    super.init();

    this.setLayout(new GridBagLayout());

    this.visitDate = new JTextField(30);
    this.charge = new JTextField();
    this.description = new JTextArea();
    this.doctorList = new JComboBox<>();
    this.doctor = new JLabel("none");
    this.patientList = new JComboBox<>();
    this.patient = new JLabel("none");
    this.clientList = new JComboBox<>();
    this.client = new JLabel("none");


    this.add(new JLabel("Visit date: "), new GBC(0, 0, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(visitDate, new GBC(1, 0, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER)
        .setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Patient: "), new GBC(0, 1, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(patient, new GBC(1, 1, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER)
        .setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Patient list: "), new GBC(0, 2, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(patientList, new GBC(1, 2, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER)
        .setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Doctor: "), new GBC(0, 3, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(doctor, new GBC(1, 3, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER)
        .setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Doctor list: "), new GBC(0, 4, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(doctorList, new GBC(1, 4, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER)
        .setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Client (choose a client first): "),
        new GBC(0, 5, 1, 1)
            .setAnchor(GBC.EAST).setInsets(5));

    this.add(client, new GBC(1, 5, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER)
        .setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Client list: "), new GBC(0, 6, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(clientList, new GBC(1, 6, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER)
        .setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    this.add(new JLabel("Charge: "), new GBC(0, 7, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(charge, new GBC(1, 7, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER)
        .setFill(GBC.HORIZONTAL).setIpad(2, 2).setInsets(5));

    JLabel descriptionLabel = new JLabel("Description: ");
    descriptionLabel.setHorizontalAlignment(JLabel.CENTER);

    this.add(descriptionLabel, new GBC(0, 8, 2, 1)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5));

    this.add(description, new GBC(0, 9, 2, 1)
        .setWeight(100, 100).setFill(GBC.BOTH).setInsets(5));

    this.add(okBtn, new GBC(0, 10, 1, 1)
        .setAnchor(GBC.EAST).setFill(GBC.NONE).setInsets(20, 5, 5, 5).setIpad(2, 2));

    this.add(cancelBtn, new GBC(1, 10, 1, 1)
        .setAnchor(GBC.WEST).setFill(GBC.NONE).setInsets(20, 5, 5, 5).setIpad(2, 2));
  }

  @Override
  protected void setHandlers()
  {
    super.setHandlers();

    doctorList.addActionListener(e -> {
      int index = doctorList.getSelectedIndex();
      if (index != -1)
      {
        doctor.setText(doctorList.getItemAt(doctorList.getSelectedIndex()).toString());
      }
      else
      {
        doctor.setText("none");
      }

    });

    patientList.addActionListener(e -> {
      int index = patientList.getSelectedIndex();
      if (index != -1)
      {
        patient.setText(patientList.getItemAt(patientList.getSelectedIndex()).toString());
      }
      else
      {
        patient.setText("none");
      }

    });

    clientList.addActionListener(e -> {
      int index = clientList.getSelectedIndex();
      if (index != -1)
      {
        Client currentClient = clientList.getItemAt(clientList.getSelectedIndex());
        setPatients(currentClient.getPets(), null);
        client.setText(currentClient.toString());
      }
      else
      {
        setPatients(new ArrayList<>(), null);
        client.setText("none");
      }

    });
  }

  @Override
  public void setItem(Visit item)
  {
    Doctor currentDoc = null;
    Pet currentPet = null;
    Client currentClient = null;

    if (item != null)
    {
      visitId = item.getId();
      visitDate.setText(DateConverter.dateToString(item.getVisitDate()));
      charge.setText(item.getCharge() + "");
      description.setText(item.getDescription());

      currentDoc = item.getDoctor();
      currentPet = item.getPatient();
      currentClient = item.getClient();

      patient.setText(currentPet != null ? currentPet.toString() : "none");
      doctor.setText(currentDoc != null ? currentDoc.toString() : "none");
      client.setText(currentClient != null ? currentClient.toString() : "none");

      if (currentClient != null)
      {
        currentClient = clientDao.read(currentClient.getId());

        setPatients(currentClient.getPets(), currentPet);
      }
    }
    else
    {
      visitId = 0;
      visitDate.setText(DateConverter.dateToString(LocalDate.now()));
      charge.setText("0");
      description.setText("");
      patient.setText("none");
      doctor.setText("none");
      client.setText("none");
    }

    setComboItems(currentDoc, doctorDao, doctorList);
    setComboItems(currentClient, clientDao, clientList);
  }

  @Override
  public Visit getItem() throws IllegalAccessException
  {
    Doctor currentDoc = doctorList.getItemAt(doctorList.getSelectedIndex());
    Pet currentPet = patientList.getItemAt(patientList.getSelectedIndex());
    Client currentClient = clientList.getItemAt(clientList.getSelectedIndex());

    Visit visit = new VisitBuilder()
        .setId(visitId)
        .setVisitDate(DateConverter.stringToDate(visitDate.getText()))
        .setCharge(Long.parseLong(charge.getText()))
        .setDescription(description.getText())
        .setPatient(currentPet)
        .setDoctor(currentDoc)
        .setClient(currentClient)
        .build();

    return visit;
  }

  @Override
  protected boolean checkData()
  {
    boolean result = doctorList.getSelectedIndex() != -1
        && patientList.getSelectedIndex() != -1
        && clientList.getSelectedIndex() != -1
        && !visitDate.getText().isEmpty()
        && !charge.getText().isEmpty();

    return result;
  }

  private void setPatients(List<Pet> pets, Pet current)
  {
    DefaultComboBoxModel<Pet> comboBoxModel = new DefaultComboBoxModel<>();

    for (Pet item : pets)
    {
      comboBoxModel.addElement(item);
    }

    patientList.setModel(comboBoxModel);

    if (current == null)
    {
      patientList.setSelectedIndex(-1);
    }
    else if (comboBoxModel.getSize() > 0)
    {
      comboBoxModel.setSelectedItem(current);
    }
  }

}
