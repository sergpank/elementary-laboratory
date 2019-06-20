package fedorov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MainFrame extends JFrame
{
  public void initUI()
  {
    this.setSize(960 ,640);
    this.setTitle("DB client");
    this.setLayout(new BorderLayout());

    JPanel connectionPanel = createConnectionPanel();
    JPanel tableListPanel = createTableListPanel();
    JPanel dataPanel = createDataPanel();

    this.add(connectionPanel, BorderLayout.NORTH);
    this.add(tableListPanel, BorderLayout.WEST);
    this.add(connectionPanel, BorderLayout.CENTER);

    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private JPanel createConnectionPanel()
  {
    JPanel panel = new JPanel(new FlowLayout());
    panel.add(new Label("JDBC URL: "));
    JTextField textField = new JTextField("enter path here");
    panel.add(textField);

    JButton openButton = new JButton("Open");
    panel.add(openButton);

    openButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection("jdbc:sqlite:data/lesson11.sqlite3");
      }
    });

    return panel;
  }

  private JPanel createTableListPanel()
  {
    JPanel panel = new JPanel();
    return panel;
  }

  private JPanel createDataPanel()
  {
    JPanel panel = new JPanel();
    return panel;
  }
}
