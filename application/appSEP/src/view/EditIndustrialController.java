package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.BuildingCompanyModel;
import model.Industrial;

import java.net.URL;
import java.util.ResourceBundle;

public class EditIndustrialController implements Initializable {

    private final ViewHandler viewHandler;
    private final BuildingCompanyModel model;
    @FXML
    private TextField industrialTitle;
    @FXML
    private TextField industrialId;
    private Industrial industrial;

    public EditIndustrialController() {
        viewHandler = ViewHandler.getInstance();
        model = viewHandler.getModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
            industrial = (Industrial) model.getOngoingProject(projectId);
            System.out.printf(industrial.toString());
            industrialId.setText(industrial.getId()+"");
            industrialTitle.setText(industrial.getTitle());
        }
    }
}
