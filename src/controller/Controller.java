package controller;

public interface Controller {

  /**
   * A method that adds a user chosen exercise.
   */
  public void addNewExercise();

  /**
   * A method that deletes an exercise on the user's choice.
   */
  public void deleteExercise();

  /**
   * A method that allows the user to create a routine.
   */
  public void createNewRoutine();

  /**
   * A method that allows the user to edit the routine.
   */
  public void editRoutine();

  /**
   * A method tht allows the user to delete a routine.
   */
  public void deleteRoutine();



}
