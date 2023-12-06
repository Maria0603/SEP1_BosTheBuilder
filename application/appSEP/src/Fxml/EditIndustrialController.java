package Fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Industrial;
import view.ViewHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class EditIndustrialController implements Initializable {

    private ViewHandler viewHandler;
    private  BuildingCompanyModel model;
    @FXML
    private TextField industrialTitle;
    @FXML
    private TextField industrialId;
    private Industrial industrial;

    public EditIndustrialController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
}
