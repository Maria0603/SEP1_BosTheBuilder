package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BuildingCompany;
import model.BuildingCompanyModel;

public class ViewHandler {

    private static ViewHandler viewHandler;
    private  BuildingCompanyModel model;
    private Stage primaryStage;
    private Scene addOngoingViewScene;
    private Scene editIndustrialViewScene;
    private Scene tabViewScene;
    private Scene openResidentialViewScene;
    private Scene editRoadViewScene;

    public ViewHandler(Stage stage) {
        this.primaryStage = stage;
        this.model = new BuildingCompany();
        viewHandler = this;
    }

    public static ViewHandler getInstance() {
        if (viewHandler == null){
            return  new ViewHandler(new Stage());
        }
        return viewHandler;
    }


    public void start() {
        this.primaryStage = new Stage();
        openTabView();
    }

    private Region loadGUIView(String fxmlFileName) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            loader.getController();
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
    public void closeView(){
        primaryStage.close();
    }

    public void openAddOngoingView() {
        if (addOngoingViewScene == null){
            this.addOngoingViewScene= new Scene(new Region());
            Region root = loadGUIView("AddResidental.fxml");
            addOngoingViewScene.setRoot(root);
            String title = "Login";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(addOngoingViewScene);
        primaryStage.show();
    }


    public void openTabView() {
        if (tabViewScene == null){
            this.tabViewScene= new Scene(new Region());
            Region root = loadTabView("TabView.fxml");
            tabViewScene.setRoot(root);
            String title = "TabView";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(tabViewScene);
        primaryStage.show();
    }

    private Region loadTabView(String fxmlFileName) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = loader.load();
            TabViewController tabViewController = loader.getController();
            tabViewController.openTab(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    public BuildingCompanyModel getModel() {
        return model;
    }

    public void openEditIndustrial(int projectId) {
        if (editIndustrialViewScene == null){
            this.editIndustrialViewScene= new Scene(new Region());
            Region root = loadEditIndustrial("EditIndustrial.fxml", projectId);
            editIndustrialViewScene.setRoot(root);
            String title = "Login";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(editIndustrialViewScene);
        primaryStage.show();
    }

    private Region loadEditIndustrial(String fxmlFileName, int projectId) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = loader.load();
            EditIndustrialController editIndustrialController = loader.getController();
            editIndustrialController.setItem(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    public void openResidential(int projectId) {
        if (openResidentialViewScene == null){
            this.openResidentialViewScene= new Scene(new Region());
            Region root = loadEditResidential("EditResidental.fxml", projectId);
            openResidentialViewScene.setRoot(root);
            String title = "EditResidental";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(openResidentialViewScene);
        primaryStage.show();
    }

    private Region loadEditResidential(String fxmlFileName, int projectId) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = loader.load();
            EditResidentalController editIndustrialController = loader.getController();
            editIndustrialController.setItem(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
    public void openEditRoad(int projectId) {
        if (editRoadViewScene == null){
            this.editRoadViewScene= new Scene(new Region());
            Region root = loadEditRoad("EditRoad.fxml", projectId);
            editRoadViewScene.setRoot(root);
            String title = "EditRoad";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(editRoadViewScene);
        primaryStage.show();
    }

    private Region loadEditRoad(String fxmlFileName, int projectId) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = loader.load();
            EditResidentalController editIndustrialController = loader.getController();
            editIndustrialController.setItem(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
}