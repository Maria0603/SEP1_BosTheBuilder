
package Fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import model.Road;
import view.ViewHandler;

public class EditRoadController {

    private ViewHandler viewHandler;
    private  BuildingCompanyModel model;
  @FXML
  public TextField roadTitle;

    @FXML
   private TextField roadId;


    private Road road;

    public EditRoadController() {

    }

    public void setItem(int projectId){
        if(model.getOngoingProject(projectId) != null){
            road = (Road) model.getOngoingProject(projectId);
            System.out.printf(road.toString());
            roadId.setText(road.getId()+"");
            roadTitle.setText(road.getTitle());
        }
    }
    public void init(ViewHandler viewHandler, BuildingCompanyModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
    }
}
