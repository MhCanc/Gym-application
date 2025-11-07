package model.routine.SaveFunctionality;

import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import model.routine.MultipleRoutineHandling.MultipleRoutine;
import model.routine.MultipleRoutineHandling.MultipleRoutines;
import model.routine.Routine;

/**
 * The implementation of the save routine functionality.
 */
public class SaveRoutinesImpl implements SaveRoutines {
  private final MultipleRoutine allRoutines;
  public SaveRoutinesImpl() {
    allRoutines = new MultipleRoutines();
  }

  @Override
  public void gatherRoutines() {
    try {
      FileReader read = new FileReader("routines.json");
      JSONParser parser = new JSONParser();
      JSONArray array = (JSONArray) parser.parse(read);
      read.close();
      for (Object o : array) {
        JSONObject j = (JSONObject) o;
        String response = (String) j.get("Name");
        Routine currentRoutine = (Routine) j.get("Routine");
        long num = (long) j.get("num");
        allRoutines.addRoutine(response, currentRoutine);
      }
    } catch (ParseException | IOException e) {
      throw new RuntimeException(e);
    }
  }
  @Override
  public void writeRoutine(String name, Routine routine) {
    allRoutines.addRoutine(name, routine);
  }

  @Override
  public void updateRoutines() throws RuntimeException {
    try {
      JSONArray jarr = new JSONArray();
      for (String name : allRoutines.getAllNames()) {
        JSONObject enter = new JSONObject();
        enter.put("Name", name);
        enter.put("Routine", allRoutines.getRoutine(name));
        jarr.add(enter);
      }
      FileWriter writer = new FileWriter("routines.json");
      writer.write(jarr.toJSONString());
      writer.flush();
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException("File not responding");
    }
  }

  @Override
  public void removeRoutines(String name) {
    allRoutines.removeRoutine(name);
  }

}
