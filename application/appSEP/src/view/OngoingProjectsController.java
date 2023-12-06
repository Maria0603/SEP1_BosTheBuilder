package view;

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
    String classType = project.getClass().getName();
    if (classType.equals("model.Industrial")){
      viewHandler.openEditIndustrial(project.getIdProperty().get());
    }
    if (classType.equals("model.Residential")){
      viewHandler.openResidential(project.getIdProperty().get());
    }
    if (classType.equals("model.Road")){
      viewHandler.openEditRoad(project.getIdProperty().get());
    }
    /*if (classType.equals("model.Commercial")){
      viewHandler.openEditCommercial(project.getId());
    }*/
  }

}