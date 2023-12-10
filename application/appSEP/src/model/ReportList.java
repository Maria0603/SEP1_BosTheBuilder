package model;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class ReportList {
  private ArrayList<Project> reportList;
  MyDate fromDate, toDate;

  public ReportList(FinishedProjectList finishedProjectList, MyDate fromDate, MyDate toDate){
    this.reportList = (ArrayList<Project>) finishedProjectList.getFinishedProjects();
    this.fromDate = fromDate;
    this.toDate = toDate;
  }
  public ReportList(FinishedProjectList finishedProjectList){
    this.reportList = (ArrayList<Project>) finishedProjectList.getFinishedProjects();
    this.fromDate = null;
    this.toDate = null;
  }

  public void setFromDate(MyDate fromDate) {
    this.fromDate = fromDate;
  }

  public void setToDate(MyDate toDate) {
    this.toDate = toDate;
  }

  public ArrayList<Project> getReportList() {
    return reportList;
  }

  public void setReportList(FinishedProjectList finishedProjectList){
    this.reportList = (ArrayList<Project>) finishedProjectList.getFinishedProjects();
    //this.reportList = finishedProjectList;
  }

  public void setReportList(ArrayList<Project> reportList){
    this.reportList = reportList;
  }

  public ArrayList<Project> applyFilters(Sort.Order order, Sort.SortingCategory sortingCategory,
      Sort.ProjectType projectType) {
    List<Project> filteredList = reportList.stream()
        .filter(project -> project.getCreationDate().isInInterval(fromDate, toDate))
        .filter(project -> projectType == Sort.ProjectType.ALL || projectMatchesType(project, projectType))
        .toList();

    Sort sort = new Sort(new ArrayList<>(filteredList), order, sortingCategory, projectType );

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
  public String toString()
  {
    String output = "";
    for ( Project project : reportList)
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
    for (Project project : reportList) {
      newList.addToFinishedList(project.copy());
    }
    return newList;
  }

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
