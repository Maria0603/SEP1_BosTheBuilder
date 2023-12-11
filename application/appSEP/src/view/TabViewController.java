package view;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import model.BuildingCompanyModel;

/**
 * The {@code TabViewController} class is responsible for managing the user interface
 * and interactions related to the main tab view in the building company application.
 */
public class TabViewController {
  @FXML
  private TabPane tabPane;
  @FXML
  private OngoingProjectsController ongoingProjectsController;
  @FXML
  private FinishedProjectsController finishedProjectsController;
  private Region root;

  /**
   * Initializes the controller with the necessary components and data.
   *
   * @param viewManager The view manager responsible for handling view transitions.
   * @param model       The building company model containing project data.
   * @param root        The root element of the user interface.
   */
  public void init(ViewHandler viewManager, BuildingCompanyModel model, Region root) {
    this.root = root;
    ongoingProjectsController.init(viewManager, model, root);
    finishedProjectsController.init(viewManager, model, root);
  }

  /**
   * Resets the state of the controller and its child controllers.
   */
  public void reset() {
    ongoingProjectsController.reset();
    finishedProjectsController.reset();
  }

  /**
   * Retrieves the root element of the user interface.
   *
   * @return The root element of the user interface.
   */
  public Region getRoot() {
    return root;
  }

  /**
   * Handles the tab selection event, resetting the selected tab's controller.
   *
   * @param event The tab selection event.
   */
  @FXML
  private void tabSelected(Event event) {
    if (ongoingProjectsController != null &&
            finishedProjectsController.getRoot() != null) {
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
   * @param index The index of the tab to open.
   */
  public void openTab(int index) {
    tabPane.getSelectionModel().select(index);
  }
}
