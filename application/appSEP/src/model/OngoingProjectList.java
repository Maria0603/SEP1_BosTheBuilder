package model;

import java.util.ArrayList;

/**
 * The {@code OngoingProjectList} class represents a list of ongoing projects.
 * It provides methods to manage ongoing projects, such as adding, deleting, and editing projects.
 */
public class OngoingProjectList {
  private ArrayList<Project> ongoingProjects;

  /**
   * Constructs a new {@code OngoingProjectList} with an empty list of ongoing projects.
   */
  private OngoingProjectList() {
    ongoingProjects = new ArrayList<>();
  }

  /**
   * Gets a project from the ongoing list if it exists.
   *
   * @param project The project to search for.
   * @return The project if found, otherwise {@code null}.
   */
  public Project getProject(Project project) {
    for (Project tmp : ongoingProjects) {
      if (tmp.equals(project)) {
        return tmp;
      }
    }
    return null;
  }

  /**
   * Adds a project to the list of ongoing projects.
   *
   * @param project The project to add.
   */
  public void addProjectToOngoingList(Project project) {
    ongoingProjects.add(project);
  }

  /**
   * Deletes a project from the list of ongoing projects.
   *
   * @param project The project to delete.
   */
  public void deleteProjectFromOngoingList(Project project) {
    ongoingProjects.remove(project);
  }

  /**
   * Edits a project in the list of ongoing projects.
   *
   * @param projectToEdit      The project to edit.
   * @param projectWithNewData The project with new data.
   */
  public void editProject(Project projectToEdit, Project projectWithNewData) {
    Project existingProject = getProject(projectToEdit);

    if (existingProject != null) {
      int index = ongoingProjects.indexOf(existingProject);
      if (index != -1) {
        ongoingProjects.set(index, projectWithNewData);
      }
    } else {
      System.out.println("Project to edit was not found in the ongoing projects list.");
    }
  }

  /**
   * Moves a project to the finished list and returns a copy of the original project.
   *
   * @param project The project to move.
   * @return A copy of the original project.
   */
  public Project sendToFinishedList(Project project) {
    Project tmp = project.copy();
    ongoingProjects.remove(project);
    return tmp;
  }

  /**
   * Creates a copy of the ongoing projects list.
   *
   * @return A copy of the ongoing projects list.
   */
  public OngoingProjectList copy() {
    OngoingProjectList newList = new OngoingProjectList();
    for (Project project : ongoingProjects) {
      newList.addProjectToOngoingList(project.copy());
    }
    return newList;
  }

  /**
   * Checks if this ongoing projects list is equal to another object.
   *
   * @param obj The object to compare.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    OngoingProjectList other = (OngoingProjectList) obj;
    return this.ongoingProjects.equals(other.ongoingProjects);
  }

  /**
   * Returns a string representation of the ongoing projects list.
   *
   * @return A string representation of the ongoing projects list.
   */
  @Override
  public String toString() {
    String output = "";
    for (Project project : ongoingProjects) {
      output += project.toString();
    }
    return output;
  }
}
