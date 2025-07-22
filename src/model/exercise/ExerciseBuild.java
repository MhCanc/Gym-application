package model.exercise;

import java.util.List;

import model.Muscles;

/**
 * A class implementing the Exercise interface.  Represents a single exercise.
 */
public class ExerciseBuild implements Exercise {
  private final String name;
  private final List<Muscles> musclesList;
  private final String description;

  private final int sets;

  private final int reps;

  private final int weight;

  /**
   * A constructor for the ExerciseBuild class.
   * @param name The name of the Exercise as a String.
   * @param musclesList The list of Muscles targeted.
   * @param description The description of the Exercise as a String.
   * @throws IllegalArgumentException Thrown when any of the parameters are empty.
   */
  public ExerciseBuild(String name, List<Muscles> musclesList, String description)
          throws IllegalArgumentException {
    try {
      if (name.isEmpty() || musclesList.isEmpty() || description.isEmpty()) {
        throw new IllegalArgumentException("Cannot have a blank field in exercise constructor");
      }
      this.name = name;
      this.musclesList = musclesList;
      this.description = description;
      this.sets = 0;
      this.reps = 0;
      this.weight = 0;
    } catch (NullPointerException e) {
      throw new IllegalArgumentException("Cannot have a null variable");
    }
  }

  /**
   * A constructor for object generation with ExerciseBuilder.
   * @param name The name of the object as a String.
   * @param musclesList The list of Muscles targeted.
   * @param description The description of the exercises as a String.
   * @param sets The amount of sets as an int.
   * @param reps The amount of reps as an int.
   * @param weight The amount of weight in lbs as an int.
   * @throws IllegalArgumentException Thrown when any of the parameters are empty.
   */
  protected ExerciseBuild(String name, List<Muscles> musclesList, String description, int sets,
                        int reps, int weight) throws IllegalArgumentException {
    try {
      if (name.isEmpty() || musclesList.isEmpty() || description.isEmpty()) {
        throw new IllegalArgumentException("Cannot have a blank field in exercise constructor");
      }
      this.name = name;
      this.musclesList = musclesList;
      this.description = description;
      this.sets = sets;
      this.reps = reps;
      this.weight = weight;
    } catch (NullPointerException e) {
      throw new IllegalArgumentException("Cannot have a null variable");
    }
  }

  @Override
  public List<Muscles> getMuscle() {
    return this.musclesList;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getSets() {
    return this.sets;
  }

  @Override
  public int getReps() {
    return this.reps;
  }

  @Override
  public int getWeight() {
    return this.weight;
  }

  /**
   * A class that allows for variables in the ExerciseBuild class to be changed without mutation.
   */
  public static class ExerciseBuilder extends ExerciseBuilderAbst {
    /**
     * A constructor for ExerciseBuilder.
     * @param exercise The ExerciseBuild object being changed.
     */
    public ExerciseBuilder(ExerciseBuild exercise) {
      this.name = exercise.getName();
      this.musclesList = exercise.getMuscle();
      this.description = exercise.getDescription();
      this.sets = exercise.getSets();
      this.reps = exercise.getReps();
      this.weight = exercise.getWeight();
    }

    @Override
    public ExerciseBuild build() {
      return new ExerciseBuild(this.name, this.musclesList, this.description,
              this.sets, this.reps, this.weight);
    }
  }
}
