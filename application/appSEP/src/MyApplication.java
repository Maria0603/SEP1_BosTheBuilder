import javafx.application.Application;
import javafx.stage.Stage;
import model.BuildingCompany;
import model.BuildingCompanyModel;
import view.ViewHandler;

/**
 * The {@code MyApplication} class represents the main application class for the building company application.
 * It extends the JavaFX {@code Application} class and initializes the model and view components.
 */
public class MyApplication extends Application {

    /**
     * The {@code init} method is called during the application initialization phase.
     *
     * @throws Exception If an exception occurs during initialization.
     */
    @Override
    public void init() throws Exception {
        // Initialization code can be added here if needed.
    }

    /**
     * The {@code start} method is called when the application is launched.
     *
     * @param primaryStage The primary stage for the application.
     * @throws Exception If an exception occurs during the application startup.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the building company model
        BuildingCompanyModel model = new BuildingCompany();

        // Create the view handler with the model
        ViewHandler view = new ViewHandler(model);

        // Start the view with the primary stage
        view.start(primaryStage);
    }
}
