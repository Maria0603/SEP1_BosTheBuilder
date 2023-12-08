package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Commercial;
import model.MyDate;
import view.ViewHandler;
import viewModel.ProjectViewModel;

public class EditCommercialController {

  @FXML public TextField titleField;
  @FXML public TextField creationDateField;
  @FXML public TextField expectedBudgetField;
  @FXML public TextField expectedMonthField;
  @FXML public TextField squareMetersField;
  @FXML public TextField numberOfFloorsField;
  @FXML public TextField idField;
  @FXML public TextField spentBudgetField;
  @FXML public TextField spentMonthField;
  @FXML public TextField usedForField;

  private Region root;
  private BuildingCompanyModel model;
  private ViewHandler viewHandler;
  private Commercial commercialProject;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root, ProjectViewModel selectedItem) {

    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    commercialProject = (Commercial) model.getOngoingProject(
        selectedItem.getIdProperty().get());
  }

  public void reset() {
    idField.setText(String.valueOf(commercialProject.getId()));

    titleField.setText(commercialProject.getTitle());

    creationDateField.setText(commercialProject.getCreationDate().toString());

    expectedBudgetField.setText(
        String.valueOf(commercialProject.getExpectedBudget()));

    expectedMonthField.setText(
        String.valueOf(commercialProject.getExpectedMonths()));

    squareMetersField.setText(
        String.valueOf(commercialProject.getSquareMeters()));

    numberOfFloorsField.setText(
        String.valueOf(commercialProject.getNumberOfFloors()));

    spentBudgetField.setText(
        String.valueOf(commercialProject.getSpentBudget()));

    spentMonthField.setText(
        String.valueOf(commercialProject.getSpentMonths()));

    usedForField.setText(String.valueOf(commercialProject.getUsedFor()));

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
      int numberOfFloors = Integer.parseInt(numberOfFloorsField.getText());
      int spentMonths = Integer.parseInt(spentMonthField.getText());
      int spentBudget = Integer.parseInt(spentBudgetField.getText());
      String usedFor = usedForField.getText();

      String creationDate = creationDateField.getText();
      MyDate myCreationDate = MyDate.parseStringToDate(creationDate);
      MyDate myEndDate = myCreationDate.addMonths(expectedMonths);

      Commercial newCommercialProject = new Commercial(
          id, title, expectedBudget, expectedMonths, myCreationDate, myEndDate,
          squareMeters, numberOfFloors, usedFor);
      newCommercialProject.setSpentBudget(spentBudget);
      newCommercialProject.setSpentMonths(spentMonths);

      model.editOngoingProjectData(model.getOngoingProject(id), newCommercialProject);
      viewHandler.openTabView("ongoing");
      System.out.println(model.getOngoingProjects().toString());

    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }
}
