package model.routine;

import java.util.List;

import model.Muscles;

/**
 * An interface outlining the functionality of the auto-build routine functionality.
 */
public interface AutoBuildRoutine {

  /**
   * A method taking in a list of Muscle groups to be excluded
   * from exercises added to the routine.
   * @param muscles The muscle groups to be excluded from the routine.
   */
  void excludeMuscleGroups(List<Muscles> muscles);

  /**
   * A method taking in a list of Muscle groups to be prioritized by the routine.
   * @param muscles The muscle groups to be chosen for the routine.
   */
  void chooseMuscleGroups(List<Muscles> muscles);

  /**
   * A method that generates a routine based upon the given exercise perimeters.
   * @param name The name of the routine.
   * @param num The number of exercises in the routine.
   * @return The generated Routine object.
   */
  Routine generateRoutine(String name, int num);

}
