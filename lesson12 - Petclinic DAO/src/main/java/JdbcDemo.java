import dao.ClientDAO;
import entity.Address;
import entity.Client;

import java.sql.SQLException;
import java.util.Date;

public class JdbcDemo
{
  public static void main(String[] args) throws SQLException
  {
    Address address = new Address("Sadovaya", "14a", 55, 65000);
    Client client = new Client("Sergey", "Panko", address, new Date(), "+380-1234-56-78");

    ClientDAO clientDAO = new ClientDAO();

    clientDAO.create(client);
    System.out.println(client);

    Client dbClient = clientDAO.read(client.getId());
    System.out.println(client);

    System.out.println(client.equals(dbClient));
  }
}
