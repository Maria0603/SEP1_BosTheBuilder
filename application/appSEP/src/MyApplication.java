import javafx.application.Application;
import javafx.stage.Stage;
import model.BuildingCompany;
import model.BuildingCompanyModel;
import view.ViewHandler;

public class MyApplication extends Application {


    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BuildingCompanyModel model = new BuildingCompany();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);
    }
}

