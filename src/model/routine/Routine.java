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
  void addExercise(String name) throws IllegalArgumentException;


  /**
   * A method removing an exercise from the routine.
   * @param name The name of the exercise.
   */
  void removeExercise(String name) throws IllegalArgumentException;

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



}
