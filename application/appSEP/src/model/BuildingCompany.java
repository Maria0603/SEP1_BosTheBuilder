package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;

public class BuildingCompany implements BuildingCompanyModel {

    private FinishedProjectList finishedProjectList;
    private ArrayList<Project> ongoingProjectList;

    public BuildingCompany() {
        this.finishedProjectList = new FinishedProjectList();
        this.ongoingProjectList = new ArrayList<>();
    }


    public void listAllOngoing() {
        for (Project project : ongoingProjectList) {
            System.out.println(project.toString());
        }

    }

    public FinishedProjectList listAllFinished() {
        return finishedProjectList;
    }

    public void addNewProject(Project project) {
        ongoingProjectList.add(project);
    }

    public void editOngoingProjectData(Project projectToEdit, Project projectWithNewData) {
        int index = ongoingProjectList.indexOf(projectToEdit);
        if (index != -1) {
            ongoingProjectList.set(index, projectWithNewData);
        } else {
            System.out.println("Project not found in ongoing projects.");
        }
    }

    public void editStatusOfFinishedProject(Project project) {
        project = finishedProjectList.sendToOngoing(project);
    }

    public void deleteOngoingProject(Project project) {
        ongoingProjectList.remove(project);
    }

    public ReportList generateReport(MyDate fromDate, MyDate toDate, Sort.Order order, Sort.SortingCategory sortingCategory, Sort.ProjectType projectType) {
        ReportList reports = new ReportList(finishedProjectList, fromDate, toDate);
        ArrayList<Project> filteredAndSortedProjects = reports.applyFilters(order, sortingCategory, projectType);

        // Display or process the generated report
        for (Project project : filteredAndSortedProjects) {
            System.out.println(project.toString());
        }

        return reports; // Return the report list if needed for further processing
    }

    public List<Project> getOngoingProjectList() {
        // TODO :  With acutal data
        // return (ObservableList<Project>) ongoingProjects;
        MyDate startDate1 = new MyDate(1, 12, 2023);
        MyDate endingDate1 = new MyDate(1, 7, 2024);
        Industrial ABCCompany = new Industrial(1, "Industrial", 90000, 8, startDate1, endingDate1, 1000, "Company");
        ongoingProjectList.add(ABCCompany);

        MyDate startDate2 = new MyDate(10, 9, 2023);
        MyDate endingDate2 = new MyDate(10, 2, 2024);
        Residental residental = new Residental(2,"Residental ", 12212,5,startDate2,endingDate2,100,2,1,1,Boolean.TRUE);
        ongoingProjectList.add(residental);

        MyDate startDate4 = new MyDate(5, 07, 2023);
        MyDate endingDate4 = new MyDate(5, 05, 2024);
        Commercial commercial = new Commercial(4, "Commercial ", 49999, 10, startDate4, endingDate4, 777, 5, "Company");
        ongoingProjectList.add(commercial);
        return ongoingProjectList;

    }

//    @Override
//    public ObservableList<Project> getObservableOngoingProjectList() {
//        ObservableList<Project> observableList = FXCollections.observableArrayList();
//        observableList = (ObservableList<Project>) getOngoingProjectList();
//        return observableList;
//    }


    @Override
    public Project getOngoingProject(int projectId) {
        //Dummy data if there is no file

        for (int i = 0; i < ongoingProjectList.size(); i++) {
            if (ongoingProjectList.get(i).getId() == projectId){
                return ongoingProjectList.get(i);
            }
        }

        return null;
    }
    /*void showReportInfo() {
    }*/
}
