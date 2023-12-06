package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Commercial;
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

  }

}
