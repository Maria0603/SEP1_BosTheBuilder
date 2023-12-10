package model;

import java.util.ArrayList;

public class BuildingCompany implements BuildingCompanyModel {

  private FinishedProjectList finishedProjectList;
  private OngoingProjectList ongoingProjectList;
  private ReportList reportList;


  public BuildingCompany() {
    FilePersistance fileSystem = new FilePersistance();

    // Read the finished projects from the XML file
    this.finishedProjectList = fileSystem.readFromFinishedFXMLFile();

    this.ongoingProjectList = fileSystem.readFromOngoingFXMLFile();
    this.reportList = null;
  }

  public ArrayList<Project> getOngoingProjects() {
    return (ArrayList<Project>) ongoingProjectList.getOngoingProjects();
  }

  public ArrayList<Project> getFinishedProjects() {
    return (ArrayList<Project>) finishedProjectList.getFinishedProjects();
  }

  public ArrayList<Project> getReportProjects() {
    return reportList.getReportList();
  }

  public void addOngoingProject(Project project) {
    ongoingProjectList.getOngoingProjects().add(project);
    FilePersistance.writeToOngoingXMLFile(ongoingProjectList);
  }

  public void addFinishedProject(Project project) {
    finishedProjectList.addToFinishedList(project);
    FilePersistance.writeToFinishedXMLFile(finishedProjectList);
  }

  public void editOngoingProjectData(Project projectToEdit,
      Project projectWithNewData) {
    int index = ongoingProjectList.getOngoingProjects().indexOf(projectToEdit);
    if (index != -1) {
      ongoingProjectList.getOngoingProjects().set(index, projectWithNewData);
      FilePersistance.writeToOngoingXMLFile(ongoingProjectList);
    }
    else {
      System.out.println("Project not found in ongoing projects.");
    }
  }

  public void deleteFinishedProject(Project project) {
    finishedProjectList.removeFromFinishedList(project);
    FilePersistance.writeToFinishedXMLFile(finishedProjectList);
  }

  public void deleteOngoingProject(Project project) {
    ongoingProjectList.deleteProjectFromOngoingList(project);
    FilePersistance.writeToOngoingXMLFile(ongoingProjectList);
  }

  public ReportList generateReport(MyDate fromDate, MyDate toDate,
      Sort.Order order, Sort.SortingCategory sortingCategory,
      Sort.ProjectType projectType) {
    ReportList reports = new ReportList(finishedProjectList, fromDate, toDate);
    ArrayList<Project> filteredAndSortedProjects = reports.applyFilters(order,
        sortingCategory, projectType);

    // Display or process the generated report
    for (Project project : filteredAndSortedProjects) {
      System.out.println(project.toString());
    }
    return reports; // Return the report list if needed for further processing
  }

  @Override public Project getOngoingProject(int projectId) {
    for (int i = 0; i < ongoingProjectList.getOngoingProjects().size(); i++) {
      if (ongoingProjectList.getOngoingProjects().get(i).getId() == projectId) {
        return ongoingProjectList.getOngoingProjects().get(i);
      }
    }

    return null;
  }

  @Override public Project getFinishedProject(int projectId) {
    for (int i = 0; i < finishedProjectList.getSize(); i++) {
      if (finishedProjectList.getFinishedProjects().get(i).getId()
          == projectId) {
        return finishedProjectList.getFinishedProjects().get(i);
      }
    }
    return null;
  }

}
