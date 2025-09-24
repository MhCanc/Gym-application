package view;

import java.awt.*;
import java.time.YearMonth;
import java.time.ZoneId;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class UserViewGUI {

  private final JFrame frame;
  private YearMonth currentMonth;
  private String selectedCalendar;

  private final JMenuBar options;

  private final JMenu create;
  private final JMenu routines;

  private final JMenu mealPlan;

  public UserViewGUI() {
    frame = new JFrame("PUMP");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1980, 1080);
    frame.setLayout(new BorderLayout());
    routines = new JMenu("Routines");
    create = new JMenu("Create");
    create.add(new JMenuItem("Build a new routine"));
    create.add(new JMenuItem("Add a new Exercise"));
    mealPlan = new JMenu("Meal Plans");
    mealPlan.add(new JMenuItem("Create New Meal Plan"));
    mealPlan.add(new JMenuItem("Edit Meal Plans"));
    options = new JMenuBar();
    options.add(routines);
    options.add(create);
    options.add(mealPlan);
    frame.add(options, BorderLayout.NORTH);



    frame.setVisible(true);



  }

}
