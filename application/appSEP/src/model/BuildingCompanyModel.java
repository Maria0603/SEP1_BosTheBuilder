package model;

/**
 * The {@code BuildingCompanyModel} interface defines the operations that a building company should support.
 * Implementing classes or interfaces should provide functionality related to ongoing and finished projects,
 * as well as report generation.
 */
public interface BuildingCompanyModel {

    /**
     * Lists all ongoing projects, displaying their information.
     */
    public void listAllOngoing();

    /**
     * Lists all finished projects, displaying their information.
     */
    public void listAllFinished();

    /**
     * Adds a new project to the building company's project list.
     *
     * @param project The project to be added.
     */
    public void addNewProject(Project project);

    /**
     * Edits the data of an ongoing project.
     *
     * @param projectToEdit       The project to be edited.
     * @param projectWithNewData  The project with the new data.
     */
    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData);

    /**
     * Edits the status of a finished project.
     *
     * @param project The project whose status is to be edited.
     */
    public void editStatusOfFinishedProject(Project project);

    /**
     * Deletes an ongoing project from the building company's project list.
     *
     * @param project The project to be deleted.
     */
    public void deleteOngoingProject(Project project);

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
                                     Sort.SortingCategory sortingCategory, Sort.ProjectType projectType);
    //void showReportInfo();
}
