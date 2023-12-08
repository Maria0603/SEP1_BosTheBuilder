package fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import viewModel.OngoingProjectListViewModel;
import viewModel.ProjectViewModel;

import java.util.Optional;

public class OngoingProjectsController {
  @FXML private ComboBox<String> comboBox;
  @FXML private TableView<ProjectViewModel> projectListTable;
  @FXML private TableColumn<ProjectViewModel, Number> idColumn;
  @FXML private TableColumn<ProjectViewModel, String> titleColumn;
  @FXML private TableColumn<ProjectViewModel, String> dateColumn;
  @FXML private TableColumn<ProjectViewModel, String> typeColumn;
  @FXML private Label errorLabel;

  private BuildingCompanyModel model;
  private OngoingProjectListViewModel viewModel;
  private ViewHandler viewHandler;
  private Region root;

  private ObservableList<String> options;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new OngoingProjectListViewModel(model);

    options = FXCollections.observableArrayList("Residential", "Commercial", "Industrial", "Road");

    comboBox.setItems(options);

    idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
    typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());

    projectListTable.setItems(viewModel.getList());
  }

  @FXML private void onComboBoxSelectionChange() {
    String selectedItem = comboBox.getSelectionModel().getSelectedItem();
    viewHandler.openComboBoxSelectionView(selectedItem);
  }

  public void reset() {
    init(this.viewHandler, this.model, this.root);
  }


 @FXML private void detailsPressed(){
   errorLabel.setText("");
   try{
     ProjectViewModel selectedItem = projectListTable.getSelectionModel().getSelectedItem();
     viewHandler.openDetailsSelectionView(selectedItem);

   }
   catch (Exception e) {
     errorLabel.setText("Item not found " + e.getMessage());
   }
 }

 @FXML public void removePressed() {
    try
    {
      ProjectViewModel selectedItem = projectListTable.getSelectionModel()
          .getSelectedItem();
      boolean remove = confirmation();
      if (remove)
      {

        Project projectToRemove = model.getOngoingProject(selectedItem.getIdProperty().get());
        model.deleteOngoingProject(projectToRemove);
        viewModel.remove(selectedItem);
        projectListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found " + e.getMessage());
    }

  }

  @FXML private void sendToFinishedPressed(){

    try
    {
      ProjectViewModel selectedItem = projectListTable.getSelectionModel()
          .getSelectedItem();
      boolean remove = confirmation();
      if (remove)
      {

        Project projectToRemove = model.getOngoingProject(selectedItem.getIdProperty().get());
        model.deleteOngoingProject(projectToRemove);
        model.addFinishedProject(projectToRemove);
        viewModel.remove(selectedItem);
        projectListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found " + e.getMessage());
    }

  }

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