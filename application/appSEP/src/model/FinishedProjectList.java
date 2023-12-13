package model;

import javafx.fxml.FXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of finished projects.
 */
@XmlRootElement(name = "FinishedProjects")
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishedProjectList implements Serializable {
  @XmlElement(name = "Project") private List<Project> finishedProjects;

  /**
   * Constructs an empty list of finished projects.
   */
  public FinishedProjectList() {
    this.finishedProjects = new ArrayList<>();
  }

  /**
   * Sets the list of finished projects.
   *
   * @param finishedProjects The list of finished projects to be set.
   */
  public void setFinishedProjects(List<Project> finishedProjects) {
    this.finishedProjects = finishedProjects;
  }

  /**
   * Gets the list of finished projects.
   *
   * @return The list of finished projects.
   */
  public List<Project> getFinishedProjects() {
    return finishedProjects;
  }

  /**
   * Gets a project from the list based on equality.
   *
   * @param project The project to be retrieved.
   * @return The project if found, otherwise null.
   */
  public Project getProject(Project project) {
    for (Project tmp : finishedProjects) {
      if (tmp.equals(project))
        return project;
    }
    return null;
  }

  /**
   * Gets the number of finished projects in the list.
   *
   * @return The number of finished projects.
   */
  public int getSize() {
    return finishedProjects.size();
  }

  /**
   * Gets a project from the list based on its ID.
   *
   * @param id The ID of the project to be retrieved.
   * @return The project if found, otherwise null.
   */
  public Project getProject(int id) {
    for (Project tmp : finishedProjects) {
      if (tmp.getId() == id) {
        return tmp;
      }
    }
    return null;
  }

  /**
   * Removes a project from the finished project list.
   *
   * @param project The project to be removed.
   */
  public void removeFromFinishedList(Project project) {
    finishedProjects.remove(project);
  }

  /**
   * Adds a project to the finished project list.
   *
   * @param project The project to be added.
   */
  public void addToFinishedList(Project project) {
    finishedProjects.add(project);
  }

  /**
   * Converts the finished project list to a string.
   *
   * @return A string representation of the finished project list.
   */
  public String toString() {
    String output = "";
    for (Project project : finishedProjects) {
      output += project.toString();
    }
    return output;
  }

  /**
   * Checks if this finished project list is equal to another object.
   *
   * @param obj The object to compare.
   * @return True if the objects are equal, false otherwise.
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
   * Creates a copy of the finished project list.
   *
   * @return A new instance of FinishedProjectList with the same projects.
   */
  public FinishedProjectList copy() {
    FinishedProjectList newList = new FinishedProjectList();
    for (Project project : finishedProjects) {
      newList.addToFinishedList(project);
    }
    return newList;
  }
}
