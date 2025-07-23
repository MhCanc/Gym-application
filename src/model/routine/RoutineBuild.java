package model.routine;

import java.util.ArrayList;
import java.util.List;

import model.GenerateExercise.GenerateExercise;
import model.exercise.Exercise;
import model.exercise.ExerciseBuild;

public class RoutineBuild implements Routine{

  private final List<Exercise> routine;
  private final List<Exercise> available;
  private final GenerateExercise file = new GenerateExercise("model/RecordedExercises");

  /**
   * A constructor for the RoutineBuild Class.
   */
  public RoutineBuild(){
    routine = new ArrayList<>();
    available = file.getExercises();
  }

  @Override
  public void addExercise(String name) throws IllegalArgumentException {
    for (Exercise e: available) {
      if (e.getName().equals(name)) {
        routine.add(e);
        return;
      }
    }
    throw new IllegalArgumentException("Exercise does not exist");
  }

  @Override
  public void removeExercise(String name) {
    for (Exercise e: routine) {
      if (e.getName().equals(name)) {
        routine.remove(e);
        return;
      }
    }
    throw new IllegalArgumentException("Exercise does not exist to be removed");
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
}
