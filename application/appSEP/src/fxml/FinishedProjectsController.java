package fxml;

import javafx.scene.layout.Region;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;
import view.ViewHandler;
import viewModel.FinishedProjectListViewModel;
import viewModel.ProjectViewModel;

import java.util.Optional;

/**
 * Controller class for managing finished projects view.
 */
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

  /**
   * Initializes the controller with the necessary components.
   *
   * @param viewHandler The ViewHandler instance.
   * @param model The BuildingCompanyModel instance.
   * @param root The root Region for the view.
   */
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

  /**
   * Resets the view by initializing it again.
   */
  public void reset() {
    init(this.viewHandler, this.model, this.root);
  }

  /**
   * Gets the root Region of the view.
   *
   * @return The root Region.
   */
  public Region getRoot() {
    return root;
  }

  /**
   * Handles the action when the "Send to Ongoing" button is pressed.
   * Moves a finished project to ongoing projects.
   */
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

  /**
   * Handles the action when the "Create Report" button is pressed.
   * Opens the report view.
   */
  @FXML private void createReportPressed(){ viewHandler.openReportView(); }

  /**
   * Displays a confirmation dialog for the user to confirm an action.
   *
   * @return True if the user clicks OK, otherwise false.
   */
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
            "Removing project from Finished: " + selectedItem.getIdProperty().get() + " "
                    + selectedItem.getTitleProperty().get() + "");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent() && (result.get() == ButtonType.OK));
  }
}
