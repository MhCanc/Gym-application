package model.routine;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.GenerateExercise.GenerateExercise;
import model.exercise.Exercise;
import model.exercise.ExerciseBuild;

/**
 * A method implementing the Routine object.
 */
public class RoutineBuild implements Routine, Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  private final List<Exercise> routine;
  private final String name;

  /**
   * A constructor for the RoutineBuild Class.
   */
  public RoutineBuild(String name){
    this.name = name;
    routine = new ArrayList<>();
  }

  @Override
  public void addExercise(Exercise e) throws IllegalArgumentException {
      if (!routine.contains(e)) {
        routine.add(e);
      } else {
        throw new IllegalArgumentException("Exercise already present");
      }
  }

  @Override
  public void removeExercise(Exercise e) {
    if (routine.contains(e)) {
      routine.remove(e);
    } else {
      throw new IllegalArgumentException("Exercise does not exist");
    }
  }

  @Override
  public void changeExerciseWeight(String name, int weight) {
    for (Exercise e: routine) {
      if (e.getName().equals(name)) {
        routine.remove(e);
        routine.add(new ExerciseBuild.ExerciseBuilder(e).changeWeight(weight).build());
        return;
      }
    }
    throw new IllegalArgumentException("No Exercise weight changed.");
  }

  @Override
  public void changeExerciseSet(String name, int sets) {
    for (Exercise e: routine) {
      if (e.getName().equals(name)) {
        routine.remove(e);
        routine.add(new ExerciseBuild.ExerciseBuilder(e).changeSets(sets).build());
        return;
      }
    }
    throw new IllegalArgumentException("No Exercise sets changed.");
  }

  @Override
  public void clearAllExercises(){
    routine.clear();
  }

  @Override
  public List<Exercise> getRoutine(){
    return new ArrayList<>(routine);
  }

  @Override
  public String getName() {
    return this.name;
  }
}
