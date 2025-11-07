package view;

import java.awt.*;

import controller.Controller;
import controller.GuiController;

public class UserViewGUI {

  private final Controller controller;
  private final UserFrame frame;
  private final UserMenu menu;
  //Need to break into various different classes for each part of the GUI
  public UserViewGUI() {
    controller = new GuiController();
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
