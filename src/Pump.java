import javax.swing.*;

import view.UserViewGUI;

/**
 * The class made to run the program.
 */
public class Pump {
  /**
   * The main function for running the application.
   * @param args
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(UserViewGUI::new);
  }
}
