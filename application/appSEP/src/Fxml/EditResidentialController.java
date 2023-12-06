package Fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.BuildingCompanyModel;
import model.Residential;
import view.ViewHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class EditResidentialController implements Initializable {

    private ViewHandler viewHandler;
    private BuildingCompanyModel model;
   @FXML
   private TextField residentalTitle;
    @FXML
   private TextField residentalId;

    Residential residental;

    public EditResidentialController() {
      model = viewHandler.getModel();
      viewHandler = new ViewHandler(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
             residental = (Residential) model.getOngoingProject(projectId);
            System.out.printf(residental.toString());

            residentalId.setText(residental.getId()+"");
            residentalTitle.setText(residental.getTitle());
        }
    }
}