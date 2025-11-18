package model.routine.SaveFunctionality;

import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import model.routine.MultipleRoutineHandling.MultipleRoutine;
import model.routine.MultipleRoutineHandling.MultipleRoutines;
import model.routine.Routine;

/**
 * The implementation of the save routine functionality.
 */
public class SaveRoutinesImpl implements SaveRoutines, Serializable {
  private MultipleRoutine allRoutines;
  private List<Routine> contents;

  public SaveRoutinesImpl() {
    allRoutines = new MultipleRoutines(new ArrayList<>());
  }

  //Need to break Routine object into recordable information.
  @Override
  public MultipleRoutine gatherRoutines() {
    this.contents = new ArrayList<>();
    try (FileInputStream fileIn =
                 new FileInputStream("Gym-Application/src/model/routines.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn)) {

      while (true) {
        try {
          Routine obj = (Routine) in.readObject();
          contents.add(obj);
        } catch (EOFException e) {
          break;
        }
      }

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    allRoutines = new MultipleRoutines(contents);
    return allRoutines;
  }
  @Override
  public void writeRoutine(String name, Routine routine) {
    allRoutines.addRoutine(name, routine);
  }

  @Override
  public void updateRoutines() throws RuntimeException {
    try (ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream("Gym-Application/src/model/routines.txt"))) {

      for (String s : allRoutines.getAllNames()) {
        out.writeObject(allRoutines.getRoutine(s));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void removeRoutines(String name) {
    allRoutines.removeRoutine(name);
  }

}
