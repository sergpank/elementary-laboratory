import dao.ClientDAO;
import entity.Address;
import entity.Client;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
    ClientDAO clientDAO = new ClientDAO();

    Client client = clientDAO.read(1);
    client.setId(2);
    clientDAO.update(client);
    System.out.println(clientDAO.readAll());


  }
}
