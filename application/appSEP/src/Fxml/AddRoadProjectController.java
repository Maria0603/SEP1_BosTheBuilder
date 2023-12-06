package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.MyDate;
import model.Road;
import view.ViewHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class AddRoadProjectController {

  @FXML private TextField idField;
  @FXML private TextField titleField;
  @FXML private TextField creationDateField;
  @FXML private TextField expectedBudgetField;
  @FXML private TextField lengthField;
  @FXML private TextField widthField;
  @FXML private TextField numberOfBridgesField;
  @FXML private TextField numberOfTunnelsField;


  private Region root;
  private BuildingCompanyModel model;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
  }

  public Region getRoot() {
    return root;
  }

  @FXML private void submitButtonPressed() {
    try {
      int id = Integer.parseInt(idField.getText());
      String title = titleField.getText();
      int expectedBudget = Integer.parseInt(expectedBudgetField.getText());
      int length = Integer.parseInt(lengthField.getText());
      int width = Integer.parseInt(widthField.getText());
      int numberOfBridges = Integer.parseInt(numberOfBridgesField.getText());
      int numberOfTunnels = Integer.parseInt(numberOfTunnelsField.getText());
      String creationDate = creationDateField.getText();
      MyDate myCreationDate = new MyDate(10,10,2010);
      MyDate myEndingDate = new MyDate(10, 10, 2020);
      Road newRoadProject = new Road(length, width, numberOfBridges, numberOfTunnels, id, title, expectedBudget, 42, myCreationDate, myEndingDate, new ArrayList<>(Arrays.asList("landslide", "mountains", "BIG GOOSE")));

      model.addNewProject(newRoadProject);
      clearFields();
      viewHandler.openTabView();
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @FXML
  private void cancelButtonPressed() {
    clearFields();
    viewHandler.openTabView();
  }

  private void clearFields() {
    idField.clear();
    titleField.clear();
    creationDateField.clear();
    expectedBudgetField.clear();
    lengthField.clear();
    widthField.clear();
    numberOfBridgesField.clear();
    numberOfTunnelsField.clear();

  }
}
