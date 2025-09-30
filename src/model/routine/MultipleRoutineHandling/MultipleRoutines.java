package model.routine.MultipleRoutineHandling;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.routine.Routine;
import model.routine.RoutineBuild;


public class MultipleRoutines implements MultipleRoutine{
  private final Map<String, Routine> allRoutines;

  public MultipleRoutines() {
    allRoutines = new HashMap<>();
  }

  @Override
  public void addRoutine(String name) throws IllegalArgumentException {
    if (allRoutines.containsKey(name)) {
      throw new IllegalArgumentException("Routine already exists.");
    }
    allRoutines.put(name, new RoutineBuild());
  }

  @Override
  public void removeRoutine(String name) throws IllegalArgumentException {
    if (allRoutines.containsKey(name)) {
      allRoutines.remove(name);
    } else {
      throw new IllegalArgumentException("Routine does not exist.");
    }
  }

  @Override
  public Routine getRoutine(String name) throws IllegalArgumentException {
    if (allRoutines.containsKey(name)) {
      return allRoutines.get(name);
    }
    throw new IllegalArgumentException("Routine does not exist.");
  }

  @Override
  public Set<String> getAllNames() {
    if (allRoutines.keySet().isEmpty()) {
      throw new IllegalArgumentException("No routines recorded.");
    }
    return new HashSet<>(allRoutines.keySet());
  }
}
