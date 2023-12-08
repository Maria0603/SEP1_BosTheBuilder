package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Industrial;
import model.MyDate;
import view.ViewHandler;
import viewModel.ProjectViewModel;

public class EditIndustrialController {

  @FXML private TextField idField;
  @FXML private TextField titleField;
  @FXML private TextField creationDateField;
  @FXML private TextField expectedBudgetField;
  @FXML private TextField expectedMonthField;
  @FXML private TextField squareMetersField;
  @FXML private TextField usedForField;
  @FXML public TextField spentBudgetField;
  @FXML public TextField spentMonthField;
  private ViewHandler viewHandler;
  private BuildingCompanyModel model;

  private Industrial industrialProject;
  private Region root;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root, ProjectViewModel selectedItem) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    industrialProject = (Industrial) model.getOngoingProject(
        selectedItem.getIdProperty().get());

  }

  public void reset() {
    idField.setText(String.valueOf(industrialProject.getId()));

    titleField.setText(industrialProject.getTitle());

    creationDateField.setText(industrialProject.getCreationDate().toString());

    expectedBudgetField.setText(
        String.valueOf(industrialProject.getExpectedBudget()));

    expectedMonthField.setText(
        String.valueOf(industrialProject.getExpectedMonths()));

    squareMetersField.setText(
        String.valueOf(industrialProject.getSquareMeters()));

    spentBudgetField.setText(
        String.valueOf(industrialProject.getSpentBudget()));

    spentMonthField.setText(String.valueOf(industrialProject.getSpentMonths()));

    usedForField.setText(String.valueOf(industrialProject.getUsedFor()));

  }

  @FXML public void cancelPressed() {
    viewHandler.openTabView("ongoing");
  }

  @FXML public void submitPressed() {
    try {

      int id = Integer.parseInt(idField.getText());
      String title = titleField.getText();
      int expectedBudget = Integer.parseInt(expectedBudgetField.getText());
      int expectedMonths = Integer.parseInt(expectedMonthField.getText());
      int squareMeters = Integer.parseInt(squareMetersField.getText());
      int spentMonths = Integer.parseInt(spentMonthField.getText());
      int spentBudget = Integer.parseInt(spentBudgetField.getText());
      String usedFor = usedForField.getText();

      String creationDate = creationDateField.getText();
      MyDate myCreationDate = MyDate.parseStringToDate(creationDate);
      MyDate myEndDate = myCreationDate.addMonths(expectedMonths);

      Industrial newIndustrialProject = new Industrial(id, title,
          expectedBudget, expectedMonths, myCreationDate, myEndDate,
          squareMeters, usedFor);

      newIndustrialProject.setSpentBudget(spentBudget);
      newIndustrialProject.setSpentMonths(spentMonths);

      model.editOngoingProjectData(model.getOngoingProject(id),
          newIndustrialProject);
      viewHandler.openTabView("ongoing");
      System.out.println(model.getOngoingProjects().toString());

    }
    catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }
}
