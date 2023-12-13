package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of ongoing projects.
 */
@XmlRootElement(name = "OngoingProjects")
@XmlAccessorType(XmlAccessType.FIELD)
public class OngoingProjectList implements Serializable {
  @XmlElement(name = "Project")
  private List<Project> ongoingProjects;

  /**
   * Default constructor for the OngoingProjectList class.
   */
  public OngoingProjectList() {
    ongoingProjects = new ArrayList<>();
  }

  /**
   * Gets a project from the ongoing project list.
   *
   * @param project The project to retrieve.
   * @return The project from the ongoing project list, or null if not found.
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
   * Gets a project from the ongoing project list by index.
   *
   * @param index The index of the project.
   * @return The project at the specified index.
   */
  public Project getProject(int index) {
    return ongoingProjects.get(index);
  }

  /**
   * Sets the ongoing projects list.
   *
   * @param ongoingProjects The list of ongoing projects.
   */
  public void setOngoingProjects(List<Project> ongoingProjects) {
    this.ongoingProjects = ongoingProjects;
  }

  /**
   * Adds a project to the ongoing project list.
   *
   * @param project The project to add.
   */
  public void addProjectToOngoingList(Project project) {
    validateProjectID(project);
    ongoingProjects.add(project);
  }

  /**
   * Validates the project ID to be unique within the ongoing project list.
   *
   * @param project The project to validate.
   */
  private void validateProjectID(Project project) {
    for (Project tmp : ongoingProjects) {
      if (tmp.getId() == project.getId()) {
        throw new IllegalArgumentException("Choose a unique project ID");
      }
    }
  }

  /**
   * Deletes a project from the ongoing project list.
   *
   * @param project The project to delete.
   */
  public void deleteProjectFromOngoingList(Project project) {
    ongoingProjects.remove(project);
  }

  /**
   * Creates a copy of the ongoing project list.
   *
   * @return A new instance of OngoingProjectList with copied projects.
   */
  public OngoingProjectList copy() {
    OngoingProjectList newList = new OngoingProjectList();
    for (Project project : ongoingProjects) {
      newList.addProjectToOngoingList(project.copy());
    }
    return newList;
  }

  /**
   * Checks if this ongoing project list is equal to another object.
   *
   * @param obj The object to compare.
   * @return True if the objects are equal, false otherwise.
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
   * Returns a string representation of the ongoing project list.
   *
   * @return A string representation of the ongoing project list.
   */
  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (Project project : ongoingProjects) {
      output.append(project.toString());
    }
    return output.toString();
  }

  /**
   * Gets the list of ongoing projects.
   *
   * @return The list of ongoing projects.
   */
  public List<Project> getOngoingProjects() {
    return ongoingProjects;
  }
}
