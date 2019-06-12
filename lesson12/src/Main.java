import java.sql.SQLException;

public class Main
{
  public static void main(String[] args) throws SQLException
  {
    ClientDAO clientDAO = new ClientDAO();
    PetDAO petDAO = new PetDAO();
    DoctorDAO doctorDAO = new DoctorDAO();
    VisitDAO visitDAO = new VisitDAO();
    AddressDAO addressDAO = new AddressDAO();

    //addressDAO.create(new Address("Deribasovska", 120, 42, 111));
    //addressDAO.create(new Address("Bocharoba", 12, 55, 143));
    //clientDAO.create(new Client("Vasiliy", "Petrenko", 114, "22 november 1996", "380672834369", new ArrayList<Pet>()));
    //clientDAO.create(new Client("Daniil", "Sobolev", 115, "12 november 1976", "380672624369", new ArrayList<Pet>()));
    //System.out.println(clientDAO.read(2));
    /*ArrayList<Client> show = clientDAO.read();
    for(Client a : show)
    {
      System.out.println(a);
    }
    */
    //clientDAO.update(new Client("Daniil", "Sobolev", 115, "12 december 2003", "380672624369"), 3);
    //  clientDAO.delete(5);
    //System.out.println(addressDAO.read(114));
    /*ArrayList<Address> show = addressDAO.read();
    for(Address a : show)
    {
      System.out.println(a);
    }*/
    //addressDAO.update(new Address("Bsdsdsdsdsocharoddba", 131111112, 53111115, 14111113), 116);
    //addressDAO.delete(116);
    //petDAO.create(new Pet("Betty", "12.06.2017","dog", 2));
    //System.out.println(petDAO.read(1));
    //petDAO.create(new Pet("Max", "02.08.2047","dog", 2));
    /*ArrayList<Pet> show = petDAO.read();
    for(Pet a : show)
    {
      System.out.println(a);
    }*/
    //petDAO.update(new Pet("Maximus", "02.08.2027","dog", 2), 2);
    //petDAO.delete(2);
    //doctorDAO.create(new Doctor("Vladimir","Marienko","05.11.1978","380636482639", new ArrayList<Pet>()));
    //System.out.println(doctorDAO.read(2));
    //doctorDAO.create(new Doctor("Anna","Generatesurname","12.12.1822","380636729639", new ArrayList<Pet>()));
    /*ArrayList<Doctor> show = doctorDAO.read();
    for(Doctor a : show)
    {
      System.out.println(a);
    }*/
    //doctorDAO.update(new Doctor("Kristina","Kot","12.12.1822","380636729639", new ArrayList<Pet>()),3);
    //doctorDAO.delete(3);
    //visitDAO.create(new Visit("11.04.2017", 2, 1, 2, "test", "nothing"));
    //visitDAO.create(new Visit("22.11.2018", 2, 1, 2, "test2", "sameasfirsttime"));
    //System.out.println(visitDAO.read(2));
    /*ArrayList<Visit> show = visitDAO.read();
    for(Visit a : show)
    {
      System.out.println(a);
    }*/
    //visitDAO.update(new Visit("02.12.2018", 2, 1, 2, "test2", "sameasfirsttime"), 2);
    //visitDAO.delete(2);


    DAO.connection.close();
  }
}
