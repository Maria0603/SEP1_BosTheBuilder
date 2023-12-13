package model;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of finished projects for reporting purposes.
 */
public class ReportList {
  private ArrayList<Project> reportList;
  MyDate fromDate, toDate;

  /**
   * Constructs a ReportList with the specified finished project list, start date, and end date.
   *
   * @param finishedProjectList The finished project list.
   * @param fromDate            The start date for filtering.
   * @param toDate              The end date for filtering.
   */
  public ReportList(FinishedProjectList finishedProjectList, MyDate fromDate, MyDate toDate) {
    this.reportList = (ArrayList<Project>) finishedProjectList.getFinishedProjects();
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  /**
   * Constructs a ReportList with the specified finished project list.
   *
   * @param finishedProjectList The finished project list.
   */
  public ReportList(FinishedProjectList finishedProjectList) {
    this.reportList = (ArrayList<Project>) finishedProjectList.getFinishedProjects();
    this.fromDate = null;
    this.toDate = null;
  }

  /**
   * Sets the start date for filtering.
   *
   * @param fromDate The start date.
   */
  public void setFromDate(MyDate fromDate) {
    this.fromDate = fromDate;
  }

  /**
   * Sets the end date for filtering.
   *
   * @param toDate The end date.
   */
  public void setToDate(MyDate toDate) {
    this.toDate = toDate;
  }

  /**
   * Gets the list of projects for reporting.
   *
   * @return The list of projects.
   */
  public ArrayList<Project> getReportList() {
    return reportList;
  }

  /**
   * Sets the report list based on a finished project list.
   *
   * @param finishedProjectList The finished project list.
   */
  public void setReportList(FinishedProjectList finishedProjectList) {
    this.reportList = (ArrayList<Project>) finishedProjectList.getFinishedProjects();
  }

  /**
   * Sets the report list with a custom list of projects.
   *
   * @param reportList The list of projects.
   */
  public void setReportList(ArrayList<Project> reportList) {
    this.reportList = reportList;
  }

  /**
   * Applies filters to the report list based on order, sorting category, and project type.
   *
   * @param order           The sorting order.
   * @param sortingCategory The sorting category.
   * @param projectType     The project type.
   * @return The filtered and sorted list of projects.
   */
  public ArrayList<Project> applyFilters(Sort.Order order, Sort.SortingCategory sortingCategory,
                                         Sort.ProjectType projectType) {
    List<Project> filteredList = reportList.stream()
            .filter(project -> project.getCreationDate().isInInterval(fromDate, toDate))
            .filter(project -> projectType == Sort.ProjectType.ALL || projectMatchesType(project, projectType))
            .toList();

    Sort sort = new Sort(new ArrayList<>(filteredList), order, sortingCategory, projectType);

    switch (sortingCategory) {
      case BUDGET:
        return sort.sortByMoney(order);
      case MONTHS_SPENT:
        return sort.sortByMonths(order);
      case DATE:
        return sort.sortByDate(order);
      default:
        return new ArrayList<>(filteredList);
    }
  }

  private boolean projectMatchesType(Project project, Sort.ProjectType type) {
    switch (type) {
      case RESIDENTIAL:
        return project instanceof Residential;
      case COMMERCIAL:
        return project instanceof Commercial;
      case INDUSTRIAL:
        return project instanceof Industrial;
      case ROAD:
        return project instanceof Road;
      default:
        return false;
    }
  }

  /**
   * Returns a string representation of the report list.
   *
   * @return A string representation of the report list.
   */
  public String toString() {
    String output = "";
    for (Project project : reportList) {
      output += project.toString();
    }
    return output;
  }

  /**
   * Checks if the current report list is equal to another object.
   *
   * @param obj The object to compare with.
   * @return True if the report lists are equal, false otherwise.
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ReportList other = (ReportList) obj;
    return this.reportList.equals(other.reportList);
  }

  /**
   * Creates a copy of the finished project list.
   *
   * @return A copy of the finished project list.
   */
  public FinishedProjectList copy() {
    FinishedProjectList newList = new FinishedProjectList();
    for (Project project : reportList) {
      newList.addToFinishedList(project.copy());
    }
    return newList;
  }

  /**
   * Main method for testing the ReportList class.
   *
   * @param args Command line arguments.
   * @throws JAXBException If there's an issue with JAXB.
   */
  public static void main(String[] args) throws JAXBException {
    BuildingCompany model = new BuildingCompany();
    System.out.println(model.getReportProjects());
    FinishedProjectList tmp = new FinishedProjectList();
    tmp.setFinishedProjects(model.getFinishedProjects());

    ReportList reportTest = new ReportList(tmp);
    System.out.println(reportTest);

    reportTest.applyFilters(Sort.Order.INCREASING, Sort.SortingCategory.BUDGET, Sort.ProjectType.COMMERCIAL);
    System.out.println(reportTest);
  }
}
