package model.routine.MultipleRoutineHandling;

import java.util.List;
import java.util.Set;

import model.routine.Routine;

public interface MultipleRoutine {
  /**
   * Adds a new routine.
   * @param name The name of the routine.
   * @param routine the Routine object.
   */
  void addRoutine(String name, Routine routine);

  /**
   * Removes a routine.
   * @param name The name of the routine.
   */
  void removeRoutine(String name);

  /**
   * Gets the routine of a specific name.
   * @param name The name of the routine.
   * @return The chosen Routine object.
   */
  Routine getRoutine(String name);

  /**
   * Gets the names of all created routines.
   * @return The names of all routines in a list of Strings.
   */
  List<String> getAllNames();
}
