package fxml;

import javafx.scene.layout.Region;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;
import view.ViewHandler;
import viewModel.FinishedProjectListViewModel;
import viewModel.ProjectViewModel;

import java.util.Optional;

public class FinishedProjectsController {

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

  public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
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


  @FXML private void sendToOngoingPressed(){

    try
    {
      ProjectViewModel selectedItem = projectListTable.getSelectionModel()
          .getSelectedItem();
      boolean remove = confirmation();
      if (remove)
      {

        Project projectToRemove = model.getFinishedProject(selectedItem.getIdProperty().get());
        model.deleteFinishedProject(projectToRemove);
        model.addOngoingProject(projectToRemove);
        viewModel.remove(selectedItem);
        projectListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found " + e.getMessage());
    }

  }

  @FXML private void createReportPressed(){ viewHandler.openReportView(); }

  private boolean confirmation(){
    int index = projectListTable.getSelectionModel().getSelectedIndex();
    ProjectViewModel selectedItem = projectListTable.getItems().get(index);
    if (index < 0 || index >= projectListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing grade {" + selectedItem.getIdProperty().get() + ": "
            + selectedItem.getTitleProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent() && (result.get() == ButtonType.OK));
  }
}
