package homework25.view_components;

import homework25.dao.GroupDao;
import homework25.models.Group;
import homework25.models.Role;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RoleEditor extends JPanel
{
  private JDialog dialog;
  private JFrame parent;
  private GroupDao groupDao;

  private long roleId;

  private JTextField description;
  private JButton okBtn;
  private JButton cancelBtn;
  private JList<Group> groups;

  private boolean dialogResult;

  public RoleEditor(JFrame parent, GroupDao groupDao)
  {
    this.parent = parent;
    this.groupDao = groupDao;
    init();

    setHandlers();
  }

  private void init()
  {
    okBtn = new JButton("Commit");
    cancelBtn = new JButton("Cancel");
    description = new JTextField();
    description.setColumns(25);

    Box basePanel = new Box(BoxLayout.Y_AXIS);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 1));

    panel.add(new JLabel("Role description:  "));
    panel.add(description);

    basePanel.add(panel);

    panel = new JPanel();
    panel.setLayout(new GridLayout(1, 1));
    panel.add(new JLabel("Groups: "));
    groups = new JList<>();

    groups.setVisibleRowCount(4);
    panel.add(new JScrollPane(groups));

    basePanel.add(panel);

    this.setLayout(new BorderLayout());

    this.add(basePanel, BorderLayout.CENTER);

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
    dialog.setVisible(true);

    return dialogResult;
  }

  public void setRole(Role role)
  {
    this.description.setText(role.getDescription());
    this.roleId = role.getId();

    setGroups(role);
  }

  public Role getRole()
  {
    Role role = new Role(this.roleId, this.description.getText());
    role.setGroups(groups.getSelectedValuesList());
    return role;
  }

  private void setGroups(Role current)
  {
    List<Group> groupsList = groupDao.read();

    List<Group> currentRoleGroups = current.getGroups();

    DefaultListModel<Group> listModel = new DefaultListModel<>();

    for (Group group : groupsList)
    {
      listModel.addElement(group);
    }
    groups.setModel(listModel);

    int[] selectedIn = new int[currentRoleGroups.size()];

    for (int i = 0; i < currentRoleGroups.size(); i++)
    {
      Group gr = currentRoleGroups.get(i);
      int index = listModel.indexOf(gr);
      if (index != -1)
      {
        selectedIn[i] = index;
      }
    }

    groups.setSelectedIndices(selectedIn);
  }
}
