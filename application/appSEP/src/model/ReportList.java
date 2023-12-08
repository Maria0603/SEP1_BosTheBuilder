package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportList {
  private FinishedProjectList reportList;
  MyDate fromDate, toDate;

  public ReportList(FinishedProjectList finishedProjectList, MyDate fromDate, MyDate toDate){
    this.reportList = finishedProjectList.copy();
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public ArrayList<Project> applyFilters(Sort.Order order, Sort.SortingCategory sortingCategory,
      Sort.ProjectType projectType) {
    List<Project> filteredList = reportList.getFinishedProjects().stream()
        .filter(project -> project.getCreationDate().isInInterval(fromDate, toDate))
        .filter(project -> projectType == Sort.ProjectType.all || projectMatchesType(project, projectType))
        .toList();

    Sort sort = new Sort(new ArrayList<>(filteredList), order, sortingCategory, projectType );

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
  private boolean projectMatchesType(Project project, Sort.ProjectType type) {
    switch (type) {
      case residental:
        return project instanceof Residential;
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
  public String toString()
  {
    String output = "";
    for ( Project project : reportList.getFinishedProjects())
    {
      output += project.toString();
    }
    return output;
  }

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
  public FinishedProjectList copy() {
    FinishedProjectList newList = new FinishedProjectList();
    for (Project project : reportList.getFinishedProjects()) {
      newList.addToFinishedList(project.copy());
    }
    return newList;
  }

}
