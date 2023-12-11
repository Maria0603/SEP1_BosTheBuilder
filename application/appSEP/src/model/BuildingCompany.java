package model;

import java.util.ArrayList;

/**
 * The {@code BuildingCompany} class represents a building company and its operations.
 * It manages ongoing and finished projects, allowing the addition, modification, and deletion of projects.
 * Additionally, the class can generate reports based on specified criteria.
 */
public class BuildingCompany implements BuildingCompanyModel {

    private FinishedProjectList finishedProjectList;
    private ArrayList<Project> ongoingProjects;

    /**
     * Constructs a new {@code BuildingCompany} object with an empty finished project list
     * and an empty list of ongoing projects.
     */
    public BuildingCompany() {
        this.finishedProjectList = new FinishedProjectList();
        this.ongoingProjects = new ArrayList<>();
    }

    /**
     * Lists all ongoing projects, displaying their information.
     */
    public void listAllOngoing() {
        for (Project project : ongoingProjects) {
            System.out.println(project.toString());
        }
    }

    /**
     * Lists all finished projects, displaying their information.
     */
    public void listAllFinished() {
        System.out.println(finishedProjectList.toString());
    }

    /**
     * Adds a new project to the list of ongoing projects.
     *
     * @param project The project to be added.
     */
    public void addNewProject(Project project) {
        ongoingProjects.add(project);
    }

    /**
     * Edits the data of an ongoing project.
     *
     * @param projectToEdit       The project to be edited.
     * @param projectWithNewData  The project with the new data.
     */
    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData) {
        int index = ongoingProjects.indexOf(projectToEdit);
        if (index != -1) {
            ongoingProjects.set(index, projectWithNewData);
        } else {
            System.out.println("Project not found in ongoing projects.");
        }
    }

    /**
     * Edits the status of a finished project, moving it to the ongoing projects list.
     *
     * @param project The project to be moved to ongoing projects.
     */
    public void editStatusOfFinishedProject(Project project) {
        project = finishedProjectList.sendToOngoing(project);
    }

    /**
     * Deletes an ongoing project from the list.
     *
     * @param project The project to be deleted.
     */
    public void deleteOngoingProject(Project project) {
        ongoingProjects.remove(project);
    }

    /**
     * Generates a report based on specified criteria and returns the list of reports.
     *
     * @param fromDate         The starting date for the report.
     * @param toDate           The ending date for the report.
     * @param order            The order in which to sort the report.
     * @param sortingCategory  The category by which to sort the report.
     * @param projectType      The type of project to include in the report.
     * @return The list of generated reports.
     */
    public ReportList generateReport(MyDate fromDate, MyDate toDate, Sort.Order order,
                                     Sort.SortingCategory sortingCategory, Sort.ProjectType projectType) {
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
