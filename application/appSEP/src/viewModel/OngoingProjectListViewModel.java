package viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BuildingCompanyModel;
import model.Project;

public class OngoingProjectListViewModel
{
  private ObservableList<ProjectViewModel> list;
  private BuildingCompanyModel model;

  public OngoingProjectListViewModel(BuildingCompanyModel model) {
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
    for (int i = 0; i < model.getOngoingProjects().size(); i++)
    {
      list.add(new ProjectViewModel(model.getOngoingProjects().get(i)));
    }
  }

  public void add(Project project) {
    model.addNewProject(project);
    list.add(new ProjectViewModel(project));
  }

  public void remove(Project project) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getIdProperty().get() == project.getId()) {
        list.remove(i);
        break;
      }
    }
  }
}
