package model.GenerateExercise;

import java.util.List;

import model.exercise.Exercise;

/**
 * An interface outlining the functionality for the generation of exercise choices.
 */
public interface Generate {
  /**
   * A method that adds a new exercise to the file is a "exercise-description-muscle list" format.
   * @param exercise The exercise being added to the file.
   * @throws IllegalArgumentException Thrown when an exercise with the same name already exists.
   */
  void addExerciseTxt(Exercise exercise) throws IllegalArgumentException;

  /**
   * A method that returns all exercises in the file.
   * @return A list of all available exercises.
   * @throws IllegalArgumentException Thrown when there are no exercises to be returned, or txt file
   *      is unreadable.
   */
  List<Exercise> getExercises() throws IllegalArgumentException;

  /**
   * A method that removes an exercise from RecordedExercises.
   * @param name The name of the exercise to be removed.
   * @throws IllegalArgumentException Thrown when an exercise of the name does not exist.
   */
  void removeExerciseTxt(String name) throws IllegalArgumentException;
}
