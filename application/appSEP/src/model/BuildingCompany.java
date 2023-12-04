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

    @Override
    public List<Project> getOngoingProjectList() {
        // TODO :  With acutal data
        // return (ObservableList<Project>) ongoingProjects;
        MyDate startDate = new MyDate(1, 12, 2023);
        MyDate endingDate = new MyDate(1, 7, 2024);
        Industrial ABCCompany = new Industrial(1, "Industrial", 90000, 8, startDate, endingDate, 1000, "Company");
        ongoingProjectList.add(ABCCompany);
        Residental residental = new Residental(2,"WOWOWO ", 12212,1212,startDate,endingDate,100,2,1,1,Boolean.TRUE);
        ongoingProjectList.add(residental);
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
