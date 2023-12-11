package model;

import java.util.ArrayList;

/**
 * The {@code FinishedProjectList} class represents a list of finished projects.
 * It provides methods to manage finished projects, such as moving them to ongoing projects and creating a copy of the list.
 */
public class FinishedProjectList {

  private ArrayList<Project> finishedProjects;

  /**
   * Constructs a new {@code FinishedProjectList} with an empty list of finished projects.
   */
  public FinishedProjectList() {
    this.finishedProjects = new ArrayList<Project>();
  }

  /**
   * Gets the list of finished projects.
   *
   * @return The list of finished projects.
   */
  public ArrayList<Project> getFinishedProjects() {
    return finishedProjects;
  }

  /**
   * Sets the list of finished projects.
   *
   * @param finishedProjects The list of finished projects to set.
   */
  public void setFinishedProjects(Project finishedProjects) {
    this.finishedProjects = new ArrayList<Project>();
  }

  /**
   * Moves a project to the ongoing list if it is not already marked as ongoing.
   *
   * @param project The project to be moved.
   * @return The project, potentially modified to be marked as ongoing.
   */
  public Project sendToOngoing(Project project) {
    if (!project.isFinished()) {
      project.setFinished(false);
      System.out.println("The project is set as Ongoing.");
    }
    return project;
  }

  /**
   * Adds a project to the list of finished projects.
   *
   * @param project The project to be added.
   */
  public void addToFinishedList(Project project) {
    finishedProjects.add(project);
  }

  /**
   * Returns a string representation of the list of finished projects.
   *
   * @return A string representation of the list of finished projects.
   */
  public String toString() {
    String output = "";
    for (Project project : finishedProjects) {
      output += project.toString();
    }
    return output;
  }

  /**
   * Checks if this list of finished projects is equal to another object.
   *
   * @param obj The object to compare.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    FinishedProjectList other = (FinishedProjectList) obj;
    return this.finishedProjects.equals(other.finishedProjects);
  }

  /**
   * Creates a copy of the list of finished projects.
   *
   * @return A copy of the list of finished projects.
   */
  public FinishedProjectList copy() {
    FinishedProjectList newList = new FinishedProjectList();
    for (Project project : finishedProjects) {
      newList.addToFinishedList(project.copy());
    }
    return newList;
  }
}
