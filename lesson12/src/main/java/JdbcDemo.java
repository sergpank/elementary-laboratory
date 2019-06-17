import dao.ClientDAO;
import dao.DocDAO;
import dao.PetDAO;
import entity.Address;
import entity.Client;
import entity.Doc;
import entity.Pet;
import util.DbUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
   DocDAO docDAO = new DocDAO();
    Doc doc = new Doc("Kostia","Shylov",new Date(1986,10,29),"80630701721");
    System.out.println(docDAO.readAll());
  }
}
