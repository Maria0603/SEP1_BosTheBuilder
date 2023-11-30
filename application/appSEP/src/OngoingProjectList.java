import model.Project;

import java.util.ArrayList;

public class OngoingProjectList {

    private ArrayList<Project> ongoingProjects;

    private OngoingProjectList() {
        ongoingProjects = new ArrayList<>();
    }

    public void addProjectToOngoingList(Project project) {
        ongoingProjects.add(project);
    }

    public void deleteProjectFromOngoingList(Project project) {
        ongoingProjects.remove(project);
    }



}