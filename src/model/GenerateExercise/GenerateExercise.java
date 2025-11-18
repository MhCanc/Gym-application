package model.GenerateExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Muscles;
import model.exercise.Exercise;
import model.exercise.ExerciseBuild;

/**
 * A class that reads the exercises stored in RecordedExercises,
 */
public class GenerateExercise implements Generate {

  private final List<String> contents;

  private final String filePath;

  /**
   * A constructor for GenerateExercise that splits a txt file by line for each exercise.
   * @param filePath The filepath to the file holding the recorded exercises.
   */
  public GenerateExercise(String filePath) {
    this.contents = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        contents.add(line);
      }
    } catch (IOException e) {
      throw new IllegalArgumentException();
    }
    this.filePath = filePath;
  }

  @Override
  public void addExerciseTxt(Exercise exercise) throws IllegalArgumentException {
    Writer output;
    StringBuilder add = new StringBuilder();
    try {
      output = new BufferedWriter(new FileWriter(this.filePath, true));
      add.append(exercise.getName()).append("-").append(exercise.getDescription())
              .append("-").append(exercise.getMuscle());
      output.append("\n").append(add);
      contents.add(String.valueOf(add));
      output.close();
    } catch (IOException e) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * A helper method for turning a string into a Muscle enum.
   * @param s The string being checked.
   * @return The muscle list.
   * @throws IllegalArgumentException Thrown when no muscles are present in the string.
   */
  private List<Muscles> stringToMuscle(String s) throws IllegalArgumentException {
    String str = s.replaceAll("\\[", "");
    str = str.replaceAll("]", "");
    String[] split = str.split(",");
    List<Muscles> musc = new ArrayList<>();
    for (String x : split) {
      for (Muscles m: Muscles.values()) {
        if (x.equals(m.name())) {
          musc.add(m);
        }
      }
    }
    if (musc.isEmpty()) {
      throw new IllegalArgumentException("No Muscle Group Specified.");
    }
    return musc;
  }

  @Override
  public List<Exercise> getExercises() throws IllegalArgumentException {
    List<Exercise> options = new ArrayList<>();
    String[] splited;
    for (String content : contents) {
      splited = content.split("-");
      options.add(new ExerciseBuild(splited[0], stringToMuscle(splited[2]), splited[1]));
    }
    if (options.isEmpty()) {
      throw new IllegalArgumentException("No exercises available");
    }
    return options;
  }

  //Overwrites file
  @Override
  public void removeExerciseTxt(String name) throws IllegalArgumentException {
    List<String> current = new ArrayList<>(contents);
    String[] splited;
    Writer output;
    StringBuilder add = new StringBuilder();
    for (String content : current) {
      splited = content.split("-");
      if (splited[0].equals(name)) {
        contents.remove(content);
        break;
      }
    }
    if (current.size() == contents.size()) {
      throw new IllegalArgumentException("No exercise of this name exists.");
    }
    try {
      output = new FileWriter(this.filePath);
      for (String content: contents) {
        add.append(content).append("\n");
      }
      output.append(add);
      output.close();
    } catch (IOException e) {
      throw new IllegalArgumentException();
    }
  }
}
