package view;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import viewModel.OngoingProjectListViewModel;
import viewModel.ProjectViewModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OngoingProjectsController {
  @FXML private ComboBox<String> comboBox;
  @FXML private TableView<ProjectViewModel> projectListTable;
  @FXML private TableColumn<ProjectViewModel, Number> idColumn;
  @FXML private TableColumn<ProjectViewModel, String> titleColumn;
  @FXML private TableColumn<ProjectViewModel, String> dateColumn;
  @FXML private TableColumn<ProjectViewModel, String> typeColumn;

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

    projectListTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if(newSelection != null){
        handleItemClicked(newSelection);
      }

    });
  }

  @FXML private void onComboBoxSelectionChange() {
    String selectedItem = comboBox.getSelectionModel().getSelectedItem();
    viewHandler.openComboBoxSelectionView(selectedItem);
  }

  public void reset() {
    init(this.viewHandler, this.model, this.root);
  }


  private void handleItemClicked(ProjectViewModel project) {
    StringProperty classType = project.getTypeProperty();
    if (classType.getValue().equals("industrial")){
      viewHandler.openEditIndustrial(project.getIdProperty().get());
    }
    if (classType.getValue().equals("residential")){
      viewHandler.openResidential(project.getIdProperty().get());
    }
    if (classType.getValue().equals("road")){
      viewHandler.openEditRoad(project.getIdProperty().get());
    }
    /*if (classType.equals("model.Commercial")){
      viewHandler.openEditCommercial(project.getId());
    }*/
  }

}