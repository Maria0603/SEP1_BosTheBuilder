package view;

import Fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BuildingCompanyModel;
import model.Commercial;
import model.Industrial;
import model.Residential;
import model.MyDate;

public class ViewHandler {

    private BuildingCompanyModel model;
    private TabViewController tabViewController;
    private AddCommercialProjectController commercialProjectController;
    private AddResidentialProjectController residentialProjectController;
    private AddIndustrialProjectController industrialProjectController;
    private EditIndustrialController editIndustrialController;
    private AddRoadProjectController roadProjectController;
    private Scene currentScene;
    private Stage primaryStage;
    private Scene openResidentialViewScene;
    private Scene editRoadViewScene;
    private Scene editIndustrialViewScene;

    private EditResidentialController editResidentialController;
    private EditRoadController editRoadController;
    private Scene editCommercialViewScene;
    private EditCommercialController editCommercialController;

    public ViewHandler(BuildingCompanyModel model) {
        this.currentScene = new Scene(new Region());
        this.model = model;
        model.addNewProject(new Commercial(1, "hello", 10, 10, new MyDate(10, 10, 1000), new MyDate(10, 10, 1000), 100, 5, "serious business"));
        model.addNewProject(new Industrial(2,"Testing edit ", 121212,21,new MyDate(10, 10, 1000), new MyDate(10, 10, 1000),122,"BOMBING"));
        model.addNewProject(new Residential(3,"Testing edit ", 121212,21,new MyDate(10, 10, 1000), new MyDate(10, 10, 1000),122,1,1,1,true,1));
    }

    public BuildingCompanyModel getModel() {
        return model;
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openTabView("ongoing");
    }

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

    public void closeView(){
        primaryStage.close();
    }

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

    private Region loadTabView(String fxmlFile) {
        Region root = null;
        if (tabViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
                tabViewController = loader.getController();
                tabViewController.init(model, this, root);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            tabViewController.reset();
        }
        return tabViewController.getRoot();
    }

    //      For ADD windows

    private Region loadCommercialView(String fxmlFile) {
        Region root = null;

        try
        {
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

    private Region loadResidentialView(String fxmlFile) {
        Region root = null;

        try
        {
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

    private Region loadRoadView(String fxmlFile) {
        Region root = null;

        try
        {
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

    private Region loadIndustrialView(String fxmlFile) {
        Region root = null;

        try
        {
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

    public void openEditIndustrial(int projectId) {
        if (editIndustrialViewScene == null){
            this.editIndustrialViewScene = new Scene(new Region());
            Region root = loadEditIndustrial("./EditIndustrial.fxml", projectId);
            editIndustrialViewScene.setRoot(root);
            String title = "EditIndustrial";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(editIndustrialViewScene);
        primaryStage.show();
    }

    private Region loadEditIndustrial(String fxmlFileName,int projectId) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = loader.load();
            if (editIndustrialController == null){
                editIndustrialController = loader.getController();
                editIndustrialController.init(this,model,root);
                editIndustrialController.setItem(projectId);
            }else {
                editIndustrialController.setItem(projectId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    public void openResidential(int projectId) {
        if (openResidentialViewScene == null){
            this.openResidentialViewScene = new Scene(new Region());
            Region root = loadEditResidential("./EditResidential.fxml", projectId);
            openResidentialViewScene.setRoot(root);
            String title = "EditResidential";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(openResidentialViewScene);
        primaryStage.show();
    }

    private Region loadEditResidential(String fxmlFileName,int projectId) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = loader.load();
            if (editResidentialController == null){
                editResidentialController = loader.getController();
                editResidentialController.init(this,model,root);
                editResidentialController.setItem(projectId);
            }else {
                editResidentialController.setItem(projectId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    public void openEditRoad(int projectId) {
        if (editRoadViewScene == null){
            this.editRoadViewScene = new Scene(new Region());
            Region root = loadEditRoad("./EditRoad.fxml", projectId);
            editRoadViewScene.setRoot(root);
            String title = "EditRoad";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(editRoadViewScene);
        primaryStage.show();
    }

    private Region loadEditRoad(String fxmlFileName,int projectId) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = loader.load();

            if (editRoadController == null){
                editRoadController = loader.getController();
                editRoadController.init(this,model,root);
                editRoadController.setItem(projectId);
            }else {
                editRoadController.setItem(projectId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
    public void openEditCommercial(int projectId) {
        if (editCommercialViewScene == null){
            this.editCommercialViewScene = new Scene(new Region());
            Region root = loadEditCommercial("./EditCommercial.fxml", projectId);
            editCommercialViewScene.setRoot(root);
            String title = "EditCommercial";
            primaryStage.setTitle(title);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
        }
        primaryStage.setScene(editCommercialViewScene);
        primaryStage.show();
    }

    private Region loadEditCommercial(String fxmlFileName,int projectId) {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = loader.load();

            if (editCommercialController == null){
                editCommercialController = loader.getController();
                editCommercialController.init(this,model,root);
                editCommercialController.setItem(projectId);
            }else {
                editCommercialController.setItem(projectId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
}