public class Pet
{
  protected long id;
  protected String name;
  protected String date_of_birth;
  protected String type;
  protected int client_id;

  public Pet(String name, String date_of_birth, String type, int client_id)
  {
    this.name = name;
    this.date_of_birth = date_of_birth;
    this.type = type;
    this.client_id = client_id;
  }

  public Pet(long id, String name, String date_of_birth, String type, int client_id)
  {
    this.id = id;
    this.name = name;
    this.date_of_birth = date_of_birth;
    this.type = type;
    this.client_id = client_id;
  }

  @Override
  public String toString()
  {
    return "Pet{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", date_of_birth='" + date_of_birth + '\'' +
        ", type='" + type + '\'' +
        ", client_id=" + client_id +
        '}';
  }
}