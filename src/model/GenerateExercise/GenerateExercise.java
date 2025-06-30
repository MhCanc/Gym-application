package model.GenerateExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.exercise.Exercise;
import model.exercise.ExerciseBuild;

public class GenerateExercise implements Generate {

  private final List<String> contents;

  private final String filePath;

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

  //Need to add function to allow for the transference of text to Muscles Enum Constant.
  @Override
  public List<Exercise> getExercises() throws IllegalArgumentException {
    List<Exercise> options = new ArrayList<>();
    String[] splited;
    for (String content : contents) {
      splited = content.split("-");

      options.add(new ExerciseBuild(splited[0], splited[2], splited[1]);
    }
  }
}
