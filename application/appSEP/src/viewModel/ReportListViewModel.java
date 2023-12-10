package viewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BuildingCompanyModel;
import model.Project;

public class ReportListViewModel {

  private ObservableList<ProjectViewModel> list;
  private BuildingCompanyModel model;

  public ReportListViewModel(BuildingCompanyModel model) {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    initList();
  }

  public ObservableList<ProjectViewModel> getList()
  {
    return list;
  }

  public void initList(){
    list.clear();
    for (Project tmp : model.getReportProjects()) {
      list.add(new ProjectViewModel(tmp));
    }
  }

  public void updateList() {
    list.clear();
    for (int i = 0; i < model.getReportProjects().size(); i++)
    {
      list.add(new ProjectViewModel(model.getReportProjects().get(i)));
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
