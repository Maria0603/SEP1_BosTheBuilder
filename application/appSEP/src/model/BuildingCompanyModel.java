package model;

import javafx.collections.ObservableList;

import java.util.List;

public interface BuildingCompanyModel {
    public void listAllOngoing();

    public FinishedProjectList listAllFinished();
    public void addNewProject(Project project);
    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData);
    public void editStatusOfFinishedProject(Project project);
    public void deleteOngoingProject(Project project);
    public ReportList generateReport(MyDate fromDate, MyDate toDate, Sort.Order order, Sort.SortingCategory sortingCategory, Sort.ProjectType projectType);
    //void showReportInfo();

    List<Project> getOngoingProjectList();

//    ObservableList<Project> getObservableOngoingProjectList();


    Project getOngoingProject(int projectId);
}
