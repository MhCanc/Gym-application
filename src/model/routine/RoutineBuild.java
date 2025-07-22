package model.routine;

import java.util.ArrayList;
import java.util.List;

import model.GenerateExercise.GenerateExercise;
import model.Muscles;
import model.exercise.Exercise;

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
  public void addExercise(String name) {

  }

  @Override
  public void autoGenerateRoutine(List<Muscles> muscles, int totalExercises) {

  }

  @Override
  public void removeExercise(String name) {

  }

  @Override
  public void changeExerciseWeight(int weight) {

  }

  @Override
  public void changeExerciseSet(int sets) {

  }
}
