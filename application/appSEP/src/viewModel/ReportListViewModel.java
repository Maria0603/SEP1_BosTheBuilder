package viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BuildingCompanyModel;
import model.Project;

/**
 * The ReportListViewModel class represents the view model for the list of projects in a report.
 */
public class ReportListViewModel {

  private ObservableList<ProjectViewModel> list;
  private BuildingCompanyModel model;

  /**
   * Constructs a ReportListViewModel with the specified BuildingCompanyModel.
   *
   * @param model The BuildingCompanyModel to be associated with the view model.
   */
  public ReportListViewModel(BuildingCompanyModel model) {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    initList();
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
   * Initializes the list of projects in a report with ProjectViewModels.
   */
  public void initList() {
    list.clear();
    for (Project tmp : model.getReportProjects()) {
      list.add(new ProjectViewModel(tmp));
    }
  }

  /**
   * Updates the list of projects in a report with ProjectViewModels.
   */
  public void updateList() {
    list.clear();
    for (int i = 0; i < model.getReportProjects().size(); i++) {
      list.add(new ProjectViewModel(model.getReportProjects().get(i)));
    }
  }

  /**
   * Adds a project to the finished projects list and updates the associated ProjectViewModel list.
   *
   * @param project The project to be added to the finished projects list.
   */
  public void add(Project project) {
    model.addFinishedProject(project);
    list.add(new ProjectViewModel(project));
  }

  /**
   * Removes a project from the finished projects list and updates the associated ProjectViewModel list.
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
