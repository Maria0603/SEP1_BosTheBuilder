package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Residential;
import view.ViewHandler;


public class EditResidentialController {


    public TextField residentialTitle;
    public TextField residentialId;
    private ViewHandler viewHandler;
    private BuildingCompanyModel model;

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
}