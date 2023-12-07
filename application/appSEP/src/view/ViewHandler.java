package view;

import Fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.BuildingCompanyModel;
import model.Commercial;
import model.MyDate;
import model.Road;
import viewModel.ProjectViewModel;

import java.util.ArrayList;

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
    private Scene currentScene;
    private Stage primaryStage;


    public ViewHandler(BuildingCompanyModel model) {
        this.currentScene = new Scene(new Region());
        this.model = model;
        model.addNewProject(
            new Commercial(1, "hello", 10, 10, new MyDate(10, 10, 1000),
                new MyDate(10, 10, 1000), 100, 5, "serious business"));
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

    public void closeView(){
        primaryStage.close();
    }

    //  For opening ADD windows
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

    //      For opening EDIT windows
    public void openDetailsSelectionView(ProjectViewModel selectedItem) {
        Region root = null;
        switch (selectedItem.getTypeProperty().get()) {
            case "commercial" -> root = loadEditCommercialView("./EditCommercial.fxml", selectedItem);
            case "residential" -> root = loadEditResidentialView("./EditResidential.fxml", selectedItem);
            case "industrial" -> root = loadEditIndustrialView("./EditIndustrial.fxml", selectedItem);
            case "road" -> root = loadEditRoadView("./EditRoad.fxml", selectedItem);
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

    private Region loadEditRoadView(String fxmlFileName, ProjectViewModel selectedItem) {
        Region root = null;
        try
        {
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

    private Region loadEditCommercialView(String fxmlFileName, ProjectViewModel selectedItem) {
        Region root = null;
        try
        {
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

    private Region loadEditResidentialView(String fxmlFileName, ProjectViewModel selectedItem) {
        Region root = null;
        try
        {
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

    private Region loadEditIndustrialView(String fxmlFileName, ProjectViewModel selectedItem) {
        Region root = null;
        try
        {
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
}