package view;

import java.awt.*;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

import static javax.swing.SwingConstants.NORTH;

public class UserViewGUI {

  private final UserFrame frame;
  private final UserMenu menu;
  //Need to break into various different classes for each part of the GUI
  public UserViewGUI() {
    frame = new UserFrame();
    menu = new UserMenu();
    menu.addMenu("Routines");
    menu.addMenu("Create");
    menu.addMenu("Meal Plan");
//    menu.addMenuItem(1, "Create New Routine", );
//    menu.addMenuItem(1, "Add New Exercise", );
//    menu.addMenuItem(2, "Create New Meal Plan", );
//    menu.addMenuItem(2, "Edit Meal Plan", );
    frame.addToLayout(BorderLayout.NORTH, menu.getMenuBar());
    frame.visible();
  }

}
