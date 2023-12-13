package model;

import java.util.ArrayList;

/**
 * Represents a building company that manages ongoing and finished projects, generates reports,
 * and interacts with file persistence.
 */
public class BuildingCompany implements BuildingCompanyModel {

  private FinishedProjectList finishedProjectList;
  private OngoingProjectList ongoingProjectList;
  private ReportList reportList;

  /**
   * Constructs a BuildingCompany, initializing project lists and reading data from XML files.
   */
  public BuildingCompany() {
    FilePersistance fileSystem = new FilePersistance();

    // Read the finished projects from the XML file
    this.finishedProjectList = fileSystem.readFromFinishedFXMLFile();
    this.ongoingProjectList = fileSystem.readFromOngoingFXMLFile();
    setDates();
    this.reportList = new ReportList(finishedProjectList);
    System.out.println(reportList);
  }

  private void setDates() {
    for (Project tmp : finishedProjectList.getFinishedProjects()) {
      tmp.setCreationDate(
              MyDate.parseStringToDate(tmp.getCreationDateString()));
      tmp.setEndingDate(MyDate.parseStringToDate(tmp.getEndingDateString()));
      System.out.println(tmp.getCreationDate());
      System.out.println(tmp.getEndingDate());
    }
    for (Project tmp : ongoingProjectList.getOngoingProjects()) {
      tmp.setCreationDate(
              MyDate.parseStringToDate(tmp.getCreationDateString()));
      System.out.println(tmp.getCreationDate());
    }
  }

  /**
   * Sets the start date for generating reports.
   *
   * @param date The start date.
   */
  public void setFromDateForReport(MyDate date) {
    reportList.setFromDate(date);
  }

  /**
   * Sets the end date for generating reports.
   *
   * @param date The end date.
   */
  public void setToDateForReport(MyDate date) {
    reportList.setToDate(date);
  }

  /**
   * Gets a list of ongoing projects.
   *
   * @return The list of ongoing projects.
   */
  public ArrayList<Project> getOngoingProjects() {
    return (ArrayList<Project>) ongoingProjectList.getOngoingProjects();
  }

  /**
   * Gets a list of finished projects.
   *
   * @return The list of finished projects.
   */
  public ArrayList<Project> getFinishedProjects() {
    return (ArrayList<Project>) finishedProjectList.getFinishedProjects();
  }

  /**
   * Gets a list of projects for generating reports.
   *
   * @return The list of projects for generating reports.
   */
  public ArrayList<Project> getReportProjects() {
    return reportList.getReportList();
  }

  /**
   * Sets the list of projects for generating reports.
   *
   * @param finishedProjectList The list of finished projects.
   */
  public void setReportProjects(FinishedProjectList finishedProjectList) {
    this.reportList.setReportList(finishedProjectList);
  }

  /**
   * Sets the list of projects for generating reports.
   *
   * @param reportList The list of projects for generating reports.
   */
  public void setReportList(ArrayList<Project> reportList) {
    this.reportList.setReportList(reportList);
  }

  /**
   * Resets the report list.
   */
  public void resetReportList() {
    this.reportList = new ReportList(finishedProjectList);
  }

  /**
   * Adds an ongoing project.
   *
   * @param project The ongoing project to add.
   */
  public void addOngoingProject(Project project) {
    ongoingProjectList.getOngoingProjects().add(project);
    FilePersistance.writeToOngoingXMLFile(ongoingProjectList);
  }

  /**
   * Adds a finished project.
   *
   * @param project The finished project to add.
   */
  public void addFinishedProject(Project project) {
    finishedProjectList.addToFinishedList(project);
    reportList.setReportList(finishedProjectList);
    FilePersistance.writeToFinishedXMLFile(finishedProjectList);
  }

  /**
   * Edits data for an ongoing project.
   *
   * @param projectToEdit    The ongoing project to edit.
   * @param projectWithNewData The project with new data.
   */
  public void editOngoingProjectData(Project projectToEdit,
                                     Project projectWithNewData) {
    int index = ongoingProjectList.getOngoingProjects().indexOf(projectToEdit);
    if (index != -1) {
      ongoingProjectList.getOngoingProjects().set(index, projectWithNewData);
      FilePersistance.writeToOngoingXMLFile(ongoingProjectList);
    } else {
      System.out.println("Project not found in ongoing projects.");
    }
  }

  /**
   * Deletes a finished project.
   *
   * @param project The finished project to delete.
   */
  public void deleteFinishedProject(Project project) {
    finishedProjectList.removeFromFinishedList(project);
    reportList.setReportList(finishedProjectList);
    FilePersistance.writeToFinishedXMLFile(finishedProjectList);
  }

  /**
   * Deletes an ongoing project.
   *
   * @param project The ongoing project to delete.
   */
  public void deleteOngoingProject(Project project) {
    ongoingProjectList.deleteProjectFromOngoingList(project);
    FilePersistance.writeToOngoingXMLFile(ongoingProjectList);
  }

  /**
   * Generates a report based on specified parameters.
   *
   * @param order            The order of the report.
   * @param sortingCategory  The sorting category.
   * @param projectType      The type of project.
   * @return The generated report list.
   */
  public ReportList generateReport(Sort.Order order,
                                   Sort.SortingCategory sortingCategory, Sort.ProjectType projectType) {

    ArrayList<Project> filteredProjects;

    filteredProjects = reportList.applyFilters(order, sortingCategory,
            projectType);

    // Display or process the generated report
    for (Project project : filteredProjects) {
      System.out.println(project.toString());
    }
    setReportList(filteredProjects);

    return reportList; // Return the report list if needed for further processing
  }

  /**
   * Generates a TXT report.
   */
  @Override
  public void generateReportTXT() {
    FilePersistance.createReportTXTFile(getReportProjects());
  }

  /**
   * Gets the ongoing project with the specified ID.
   *
   * @param projectId The ID of the ongoing project.
   * @return The ongoing project with the specified ID.
   */
  @Override
  public Project getOngoingProject(int projectId) {
    for (int i = 0; i < ongoingProjectList.getOngoingProjects().size(); i++) {
      if (ongoingProjectList.getOngoingProjects().get(i).getId() == projectId) {
        return ongoingProjectList.getOngoingProjects().get(i);
      }
    }

    return null;
  }

  /**
   * Gets the finished project with the specified ID.
   *
   * @param projectId The ID of the finished project.
   * @return The finished project with the specified ID.
   */
  public Project getFinishedProject(int projectId) {
    for (int i = 0; i < finishedProjectList.getSize(); i++) {
      if (finishedProjectList.getFinishedProjects().get(i).getId()
              == projectId) {
        return finishedProjectList.getFinishedProjects().get(i);
      }
    }
    return null;
  }
}
