package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import viewModel.ProjectViewModel;

import java.util.ArrayList;

import static fxml.AddRoadProjectController.parseEnvironmentalChallenges;

/**
 * Controller class for editing Road projects.
 */
public class EditRoadController {

  @FXML private TextField idField;
  @FXML private TextField titleField;
  @FXML private TextField creationDateField;
  @FXML private TextField expectedBudgetField;
  @FXML private TextField lengthField;
  @FXML private TextField widthField;
  @FXML private TextField numberOfBridgesField;
  @FXML private TextField numberOfTunnelsField;
  @FXML public TextField spentBudgetField;
  @FXML public TextField spentMonthsField;
  @FXML private TextField expectedMonthsField;
  @FXML private TextField challengesField;

  private Region root;
  private BuildingCompanyModel model;
  private ViewHandler viewHandler;
  private Road roadProject;

  /**
   * Initializes the controller with the necessary components.
   *
   * @param viewHandler The ViewHandler instance.
   * @param model The BuildingCompanyModel instance.
   * @param root The root Region for the view.
   * @param selectedItem The selected ProjectViewModel.
   */
  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
                   Region root, ProjectViewModel selectedItem) {

    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    roadProject = (Road) model.getOngoingProject(
            selectedItem.getIdProperty().get());
  }

  /**
   * Resets the form fields with the data of the road project being edited.
   */
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

    spentBudgetField.setText(String.valueOf(roadProject.getSpentBudget()));

    spentMonthsField.setText(String.valueOf(roadProject.getSpentMonths()));

    expectedMonthsField.setText(String.valueOf(roadProject.getExpectedMonths()));

    challengesField.setText(challengesToString((ArrayList<String>) roadProject.getEnvironmentalChallenges()));

  }

  /**
   * Handles the cancel button press event.
   */
  @FXML public void cancelPressed() {
    viewHandler.openTabView("ongoing");
  }

  /**
   * Handles the submit button press event for editing a Road project.
   */
  public void submitPressed() {
    try {
      int id = Integer.parseInt(idField.getText());
      String title = titleField.getText();
      int expectedBudget = Integer.parseInt(expectedBudgetField.getText());
      int length = Integer.parseInt(lengthField.getText());
      int width = Integer.parseInt(widthField.getText());
      int numberOfBridges = Integer.parseInt(numberOfBridgesField.getText());
      int numberOfTunnels = Integer.parseInt(numberOfTunnelsField.getText());
      int expectedMonths = Integer.parseInt(expectedMonthsField.getText());
      int spentMonths = Integer.parseInt(spentMonthsField.getText());
      int spentBudget = Integer.parseInt(spentBudgetField.getText());

      String creationDate = creationDateField.getText();
      MyDate myCreationDate = MyDate.parseStringToDate(creationDate);
      MyDate myEndDate = myCreationDate.addMonths(expectedMonths);

      String challenges = challengesField.getText();

      Road newRoadProject = new Road(length, width, numberOfBridges,
              numberOfTunnels, id, title, expectedBudget, expectedMonths, myCreationDate,
              myEndDate, parseEnvironmentalChallenges(challenges));

      newRoadProject.setSpentBudget(spentBudget);
      newRoadProject.setSpentMonths(spentMonths);

      model.editOngoingProjectData(model.getOngoingProject(id),newRoadProject);
      viewHandler.openTabView("ongoing");
    }
    catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }

  }

  /**
   * Converts the ArrayList of environmental challenges to a String.
   *
   * @param challenges The ArrayList of environmental challenges.
   * @return The concatenated String of challenges.
   */
  public static String challengesToString(ArrayList<String> challenges){
    String output = "";
    for (String tmp : challenges) {
      output += tmp + ", ";
    }
    return output;
  }
}
