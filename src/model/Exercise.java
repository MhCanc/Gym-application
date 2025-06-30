package model;

import java.util.List;

/**
 * An interface representing a single exercise.
 */
public interface Exercise {
  /**
   * A method that returns the muscle group targeted by the exercise.
   * @return The Muscles the exercise hits.
   */
  List<Muscles> getMuscle();

  /**
   * A method that returns the description and instructions of the exercise.
   * @return A String representation of the exercise description and instructions.
   */
  String getDescription();

  /**
   * A method that returns the name of the exercise.
   * @return A String representation of the name of the exercise.
   */
  String getName();

  /**
   * A method that returns the amount of sets per exercise.
   * @return The amount of sets as an integer.
   */
  int getSets();

  /**
   * A method that returns the amount of reps per set of the exercise.
   * @return The amount of reps per set as an integer.
   */
  int getReps();

  /**
   * A method that returns the weight used in the exercise as lbs.
   * @return The lbs of the weight as an integer.
   */
  int getWeight();
}
