package model.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import model.Muscles;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExerciseBuildTest {
  private Exercise test;
  @BeforeEach
  public void startUp() {
    List<Muscles> list = new ArrayList<>();
    list.add(Muscles.CHEST);
    this.test = new ExerciseBuild("NAme", list,
            "A Test Exercise");
  }


  //Need to add an equals method to compare exercises.
  @Test
  public void invalidMuscleListInputTest() {
    try {
      this.test = new ExerciseBuild("NAme", new ArrayList<>(),
              "A Test Exercise");
    } catch (IllegalArgumentException e) {
      List<Muscles> list = new ArrayList<>();
      list.add(Muscles.CHEST);
      assertEquals(new ExerciseBuild("NAme", list,
              "A Test Exercise"), test);
    }
  }

  @Test
  public void getNameTest() {
    assertEquals("NAme", test.getName());
  }

  @Test
  public void getDescriptionTest() {
    assertEquals("A Test Exercise", test.getDescription());
  }

  @Test
  public void getMuscleListTest() {
    List<Muscles> list = new ArrayList<>();
    list.add(Muscles.CHEST);
    assertEquals(list, test.getMuscle());
  }

  @Test
  public void getSetTest(){
    assertEquals(0, test.getSets());
  }

  @Test
  public void getRepTest() {
    assertEquals(0, test.getReps());
  }

  @Test
  public void getWeight() {
    assertEquals(0, test.getWeight());
  }

}