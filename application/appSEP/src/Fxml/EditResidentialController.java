package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Industrial;
import model.MyDate;
import model.Residential;
import view.ViewHandler;


public class EditResidentialController {


    public TextField residentialTitle;
    public TextField residentialId;
    private ViewHandler viewHandler;
    private BuildingCompanyModel model;

    @FXML private TextField creationDateResidential;
    @FXML private TextField expectedBudgetResidential;
    @FXML private TextField expectedMonthsResidential;
    @FXML private TextField squareMetersResidential;
    @FXML private TextField numberOfKitchenResidential;
    @FXML private TextField numberOfRoomsResidential;
    @FXML private TextField numberOfBathroomsResidential;

    Residential residential;

    public EditResidentialController() {

    }


    public void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
            residential = (Residential) model.getOngoingProject(projectId);
            System.out.printf(residential.toString());
            residentialId.setText(residential.getId()+"");
            residentialTitle.setText(residential.getTitle());
        }else {
            System.out.println("It is null" + projectId);

        }
    }
    public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
    }
    @FXML private void submitButtonPressed() {
        try {
            int id = Integer.parseInt(residentialId.getText());
            String title = residentialTitle.getText();
            int expectedBudget = Integer.parseInt(expectedBudgetResidential.getText());
            int expectedMonths = Integer.parseInt(expectedMonthsResidential.getText());
            String creationDate = creationDateResidential.getText();
            int squareMeters = Integer.parseInt(squareMetersResidential.getText());
            int numberOfKitchens = Integer.parseInt(numberOfKitchenResidential.getText());
            int numberOfBathrooms = Integer.parseInt(numberOfBathroomsResidential.getText());
            int numberOfRooms = Integer.parseInt(numberOfRoomsResidential.getText());
            MyDate myCreationDate = new MyDate(10,10,2010);
            MyDate myEndingDate = new MyDate(10, 10, 2020);

            Residential newResidentialProject = new Residential(
                    id, title, expectedBudget, expectedMonths, myCreationDate, myEndingDate,
                    squareMeters, numberOfKitchens, numberOfBathrooms, 0, true, numberOfRooms);

            model.editOngoingProjectData(residential, newResidentialProject);
            clearFields();
            viewHandler.openTabView("editResidentialProject");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing fields: " + e.getMessage());
        }
    }

    @FXML private void cancelButtonPressed() {
        clearFields();
        viewHandler.openTabView("residential");
    }

    private void clearFields() {
        residentialId.clear();
        residentialTitle.clear();
        creationDateResidential.clear();
        expectedBudgetResidential.clear();
        expectedMonthsResidential.clear();
        squareMetersResidential.clear();
        numberOfRoomsResidential.clear();
    }
    }



