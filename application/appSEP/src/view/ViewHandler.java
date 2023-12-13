package view;

import fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BuildingCompanyModel;
import viewModel.ProjectViewModel;

/**
 * The ViewHandler class manages the different views and controllers in the application.
 */
public class ViewHandler {

  private BuildingCompanyModel model;
  private TabViewController tabViewController;
  private AddCommercialProjectController commercialProjectController;
  private AddResidentialProjectController residentialProjectController;
  private AddIndustrialProjectController industrialProjectController;
  private AddRoadProjectController roadProjectController;
  private EditCommercialController editCommercialProjectController;
  private EditResidentialController editResidentialProjectController;
  private EditIndustrialController editIndustrialProjectController;
  private EditRoadController editRoadProjectController;
  private CreateReportController createReportController;
  private Scene currentScene;
  private Stage primaryStage;

  /**
   * Constructs a ViewHandler object with the specified model.
   *
   * @param model The BuildingCompanyModel to be associated with the view handler.
   */
  public ViewHandler(BuildingCompanyModel model) {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

  /**
   * Gets the associated BuildingCompanyModel.
   *
   * @return The BuildingCompanyModel associated with the view handler.
   */
  public BuildingCompanyModel getModel() {
    return model;
  }

  /**
   * Initializes the primary stage and opens the initial view.
   *
   * @param primaryStage The primary stage of the application.
   */
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    openTabView("ongoing");
  }

  /**
   * Opens the tab view based on the specified ID.
   *
   * @param id The ID representing the tab view ("ongoing" or "finished").
   */
  public void openTabView(String id) {
    Region root = loadTabView("TabView.fxml");
    currentScene.setRoot(root);
    String title = "Ongoing Projects";
    if (root.getUserData() != null) {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();

    switch (id) {
      case "ongoing" -> tabViewController.openTab(0);
      case "finished" -> tabViewController.openTab(1);
    }
  }

  /**
   * Loads the TabView and initializes the associated controller.
   *
   * @param fxmlFile The FXML file representing the TabView.
   * @return The loaded Region representing the TabView.
   */
  private Region loadTabView(String fxmlFile) {
    Region root = null;
    if (tabViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        tabViewController = loader.getController();
        tabViewController.init(model, this, root);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      tabViewController.reset();
    }
    return tabViewController.getRoot();
  }

  /**
   * Closes the primary stage of the application.
   */
  public void closeView() {
    primaryStage.close();
  }

  /**
   * Opens a specific ComboBoxSelectionView based on the provided ID.
   *
   * @param id The ID representing the type of ComboBoxSelectionView to open.
   */
  public void openComboBoxSelectionView(String id) {
    Region root = null;
    switch (id) {
      case "Commercial" -> root = loadCommercialView("./AddCommercial.fxml");
      case "Residential" -> root = loadResidentialView("./AddResidential.fxml");
      case "Industrial" -> root = loadIndustrialView("./AddIndustrial.fxml");
      case "Road" -> root = loadRoadView("./AddRoad.fxml");
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null) {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  /**
   * Loads the CommercialView and initializes the associated controller.
   *
   * @param fxmlFile The FXML file representing the CommercialView.
   * @return The loaded Region representing the CommercialView.
   */
  private Region loadCommercialView(String fxmlFile) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      commercialProjectController = loader.getController();
      commercialProjectController.init(this, model, root);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the ResidentialView and initializes the associated controller.
   *
   * @param fxmlFile The FXML file representing the ResidentialView.
   * @return The loaded Region representing the ResidentialView.
   */
  private Region loadResidentialView(String fxmlFile) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      residentialProjectController = loader.getController();
      residentialProjectController.init(this, model, root);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the RoadView and initializes the associated controller.
   *
   * @param fxmlFile The FXML file representing the RoadView.
   * @return The loaded Region representing the RoadView.
   */
  private Region loadRoadView(String fxmlFile) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      roadProjectController = loader.getController();
      roadProjectController.init(this, model, root);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the IndustrialView and initializes the associated controller.
   *
   * @param fxmlFile The FXML file representing the IndustrialView.
   * @return The loaded Region representing the IndustrialView.
   */
  private Region loadIndustrialView(String fxmlFile) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      industrialProjectController = loader.getController();
      industrialProjectController.init(this, model, root);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loads the EditRoadView and initializes the associated controller.
   *
   * @param fxmlFileName The FXML file representing the EditRoadView.
   * @param selectedItem The selected project view model.
   * @return The loaded Region representing the EditRoadView.
   */
  private Region loadEditRoadView(String fxmlFileName, ProjectViewModel selectedItem) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFileName));
      root = loader.load();
      editRoadProjectController = loader.getController();
      editRoadProjectController.init(this, model, root, selectedItem);
    } catch (Exception e) {
      e.printStackTrace();
    }
    editRoadProjectController.reset();
    return root;
  }

  /**
   * Loads the EditCommercialView and initializes the associated controller.
   *
   * @param fxmlFileName The FXML file representing the EditCommercialView.
   * @param selectedItem The selected project view model.
   * @return The loaded Region representing the EditCommercialView.
   */
  private Region loadEditCommercialView(String fxmlFileName, ProjectViewModel selectedItem) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFileName));
      root = loader.load();
      editCommercialProjectController = loader.getController();
      editCommercialProjectController.init(this, model, root, selectedItem);
    } catch (Exception e) {
      e.printStackTrace();
    }
    editCommercialProjectController.reset();
    return root;
  }

  /**
   * Loads the EditResidentialView and initializes the associated controller.
   *
   * @param fxmlFileName The FXML file representing the EditResidentialView.
   * @param selectedItem The selected project view model.
   * @return The loaded Region representing the EditResidentialView.
   */
  private Region loadEditResidentialView(String fxmlFileName, ProjectViewModel selectedItem) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFileName));
      root = loader.load();
      editResidentialProjectController = loader.getController();
      editResidentialProjectController.init(this, model, root, selectedItem);
    } catch (Exception e) {
      e.printStackTrace();
    }
    editResidentialProjectController.reset();
    return root;
  }

  /**
   * Loads the EditIndustrialView and initializes the associated controller.
   *
   * @param fxmlFileName The FXML file representing the EditIndustrialView.
   * @param selectedItem The selected project view model.
   * @return The loaded Region representing the EditIndustrialView.
   */
  private Region loadEditIndustrialView(String fxmlFileName, ProjectViewModel selectedItem) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFileName));
      root = loader.load();
      editIndustrialProjectController = loader.getController();
      editIndustrialProjectController.init(this, model, root, selectedItem);
    } catch (Exception e) {
      e.printStackTrace();
    }
    editIndustrialProjectController.reset();
    return root;
  }

  /**
   * Loads the ReportView and initializes the associated controller.
   *
   * @return The loaded Region representing the ReportView.
   */
  private Region loadReportView() {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("./CreateAReport.fxml"));
      root = loader.load();
      createReportController = loader.getController();
      createReportController.init(this, model, root);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return root;
  }
}
