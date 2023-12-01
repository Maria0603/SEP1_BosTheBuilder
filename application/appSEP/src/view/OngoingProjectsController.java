package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Industrial;
import model.MyDate;
import model.OngoingProjectList;

import javax.swing.text.View;
import java.net.URL;
import java.util.ResourceBundle;

public class OngoingProjectsController implements Initializable {
    @FXML
    public TableView<Industrial> gradeListTable;
    @FXML
    public TableColumn<Industrial, Integer> gradeColumn;
    @FXML
    public TableColumn<Industrial, String> gradeColumn1;
//    public OngoingProjectList ongoingProjectList;
    private ViewHandler viewHandler;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewHandler = new ViewHandler();
        MyDate as = new MyDate(1, 2, 2020);
        Industrial akjs = new Industrial(1, "Test", 213, 122, as, as, 121, "dance");
        ObservableList<Industrial> oL = FXCollections.observableArrayList();
        oL.add(akjs);
        gradeListTable.setItems(oL);

        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("squareMeters"));
        gradeColumn1.setCellValueFactory(new PropertyValueFactory<>("usedFor"));

        gradeListTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                System.out.println("Itel clicked " + newSelection.getSquareMeters()+ " .. "+ newSelection.getId());
                handleItemClicked(newSelection);
            }
        });
    }

    private void handleItemClicked(Industrial newSelection) {
        //yo change garne
        viewHandler.openIndsturial();
    }
}
