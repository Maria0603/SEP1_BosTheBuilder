package model;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import java.util.List;

public interface BuildingCompanyModel {
    public ArrayList<Project> getOngoingProjects();
    //List<Project> getOngoingProjectList(); Sneha

    public void listAllOngoing();

    // public void listAllFinished();
    // public FinishedProjectList listAllFinished(); Sneha

    public void addNewProject(Project project);
    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData);
    public void editStatusOfFinishedProject(Project project);
    public void deleteOngoingProject(Project project);
    public ReportList generateReport(MyDate fromDate, MyDate toDate, Sort.Order order, Sort.SortingCategory sortingCategory, Sort.ProjectType projectType);
    Project getOngoingProject(int projectId);

}