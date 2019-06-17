package homework26;

import homework26.dao.ClientDao;
import homework26.dao.DoctorDao;
import homework26.dao.PetDao;
import homework26.dao.VisitDao;
import homework26.util.DbSQLiteUtil;
import homework26.view_component.AppFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class App
{
  private static final Logger logger = LogManager.getLogger(App.class);

  public static void main(String[] args) throws IllegalAccessException
  {
    DbSQLiteUtil.initDb();

    ClientDao clientDao = new ClientDao(DbSQLiteUtil::getConnectionFromPool);
    PetDao petDao = new PetDao(DbSQLiteUtil::getConnectionFromPool);
    DoctorDao doctorDao = new DoctorDao(DbSQLiteUtil::getConnectionFromPool);
    VisitDao visitDao = new VisitDao(DbSQLiteUtil::getConnectionFromPool);

    EventQueue.invokeLater(() -> {
      AppFrame frame = new AppFrame(clientDao, petDao, doctorDao, visitDao);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });

  }
}
