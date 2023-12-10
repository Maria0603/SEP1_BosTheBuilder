package model;

import java.util.ArrayList;

public interface BuildingCompanyModel {
  public ArrayList<Project> getOngoingProjects();
  public ArrayList<Project> getFinishedProjects();
  public ArrayList<Project> getReportProjects();
  public Project getOngoingProject(int projectId);
  public Project getFinishedProject(int projectId);
  public void setReportList(ArrayList<Project> reportList);
  public void setFromDateForReport(MyDate date);
  public void setToDateForReport(MyDate date);
  public void addOngoingProject(Project project);
  public void addFinishedProject(Project project);
  public void editOngoingProjectData(Project projectToEdit,
      Project projectWithNewData);
  public void deleteOngoingProject(Project project);
  public void deleteFinishedProject(Project project);
  public ReportList generateReport(Sort.Order order,
      Sort.SortingCategory sortingCategory, Sort.ProjectType projectType);
  public void generateReportTXT();
  public void resetReportList();

}
