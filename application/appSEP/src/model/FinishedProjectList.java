package model;

import java.util.ArrayList;
import java.util.Arrays;

public class FinishedProjectList {
  private ArrayList<Project> finishedProjects;

  public FinishedProjectList() {
    this.finishedProjects = new ArrayList<Project>();
  }

  public int getSize(){ return finishedProjects.size(); }

  public Project getProject(Project project) {
    for (Project tmp : finishedProjects) {
      if (tmp.equals(project)) {
        return tmp;
      }
    }
    return null;
  }

  public Project getProject(int id) {
    for (Project tmp : finishedProjects) {
      if (tmp.getId() == id) {
        return tmp;
      }
    }
    return null;
  }

  public void removeFromFinishedList(Project project){
    finishedProjects.remove(project);
  }

  public void addToFinishedList(Project project) {
    finishedProjects.add(project);
  }

  public String toString() {
    String output = "";
    for (Project project : finishedProjects) {
      output += project.toString();
    }
    return output;
  }

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

  public FinishedProjectList copy() {
    FinishedProjectList newList = new FinishedProjectList();
    for (Project project : finishedProjects) {
      newList.addToFinishedList(project.copy());
    }
    return newList;
  }

  public ArrayList<Project> getFinishedProjects() {
    return finishedProjects;
  }
}
