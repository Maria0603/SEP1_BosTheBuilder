package model;

import java.util.ArrayList;

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


    public void addOngoingProject(Project project) {
        ongoingProjectList.getOngoingProjects().add(project);
    }

    public void addFinishedProject(Project project) {
        finishedProjectList.addToFinishedList(project);
    }

    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData) {
        int index = ongoingProjectList.getOngoingProjects().indexOf(projectToEdit);
        if (index != -1) {
            ongoingProjectList.getOngoingProjects().set(index, projectWithNewData);
        } else {
            System.out.println("Project not found in ongoing projects.");
        }
    }


    public void deleteFinishedProject(Project project) {
        finishedProjectList.removeFromFinishedList(project);
    }
    public void deleteOngoingProject(Project project) {
        ongoingProjectList.deleteProjectFromOngoingList(project);
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

    @Override public Project getFinishedProject(int projectId) {
        for (int i = 0; i < finishedProjectList.getSize(); i++) {
            if (finishedProjectList.getFinishedProjects().get(i).getId() == projectId){
                return finishedProjectList.getFinishedProjects().get(i);
            }
        }
        return null;
    }

}
