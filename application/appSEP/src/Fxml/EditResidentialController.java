package Fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Industrial;
import model.Residential;
import view.ViewHandler;
import viewModel.ProjectViewModel;

public class EditResidentialController  {


  @FXML public TextField idField;
  @FXML public TextField titleField;
  @FXML public TextField creationDateField;
  @FXML public TextField expectedMonthField;
  @FXML public TextField squareMetersField;
  @FXML public TextField ExpectedBudgetField;
  @FXML public TextField NumberOfKitchensField;
  @FXML public TextField numberOfRoomsField;
  @FXML public TextField numberOfBathroomsField;
  private ViewHandler viewHandler;
  private BuildingCompanyModel model;

  private Residential residentialProject;
  private Region root;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root, ProjectViewModel selectedItem) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    residentialProject = (Residential) model.getOngoingProject(selectedItem.getIdProperty().get());

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

  }
}