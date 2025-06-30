package model.exercise;

import java.util.List;

import model.Muscles;

/**
 * An abstract method that allows for the building of an exercise object.
 */
abstract class ExerciseBuilderAbst {

  protected String name;

  protected String description;

  protected List<Muscles> musclesList;

  protected int sets;

  protected int reps;

  protected int weight;

  /**
   * A method that changes the number of sets.
   * @param setNum The new set number as an integer.
   * @return The updated ExerciseBuilderAbst object.
   */
  public ExerciseBuilderAbst changeSets(int setNum) {
    this.sets = setNum;
    return this;
  }

  /**
   * A method that changes the number of reps.
   * @param repNum The new rep number as an integer.
   * @return The updated ExerciseBuilderAbst object.
   */
  public ExerciseBuilderAbst changeReps(int repNum) {
    this.reps = repNum;
    return this;
  }

  /**
   * A method that changes the amount of weight.
   * @param weightNum The amount of weight in lbs as an integer.
   * @return The updated ExerciseBuilderAbst object.
   */
  public ExerciseBuilderAbst changeWeight(int weightNum) {
    this.weight = weightNum;
    return this;
  }

  /**
   * A method that creates an ExerciseBuild object with the updated changes.
   * @return A new ExerciseBuild object with the updated changes.
   */
  public abstract ExerciseBuild build();
}
