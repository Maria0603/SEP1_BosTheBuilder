package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;

public class BuildingCompany implements BuildingCompanyModel {

    private FinishedProjectList finishedProjectList;
    private OngoingProjectList ongoingProjectList;

    public BuildingCompany() {
        this.finishedProjectList = new FinishedProjectList();
        this.ongoingProjectList = new OngoingProjectList();
    }

    public ArrayList<Project> getOngoingProjects() {
        return ongoingProjectList.getOngoingProjects();
    }

    public ArrayList<Project> getFinishedProjects() {
        return finishedProjectList.getFinishedProjects();
    }

    public void listAllOngoing() {
        for (Project project : ongoingProjectList.getOngoingProjects()) {
            System.out.println(project.toString());
        }
    }



    public void addNewProject(Project project) {
        ongoingProjectList.getOngoingProjects().add(project);
    }
    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData) {
        int index = ongoingProjectList.getOngoingProjects().indexOf(projectToEdit);
        if (index != -1) {
            ongoingProjectList.getOngoingProjects().set(index, projectWithNewData);
        } else {
            System.out.println("Project not found in ongoing projects.");
        }
    }

    public void editStatusOfFinishedProject(Project project) {
        project = finishedProjectList.sendToOngoing(project);
    }

    public void deleteOngoingProject(Project project) {
        ongoingProjectList.getOngoingProjects().remove(project);
    }

    public ReportList generateReport(MyDate fromDate, MyDate toDate, Sort.Order order, Sort.SortingCategory sortingCategory, Sort.ProjectType projectType) {
        ReportList reports = new ReportList(finishedProjectList, fromDate, toDate);
        ArrayList<Project> filteredAndSortedProjects = reports.applyFilters(order, sortingCategory, projectType);

        // Display or process the generated report
        for (Project project : filteredAndSortedProjects) {
            System.out.println(project.toString());
        }
        return reports; // Return the report list if needed for further processing
    }



    @Override
    public Project getOngoingProject(int projectId) {
        for (int i = 0; i < ongoingProjectList.getOngoingProjects().size(); i++) {
            if (ongoingProjectList.getOngoingProjects().get(i).getId() == projectId){
                return ongoingProjectList.getOngoingProjects().get(i);
            }
        }

        return null;
    }

}