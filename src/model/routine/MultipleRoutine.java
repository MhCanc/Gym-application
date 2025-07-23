package model.routine;

import java.util.Set;

public interface MultipleRoutine {
  /**
   * Adds a new routine.
   * @param name The name of the routine.
   */
  void addRoutine(String name);

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
  Set<String> getAllNames();
}
