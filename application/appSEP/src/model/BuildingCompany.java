package model;

import java.util.ArrayList;

public class BuildingCompany implements BuildingCompanyModel {

    private FinishedProjectList finishedProjectList;
    private ArrayList<Project> ongoingProjects;

    public BuildingCompany() {
        this.finishedProjectList = new FinishedProjectList();
        this.ongoingProjects = new ArrayList<>();
    }


    public void listAllOngoing() {
        for (Project project : ongoingProjects) {
            System.out.println(project.toString());
        }

    }

    public void listAllFinished() {
        System.out.println(finishedProjectList.toString());
    }

    public void addNewProject(Project project) {
        ongoingProjects.add(project);
    }

    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData) {
        int index = ongoingProjects.indexOf(projectToEdit);
        if (index != -1) {
            ongoingProjects.set(index, projectWithNewData);
        } else {
            System.out.println("Project not found in ongoing projects.");
        }
    }

    public void editStatusOfFinishedProject(Project project) {
        project = finishedProjectList.sendToOngoing(project);
    }

    public void deleteOngoingProject(Project project) {
        ongoingProjects.remove(project);
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
    /*void showReportInfo() {
    }*/
}
