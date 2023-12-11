package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code Sort} class provides methods to sort a list of projects based on different criteria.
 */
public class Sort {
  private ArrayList<Project> listToSort;
  private Order order;
  private SortingCategory sortingCategory;
  private ProjectType projectType;

  /**
   * Constructs a new Sort object with the specified parameters.
   *
   * @param listToSort       The list of projects to be sorted.
   * @param order            The order of sorting (increasing or decreasing).
   * @param sortingCategory  The category by which to sort the projects (money, monthsSpent, date).
   * @param projectType      The type of projects to include in the sorting.
   */
  public Sort(ArrayList<Project> listToSort, Order order, SortingCategory sortingCategory, ProjectType projectType) {
    this.listToSort = listToSort;
    this.sortingCategory = sortingCategory;
    this.order = order;
    this.projectType = projectType;
  }

  /**
   * Sorts the list of projects by expected budget.
   *
   * @param order The order of sorting (increasing or decreasing).
   * @return The sorted list of projects.
   */
  public ArrayList<Project> sortByMoney(Order order) {
    Comparator<Project> comparator = Comparator.comparingInt(Project::getExpectedBudget);
    return sort(comparator, order);
  }

  /**
   * Sorts the list of projects by creation date.
   *
   * @param order The order of sorting (increasing or decreasing).
   * @return The sorted list of projects.
   */
  public ArrayList<Project> sortByDate(Order order) {
    Comparator<Project> comparator = Comparator.comparing(Project::getCreationDate);
    return sort(comparator, order);
  }

  /**
   * Sorts the list of projects by expected months.
   *
   * @param order The order of sorting (increasing or decreasing).
   * @return The sorted list of projects.
   */
  public ArrayList<Project> sortByMonths(Order order) {
    Comparator<Project> comparator = Comparator.comparingInt(Project::getExpectedMonths);
    return sort(comparator, order);
  }

  /**
   * Sorts the list of projects by only the specified project type.
   *
   * @param order The order of sorting (increasing or decreasing).
   * @param type  The project type to include in the sorting.
   * @return The sorted list of projects of the specified type.
   */
  public ArrayList<Project> sortByOnlyOneType(Order order, ProjectType type) {
    // Filter projects by the specified type
    ArrayList<Project> filteredProjects = listToSort.stream()
            .filter(project -> projectTypeMatches(project, type))
            .collect(Collectors.toCollection(ArrayList::new));

    return filteredProjects;
  }

  /**
   * Checks if a project matches the specified project type.
   *
   * @param project The project to check.
   * @param type    The project type to match.
   * @return {@code true} if the project matches the type, {@code false} otherwise.
   */
  private boolean projectTypeMatches(Project project, ProjectType type) {
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
        return true;
    }
  }

  /**
   * Sorts the list of projects based on the specified comparator and order.
   *
   * @param comparator The comparator to use for sorting.
   * @param order      The order of sorting (increasing or decreasing).
   * @return The sorted list of projects.
   */
  private ArrayList<Project> sort(Comparator<Project> comparator, Order order) {
    if (order == Order.decreasing) {
      comparator = comparator.reversed();
    }
    Collections.sort(listToSort, comparator);
    return listToSort;
  }

  /**
   * Enumeration representing the order of sorting.
   */
  public enum Order {
    increasing, decreasing
  }

  /**
   * Enumeration representing the sorting category.
   */
  public enum SortingCategory {
    money, monthsSpent, date
  }

  /**
   * Enumeration representing the project type.
   */
  public enum ProjectType {
    residental, comercial, industrial, road, all
  }
}
