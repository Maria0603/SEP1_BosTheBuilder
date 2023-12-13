import javafx.application.Application;
import javafx.stage.Stage;
import model.BuildingCompany;
import model.BuildingCompanyModel;
import view.ViewHandler;

/**
 * The MyApplication class represents the entry point for the JavaFX application.
 */
public class MyApplication extends Application {

    /**
     * Initializes the JavaFX application.
     *
     * @throws Exception If an exception occurs during initialization.
     */
    @Override
    public void init() throws Exception {
        // Perform any necessary initialization here
    }

    /**
     * Starts the JavaFX application by creating the model, view, and launching the primary stage.
     *
     * @param primaryStage The primary stage of the JavaFX application.
     * @throws Exception If an exception occurs during the application start.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the model
        BuildingCompanyModel model = new BuildingCompany();

        // Create the view handler with the model
        ViewHandler view = new ViewHandler(model);

        // Start the view with the primary stage
        view.start(primaryStage);
    }
}
