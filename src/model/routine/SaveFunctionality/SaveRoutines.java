package model.routine.SaveFunctionality;

import model.routine.Routine;

/**
 * An interface representing the save functionality for routines.
 */
public interface SaveRoutines {


  /**
   * A method that writes new routine into the Json file.
   * @param name The name of the routine being added.
   * @param routine The Routine object being added.
   */
  void writeRoutine(String name, Routine routine);

  /**
   * Reads and gathers all routines from json file.
   */
  void gatherRoutines();

  /**
   * Updates the json file with the new values.
   * @throws RuntimeException Thrown when file fails.
   */
  void updateRoutines() throws RuntimeException;

  /**
   * Removes a routine from the json file.
   * @param name The name of the routine.
   */
  void removeRoutines(String name);
}
