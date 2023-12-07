package Fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import viewModel.ProjectViewModel;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EditRoadController {

  public TextField idField;
  public TextField titleField;
  public TextField creationDateField;
  public TextField expectedBudgetField;
  public TextField lengthField;
  public TextField widthField;
  public TextField numberOfBridgesField;
  public TextField numberOfTunnelsField;


  private Region root;
  private BuildingCompanyModel model;
  private ViewHandler viewHandler;
  private Road roadProject;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root, ProjectViewModel selectedItem) {

    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    roadProject = (Road) model.getOngoingProject(
        selectedItem.getIdProperty().get());
  }

  public void reset() {
    idField.setText(String.valueOf(roadProject.getId()));

    titleField.setText(roadProject.getTitle());

    creationDateField.setText(roadProject.getCreationDate().toString());

    expectedBudgetField.setText(
        String.valueOf(roadProject.getExpectedBudget()));

    lengthField.setText(
        String.valueOf(roadProject.getLength()));

    widthField.setText(
        String.valueOf(roadProject.getWidth()));

    numberOfBridgesField.setText(
        String.valueOf(roadProject.getNumberOfBridges()));

    numberOfTunnelsField.setText(
        String.valueOf(roadProject.getNumberOfTunnels()));
  }
}
