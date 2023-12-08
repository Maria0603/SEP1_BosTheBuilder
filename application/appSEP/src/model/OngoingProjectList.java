package model;

import java.util.ArrayList;

public class OngoingProjectList {
  private ArrayList<Project> ongoingProjects;

  public ArrayList<Project> getOngoingProjects() {
    return ongoingProjects;
  }

  public OngoingProjectList() {
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
    validateProjectID(project);
    ongoingProjects.add(project);
  }

  private void validateProjectID(Project project) {
    for (Project tmp : ongoingProjects) {
      if(tmp.getId() == project.getId()){
        throw new IllegalArgumentException("Choose unique project ID");
      }
    }
  }
  public void deleteProjectFromOngoingList(Project project) {
    ongoingProjects.remove(project);
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
