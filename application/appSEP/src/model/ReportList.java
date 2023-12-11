package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code ReportList} class represents a list of finished projects with filtering and sorting capabilities.
 */
public class ReportList {
  private FinishedProjectList reportList;
  private MyDate fromDate, toDate;

  /**
   * Constructs a new {@code ReportList} with the specified parameters.
   *
   * @param finishedProjectList The list of finished projects.
   * @param fromDate            The starting date for filtering projects.
   * @param toDate              The ending date for filtering projects.
   */
  public ReportList(FinishedProjectList finishedProjectList, MyDate fromDate, MyDate toDate) {
    this.reportList = finishedProjectList.copy();
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  /**
   * Applies filters and sorting to the finished projects based on the specified criteria.
   *
   * @param order            The sorting order.
   * @param sortingCategory  The sorting category.
   * @param projectType      The type of projects to include in the report.
   * @return A list of filtered and sorted projects.
   */
  public ArrayList<Project> applyFilters(Sort.Order order, Sort.SortingCategory sortingCategory,
                                         Sort.ProjectType projectType) {
    List<Project> filteredList = reportList.getFinishedProjects().stream()
            .filter(project -> project.getCreationDate().isInInterval(fromDate, toDate))
            .filter(project -> projectType == Sort.ProjectType.all || projectMatchesType(project, projectType))
            .toList();

    Sort sort = new Sort(new ArrayList<>(filteredList), order, sortingCategory, projectType);

    switch (sortingCategory) {
      case money:
        return sort.sortByMoney(order);
      case monthsSpent:
        return sort.sortByMonths(order);
      case date:
        return sort.sortByDate(order);
      default:
        return new ArrayList<>(filteredList);
    }
  }

  /**
   * Checks if a project matches the specified type.
   *
   * @param project The project to check.
   * @param type    The project type to match.
   * @return {@code true} if the project matches the type, {@code false} otherwise.
   */
  private boolean projectMatchesType(Project project, Sort.ProjectType type) {
    switch (type) {
      case residental:
        return project instanceof Residental;
      case comercial:
        return project instanceof Commercial;
      case industrial:
        return project instanceof Industrial;
      case road:
        return project instanceof Road;
      default:
        return false;
    }
  }

  /**
   * Returns a string representation of the projects in the report.
   *
   * @return A string representation of the projects.
   */
  public String toString() {
    String output = "";
    for (Project project : reportList.getFinishedProjects()) {
      output += project.toString();
    }
    return output;
  }

  /**
   * Checks if this report list is equal to another object.
   *
   * @param obj The object to compare.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
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
   * Creates a copy of the finished project list in the report.
   *
   * @return A copy of the finished project list.
   */
  public FinishedProjectList copy() {
    FinishedProjectList newList = new FinishedProjectList();
    for (Project project : reportList.getFinishedProjects()) {
      newList.addToFinishedList(project.copy());
    }
    return newList;
  }
}
