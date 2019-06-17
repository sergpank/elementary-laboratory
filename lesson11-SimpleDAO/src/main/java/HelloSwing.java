import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloSwing
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Hello Swing!");
    frame.setSize(300, 300);
    frame.setLayout(new BorderLayout());

    frame.getContentPane().add(createButton("Center"), BorderLayout.CENTER);
    frame.getContentPane().add(createButton("North"), BorderLayout.NORTH);
    frame.getContentPane().add(createButton("South"), BorderLayout.SOUTH);
    frame.getContentPane().add(createButton("East"), BorderLayout.EAST);
    frame.getContentPane().add(createButton("West"), BorderLayout.WEST);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
  }

  private static JButton createButton(String label)
  {
    JButton button = new JButton("Hello Button! (" + label + ")");

    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        JOptionPane.showMessageDialog(null, "Hello Message Dialog! --> " + label);
      }
    });

    return button;
  }
}
