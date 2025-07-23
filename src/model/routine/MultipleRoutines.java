package model.routine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
  public void removeRoutine(String name) {
    if (allRoutines.containsKey(name)) {
      allRoutines.remove(name);
    } else {
      throw new IllegalArgumentException("Routine does not exist.");
    }

  }

  @Override
  public Routine getRoutine(String name) {
    if (allRoutines.containsKey(name)) {
      return allRoutines.get(name);
    }
    throw new IllegalArgumentException("Routine does not exist.");
  }

  @Override
  public Set<String> getAllNames() {
    return allRoutines.keySet();
  }
}
