package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import view.ViewHandler;
import viewModel.FinishedProjectListViewModel;
import viewModel.ProjectViewModel;

public class CreateReportController {

  @FXML private TableView<ProjectViewModel> projectListTable;
  @FXML private TableColumn<ProjectViewModel, Number> idColumn;
  @FXML private TableColumn<ProjectViewModel, String> titleColumn;
  @FXML private TableColumn<ProjectViewModel, String> dateColumn;
  @FXML private TableColumn<ProjectViewModel, String> typeColumn;
  @FXML private Label errorLabel;

  private BuildingCompanyModel model;
  private FinishedProjectListViewModel viewModel;
  private ViewHandler viewHandler;
  private Region root;
  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new FinishedProjectListViewModel(model);

    idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
    typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());

    projectListTable.setItems(viewModel.getList());

  }

  public void reset() {
    init(this.viewHandler, this.model, this.root);
  }

  public Region getRoot() {
    return root;
  }
}
