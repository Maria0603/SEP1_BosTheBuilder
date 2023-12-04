package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Commercial;
import model.MyDate;
import view.ViewHandler;

public class AddCommercialProjectController {
  @FXML private TextField idField;
  @FXML private TextField titleField;
  @FXML private TextField creationDateField;
  @FXML private TextField expectedBudgetField;
  @FXML private TextField expectedMonthsField;
  @FXML private TextField squareMetersField;
  @FXML private TextField numberOfFloorsField;
  @FXML private Label errorLabel;
  @FXML private ComboBox<String> projectTypeComboBox;

  private Region root;
  private BuildingCompanyModel model;
  private ViewHandler viewHandler;

  public void init(BuildingCompanyModel model, ViewHandler viewHandler, Region root) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.idField = idField;
    this.titleField = titleField;
    this.creationDateField = creationDateField;
    this.expectedBudgetField = expectedBudgetField;
    this.expectedMonthsField = expectedMonthsField;
    this.squareMetersField = squareMetersField;
    this.numberOfFloorsField = numberOfFloorsField;
    this.errorLabel = errorLabel;
  }
  public Region getRoot() {
    return root;
  }
  private void submitButtonPressed() {
    try {
      int id = Integer.parseInt(idField.getText());
      String title = titleField.getText();
      int expectedBudget = Integer.parseInt(expectedBudgetField.getText());
      int expectedMonths = Integer.parseInt(expectedMonthsField.getText());
      String creationDate = creationDateField.getText();
      int squareMeters = Integer.parseInt(squareMetersField.getText());
      int numberOfFloors = Integer.parseInt(numberOfFloorsField.getText());
      MyDate myCreationDate = new MyDate(10,10,2010);
      Commercial newCommercialProject = new Commercial(
          id, title, expectedBudget, expectedMonths, myCreationDate, null,
          squareMeters, numberOfFloors, "");

      model.addNewProject(newCommercialProject);
      clearFields();
    } catch (NumberFormatException e) {
      errorLabel.setText("Please input valid numeric data.");
    }
  }

  @FXML private void projectTypeComboBoxPressed() {
    viewHandler.openView();
  }
  @FXML
  private void cancelButtonPressed() {
    clearFields();
    errorLabel.setText("");
  }
  private void clearFields() {
    idField.clear();
    titleField.clear();
    creationDateField.clear();
    expectedBudgetField.clear();
    expectedMonthsField.clear();
    squareMetersField.clear();
    numberOfFloorsField.clear();
  }
}
