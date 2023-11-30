package model;

import java.util.ArrayList;

public class OngoingProjectList {

    private ArrayList<Project> ongoingProjects;

    private OngoingProjectList() {
        ongoingProjects = new ArrayList<>();
    }

    public Project getProject(Project project) {
        for (Project tmp: ongoingProjects) {
            if (project.equals(tmp)){
                return tmp;
            }
        }
        return null;
    }

    public void addProjectToOngoingList(Project project) {
        ongoingProjects.add(project);
    }

    public void deleteProjectFromOngoingList(Project project) {
        ongoingProjects.remove(project);
    }

    public void editProject(Project projectToEdit, Project projectWithNewData) {
        ongoingProjects.get(projectToEdit) = projectWithNewData;
    }

    public String SendToFinishedList(Project project) {
        ongoingProjects.remove(project);
        return "The Project " + project + "is now sent to the Finished Projects List";
    }

    public void showOngoingList() {
        System.out.println("Ongoing Projects:");

        if (ongoingProjects.isEmpty()) {
            System.out.println("There aren't any Ongoing projects in the list.");
        } else {

            for (Project project : ongoingProjects) {
                System.out.println(project);
            }
        }

    }
}