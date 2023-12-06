
package Fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.BuildingCompanyModel;
import model.Industrial;
import model.Residental;
import model.Road;
import view.ViewHandler;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EditRoadController implements Initializable {

    private ViewHandler viewHandler;
    private  BuildingCompanyModel model;
  @FXML
  public TextField roadTitle;

    @FXML
   private TextField roadId;


    Residental residental;
    Road road;

    public EditRoadController() {
        viewHandler = new ViewHandler(model);
        model = viewHandler.getModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
            road = (Road) model.getOngoingProject(projectId);
            System.out.printf(road.toString());
            roadId.setText(road.getId()+"");
            roadTitle.setText(road.getTitle());
        }
    }
}
