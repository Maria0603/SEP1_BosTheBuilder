package fxml;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import view.ViewHandler;

public class TabViewController {
  @FXML private TabPane tabPane;
  @FXML private OngoingProjectsController ongoingProjectsController;
  @FXML private FinishedProjectsController finishedProjectsController;
  private Region root;

  public void init(BuildingCompanyModel model, ViewHandler viewHandler, Region root) {
    this.root = root;

    ongoingProjectsController.init(viewHandler, model, root);
    finishedProjectsController.init(viewHandler, model, root);
  }

  public void reset() {
    ongoingProjectsController.reset();
    finishedProjectsController.reset();
  }

  public Region getRoot() {
    return root;
  }

  @FXML private void tabSelected(Event event) {
    if (ongoingProjectsController != null
        && finishedProjectsController != null) {
      int index = ((Tab) event.getSource()).getTabPane().getSelectionModel().getSelectedIndex();
      switch (index) {
        case 0 -> ongoingProjectsController.reset();
        case 1 -> finishedProjectsController.reset();
      }
    }
  }
  public void openTab(int index){
    tabPane.getSelectionModel().select(index);
  }
}
