import javafx.application.Application;
import model.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Application.launch(MyApplication.class);


//    // Create some MyDate instances for the test
//    MyDate startDate = new MyDate(1, 1, 2020);
//    MyDate endDate = new MyDate(31, 12, 2020);
//    MyDate date1 = new MyDate(10, 2, 2020);
//    MyDate date2 = new MyDate(15, 6, 2020);
//    MyDate date3 = new MyDate(20, 10, 2020);
//
//    // Create some sample projects
//    Project residentialProject = new Residental(1, "Residential Project", 3000, 12, date1, null, 120, 1, 1, 1, true);
//    Project commercialProject = new Commercial(2, "Commercial Project", 6000, 24, date2, null, 240, 2, "Retail");
//    Project industrialProject = new Industrial(3, "Industrial Project", 12000, 36, date3, null, 480, "Factory");
//
//    // Add them to the finished project list
//    FinishedProjectList finishedProjectList = new FinishedProjectList();
//    finishedProjectList.addToFinishedList(residentialProject);
//    finishedProjectList.addToFinishedList(commercialProject);
//    finishedProjectList.addToFinishedList(industrialProject);
//
//    // Create the ReportList instance
//    ReportList reportList = new ReportList(finishedProjectList, startDate, endDate);
//
//    // Apply filters for different scenarios and print the results
//    // Here we're assuming the finished projects list already contains only finished projects
//    ArrayList<Project> filteredProjects;
//
//    // Filter by date and residential projects
//    System.out.println("Residential projects between " + startDate + " and " + endDate + ":");
//    filteredProjects = reportList.applyFilters(Sort.Order.increasing, Sort.SortingCategory.date, Sort.ProjectType.residental);
//    filteredProjects.forEach(project -> System.out.println(project.getTitle() + " - " + project.getExpectedBudget()));
//
//    // Filter by budget and commercial projects
//    System.out.println("\nCommercial projects sorted by budget:");
//    filteredProjects = reportList.applyFilters(Sort.Order.decreasing, Sort.SortingCategory.money, Sort.ProjectType.comercial);
//    filteredProjects.forEach(project -> System.out.println(project.getTitle() + " - " + project.getExpectedBudget()));
//
//    // ... other test cases
 }
}