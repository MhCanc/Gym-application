package model.routine;

import java.util.List;

import model.Muscles;

/**
 * An interface representing the functionality for an exercise routine.  Remains functional for
 * various types of exercise routines.
 */
public interface Routine {

  /**
   * A method adding an exercise into the routine.
   * @param name The name of the exercise.
   */
  void addExercise(String name);

  /**
   * A method that auto generates a routine based on available exercises.
   * @param muscles The muscle groups for the exercises to target.
   * @param totalExercises The total amount of exercises in the routine.
   */
  void autoGenerateRoutine(List<Muscles> muscles, int totalExercises);

  /**
   * A method removing an exercise from the routine.
   * @param name The name of the exercise.
   */
  void removeExercise(String name);

  /**
   * A method that changes the weight of an exercise in the routine.
   * @param weight The weight of the exercise in pounds.
   */
  void changeExerciseWeight(int weight);

  /**
   * A method that changes the total amount of sets of an exercise.
   * @param sets The total sets of an exercise.
   */
  void changeExerciseSet(int sets);



}
