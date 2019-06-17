import dao.ClientDAO;
import dao.PetDAO;
import entity.Address;
import entity.Client;
import entity.Pet;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
    ClientDAO clientDAO = new ClientDAO();


      PetDAO petDAO = new PetDAO();
      /*Pet newPet = petDAO.create(new Pet("Koko",new Date(455554543),"chiken"));
      System.out.println(newPet);*/
      Pet pet = new Pet("Kokosik", new Date(155554541), "bird");
      pet.setId(17);
      System.out.println(petDAO.update(pet));
      System.out.println(petDAO.readAll());
      System.out.println(petDAO.delete(pet));
      System.out.println(petDAO.readAll());
  }
}
