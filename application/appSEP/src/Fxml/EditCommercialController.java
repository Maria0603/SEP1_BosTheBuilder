package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Commercial;
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
}
