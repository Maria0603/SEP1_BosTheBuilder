package model;

import java.util.ArrayList;

public class OngoingProjectList {
  private ArrayList<Project> ongoingProjects;
  private OngoingProjectList() {
    ongoingProjects = new ArrayList<>();
  }
  public Project getProject(Project project) {
    for (Project tmp : ongoingProjects) {
      if (tmp.equals(project)) {
        return tmp;
      }
    }
    return null;
  }
  public void addProjectToOngoingList(Project project) {
    ongoingProjects.add(project);
  }
  public void deleteProjectFromOngoingList(Project project) {
    ongoingProjects.remove(project);
  }
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

  public Project SendToFinishedList(Project project) {
    Project tmp;
    tmp = project.copy();
    ongoingProjects.remove(project);
    return tmp;
  }

  public OngoingProjectList copy() {
    OngoingProjectList newList = new OngoingProjectList();
    for (Project project : ongoingProjects) {
      newList.addProjectToOngoingList(project.copy());
    }
    return newList;
  }

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

  public String toString()
  {
    String output = "";
    for ( Project project : ongoingProjects)
    {
      output += project.toString();
    }
    return output;
  }

}
