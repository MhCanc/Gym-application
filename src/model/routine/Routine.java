package model.routine;

import java.util.List;

import model.Muscles;
import model.exercise.Exercise;

/**
 * An interface representing the functionality for an exercise routine.  Remains functional for
 * various types of exercise routines.
 */
public interface Routine {

  /**
   * A method adding an exercise into the routine.
   * @param e The exercise being added.
   */
  void addExercise(Exercise e) throws IllegalArgumentException;

  /**
   * A method removing an exercise from the routine.
   * @param e The exercise being removed.
   */
  void removeExercise(Exercise e) throws IllegalArgumentException;

  /**
   * A method removing all exercises from the current routine.
   */
  void clearAllExercises();

  /**
   * A method that changes the weight of an exercise in the routine.
   * @param weight The weight of the exercise in pounds.
   */
  void changeExerciseWeight(String name, int weight) throws IllegalArgumentException;

  /**
   * A method that changes the total amount of sets of an exercise.
   * @param sets The total sets of an exercise.
   */
  void changeExerciseSet(String name, int sets) throws IllegalArgumentException;

  /**
   * A method returning the current routine.
   * @return A list of all exercises in the routine.
   */
  List<Exercise> getRoutine();

  /**
   * A method returning the name of the routine.
   * @return A string representation of the name.
   */
  String getName();

}
