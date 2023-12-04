package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.BuildingCompanyModel;
import model.Commercial;
import model.Industrial;
import model.Residental;

import java.net.URL;
import java.util.ResourceBundle;

public class EditCommercialController implements Initializable {
    private final ViewHandler viewHandler;
    private final BuildingCompanyModel model;
    @FXML
    private TextField commercialTitle;
    @FXML
    private TextField commercialID;
    Commercial commercial;

    public EditCommercialController() {
        viewHandler = ViewHandler.getInstance();
        model = viewHandler.getModel();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setItem(int projectId) {
        if(model.getOngoingProject(projectId) != null){
            commercial = (Commercial) model.getOngoingProject(projectId);
            System.out.println(commercial.toString());
            commercialID.setText(commercial.getId()+"");
            commercialTitle.setText(commercial.getTitle());
        }
    }
}
