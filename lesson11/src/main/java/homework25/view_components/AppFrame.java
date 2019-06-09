package homework25.view_components;

import homework25.dao.GroupDao;
import homework25.dao.RoleDao;
import homework25.dao.UserDao;
import homework25.models.Group;
import homework25.models.Role;
import homework25.models.User;
import homework25.models.ValueObject;

import javax.swing.*;
import java.util.List;

public class AppFrame extends JFrame
{
  JTable table;

  UserDao userDao;
  GroupDao groupDao;
  RoleDao roleDao;

  JScrollPane scrollPane;


  JMenuItem showUsers;
  JMenuItem showGroups;
  JMenuItem showRoles;

  JMenuItem addUser;
  JMenuItem addGroup;
  JMenuItem addRole;

  JMenuItem editUser;
  JMenuItem editGroup;
  JMenuItem editRole;

  JMenuItem removeUser;
  JMenuItem removeGroup;
  JMenuItem removeRole;

  GroupEditor editGroupDialog;
  UserEditor editUserDialog;
  RoleEditor editRoleDialog;

  public AppFrame(GroupDao groupDao, UserDao userDao, RoleDao roleDao)
  {
    this.userDao = userDao;
    this.groupDao = groupDao;
    this.roleDao = roleDao;

    init();

    setHandlers();

    editGroupDialog = new GroupEditor(this, roleDao);
    editUserDialog = new UserEditor(this, groupDao);
    editRoleDialog = new RoleEditor(this, groupDao);

    showUsers();

  }

  private void init()
  {

    table = new JTable();
    add(new JScrollPane(table));


    JMenuBar menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);
    JMenu menuView = new JMenu("View");
    JMenu addMenu = new JMenu("Add");
    JMenu editMenu = new JMenu("Edit");
    menuBar.add(menuView);
    menuBar.add(addMenu);
    menuBar.add(editMenu);

    showUsers = new JMenuItem("Show users");
    showGroups = new JMenuItem("Show groups");
    showRoles = new JMenuItem("Sow roles");
    menuView.add(showUsers);
    menuView.add(showGroups);
    menuView.add(showRoles);

    addUser = new JMenuItem("Add user");
    addGroup = new JMenuItem("Add group");
    addRole = new JMenuItem("Add role");
    addMenu.add(addUser);
    addMenu.add(addGroup);
    addMenu.add(addRole);

    editUser = new JMenuItem("Edit selected user");
    editGroup = new JMenuItem("Edit selected group");
    editRole = new JMenuItem("Edit selected role");
    editMenu.add(editUser);
    editMenu.add(editGroup);
    editMenu.add(editRole);
    editMenu.addSeparator();

