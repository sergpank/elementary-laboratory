package homework26.view_component.dialog;

import homework26.dao.AbstractDao;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class EditorDialog<T> extends JPanel
{
  protected JDialog dialog;
  protected Frame parent;

  protected JButton okBtn;
  protected JButton cancelBtn;
  protected boolean dialogResult;

  public EditorDialog(Frame parent)
  {
    this.parent = parent;

    init();
    setHandlers();
  }

  public boolean showDialog(String title)
  {
    dialogResult = false;
    if (dialog == null)
    {
      dialog = new JDialog(parent, true);
      dialog.add(this);
      dialog.getRootPane().setDefaultButton(okBtn);
      dialog.pack();
      dialog.repaint();
    }
    dialog.setTitle(title);
    dialog.repaint();
    dialog.setVisible(true);

    return dialogResult;
  }

  protected void init()
  {
    okBtn = new JButton("Ok");
    cancelBtn = new JButton("Cancel");
  }

  protected void setHandlers()
  {
    okBtn.addActionListener(e -> {
      if (checkData())
      {
        dialogResult = true;
        dialog.setVisible(false);
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Please, fill in all the fields in the form",
            "Warning", JOptionPane.WARNING_MESSAGE);
      }
    });
    cancelBtn.addActionListener(e -> {
      dialogResult = false;
      dialog.setVisible(false);
    });
  }

  public abstract void setItem(T item);

  public abstract T getItem() throws IllegalAccessException;

  protected boolean checkData()
  {
    return true;
  }

  protected static <T> void setComboItems(T current, AbstractDao<T> dao, JComboBox<T> combo)
  {
    List<T> items = dao.read();

    DefaultComboBoxModel<T> comboBoxModel = new DefaultComboBoxModel<>();

    for (T item : items)
    {
      comboBoxModel.addElement(item);
    }

    combo.setModel(comboBoxModel);

    if (current == null)
    {
      combo.setSelectedIndex(-1);
    }
    else if (comboBoxModel.getSize() > 0)
    {
      comboBoxModel.setSelectedItem(current);
    }
  }
}
