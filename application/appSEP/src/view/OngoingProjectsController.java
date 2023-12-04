package view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.BuildingCompany;
import model.BuildingCompanyModel;
import model.Project;

import java.util.Optional;

public class OngoingProjectsController
{
  private Region root;
  private BuildingCompanyModel model;
  private ViewHandler viewHandler;

  @FXML
  private TableView<ProjectViewModel> ongoingListTable;

  @FXML
  private TableColumn<ProjectViewModel, Number> idColumn;

  @FXML
  private TableColumn<ProjectViewModel, String> titleColumn;

  @FXML
  private TableColumn<ProjectViewModel, String> dateColumn;

  @FXML
  private Label errorLabel;

  @FXML
  private ObservableList<String> newProjectOptions;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;

    idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
    titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
    dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

    ongoingListTable.setItems(model.getProjectsViewModel());
  }

  public void reset() {
    errorLabel.setText("");
    // Additional logic for resetting fields or selections if needed
  }

  public Region getRoot() {
    return root;
  }

  @FXML
  private void newProjectPressed() {
    // Handle adding a new project
  }

  @FXML
  private void deletePressed() {
    errorLabel.setText("");
    try {
      ProjectViewModel selectedItem = ongoingListTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();
      if (remove) {
        Project project = model.getProject(selectedItem.getId()); // Get project based on ViewModel ID
        model.removeProject(project);
        ongoingListTable.getItems().remove(selectedItem);
        ongoingListTable.getSelectionModel().clearSelection();
      }
    } catch (Exception e) {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  @FXML
  private void tableItemPressed() {
    // Handle when a table item is pressed
  }

  @FXML
  private void sendToFinishedPressed() {
    // Handle sending project to finished projects
  }

  private boolean confirmation() {
    ProjectViewModel selectedItem = ongoingListTable.getSelectionModel().getSelectedItem();
    if (selectedItem == null) {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing project with ID: " + selectedItem.getId());
    Optional<ButtonType> result = alert.showAndWait();
    return result.isPresent() && result.get() == ButtonType.OK;
  }
}