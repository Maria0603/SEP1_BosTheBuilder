package view;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;



public class TabViewController {
  @FXML private TabPane tabPane;
  @FXML private OngoingProjectsController ongoingProjectsController;
  @FXML private FinishedProjectsController finishedProjectsController;
  private Region root;
  private ViewHandler viewHandler;
  public TabViewController() {
    viewHandler = ViewHandler.getInstance();
  }

  public void openTab(int tabIndex) {
    if (tabPane.getTabs().size() > tabIndex) {
      tabPane.getSelectionModel().select(tabIndex);
    }
  }

  public void tabSelected(Event event) {
  }
}


