package view;

import javafx.scene.layout.Region;
import model.BuildingCompanyModel;

/**
 * The {@code FinishedProjectsController} class is responsible for managing the user interface
 * and interactions related to displaying finished projects in the building company application.
 */
public class FinishedProjectsController {
  /**
   * The root element of the user interface for displaying finished projects.
   */
  Region root;

  /**
   * Initializes the controller with the necessary components and data.
   *
   * @param viewManager The view manager responsible for handling view transitions.
   * @param model       The building company model containing project data.
   * @param root        The root element of the user interface.
   */
  public void init(ViewHandler viewManager, BuildingCompanyModel model, Region root) {

  }

  /**
   * Resets the state of the controller.
   */
  public void reset() {
  }

  /**
   * Retrieves the root element of the user interface.
   *
   * @return The root element of the user interface.
   */
  public Region getRoot() {
    return root;
  }
}
