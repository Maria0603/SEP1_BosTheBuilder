package Fxml;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Commercial;
import model.Industrial;
import model.MyDate;
import view.ViewHandler;


public class EditCommercialController {
    @FXML
    private TextField commercialCreationDate;
    @FXML
    private TextField commercialExpectedBudget;
    @FXML
    private TextField commercialExpectedMonth;
    @FXML
    private TextField commercialSquareMeters;
    @FXML
    private TextField commercialNumberOfFloors;
    private ViewHandler viewHandler;
    private BuildingCompanyModel model;
    @FXML
    private TextField commercialTitle;
    @FXML
    private TextField commercialId;
    private Commercial commercial;

    public EditCommercialController() {
    }

    public void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
            commercial = (Commercial) model.getOngoingProject(projectId);
            System.out.printf(commercial.toString());
            commercialId.setText(commercial.getId()+"");
            commercialTitle.setText(commercial.getTitle());
        }
    }

    public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
    }



    @FXML
    public void submitButtonPressed() {
        try {
            int id = Integer.parseInt(commercialId.getText());
            String title = commercialTitle.getText();
            int expectedBudget = Integer.parseInt(commercialExpectedBudget.getText());
            int expectedMonths = Integer.parseInt(commercialExpectedMonth.getText());
            String creationDate = commercialCreationDate.getText();
            int squareMeters = Integer.parseInt(commercialSquareMeters.getText());
            MyDate myCreationDate = new MyDate(10 ,11, 2023);
            MyDate myEndingDate = new MyDate(9,5,2024);
            Industrial newIndustrialProject = new Industrial(
                    id, title, expectedBudget, expectedMonths, myCreationDate, myEndingDate,
                    squareMeters, "");

            model.editOngoingProjectData(commercial, newIndustrialProject);
            clearFields();
            viewHandler.openTabView("editIndustrial");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }
    @FXML
    public void cancelButtonPressed() {
        clearFields();
        viewHandler.openTabView("editCommercial");
    }

    private void clearFields() {
        commercialId.clear();
        commercialTitle.clear();
        commercialCreationDate.clear();
        commercialExpectedBudget.clear();
        commercialExpectedMonth.clear();
        commercialNumberOfFloors.clear();
        commercialSquareMeters.clear();
    }
}
