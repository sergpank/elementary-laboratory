public class Visit
{
  protected long id;
  protected String date;
  protected int doctor_id;
  protected int pet_id;
  protected int client_id;
  protected String description;
  protected String charge;

  public Visit(String date, int doctor_id, int pet_id, int client_id, String description, String charge)
  {
    this.date = date;
    this.doctor_id = doctor_id;
    this.pet_id = pet_id;
    this.client_id = client_id;
    this.description = description;
    this.charge = charge;
  }

  public Visit(long id, String date, int doctor_id, int pet_id, int client_id, String description, String charge)
  {
    this.id = id;
    this.date = date;
    this.doctor_id = doctor_id;
    this.pet_id = pet_id;
    this.client_id = client_id;
    this.description = description;
    this.charge = charge;
  }

  @Override
  public String toString()
  {
    return "Visit{" +
        "id=" + id +
        ", date='" + date + '\'' +
        ", doctor_id=" + doctor_id +
        ", pet_id=" + pet_id +
        ", client_id=" + client_id +
        ", description='" + description + '\'' +
        ", charge='" + charge + '\'' +
        '}';
  }
}
