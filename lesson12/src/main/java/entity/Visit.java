package entity;

import java.util.Date;

public class Visit
{
  private long id;
  private Date date;
  private Client client;
  private Doc doc;
  private Pet pet;
  private String description;
  private long charge;

  public Visit(long id, Date date, Client client, Doc doc, Pet pet, String description, long charge)
  {
    this.id = id;
    this.date = date;
    this.client = client;
    this.doc = doc;
    this.pet = pet;
    this.description = description;
    this.charge = charge;
  }

  public Visit(Date date, Client client, Doc doc, Pet pet, String description, long charge)
  {
    this.date = date;
    this.client = client;
    this.doc = doc;
    this.pet = pet;
    this.description = description;
    this.charge = charge;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public Client getClient()
  {
    return client;
  }

  public void setClient(Client client)
  {
    this.client = client;
  }

  public Doc getDoc()
  {
    return doc;
  }

  public void setDoc(Doc doc)
  {
    this.doc = doc;
  }

  public Pet getPet()
  {
    return pet;
  }

  public void setPet(Pet pet)
  {
    this.pet = pet;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public long getCharge()
  {
    return charge;
  }

  public void setCharge(long charge)
  {
    this.charge = charge;
  }

  @Override
  public String toString()
  {
    return "Visit{" +
        "id=" + id +
        ", date=" + date +
        ", client=" + client +
        ", doc=" + doc +
        ", pet=" + pet +
        ", description='" + description + '\'' +
        ", charge=" + charge +
        '}';
  }
}
