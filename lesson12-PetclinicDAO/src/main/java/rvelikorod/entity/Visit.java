package rvelikorod.entity;

import java.util.Date;

public class Visit
{
  private Long id;
  private Date date;
  private Doctor doctor;
  private Client client;
  private Pet pet;
  private String description;
  private Long charge;

  public Visit(Long id, Date date, Doctor doctor, Client client, Pet pet, String description, Long charge)
  {
    this.id = id;
    this.date = date;
    this.doctor = doctor;
    this.client = client;
    this.pet = pet;
    this.description = description;
    this.charge = charge;
  }
  public Visit(Date date, Doctor doctor, Client client, Pet pet, String description, Long charge)
  {
    this.date = date;
    this.doctor = doctor;
    this.client = client;
    this.pet = pet;
    this.description = description;
    this.charge = charge;
  }

  public Long getId()
  {
    return id;
  }

  public Date getDate()
  {
    return date;
  }

  public Doctor getDoctor()
  {
    return doctor;
  }

  public Client getClient()
  {
    return client;
  }

  public Pet getPet()
  {
    return pet;
  }

  public String getDescription()
  {
    return description;
  }

  public Long getCharge()
  {
    return charge;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public void setDoctor(Doctor doctor)
  {
    this.doctor = doctor;
  }

  public void setClient(Client client)
  {
    this.client = client;
  }

  public void setPet(Pet pet)
  {
    this.pet = pet;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public void setCharge(Long charge)
  {
    this.charge = charge;
  }

  @Override
  public String toString()
  {
    return "Visit{" +
        "id=" + id +
        ", date=" + date +
        ", doctor=" + doctor +
        ", client=" + client +
        ", pet=" + pet +
        ", description='" + description + '\'' +
        ", charge=" + charge +
        '}';
  }
}
