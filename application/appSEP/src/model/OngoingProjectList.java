package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "OngoingProjects")
@XmlAccessorType(XmlAccessType.FIELD)
public class OngoingProjectList implements Serializable {
  @XmlElement(name = "Project")
  private List<Project> ongoingProjects;
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
  public Project getProject(int index){return ongoingProjects.get(index);}

  public void setOngoingProjects(List<Project> ongoingProjects)
  {
    this.ongoingProjects = ongoingProjects;
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

  public List<Project> getOngoingProjects() {
    return ongoingProjects;
  }
}
