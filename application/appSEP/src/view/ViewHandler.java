package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BuildingCompanyModel;

public class ViewHandler {
    private final Scene currentScene;
    private Stage primaryStage;
    private BuildingCompanyModel model;
    private TabViewController tabViewController;
    public ViewHandler(BuildingCompanyModel model) {
        this.currentScene = new Scene(new Region());
        this.model = model;

    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView("ongoing");
    }

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
    public void closeView(){
        primaryStage.close();
    }
    private Region loadTabView(String fxmlFile) {
        Region root = null;
        if (tabViewController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                tabViewController = loader.getController();
                tabViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            tabViewController.reset();
        }
        return tabViewController.getRoot();
    }
}