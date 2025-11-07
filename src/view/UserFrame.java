package view;

import java.awt.*;

import javax.swing.*;

public class UserFrame {

  private final JFrame frame;
  public UserFrame() {
    frame = new JFrame("PUMP");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    frame.setLayout(new BorderLayout());
  }

  public JFrame getFrame() {
    return frame;
  }

  public void addToLayout(Object b, Component o) {
    frame.add(o, b);
  }

  public void visible() {
    frame.setVisible(true);
  }


}
