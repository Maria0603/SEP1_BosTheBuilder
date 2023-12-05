package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Industrial;
import model.MyDate;
import view.ViewHandler;

public class AddIndustrialProjectController {

  @FXML private TextField idField;
  @FXML private TextField titleField;
  @FXML private TextField creationDateField;
  @FXML private TextField expectedBudgetField;
  @FXML private TextField expectedMonthsField;
  @FXML private TextField squareMetersField;

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
      int expectedMonths = Integer.parseInt(expectedMonthsField.getText());
      String creationDate = creationDateField.getText();
      int squareMeters = Integer.parseInt(squareMetersField.getText());
      MyDate myCreationDate = new MyDate(10,10,2010);
      MyDate myEndingDate = new MyDate(10, 10, 2020);
      Industrial newIndustrialProject = new Industrial(
          id, title, expectedBudget, expectedMonths, myCreationDate, myEndingDate,
          squareMeters, "");

      model.addNewProject(newIndustrialProject);
      clearFields();
      viewHandler.openTabView("ongoing");
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @FXML
  private void cancelButtonPressed() {
    clearFields();
    viewHandler.openTabView("ongoing");
  }

  private void clearFields() {
    idField.clear();
    titleField.clear();
    creationDateField.clear();
    expectedBudgetField.clear();
    expectedMonthsField.clear();
    squareMetersField.clear();
  }
}
