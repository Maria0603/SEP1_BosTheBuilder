package model;

import java.util.ArrayList;

public interface BuildingCompanyModel {
    public ArrayList<Project> getOngoingProjects();
    //List<Project> getOngoingProjectList(); Sneha
    public ArrayList<Project> getFinishedProjects();

    public void listAllOngoing();


    // public void listAllFinished();
    // public FinishedProjectList listAllFinished(); Sneha

    public void addOngoingProject(Project project);
    public void addFinishedProject(Project project);
    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData);

    public void deleteOngoingProject(Project project);
    public void deleteFinishedProject(Project project);
    public ReportList generateReport(MyDate fromDate, MyDate toDate, Sort.Order order, Sort.SortingCategory sortingCategory, Sort.ProjectType projectType);
    Project getOngoingProject(int projectId);
    Project getFinishedProject(int projectId);

}
