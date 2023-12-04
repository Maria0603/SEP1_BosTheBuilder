package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "FinishedProjects")
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishedProjectList implements Serializable
{
  @XmlElement(name = "Project")
  private List<Project> finishedProjects;

  public FinishedProjectList()
  {
    this.finishedProjects = new ArrayList<Project>();
  }

  public List<Project> getFinishedProjects()
  {
    return finishedProjects;
  }

  public Project getProject(int index){return finishedProjects.get(index);}

  public Project getProject(Project project){
    for (Project tmp : finishedProjects) {
      if (tmp.equals(project))
        return project;
    }
    return null;
  }

  public void setFinishedProjects(ArrayList<Project> finishedProjects)
  {
    this.finishedProjects = finishedProjects;
  }

  public Project sendToOngoing(Project project)
  {
      Project tmp = project;
      project.setFinished(false);
      System.out.println("The project is set as Ongoing.");

    return tmp;
  }

  public void addToFinishedList(Project project)
  {
    finishedProjects.add(project);
  }

  public String toString()
  {
    String output = "";
    for ( Project project : finishedProjects)
    {
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
