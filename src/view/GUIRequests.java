package view;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.*;
/**
 * A class that handles the user inputs for the program.
 */
public class GUIRequests {

  /**
   * Prompts the user for a string response.
   * @param response The user's response.
   * @return The user's response as a string.
   */
  public String getResponse(String response) {
    return JOptionPane.showInputDialog(response);
  }

  /**
   * Prompts the user for a choice in the options.
   * @param response The list of available options.
   * @return The Object chosen.
   */
  public Object getDropdown(Object[] response) {
    return JOptionPane.showInputDialog(
            null,
            "Please choose an option:",
            "Select an Option",
            JOptionPane.QUESTION_MESSAGE,
            null,
            response,
            response[0]
    );
  }



}
