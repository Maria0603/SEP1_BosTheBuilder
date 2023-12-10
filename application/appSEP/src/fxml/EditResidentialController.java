package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.MyDate;
import model.Residential;
import view.ViewHandler;
import viewModel.ProjectViewModel;

public class EditResidentialController {

  @FXML private TextField idField;
  @FXML private TextField titleField;
  @FXML private TextField creationDateField;
  @FXML private TextField ExpectedBudgetField;
  @FXML private TextField expectedMonthField;
  @FXML private TextField squareMetersField;
  @FXML private TextField NumberOfKitchensField;
  @FXML private TextField numberOfRoomsField;
  @FXML private TextField numberOfBathroomsField;
  @FXML private TextField numberOfOtherPlumbingRoomsField;
  @FXML public TextField spentBudgetField;
  @FXML public TextField spentMonthField;
  private ViewHandler viewHandler;
  private BuildingCompanyModel model;

  private Residential residentialProject;
  private Region root;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root, ProjectViewModel selectedItem) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    residentialProject = (Residential) model.getOngoingProject(
        selectedItem.getIdProperty().get());

  }

  public void reset() {
    idField.setText(String.valueOf(residentialProject.getId()));

    titleField.setText(residentialProject.getTitle());

    creationDateField.setText(residentialProject.getCreationDate().toString());

    ExpectedBudgetField.setText(
        String.valueOf(residentialProject.getExpectedBudget()));

    expectedMonthField.setText(
        String.valueOf(residentialProject.getExpectedMonths()));

    squareMetersField.setText(
        String.valueOf(residentialProject.getSquareMeters()));

    NumberOfKitchensField.setText(
        String.valueOf(residentialProject.getNumberOfKitchens()));

    numberOfRoomsField.setText(
        String.valueOf(residentialProject.getNumberOfRooms()));

    numberOfBathroomsField.setText(
        String.valueOf(residentialProject.getNumberOfBathrooms()));

    numberOfOtherPlumbingRoomsField.setText(
        String.valueOf(residentialProject.getNumberOfOtherPlumbingRooms()));

    spentBudgetField.setText(String.valueOf(residentialProject.getSpentBudget()));

    spentMonthField.setText(String.valueOf(residentialProject.getSpentMonths()));

  }

  @FXML public void cancelPressed() {
    viewHandler.openTabView("ongoing");
  }

  @FXML public void submitPressed() {
    try {

      int id = Integer.parseInt(idField.getText());
      String title = titleField.getText();
      int expectedBudget = Integer.parseInt(ExpectedBudgetField.getText());
      int expectedMonths = Integer.parseInt(expectedMonthField.getText());
      int squareMeters = Integer.parseInt(squareMetersField.getText());
      int spentMonths = Integer.parseInt(spentMonthField.getText());
      int spentBudget = Integer.parseInt(spentBudgetField.getText());
      int numberOfBathrooms = Integer.parseInt(
          numberOfBathroomsField.getText());
      int numberOfKitchens = Integer.parseInt(NumberOfKitchensField.getText());
      int numberOfOtherPlumbingRooms = Integer.parseInt(
          numberOfOtherPlumbingRoomsField.getText());
      int numberOfRooms = Integer.parseInt(numberOfRoomsField.getText());

      String creationDate = creationDateField.getText();
      MyDate myCreationDate = MyDate.parseStringToDate(creationDate);
      MyDate myEndDate = myCreationDate.addMonths(expectedMonths);


      Residential newResidentialProject = new Residential(id, title,
          expectedBudget, expectedMonths, myCreationDate, myEndDate,
          squareMeters, numberOfKitchens, numberOfBathrooms,
          numberOfOtherPlumbingRooms, true, numberOfRooms);

      newResidentialProject.setSpentBudget(spentBudget);
      newResidentialProject.setSpentMonths(spentMonths);

      model.editOngoingProjectData(model.getOngoingProject(id),
          newResidentialProject);
      viewHandler.openTabView("ongoing");
      System.out.println(model.getOngoingProjects().toString());

    }
    catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }
}