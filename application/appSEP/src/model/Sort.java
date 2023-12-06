package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {
  private ArrayList<Project> listToSort;
  private Order order;
  private SortingCategory sortingCategory;
  private ProjectType projectType;

  public Sort(ArrayList<Project> listToSort, Order order, SortingCategory sortingCategory, ProjectType projectType){
    this.listToSort = listToSort;
    this.sortingCategory = sortingCategory;
    this.order = order;
    this.projectType = projectType;
  }

  public ArrayList<Project> sortByMoney(Order order) {
    Comparator<Project> comparator = Comparator.comparingInt(Project::getExpectedBudget);
    return sort(comparator, order);
  }

  public ArrayList<Project> sortByDate(Order order) {
    Comparator<Project> comparator = Comparator.comparing(Project::getCreationDate);
    return sort(comparator, order);
  }

  public ArrayList<Project> sortByMonths(Order order) {
    Comparator<Project> comparator = Comparator.comparingInt(Project::getExpectedMonths);
    return sort(comparator, order);
  }

  public ArrayList<Project> sortByOnlyOneType(Order order, ProjectType type) {
    // Filter projects by the specified type
    ArrayList<Project> filteredProjects = listToSort.stream()
        .filter(project -> projectTypeMatches(project, type))
        .collect(Collectors.toCollection(ArrayList::new));

    return filteredProjects;
  }

  private boolean projectTypeMatches(Project project, ProjectType type) {
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
        return true;
    }
  }



  private ArrayList<Project> sort(Comparator<Project> comparator, Order order) {
    if (order == Order.decreasing) {
      comparator = comparator.reversed();
    }
    Collections.sort(listToSort, comparator);
    return listToSort;
  }


  public enum Order {
    increasing, decreasing
  }
  public enum SortingCategory{
    money, monthsSpent, date
  }
  public enum ProjectType{
    residental, comercial, industrial, road, all
  }

}
