package view;

import javafx.fxml.Initializable;
import model.BuildingCompanyModel;
import model.Commercial;
import model.Industrial;
import model.Residental;

import java.net.URL;
import java.util.ResourceBundle;

public class EditCommercialController implements Initializable {
    private final ViewHandler viewHandler;
    private final BuildingCompanyModel model;
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
          //  commercial.setT
//            industrial = (Industrial) model.getOngoingProject(projectId);
//            System.out.printf(industrial.toString());
//            industrialId.setText(industrial.getId()+"");
//            industrialTitle.setText(industrial.getTitle());
        }
    }
}