    removeUser = new JMenuItem("Remove user");
    removeGroup = new JMenuItem("Remove group");
    removeRole = new JMenuItem("Remove role");
    editMenu.add(removeUser);
    editMenu.add(removeGroup);
    editMenu.add(removeRole);
  }

  private void setHandlers()
  {
    showUsers.addActionListener(e -> {
      showUsers();
    });

    showGroups.addActionListener(e -> {
      showGroups();
    });

    showRoles.addActionListener(e -> {
      showRoles();
    });

    addUser.addActionListener(e -> {
      addUser();
      showUsers();
    });

    addRole.addActionListener(e -> {
      addRole();
      showRoles();
    });

    addGroup.addActionListener(e -> {
      addGroup();
      showGroups();
    });

    editUser.addActionListener(e -> {
      editUser();
      showUsers();
    });

    editGroup.addActionListener(e -> {
      editGroup();
      showGroups();
    });

    editRole.addActionListener(e -> {
      editRole();
      showRoles();
    });

    removeUser.addActionListener(e -> {
      removeUser();
      showUsers();
    });

    removeGroup.addActionListener(e -> {
      removeGroup();
      showGroups();
    });

    removeRole.addActionListener(e -> {
      removeRole();
      showRoles();
    });

  }

  private void showUsers()
  {
    table.setModel(new ItemsTableModel(userDao));

    showUsers.setEnabled(false);
    showGroups.setEnabled(true);
    showRoles.setEnabled(true);

    editUser.setEnabled(true);
    editGroup.setEnabled(false);
    editRole.setEnabled(false);

    removeUser.setEnabled(true);
    removeGroup.setEnabled(false);
    removeGroup.setEnabled(false);

    pack();

  }

  private void showGroups()
  {
    table.setModel(new ItemsTableModel(groupDao));

    showGroups.setEnabled(false);
    showUsers.setEnabled(true);
    showRoles.setEnabled(true);

    editGroup.setEnabled(true);
    editRole.setEnabled(false);
    editUser.setEnabled(false);

    removeGroup.setEnabled(true);
    removeUser.setEnabled(false);
    removeRole.setEnabled(false);

    pack();
  }

  private void showRoles()
  {
    table.setModel(new ItemsTableModel(roleDao));

    showRoles.setEnabled(false);
    showGroups.setEnabled(true);
    showUsers.setEnabled(true);

    editRole.setEnabled(true);
    editGroup.setEnabled(false);
    editUser.setEnabled(false);

    removeRole.setEnabled(true);
    removeUser.setEnabled(false);
    removeGroup.setEnabled(false);

    pack();
  }

  private void removeUser()
  {
    ValueObject item = getSelectedItem("Choose a row to delete");

    if (item instanceof User)
    {
      int confirm = JOptionPane.showConfirmDialog(this,
          "Are you sure to delete the user " + ((User) item).getLogin(), "Confirm action",
          JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
      if (confirm == JOptionPane.OK_OPTION)
      {
        userDao.delete(item.getId());

      }
    }
  }

  private void addUser()
  {
    int groupsCount = groupDao.count();
    if (groupsCount > 0)
    {
      editUserDialog.setUser(new User("", "", null));
      if (editUserDialog.showDialog("Add user"))
      {
        userDao.create(editUserDialog.getUser());
      }
    }
    else
    {
      JOptionPane.showMessageDialog(this,
          "You have to add a group first", "Message",
          JOptionPane.WARNING_MESSAGE);
    }
  }

  private void editUser()
  {
    ValueObject item = getSelectedItem("Choose a user to edit");
    if (item instanceof User)
    {
      User user = (User) item;
      editUserDialog.setUser(user);
      if (editUserDialog.showDialog("Edit user"))
      {
        userDao.update(editUserDialog.getUser());
      }
    }
  }

  private void addGroup()
  {
    editGroupDialog.setGroup(new Group(""));
    if (editGroupDialog.showDialog("Add group"))
    {
      groupDao.create(editGroupDialog.getGroup());
    }
  }

  private void editGroup()
  {
    ValueObject item = getSelectedItem("Choose a group to edit");

    if (item instanceof Group)
    {
      Group group = (Group) item;

      editGroupDialog.setGroup(group);
      if (editGroupDialog.showDialog("Edit group"))
      {
        groupDao.update(editGroupDialog.getGroup());
      }
    }
  }

  private void removeGroup()
  {
    ValueObject item = getSelectedItem("Choose a group to delete");

    if (item instanceof Group)
    {
      int confirm = JOptionPane.showConfirmDialog(this,
          "Are you sure to delete the group " + ((Group) item).getName(), "Confirm action",
          JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
      if (confirm == JOptionPane.OK_OPTION)
      {
        groupDao.delete(item.getId());
      }
    }
  }

  private void addRole()
  {
    editRoleDialog.setRole(new Role(""));
    if (editRoleDialog.showDialog("Add role"))
    {
      roleDao.create(editRoleDialog.getRole());
    }
  }

  private void editRole()
  {
    ValueObject item = getSelectedItem("Choose a role to edit");

    if (item instanceof Role)
    {
      Role role = (Role) item;

      editRoleDialog.setRole(role);
      if (editRoleDialog.showDialog("Edit role"))
      {
        roleDao.update(editRoleDialog.getRole());
      }
    }
  }

  private void removeRole()
  {
    ValueObject item = getSelectedItem("Choose a role to delete");

    if (item instanceof Role)
    {
      int confirm = JOptionPane.showConfirmDialog(this,
          "Are you sure to delete the role " + ((Role) item).getDescription(), "Confirm action",
          JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
      if (confirm == JOptionPane.OK_OPTION)
      {
        roleDao.delete(item.getId());
      }

    }
  }

  private ValueObject getSelectedItem(String warningMessage)
  {
    ValueObject result = null;

    int row = table.getSelectedRow();

    if (row == -1)
    {
      JOptionPane.showMessageDialog(this,
          warningMessage, "Message",
          JOptionPane.WARNING_MESSAGE);

    }
    else
    {
      result = ((ItemsTableModel) table.getModel()).getItem(row);
    }

    return result;
  }
}
