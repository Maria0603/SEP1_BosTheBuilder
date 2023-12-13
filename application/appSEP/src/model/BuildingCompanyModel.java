package model;

import java.util.ArrayList;

/**
 * Interface representing the model for a building company.
 */
public interface BuildingCompanyModel {

  /**
   * Get the list of ongoing projects.
   *
   * @return ArrayList of ongoing projects.
   */
  public ArrayList<Project> getOngoingProjects();

  /**
   * Get the list of finished projects.
   *
   * @return ArrayList of finished projects.
   */
  public ArrayList<Project> getFinishedProjects();

  /**
   * Get the list of projects for generating reports.
   *
   * @return ArrayList of projects for reports.
   */
  public ArrayList<Project> getReportProjects();

  /**
   * Get an ongoing project by its ID.
   *
   * @param projectId ID of the ongoing project.
   * @return Ongoing project with the specified ID.
   */
  public Project getOngoingProject(int projectId);

  /**
   * Get a finished project by its ID.
   *
   * @param projectId ID of the finished project.
   * @return Finished project with the specified ID.
   */
  public Project getFinishedProject(int projectId);

  /**
   * Set the list of projects for generating reports.
   *
   * @param reportList ArrayList of projects for reports.
   */
  public void setReportList(ArrayList<Project> reportList);

  /**
   * Set the start date for generating reports.
   *
   * @param date Start date for the report.
   */
  public void setFromDateForReport(MyDate date);

  /**
   * Set the end date for generating reports.
   *
   * @param date End date for the report.
   */
  public void setToDateForReport(MyDate date);

  /**
   * Add an ongoing project to the model.
   *
   * @param project Ongoing project to be added.
   */
  public void addOngoingProject(Project project);

  /**
   * Add a finished project to the model.
   *
   * @param project Finished project to be added.
   */
  public void addFinishedProject(Project project);

  /**
   * Edit the data of an ongoing project.
   *
   * @param projectToEdit      Ongoing project to be edited.
   * @param projectWithNewData Project with updated data.
   */
  public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData);

  /**
   * Delete an ongoing project from the model.
   *
   * @param project Ongoing project to be deleted.
   */
  public void deleteOngoingProject(Project project);

  /**
   * Delete a finished project from the model.
   *
   * @param project Finished project to be deleted.
   */
  public void deleteFinishedProject(Project project);

  /**
   * Generate a report based on specified parameters.
   *
   * @param order            Order for sorting the report.
   * @param sortingCategory  Sorting category for the report.
   * @param projectType      Type of projects to include in the report.
   * @return ReportList containing the generated report.
   */
  public ReportList generateReport(Sort.Order order, Sort.SortingCategory sortingCategory,
                                   Sort.ProjectType projectType);

  /**
   * Generate a TXT report based on the current report projects.
   */
  public void generateReportTXT();

  /**
   * Reset the report list to the original finished project list.
   */
  public void resetReportList();
}
