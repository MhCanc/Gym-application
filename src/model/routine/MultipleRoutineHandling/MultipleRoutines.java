package model.routine.MultipleRoutineHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.routine.Routine;
import model.routine.RoutineBuild;


public class MultipleRoutines implements MultipleRoutine{
  private List<Routine> allRoutines;

  public MultipleRoutines(List<Routine> routines) {
    allRoutines = routines;
  }

  @Override
  public void addRoutine(String name, Routine r) throws IllegalArgumentException {
    for (Routine check : allRoutines) {
      if (check.getName().equals(name)) {
        throw new IllegalArgumentException("Routine Already Exists of That Name");
      }
    }
    allRoutines.add(r);
  }

  @Override
  public void removeRoutine(String name) throws IllegalArgumentException {
    List<Routine> current = new ArrayList<>(allRoutines);
    for (Routine r : allRoutines) {
      if (r.getName().equals(name)) {
        current.remove(r);
        break;
      }
    }
    if (current.size() == allRoutines.size()) {
      throw new IllegalArgumentException("No Routine to Remove");
    }
    allRoutines = current;
  }

  @Override
  public Routine getRoutine(String name) throws IllegalArgumentException {
    for (Routine r : allRoutines) {
      if (r.getName().equals(name)) {
        return r;
      }
    }
    throw new IllegalArgumentException("Routine does not exist.");
  }

  @Override
  public List<String> getAllNames() {
    if (allRoutines.isEmpty()) {
      throw new IllegalArgumentException("No routines recorded.");
    }
    List<String> stringList = new ArrayList<>();
    for (Routine r : allRoutines) {
      stringList.add(r.getName());
    }
    return stringList;
  }
}
