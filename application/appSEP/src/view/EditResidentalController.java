package view;

import javafx.fxml.Initializable;
import model.BuildingCompanyModel;
import model.Residental;

import java.net.URL;
import java.util.ResourceBundle;

public class EditResidentalController implements Initializable {

    private final ViewHandler viewHandler;
    private final BuildingCompanyModel model;
    Residental residental;

    public EditResidentalController() {
        viewHandler = ViewHandler.getInstance();
        model = viewHandler.getModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setItem(int projectId) {
        if (model.getOngoingProject(projectId) != null){
            residental = (Residental) model.getOngoingProject(projectId);
            System.out.println(residental.toString());
        }
    }
}
