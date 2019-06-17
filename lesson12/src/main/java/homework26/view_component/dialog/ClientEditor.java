package homework26.view_component.dialog;

import homework26.dao.DateConverter;
import homework26.entity.Address;
import homework26.entity.Client;
import homework26.entity.builder.AddressBulder;
import homework26.entity.builder.ClientBuilder;
import homework26.view_component.dialog.EditorDialog;
import homework26.view_component.util.GBC;

import javax.swing.*;
import java.awt.*;

public class ClientEditor extends EditorDialog<Client>
{
  protected long clientId;
  protected long addressId;

  protected JTextField name;
  protected JTextField surname;
  protected JTextField phoneNr;
  protected JTextField birthDate;
  protected JTextField street;
  protected JTextField houseNr;
  protected JTextField apartmentNr;
  protected JTextField zip;

  public ClientEditor(Frame parent)
  {
    super(parent);
  }

  protected void init()
  {
    super.init();

    this.setLayout(new GridBagLayout());
    this.name = new JTextField(30);
    this.surname = new JTextField();
    this.phoneNr = new JTextField();
    this.birthDate = new JTextField();
    this.street = new JTextField();
    this.apartmentNr = new JTextField();
    this.houseNr = new JTextField();
    this.zip = new JTextField();

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

    JLabel addr = new JLabel("Address");
    addr.setHorizontalAlignment(JLabel.CENTER);

    this.add(addr, new GBC(0, 4, 2, 1)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5));

    this.add(new JLabel("Street: "), new GBC(0, 5, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(street, new GBC(1, 5, 1, 1).setWeight(100, 0)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(new JLabel("House number: "), new GBC(0, 6, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(houseNr, new GBC(1, 6, 1, 1).setWeight(100, 0)
        .setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(new JLabel("Apartment number: "), new GBC(0, 7, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(apartmentNr, new GBC(1, 7, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(new JLabel("Zip code: "), new GBC(0, 8, 1, 1)
        .setAnchor(GBC.EAST).setInsets(5));

    this.add(zip, new GBC(1, 8, 1, 1)
        .setWeight(100, 0).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setInsets(5).setIpad(2, 2));

    this.add(okBtn, new GBC(0, 9, 1, 1)
        .setAnchor(GBC.EAST).setFill(GBC.NONE).setInsets(20, 5, 5, 5).setIpad(2, 2));

    this.add(cancelBtn, new GBC(1, 9, 1, 1)
        .setAnchor(GBC.WEST).setFill(GBC.NONE).setInsets(20, 5, 5, 5).setIpad(2, 2));


  }

  @Override
  public void setItem(Client item)
  {
    if (item != null)
    {
      clientId = item.getId();
      name.setText(item.getName());
      surname.setText(item.getSurname());
      phoneNr.setText(item.getPhoneNr());
      birthDate.setText(DateConverter.dateToString(item.getBirthDate()));
      Address addr = item.getAddress();
      addressId = addr.getId();
      street.setText(addr.getStreet());
      houseNr.setText(addr.getHouseNr());
      apartmentNr.setText(addr.getAppartmentNr());
      zip.setText(addr.getZip() + "");
    }
    else
    {
      clientId = 0;
      name.setText("");
      surname.setText("");
      phoneNr.setText("");
      birthDate.setText("");

      addressId = 0;
      street.setText("");
      houseNr.setText("");
      apartmentNr.setText("");
      zip.setText("");
    }
  }

  @Override
  public Client getItem() throws IllegalAccessException
  {
    Address addr = new AddressBulder()
        .setId(this.addressId)
        .setStreet(street.getText())
        .setHouse(houseNr.getText())
        .setAppartment(apartmentNr.getText())
        .setZip(Integer.parseInt(zip.getText()))
        .build();
    Client client = new ClientBuilder()
        .setId(clientId)
        .setName(name.getText())
        .setSurname(surname.getText())
        .setPhoneNr(phoneNr.getText())
        .setBirthDate(DateConverter.stringToDate(birthDate.getText()))
        .setAddress(addr)
        .build();

    return client;
  }

  @Override
  protected boolean checkData()
  {
    boolean result = !name.getText().isEmpty() && !surname.getText().isEmpty()
        && !phoneNr.getText().isEmpty() && !birthDate.getText().isEmpty()
        && !street.getText().isEmpty() && !houseNr.getText().isEmpty()
        && !apartmentNr.getText().isEmpty() && !zip.getText().isEmpty();

    return result;
  }
}
