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
  @FXML private TextField expectedMonthsField;
  @FXML private TextField challengesField;

  private Region root;
  private BuildingCompanyModel model;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root) {
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
      int expectedMonths = Integer.parseInt(expectedMonthsField.getText());

      String creationDate = creationDateField.getText();
      MyDate myCreationDate = MyDate.parseStringToDate(creationDate);
      MyDate myEndDate = myCreationDate.addMonths(expectedMonths);

      String challenges = challengesField.getText();

      Road newRoadProject = new Road(length, width, numberOfBridges,
          numberOfTunnels, id, title, expectedBudget, expectedMonths, myCreationDate,
          myEndDate, parseEnvironmentalChallenges(challenges));

      model.addNewProject(newRoadProject);
      clearFields();
      viewHandler.openTabView("ongoing");
    }
    catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @FXML private void cancelButtonPressed() {
    clearFields();
    viewHandler.openTabView("ongoing");
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

  public static ArrayList<String> parseEnvironmentalChallenges(String challenges) {
    if (challenges == null || challenges.trim().isEmpty()) {
      return new ArrayList<>();
    }

    String[] challengesArray = challenges.split(",");
    ArrayList<String> challengesList = new ArrayList<>();
    for (String challenge : challengesArray) {
      challengesList.add(challenge.trim());
    }
    return challengesList;
  }

  public static void main(String[] args) {
    String challengesStr = "Steep terrain, Nearby river, Dense forest";
    ArrayList<String> challenges = parseEnvironmentalChallenges(challengesStr);
    System.out.println("Environmental Challenges:");
    for (String challenge : challenges) {
      System.out.println(challenge);
    }

    MyDate date = new MyDate(2, 3, 4);

    Road newRoadProject = new Road(343, 343, 54,
        54, 76, "uhb", 34, 765, date,
        date, parseEnvironmentalChallenges(challengesStr));

    System.out.println(newRoadProject);
  }
}
