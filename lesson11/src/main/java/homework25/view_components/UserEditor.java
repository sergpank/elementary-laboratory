package homework25.view_components;

import homework25.dao.GroupDao;
import homework25.models.Group;
import homework25.models.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserEditor extends JPanel
{
  private JDialog dialog;
  private JFrame parent;
  private GroupDao groupDao;
  private JTextField login;
  private JTextField password;
  private long userId;

  private JComboBox<Group> groups;

  private JButton okBtn;
  private JButton cancelBtn;
  private boolean dialogResult;

  public UserEditor(JFrame parent, GroupDao groupDao)
  {
    this.parent = parent;

    this.groupDao = groupDao;

    init();

    setHandlers();
  }

  private void init()
  {
    groups = new JComboBox<>();

    okBtn = new JButton("Commit");
    cancelBtn = new JButton("Cancel");

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));

    panel.add(new JLabel("Login"));
    login = new JTextField();
    login.setColumns(25);
    panel.add(login);

    panel.add(new JLabel("Password"));
    password = new JTextField();
    password.setColumns(25);
    panel.add(password);

    panel.add(new JLabel("Choose a group"));
    panel.add(groups);

    this.setLayout(new BorderLayout());

    this.add(panel, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();

    buttonPanel.add(okBtn);
    buttonPanel.add(cancelBtn);

    this.add(buttonPanel, BorderLayout.SOUTH);
  }

  private void setHandlers()
  {
    okBtn.addActionListener(e -> {
      dialogResult = true;
      dialog.setVisible(false);
    });

    cancelBtn.addActionListener(e -> {
      dialog.setVisible(false);
    });
  }

  public boolean showDialog(String title)
  {
    dialogResult = false;
    if (dialog == null)
    {
      dialog = new JDialog(parent, true);
      dialog.add(this);
      dialog.getRootPane().setDefaultButton(okBtn);
    }
    dialog.setTitle(title);
    dialog.pack();
    dialog.repaint();
    dialog.setVisible(true);

    return dialogResult;
  }

  public void setUser(User user)
  {
    login.setText(user.getLogin());
    password.setText(user.getPassword());
    userId = user.getId();

    setGroups(user.getGroup());
  }

  public User getUser()
  {
    return new User(userId,
        login.getText(),
        password.getText(),
        groups.getItemAt(groups.getSelectedIndex()));
  }

  private void setGroups(Group current)
  {
    List<Group> groupsList = groupDao.read();

    DefaultComboBoxModel<Group> comboModel = new DefaultComboBoxModel<>();
    for (int i = 0; i < groupsList.size(); i++)
    {
      Group group = groupsList.get(i);
      comboModel.addElement(group);
    }

    comboModel.setSelectedItem(current);
    groups.setModel(comboModel);

    if (current == null && comboModel.getSize() > 0)
    {
      groups.setSelectedIndex(0);
    }


  }
}

