package controller;

import java.util.ArrayList;
import java.util.List;

import model.GenerateExercise.GenerateExercise;
import model.Muscles;
import model.exercise.Exercise;
import model.exercise.ExerciseBuild;
import model.routine.MultipleRoutineHandling.MultipleRoutines;
import model.routine.Routine;
import model.routine.RoutineBuild;
import model.routine.SaveFunctionality.SaveRoutinesImpl;
import view.GUIPopUp;

/**
 * A class implementing the bridge between the model and view.
 */
public class GuiController implements Controller {

  private final SaveRoutinesImpl routines;
  private final GenerateExercise exercises;
  private final GUIPopUp requests;
  public GuiController() {
    exercises = new GenerateExercise("Gym-Application/src/model/RecordedExercises");
    requests = new GUIPopUp();
    routines = new SaveRoutinesImpl();
  }

  @Override
  public void addNewExercise() {
    List<Muscles> muscles = new ArrayList<>();
    String input = requests.getResponse("Enter the name of the exercise");
    try {
      for (Exercise e : exercises.getExercises()) {
        if (e.getName().equals(input)) {
          requests.popUpMessage("Exercise Already Exists");
          return;
        }
      }
    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ignored) {}
    String description = requests.getResponse("Enter description of exercise");
    Muscles m = null;
    while (m != Muscles.NA) {
      m = (Muscles) requests.getDropdown(Muscles.values());
      if (!m.equals(Muscles.NA)) {
      muscles.add(m);
      }
    }
    Exercise userMade = new ExerciseBuild(input, muscles, description);
    exercises.addExerciseTxt(userMade);
  }

  @Override
  public void deleteExercise() {
    String[] array = new String[exercises.getExercises().size()];
    for (int i = 0; i < exercises.getExercises().size(); i++) {
      array[i] = exercises.getExercises().get(i).getName();
    }
    String input = (String) requests.getDropdown(array);
    try {
      exercises.removeExerciseTxt(input);
    } catch (IllegalArgumentException e) {
      requests.popUpMessage("No exercise of that name exists");
    }
  }

  @Override
  public void createNewRoutine() {
    String input = requests.getResponse("Enter routine name");
    try {
      for (String s : routines.gatherRoutines().getAllNames()) {
        if (s.equals(input)) {
          requests.popUpMessage("Routine Name Already Taken");
          return;
        }
      }
    } catch (IllegalArgumentException ignored) {

    }
    Routine routine = new RoutineBuild(input);
    routines.writeRoutine(input, routine);
    routines.updateRoutines();
  }

  @Override
  public void editRoutine() {

  }

  @Override
  public void deleteRoutine() {
    String[] str = (String[]) routines.gatherRoutines().getAllNames().toArray();
    String input = (String) requests.getDropdown(str);
    routines.removeRoutines(input);
    routines.updateRoutines();
  }


}
