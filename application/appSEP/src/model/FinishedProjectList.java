package model;

import java.util.ArrayList;

public class FinishedProjectList
{
  private ArrayList<Project> finishedProjects;

  public FinishedProjectList()
  {
    this.finishedProjects = new ArrayList<Project>();
  }

  public ArrayList<Project> getFinishedProjects()
  {
    return finishedProjects;
  }

  public void setFinishedProjects(Project finishedProjects)
  {
    this.finishedProjects = new ArrayList<Project>();
  }

  public Project sendToOngoing(Project project)
  {
    if (!project.getIsFinished())
    {
      project.setFinished(false);
      System.out.println("The project is set as Ongoing.");
    }
    return project;
  }

  public void addToFinishedList(Project project)
  {
    if (project.getIsFinished())
      finishedProjects.add(project);
    System.out.println("Project " + project.getTitle() + " is added to the Finished project list.");
  }

  public void showFinishedList()
  {
    if (finishedProjects.isEmpty())
    {
      System.out.println("The list is empty.");
    }
    else
    {
      for (Project project : finishedProjects)
      {
        System.out.println(project);
      }
    }
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