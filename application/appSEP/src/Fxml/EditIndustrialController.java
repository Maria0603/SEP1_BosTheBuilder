package Fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Commercial;
import model.Industrial;
import view.ViewHandler;
import viewModel.ProjectViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class EditIndustrialController {

  @FXML public TextField idField;
  @FXML public TextField titleField;
  @FXML public TextField creationDateField;
  @FXML public TextField expectedBudgetField;
  @FXML public TextField expectedMonthField;
  @FXML public TextField squareMetersField;
  private ViewHandler viewHandler;
  private BuildingCompanyModel model;

  private Industrial industrialProject;
  private Region root;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root, ProjectViewModel selectedItem) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    industrialProject = (Industrial) model.getOngoingProject(selectedItem.getIdProperty().get());

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

  }
}
