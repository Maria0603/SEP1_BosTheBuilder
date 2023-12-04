package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OngoingProjectsController implements Initializable {
  private final BuildingCompanyModel businessCompanyModel;
  @FXML
  public TableView<Project> projectListTable;
  @FXML
  public TableColumn<Project, Integer> idColumn;
  @FXML
  public TableColumn<Project, String> titleColumn;
  public TableColumn <Project, Integer> dateColumn;
  public OngoingProjectList ongoingProjectList;
  private ViewHandler viewHandler;


  public OngoingProjectsController() {
    viewHandler=ViewHandler.getInstance();
    businessCompanyModel =  viewHandler.getModel();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
//    ObservableList<Project> oL = FXCollections.observableArrayList();
//    oL = businessCompanyModel.getOngoingProjectList();
    ArrayList<Project> projectArrayList = (ArrayList<Project>) businessCompanyModel.getOngoingProjectList(); // Assuming this method returns an ArrayList<Project>
    ObservableList<Project> projectObservableList = FXCollections.observableList(projectArrayList);
    projectListTable.setItems(projectObservableList);
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
    projectListTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if(newSelection != null){
        handleItemClicked(newSelection);
      }
    });
  }

  public void reset() {
  }

  public void addbuttonClick(ActionEvent actionEvent) {
    viewHandler.openAddOngoingView();
  }

  private void handleItemClicked(Project project) {
    String classType = project.getClass().getName();
    if (classType.equals("model.Industrial")){
      viewHandler.openEditIndustrial(project.getId());
    }
    if (classType.equals("model.Residental")){
      viewHandler.openResidential(project.getId());
    }
  }



}