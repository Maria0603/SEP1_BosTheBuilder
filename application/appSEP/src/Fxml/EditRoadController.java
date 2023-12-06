
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

public class EditRoadController {

    private ViewHandler viewHandler;
    private  BuildingCompanyModel model;
  @FXML
  public TextField roadTitle;

    @FXML
   private TextField roadId;

    @FXML private TextField creationDateRoad;
    @FXML private TextField expectedBudgetRoad;
    @FXML private TextField lengthRoad;
    @FXML private TextField widthRoad;
    @FXML private TextField numberOfBridgesRoad;
    @FXML private TextField numberOfTunnelsRoad;



    private Road road;

    public EditRoadController() {

    }

    public void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
            road = (Road) model.getOngoingProject(projectId);
            System.out.printf(road.toString());
            roadId.setText(road.getId()+"");
            roadTitle.setText(road.getTitle());
        }
    }
    public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
    }
    @FXML private void submitButtonPressed() {
        try {
            int id = Integer.parseInt(roadId.getText());
            String title = roadTitle.getText();
            int expectedBudget = Integer.parseInt(expectedBudgetRoad.getText());
            int length = Integer.parseInt(lengthRoad.getText());
            int width = Integer.parseInt(widthRoad.getText());
            int numberOfBridges = Integer.parseInt(numberOfBridgesRoad.getText());
            int numberOfTunnels = Integer.parseInt(numberOfTunnelsRoad.getText());
            String creationDate = creationDateRoad.getText();
            MyDate myCreationDate = new MyDate(10,10,2010);
            MyDate myEndingDate = new MyDate(10, 10, 2020);
            Road newRoadProject = new Road(length, width, numberOfBridges, numberOfTunnels, id, title, expectedBudget, 42, myCreationDate, myEndingDate, new ArrayList<>(Arrays.asList("landslide", "mountains", "BIG GOOSE")));

            model.editOngoingProjectData(road,newRoadProject);
            clearFields();
            viewHandler.openTabView("editRoad");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void cancelButtonPressed() {
        clearFields();
        viewHandler.openTabView("editRoad");
    }

    private void clearFields() {
        roadId.clear();
        roadTitle.clear();
        creationDateRoad.clear();
        expectedBudgetRoad.clear();
        lengthRoad.clear();
        widthRoad.clear();
        numberOfBridgesRoad.clear();
        numberOfTunnelsRoad.clear();

    }
}


