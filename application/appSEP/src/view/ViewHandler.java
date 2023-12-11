package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BuildingCompanyModel;

/**
 * The {@code ViewHandler} class is responsible for managing views and transitions in the
 * building company application.
 */
public class ViewHandler {
    private final Scene currentScene;
    private Stage primaryStage;
    private BuildingCompanyModel model;
    private TabViewController tabViewController;

    /**
     * Constructs a new {@code ViewHandler} with the specified {@code BuildingCompanyModel}.
     *
     * @param model The building company model containing project data.
     */
    public ViewHandler(BuildingCompanyModel model) {
        this.currentScene = new Scene(new Region());
        this.model = model;
    }

    /**
     * Starts the application by opening the primary stage and displaying the ongoing projects view.
     *
     * @param primaryStage The primary stage of the JavaFX application.
     */
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView("ongoing");
    }

    /**
     * Opens a specific view based on the provided identifier.
     *
     * @param id The identifier of the view to open ("ongoing" or "finished").
     */
    public void openView(String id) {
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
     * Closes the primary stage.
     */
    public void closeView() {
        primaryStage.close();
    }

    private Region loadTabView(String fxmlFile) {
        Region root = null;
        if (tabViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                tabViewController = loader.getController();
                tabViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            tabViewController.reset();
        }
        return tabViewController.getRoot();
    }
}
