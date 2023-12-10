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

  public void setFromDateForReport(MyDate date) {
    reportList.setFromDate(date);
  }

  public void setToDateForReport(MyDate date) {
    reportList.setToDate(date);
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

  public void setReportProjects(FinishedProjectList finishedProjectList) {
    this.reportList.setReportList(finishedProjectList);
  }

  public void setReportList(ArrayList<Project> reportList) {
    this.reportList.setReportList(reportList);
  }

  public void resetReportList() {
    this.reportList = new ReportList(finishedProjectList);
  }

  public void addOngoingProject(Project project) {
    ongoingProjectList.getOngoingProjects().add(project);
    FilePersistance.writeToOngoingXMLFile(ongoingProjectList);
  }

  public void addFinishedProject(Project project) {
    finishedProjectList.addToFinishedList(project);
    reportList.setReportList(finishedProjectList);
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
    reportList.setReportList(finishedProjectList);
    FilePersistance.writeToFinishedXMLFile(finishedProjectList);
  }

  public void deleteOngoingProject(Project project) {
    ongoingProjectList.deleteProjectFromOngoingList(project);
    FilePersistance.writeToOngoingXMLFile(ongoingProjectList);
  }

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

  @Override public void generateReportTXT() {
    FilePersistance.createReportTXTFile(getReportProjects());
  }

  @Override public Project getOngoingProject(int projectId) {
    for (int i = 0; i < ongoingProjectList.getOngoingProjects().size(); i++) {
      if (ongoingProjectList.getOngoingProjects().get(i).getId() == projectId) {
        return ongoingProjectList.getOngoingProjects().get(i);
      }
    }

    return null;
  }

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
