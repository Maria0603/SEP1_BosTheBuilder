package fxml;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import view.ViewHandler;

/**
 * Controller class for managing tabs in the main view.
 */
public class TabViewController {
  @FXML private TabPane tabPane;
  @FXML private OngoingProjectsController ongoingProjectsController;
  @FXML private FinishedProjectsController finishedProjectsController;
  private Region root;

  /**
   * Initializes the TabViewController with the required components.
   *
   * @param model The BuildingCompanyModel instance.
   * @param viewHandler The ViewHandler instance.
   * @param root The root Region for the view.
   */
  public void init(BuildingCompanyModel model, ViewHandler viewHandler, Region root) {
    this.root = root;

    ongoingProjectsController.init(viewHandler, model, root);
    finishedProjectsController.init(viewHandler, model, root);
  }

  /**
   * Resets the ongoing and finished projects controllers.
   */
  public void reset() {
    ongoingProjectsController.reset();
    finishedProjectsController.reset();
  }

  /**
   * Returns the root Region of the controller.
   *
   * @return The root Region.
   */
  public Region getRoot() {
    return root;
  }

  /**
   * Handles the event when a tab is selected.
   *
   * @param event The event triggered when a tab is selected.
   */
  @FXML private void tabSelected(Event event) {
    if (ongoingProjectsController != null
            && finishedProjectsController.getRoot() != null) {
      int index = ((Tab) event.getSource()).getTabPane().getSelectionModel().getSelectedIndex();
      switch (index) {
        case 0 -> ongoingProjectsController.reset();
        case 1 -> finishedProjectsController.reset();
      }
    }
  }

  /**
   * Opens the tab at the specified index.
   *
   * @param index The index of the tab to be opened.
   */
  public void openTab(int index){
    tabPane.getSelectionModel().select(index);
  }
}
