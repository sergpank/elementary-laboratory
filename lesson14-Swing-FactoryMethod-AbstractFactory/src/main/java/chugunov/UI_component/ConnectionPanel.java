package chugunov.UI_component;

import javax.swing.*;
import java.awt.*;

public class ConnectionPanel extends JPanel
{
  private JTextField pathField;
  private JButton openButton;

  public ConnectionPanel()
  {
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    JLabel label = new JLabel("JDBC URL : ");
    this.add(label);

    pathField = new JTextField("insert jdbc path here", 32);

    this.add(pathField);

    openButton = new JButton("Connect");

    add(openButton);
  }

  public JTextField getPathField()
  {
    return pathField;
  }

  public JButton getOpenButton()
  {
    return openButton;
  }
}
