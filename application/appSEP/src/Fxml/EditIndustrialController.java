package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Industrial;
import model.MyDate;
import view.ViewHandler;

public class EditIndustrialController {

    private ViewHandler viewHandler;
    private  BuildingCompanyModel model;
    @FXML
    private TextField industrialTitle;
    @FXML
    private TextField industrialId;

    @FXML private TextField creationDateIndustrial;
    @FXML private TextField expectedBudgetIndustrial;
    @FXML private TextField expectedMonthsIndustrial;
    @FXML private TextField squareMetersIndustrial;

    private Industrial industrial;

    public EditIndustrialController() {
    }

   public void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
            industrial = (Industrial) model.getOngoingProject(projectId);
            System.out.printf(industrial.toString());
            industrialId.setText(industrial.getId()+"");
            industrialTitle.setText(industrial.getTitle());
        }
    }

    public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
    }
    @FXML private void submitButtonPressed() {
        try {
            int id = Integer.parseInt(industrialId.getText());
            String title = industrialTitle.getText();
            int expectedBudget = Integer.parseInt(expectedBudgetIndustrial.getText());
            int expectedMonths = Integer.parseInt(expectedMonthsIndustrial.getText());
            String creationDate = creationDateIndustrial.getText();
            int squareMeters = Integer.parseInt(squareMetersIndustrial.getText());
            MyDate myCreationDate = new MyDate(10 ,11, 2023);
            MyDate myEndingDate = new MyDate(9,5,2024);
            Industrial newIndustrialProject = new Industrial(
                    id, title, expectedBudget, expectedMonths, myCreationDate, myEndingDate,
                    squareMeters, "");

            model.editOngoingProjectData(industrial, newIndustrialProject);
            clearFields();
            viewHandler.openTabView("editIndustrial");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void cancelButtonPressed() {
        clearFields();
        viewHandler.openTabView("editIndustrial");
    }
    private void clearFields() {
        industrialId.clear();
        industrialTitle.clear();
        creationDateIndustrial.clear();
        expectedBudgetIndustrial.clear();
        expectedMonthsIndustrial.clear();
        squareMetersIndustrial.clear();
    }
}


