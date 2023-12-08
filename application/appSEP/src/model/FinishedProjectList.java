package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@XmlRootElement(name = "FinishedProjects")
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishedProjectList implements Serializable
    {
  @XmlElement(name = "Project")
  private List<Project> finishedProjects;


  public FinishedProjectList() {
    this.finishedProjects = new ArrayList<Project>();
  }

  public List<Project> getFinishedProjects()
  {
    return finishedProjects;
  }

  public Project getProject(Project project){
    for (Project tmp : finishedProjects) {
      if (tmp.equals(project))
        return project;
    }
    return null;
  }

  public int getSize(){ return finishedProjects.size(); }

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

}
