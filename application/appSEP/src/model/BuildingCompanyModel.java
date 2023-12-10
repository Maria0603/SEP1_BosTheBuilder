package model;

import java.util.ArrayList;

public interface BuildingCompanyModel {
    public ArrayList<Project> getOngoingProjects();
    //List<Project> getOngoingProjectList(); Sneha
    public ArrayList<Project> getFinishedProjects();
    public void addOngoingProject(Project project);
    public void addFinishedProject(Project project);
    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData);
    public void deleteOngoingProject(Project project);
    public void deleteFinishedProject(Project project);
    public ReportList generateReport(MyDate fromDate, MyDate toDate, Sort.Order order, Sort.SortingCategory sortingCategory, Sort.ProjectType projectType);
   public Project getOngoingProject(int projectId);
    public Project getFinishedProject(int projectId);

}
