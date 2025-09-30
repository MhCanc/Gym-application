package model.routine.SaveFunctionality;

import model.routine.MultipleRoutineHandling.MultipleRoutine;

public interface SaveRoutines {


  /**
   * A method that writes all the routines into the Json file.
   * @param routines The current multipleRoutine object being stored.
   */
  void writeRoutines(MultipleRoutine routines);



}
