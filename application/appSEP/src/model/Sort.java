package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * The Sort class provides methods to sort and filter a list of projects based on various criteria.
 */
public class Sort {
  private ArrayList<Project> listToSort;
  private Order order;
  private SortingCategory sortingCategory;
  private ProjectType projectType;

  /**
   * Constructs a Sort object with the specified parameters.
   *
   * @param listToSort       The list of projects to be sorted.
   * @param order            The sorting order (increasing or decreasing).
   * @param sortingCategory  The category by which to sort the projects (budget, months spent, date).
   * @param projectType      The type of project to consider during sorting.
   */
  public Sort(ArrayList<Project> listToSort, Order order,
              SortingCategory sortingCategory, ProjectType projectType) {
    this.listToSort = listToSort;
    this.sortingCategory = sortingCategory;
    this.order = order;
    this.projectType = projectType;
  }

  /**
   * Sorts the list of projects by expected budget.
   *
   * @param order The sorting order (increasing or decreasing).
   * @return The sorted list of projects.
   */
  public ArrayList<Project> sortByMoney(Order order) {
    Comparator<Project> comparator = Comparator.comparingInt(
            Project::getExpectedBudget);
    return sort(comparator, order);
  }

  /**
   * Sorts the list of projects by creation date.
   *
   * @param order The sorting order (increasing or decreasing).
   * @return The sorted list of projects.
   */
  public ArrayList<Project> sortByDate(Order order) {
    Comparator<Project> comparator = Comparator.comparing(
            Project::getCreationDate);
    return sort(comparator, order);
  }

  /**
   * Sorts the list of projects by expected months.
   *
   * @param order The sorting order (increasing or decreasing).
   * @return The sorted list of projects.
   */
  public ArrayList<Project> sortByMonths(Order order) {
    Comparator<Project> comparator = Comparator.comparingInt(
            Project::getExpectedMonths);
    return sort(comparator, order);
  }

  /**
   * Filters and returns a list of projects of a specific type.
   *
   * @param order The sorting order (increasing or decreasing).
   * @param type  The specific project type to include in the result.
   * @return The filtered list of projects.
   */
  public ArrayList<Project> sortByOnlyOneType(Order order, ProjectType type) {
    // Filter projects by the specified type
    ArrayList<Project> filteredProjects = listToSort.stream()
            .filter(project -> projectTypeMatches(project, type))
            .collect(Collectors.toCollection(ArrayList::new));

    return filteredProjects;
  }

  private boolean projectTypeMatches(Project project, ProjectType type) {
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
        return true;
    }
  }

  private ArrayList<Project> sort(Comparator<Project> comparator, Order order) {
    if (order == Order.DECREASING) {
      comparator = comparator.reversed();
    }
    Collections.sort(listToSort, comparator);
    return listToSort;
  }

  /**
   * Enumeration representing the sorting order.
   */
  public enum Order {
    INCREASING, DECREASING
  }

  /**
   * Enumeration representing the sorting category.
   */
  public enum SortingCategory {
    BUDGET, MONTHS_SPENT, DATE
  }

  /**
   * Enumeration representing the type of project.
   */
  public enum ProjectType {
    RESIDENTIAL, COMMERCIAL, INDUSTRIAL, ROAD, ALL
  }

  /**
   * Main method for testing the Sort class.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    // Create some MyDate instances for the test
    MyDate startDate = new MyDate(1, 1, 2027);
    MyDate endDate = new MyDate(31, 12, 2028);
    MyDate date1 = new MyDate(10, 2, 2020);
    MyDate date2 = new MyDate(12, 5, 2027);
    MyDate date3 = new MyDate(13, 5, 2027);
    MyDate date4 = new MyDate(20, 10, 2026);

    // Create some sample projects
    Project residentialProject = new Residential(1, "Residential Project", 3000,
            12, date1, date4, 120, 1, 1, 1, true, 7);
    Project residentialProject2 = new Residential(1, "Residential Project", 3000,
            12, date2, date3, 120, 1, 1, 1, true, 7);
    Project commercialProject = new Commercial(2, "Commercial Project", 6000,
            24, date2, date4, 240, 2, "Retail");
    Project industrialProject = new Industrial(3, "Industrial Project", 12000,
            36, date3, date4, 480, "Factory");

    // Add them to the finished project list
    FinishedProjectList finishedProjectList = new FinishedProjectList();
    finishedProjectList.addToFinishedList(residentialProject);
    finishedProjectList.addToFinishedList(residentialProject2);
    finishedProjectList.addToFinishedList(commercialProject);
    finishedProjectList.addToFinishedList(industrialProject);

    // Create the ReportList instance
    ReportList reportList = new ReportList(finishedProjectList, startDate,
            endDate);

    // Apply filters for different scenarios and print the results
    // Here we're assuming the finished projects list already contains only finished projects
    ArrayList<Project> filteredProjects;

    // Filter by date and residential projects
    System.out.println(
            "Residential projects between " + startDate + " and " + endDate + ":");
    filteredProjects = reportList.applyFilters(Order.INCREASING,
            SortingCategory.DATE, ProjectType.RESIDENTIAL);
    filteredProjects.forEach(project -> System.out.println(
            project.getTitle() + " - " + project.getExpectedBudget()));

    // Filter by budget and commercial projects
    System.out.println("\nCommercial projects sorted by budget:");
    filteredProjects = reportList.applyFilters(Order.DECREASING,
            SortingCategory.BUDGET, ProjectType.COMMERCIAL);
    filteredProjects.forEach(project -> System.out.println(
            project.getTitle() + " - " + project.getCreationDate()));

    // ... other test cases
  }
}
