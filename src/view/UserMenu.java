package view;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserMenu {
  private final JMenuBar menu;
  public UserMenu() {
    menu = new JMenuBar();
    menu.setVisible(true);
  }

  public void addMenu(String name) {
    JMenu newMenu = new JMenu(name);
    newMenu.addSeparator();
    menu.add(newMenu);
  }

  public void addMenuItem(int i, String name, ActionListener e) {
      JMenuItem item = new JMenuItem(name);
      item.addActionListener(e);
      this.menu.getMenu(i).add(item);
  }

  public JMenuBar getMenuBar() {
    return menu;
  }


}
