package viewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BuildingCompanyModel;
import model.Project;
public class FinishedProjectListViewModel {

  private ObservableList<ProjectViewModel> list;
  private BuildingCompanyModel model;

  public FinishedProjectListViewModel(BuildingCompanyModel model) {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    updateList();
  }

  public ObservableList<ProjectViewModel> getList()
  {
    return list;
  }

  public void updateList() {
    list.clear();
    for (int i = 0; i < model.getFinishedProjects().size(); i++)
    {
      list.add(new ProjectViewModel(model.getFinishedProjects().get(i)));
    }
  }

  public void add(Project project) {
    model.addFinishedProject(project);
    list.add(new ProjectViewModel(project));
  }

  public void remove(ProjectViewModel project) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getIdProperty().get() == project.getIdProperty().get()) {
        list.remove(i);
        break;
      }
    }
  }
}
