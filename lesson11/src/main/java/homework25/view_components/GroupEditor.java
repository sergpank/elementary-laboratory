package homework25.view_components;

import homework25.dao.RoleDao;
import homework25.models.Group;
import homework25.models.Role;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GroupEditor extends JPanel
{
  private JDialog dialog;
  private JFrame parent;
  private RoleDao roleDao;
  private JTextField name;
  private JLabel groupId;
  private JList<Role> roles;
  private JButton okBtn;
  private JButton cancelBtn;
  private boolean dialogResult;

  public GroupEditor(JFrame parent, RoleDao roleDao)
  {
    this.parent = parent;

    this.roleDao = roleDao;

    init();

    setHandlers();
  }

  private void init()
  {
    okBtn = new JButton("Commit");
    cancelBtn = new JButton("Cancel");
    name = new JTextField();
    name.setColumns(25);

    Box basePanel = new Box(BoxLayout.Y_AXIS);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 2));
    panel.add(new JLabel("Group Id:  "));
    groupId = new JLabel("0");
    panel.add(groupId);
    panel.add(new JLabel("Group name:  "));
    panel.add(name);

    basePanel.add(panel);

    panel = new JPanel();
    panel.setLayout(new GridLayout(1, 1));
    panel.add(new JLabel("Roles: "));
    roles = new JList<>();
    roles.setVisibleRowCount(4);
    panel.add(new JScrollPane(roles));

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

  public void setGroup(Group group)
  {
    this.name.setText(group.getName());
    this.groupId.setText(group.getId() + "");

    setRoles(group);
  }

  public Group getGroup()
  {
    Group group = new Group(Long.parseLong(this.groupId.getText()),
        this.name.getText());
    group.setRoles(roles.getSelectedValuesList());

    return group;
  }

  private void setRoles(Group current)
  {
    java.util.List<Role> rolesList = roleDao.read();

    List<Role> currentGroupRoles = current.getRoles();

    DefaultListModel<Role> listModel = new DefaultListModel<>();

    for (Role role : rolesList)
    {
      listModel.addElement(role);
    }

    roles.setModel(listModel);

    int[] selectedIn = new int[currentGroupRoles.size()];

    for (int i = 0; i < currentGroupRoles.size(); i++)
    {
      Role role = currentGroupRoles.get(i);
      int index = listModel.indexOf(role);
      if (index != -1)
      {
        selectedIn[i] = index;
      }
    }

    roles.setSelectedIndices(selectedIn);
  }
}
