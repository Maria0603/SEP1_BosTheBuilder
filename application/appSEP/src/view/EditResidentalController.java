package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.BuildingCompanyModel;
import model.Industrial;
import model.Residental;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EditResidentalController implements Initializable {

    private  ViewHandler viewHandler;
    private BuildingCompanyModel model;
   @FXML
   private TextField residentalTitle;
    @FXML
   private TextField residentalId;

    Residental residental;

    public EditResidentalController() {
        //viewHandler = ViewHandler.getInstance();
        //model = viewHandler.getModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
             residental = (Residental) model.getOngoingProject(projectId);
            System.out.printf(residental.toString());

            residentalId.setText(residental.getId()+"");
            residentalTitle.setText(residental.getTitle());
        }
    }
}