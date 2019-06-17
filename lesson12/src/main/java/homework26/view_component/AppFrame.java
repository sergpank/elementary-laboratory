package homework26.view_component;

import homework26.dao.*;

import homework26.entity.*;

import homework26.view_component.dialog.*;

import homework26.view_component.models.*;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AppFrame extends JFrame
{
  private ClientDao clientDao;
  private PetDao petDao;
  private DoctorDao doctorDao;
  private VisitDao visitDao;

  ClientEditor clientEditor;
  DoctorEditor doctorEditor;
  PetEditor petEditor;
  VisitEditor visitEditor;

  private JTable table;
  private JMenuItem showClients;
  private JMenuItem showPets;
  private JMenuItem showDoctors;
  private JMenuItem showVisits;
  private JMenuItem addClient;
  private JMenuItem addPet;
  private JMenuItem addDoctor;
  private JMenuItem addVisit;
  private JMenuItem editClient;
  private JMenuItem editPet;
  private JMenuItem editDoctor;
  private JMenuItem editVisit;
  private JMenuItem deleteClient;
  private JMenuItem deletePet;
  private JMenuItem deleteDoctor;
  private JMenuItem deleteVisit;

  public AppFrame(ClientDao clientDao, PetDao petDao, DoctorDao doctorDao, VisitDao visitDao)
  {
    this.clientDao = clientDao;
    this.petDao = petDao;
    this.doctorDao = doctorDao;
    this.visitDao = visitDao;

    clientEditor = new ClientEditor(this);
    doctorEditor = new DoctorEditor(this);
    petEditor = new PetEditor(this, clientDao);
    visitEditor = new VisitEditor(this, doctorDao, clientDao);

    init();
    setHandlers();

  }

  private void init()
  {
    table = new JTable();
    this.add(new JScrollPane(table));
    this.setMinimumSize(new Dimension(900, 200));

    JMenuBar menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);
    JMenu showMenu = new JMenu("Show");
    showClients = new JMenuItem("Show Clients");
    showPets = new JMenuItem("Show Pets");
    showDoctors = new JMenuItem("Show doctors");
    showVisits = new JMenuItem("Show visits");

    JMenu addMenu = new JMenu("Add");
    addClient = new JMenuItem("Add Client");
    addPet = new JMenuItem("Add pet");
    addDoctor = new JMenuItem("Add doctor");
    addVisit = new JMenuItem("Add visit");

    JMenu editMenu = new JMenu("Edit");
    editClient = new JMenuItem("Edit Client");
    editPet = new JMenuItem("Edit pet");
    editDoctor = new JMenuItem("Edit doctor");
    editVisit = new JMenuItem("Edit visit");

    JMenu deleteMenu = new JMenu("Delete");
    deleteClient = new JMenuItem("Delete Client");
    deletePet = new JMenuItem("Delete pet");
    deleteDoctor = new JMenuItem("Delete doctor");
    deleteVisit = new JMenuItem("Delete visit");

    showMenu.add(showClients);
    showMenu.add(showPets);
    showMenu.add(showDoctors);
    showMenu.add(showVisits);

    addMenu.add(addClient);
    addMenu.add(addPet);
    addMenu.add(addDoctor);
    addMenu.add(addVisit);

    editMenu.add(editClient);
    editMenu.add(editPet);
    editMenu.add(editDoctor);
    editMenu.add(editVisit);

    deleteMenu.add(deleteClient);
    deleteMenu.add(deletePet);
    deleteMenu.add(deleteDoctor);
    deleteMenu.add(deleteVisit);

    menuBar.add(showMenu);
    menuBar.add(addMenu);
    menuBar.add(editMenu);
    menuBar.add(deleteMenu);

    showClients();
  }

  private void setHandlers()
  {
    showClients.addActionListener(e -> {
      showClients();
    });
    showDoctors.addActionListener(e -> {
      showDoctors();
    });
    showPets.addActionListener(e -> {
      showPets();
    });
    showVisits.addActionListener(e -> {
      showVisits();
    });
    addClient.addActionListener(e -> {
      addClient();
      showClients();
    });

    addDoctor.addActionListener(e -> {
      addDoctor();
      showDoctors();
    });

    addPet.addActionListener(e -> {
      addPet();
      showPets();
    });

    addVisit.addActionListener(e -> {
      addVisit();
      showVisits();
    });

    editClient.addActionListener(e -> {
      editClient();
      showClients();
    });

    editDoctor.addActionListener(e -> {
      editDoctor();
      showDoctors();
    });

    editPet.addActionListener(e -> {
      editPet();
      showPets();
    });

    editVisit.addActionListener(e -> {
      editVisit();
      showVisits();
    });

    deleteClient.addActionListener(e -> {
      removeClient();
      showClients();
    });

    deleteDoctor.addActionListener(e -> {
      removeDoctor();
      showDoctors();
    });

    deletePet.addActionListener(e -> {
      removePet();
      showPets();
    });

    deleteVisit.addActionListener(e -> {
      removeVisit();
      showVisits();
    });
  }

  private void showClients()
  {
    setTitle("Client list");

    List<Client> clientList = clientDao.read();
    table.setModel(new ClientTableModel(clientList));

    int rowHeight = table.getFont().getSize() * 2;
    for (int i = 0; i < clientList.size(); i++)
    {
      int size = clientList.get(i).getPets().size();
      size = size == 0 ? 1 : size;
      table.setRowHeight(i, size * rowHeight);
    }

    table.getColumnModel().getColumn(5).setMinWidth(200);

    showVisits.setEnabled(true);
    showDoctors.setEnabled(true);
    showPets.setEnabled(true);
    showClients.setEnabled(false);

    editVisit.setEnabled(false);
    editDoctor.setEnabled(false);
    editPet.setEnabled(false);
    editClient.setEnabled(true);

    deleteVisit.setEnabled(false);
    deleteDoctor.setEnabled(false);
    deleteClient.setEnabled(true);
    deletePet.setEnabled(false);

    pack();
  }

  private void showDoctors()
  {
    setTitle("Doctor list");

    List<Doctor> doctorList = doctorDao.read();
    table.setModel(new DoctorTableModel(doctorList));

    showVisits.setEnabled(true);
    showDoctors.setEnabled(false);
    showPets.setEnabled(true);
    showClients.setEnabled(true);

    editVisit.setEnabled(false);
    editDoctor.setEnabled(true);
    editPet.setEnabled(false);
    editClient.setEnabled(false);

    deleteVisit.setEnabled(false);
    deleteDoctor.setEnabled(true);
    deleteClient.setEnabled(false);
    deletePet.setEnabled(false);

    pack();
  }

  private void showPets()
  {
    setTitle("Pet list");

    List<Pet> petList = petDao.read();
    table.setModel(new PetTableModel(petList));

    showVisits.setEnabled(true);
    showDoctors.setEnabled(true);
    showPets.setEnabled(false);
    showClients.setEnabled(true);

    editVisit.setEnabled(false);
    editDoctor.setEnabled(false);
    editPet.setEnabled(true);
    editClient.setEnabled(false);

    deleteVisit.setEnabled(false);
    deleteDoctor.setEnabled(false);
    deleteClient.setEnabled(false);
    deletePet.setEnabled(true);

    pack();
  }

  private void showVisits()
  {
    setTitle("Visit list");

    List<Visit> visitList = visitDao.read();

    table.setModel(new VisitTableModel(visitList));

    showVisits.setEnabled(false);
    showDoctors.setEnabled(true);
    showPets.setEnabled(true);
    showClients.setEnabled(true);

    editVisit.setEnabled(true);
    editDoctor.setEnabled(false);
    editPet.setEnabled(false);
    editClient.setEnabled(false);

    deleteVisit.setEnabled(true);
    deleteDoctor.setEnabled(false);
    deleteClient.setEnabled(false);
    deletePet.setEnabled(false);

    pack();
  }


  private void addClient()
  {
    clientEditor.setItem(null);

    if (clientEditor.showDialog("Add client"))
    {
      try
      {
        clientDao.create(clientEditor.getItem());
      }
      catch (IllegalAccessException e)
      {
        JOptionPane.showMessageDialog(null, "An item was not created!",
            "Warning", JOptionPane.WARNING_MESSAGE);
      }
    }
  }

  private void addPet()
  {
    petEditor.setItem(null);

    int confirm = JOptionPane.showConfirmDialog(null,
        "You should add the client first.\n Continue?",
        "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

    if (confirm == JOptionPane.OK_OPTION)
    {
      if (petEditor.showDialog("Add pet"))
      {
        try
        {
          petDao.create(petEditor.getItem());
        }
        catch (IllegalAccessException e)
        {
          JOptionPane.showMessageDialog(null, "An item was not created!",
              "Warning", JOptionPane.WARNING_MESSAGE);
        }
      }
    }
  }

  private void addVisit()
  {
    visitEditor.setItem(null);

    if (visitEditor.showDialog("Add visit"))
    {
      try
      {
        visitDao.create(visitEditor.getItem());
      }
      catch (IllegalAccessException e)
      {
        JOptionPane.showMessageDialog(null, "An item was not created!",
            "Warning", JOptionPane.WARNING_MESSAGE);
      }
    }

  }

  private void editClient()
  {
    int row = getSelectedRow("Choose a row to update");

    if (row > -1 && table.getModel() instanceof ClientTableModel)
    {
      Client client = ((ClientTableModel) table.getModel()).getClient(row);
      clientEditor.setItem(client);
      if (clientEditor.showDialog("Edit client"))
      {
        try
        {
          clientDao.update(clientEditor.getItem());
        }
        catch (IllegalAccessException e)
        {
          JOptionPane.showMessageDialog(null, "An item was not updated!",
              "Warning", JOptionPane.WARNING_MESSAGE);
        }
      }
    }
  }

  private void editDoctor()
  {
    int row = getSelectedRow("Choose a row to update");

    if (row > -1 && table.getModel() instanceof DoctorTableModel)
    {
      Doctor doctor = ((DoctorTableModel) table.getModel()).getDoctor(row);
      doctorEditor.setItem(doctor);
      if (doctorEditor.showDialog("Edit doctor"))
      {
        try
        {
          doctorDao.update(doctorEditor.getItem());
        }
        catch (IllegalAccessException e)
        {
          JOptionPane.showMessageDialog(null, "An item was not updated!",
              "Warning", JOptionPane.WARNING_MESSAGE);
        }
      }
    }
  }

  private void editPet()
  {
    int row = getSelectedRow("Choose a row to update");

    if (row > -1 && table.getModel() instanceof PetTableModel)
    {
      Pet pet = ((PetTableModel) table.getModel()).getPet(row);
      petEditor.setItem(pet);
      if (petEditor.showDialog("Edit pet"))
      {
        try
        {
          petDao.update(petEditor.getItem());
        }
        catch (IllegalAccessException e)
        {
          JOptionPane.showMessageDialog(null, "An item was not updated!",
              "Warning", JOptionPane.WARNING_MESSAGE);
        }
      }
    }
  }

  private void editVisit()
  {
    int row = getSelectedRow("Choose a row to update");

    if (row > -1 && table.getModel() instanceof VisitTableModel)
    {
      Visit visit = ((VisitTableModel) table.getModel()).getVisit(row);
      visitEditor.setItem(visit);
      if (visitEditor.showDialog("Edit Visit"))
      {
        try
        {
          visitDao.update(visitEditor.getItem());
        }
        catch (IllegalAccessException e)
        {
          JOptionPane.showMessageDialog(null, "An item was not updated!",
              "Warning", JOptionPane.WARNING_MESSAGE);
        }
      }
    }
  }

  private void addDoctor()
  {
    doctorEditor.setItem(null);

    if (doctorEditor.showDialog("Add doctor"))
    {
      try
      {
        doctorDao.create(doctorEditor.getItem());
      }
      catch (IllegalAccessException e)
      {
        JOptionPane.showMessageDialog(null, "An item was not created!",
            "Warning", JOptionPane.WARNING_MESSAGE);
      }
    }
  }

  private void removePet()
  {
    int row = getSelectedRow("Choose a row to delete");

    if (row > -1 && table.getModel() instanceof PetTableModel)
    {
      Pet pet = ((PetTableModel) table.getModel()).getPet(row);
      petDao.delete(pet.getId());
    }
  }

  private void removeDoctor()
  {
    int row = getSelectedRow("Choose a row to delete");

    if (row > -1 && table.getModel() instanceof DoctorTableModel)
    {
      Doctor doctor = ((DoctorTableModel) table.getModel()).getDoctor(row);
      doctorDao.delete(doctor.getId());
    }
  }

  private void removeClient()
  {
    int row = getSelectedRow("Choose a row to delete");

    if (row > -1 && table.getModel() instanceof ClientTableModel)
    {
      Client client = ((ClientTableModel) table.getModel()).getClient(row);
      clientDao.delete(client.getId());
    }
  }

  private void removeVisit()
  {
    int row = getSelectedRow("Choose a row to delete");

    if (row != -1 && table.getModel() instanceof VisitTableModel)
    {
      Visit visit = ((VisitTableModel) table.getModel()).getVisit(row);
      visitDao.delete(visit.getId());
    }
  }

  private int getSelectedRow(String message)
  {
    int row = table.getSelectedRow();

    if (row == -1)
    {
      JOptionPane.showMessageDialog(this,
          message, "Message",
          JOptionPane.WARNING_MESSAGE);

    }

    return row;
  }

}
