package viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BuildingCompanyModel;
import model.Project;

/**
 * The OngoingProjectListViewModel class represents the view model for the list of ongoing projects.
 */
public class OngoingProjectListViewModel {

  private ObservableList<ProjectViewModel> list;
  private BuildingCompanyModel model;

  /**
   * Constructs an OngoingProjectListViewModel with the specified BuildingCompanyModel.
   *
   * @param model The BuildingCompanyModel to be associated with the view model.
   */
  public OngoingProjectListViewModel(BuildingCompanyModel model) {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    updateList();
  }

  /**
   * Gets the observable list of ProjectViewModels.
   *
   * @return The observable list of ProjectViewModels.
   */
  public ObservableList<ProjectViewModel> getList() {
    return list;
  }

  /**
   * Updates the list of ongoing projects with ProjectViewModels.
   */
  public void updateList() {
    list.clear();
    for (int i = 0; i < model.getOngoingProjects().size(); i++) {
      list.add(new ProjectViewModel(model.getOngoingProjects().get(i)));
    }
  }

  /**
   * Adds a project to the ongoing projects list and updates the associated ProjectViewModel list.
   *
   * @param project The project to be added to the ongoing projects list.
   */
  public void add(Project project) {
    model.addOngoingProject(project);
    list.add(new ProjectViewModel(project));
  }

  /**
   * Removes a project from the ongoing projects list and updates the associated ProjectViewModel list.
   *
   * @param project The ProjectViewModel representing the project to be removed.
   */
  public void remove(ProjectViewModel project) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getIdProperty().get() == project.getIdProperty().get()) {
        list.remove(i);
        break;
      }
    }
  }
}
