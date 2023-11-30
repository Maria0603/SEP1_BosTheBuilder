package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


public class ViewHandler {
    private final Scene currentScene;
    private Stage primaryStage;
    public ViewHandler() {
        this.currentScene = new Scene(new Region());
    }


    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView();
    }

    public void openView() {
        Region root = loadTabView("OngoingProjects.fxml");
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
    }
    public void closeView(){

    }
    private Region loadTabView(String fxmlFile) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
}