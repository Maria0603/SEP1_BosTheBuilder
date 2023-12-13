package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import viewModel.FinishedProjectListViewModel;
import viewModel.ProjectViewModel;
import viewModel.ReportListViewModel;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Controller class for creating reports.
 */
public class CreateReportController {

    public RadioButton allTypesRadio;
    public RadioButton commercialRadio;
    public RadioButton residentialRadio;
    public RadioButton industrialRadio;
    @FXML public RadioButton roadRadio;
    @FXML public TextField fromDateField;
    @FXML public TextField toDateField;
    @FXML public RadioButton dateRadio;
    @FXML public RadioButton budgetRadio;
    @FXML public RadioButton monthsRadio;
    @FXML public RadioButton increasingRadio;
    @FXML public RadioButton decreasingRadio;
    @FXML private TableView<ProjectViewModel> projectListTable;
    @FXML private TableColumn<ProjectViewModel, Number> idColumn;
    @FXML private TableColumn<ProjectViewModel, String> titleColumn;
    @FXML private TableColumn<ProjectViewModel, String> dateColumn;
    @FXML private TableColumn<ProjectViewModel, String> typeColumn;
    @FXML private Label errorLabel;

    private BuildingCompanyModel model;
    private ReportListViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;
    private ToggleGroup order, sortingCategory, projectType;

    /**
     * Initializes the controller with the necessary components.
     *
     * @param viewHandler The ViewHandler instance.
     * @param model The BuildingCompanyModel instance.
     * @param root The root Region for the view.
     */
    public void init(ViewHandler viewHandler, BuildingCompanyModel model,
                     Region root) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.root = root;
        this.viewModel = new ReportListViewModel(model);

        idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());

        projectListTable.setItems(viewModel.getList());

        this.projectType = new ToggleGroup();
        allTypesRadio.setToggleGroup(projectType);
        commercialRadio.setToggleGroup(projectType);
        residentialRadio.setToggleGroup(projectType);
        industrialRadio.setToggleGroup(projectType);
        roadRadio.setToggleGroup(projectType);

        this.sortingCategory = new ToggleGroup();
        dateRadio.setToggleGroup(sortingCategory);
        monthsRadio.setToggleGroup(sortingCategory);
        budgetRadio.setToggleGroup(sortingCategory);

        this.order = new ToggleGroup();
        increasingRadio.setToggleGroup(order);
        decreasingRadio.setToggleGroup(order);
    }

    /**
     * Resets the controller to its initial state.
     */
    public void reset() {
        init(this.viewHandler, this.model, this.root);
    }

    /**
     * Gets the root Region of the view.
     *
     * @return The root Region.
     */
    public Region getRoot() {
        return root;
    }

    @FXML public void cancelPressed() {
        model.resetReportList();
        viewHandler.openTabView("finished");
    }

    @FXML public void generateReportFilePressed() {
        model.generateReportTXT();
    }

    @FXML public void applyFiltersPressed() {
        // Get the selected RadioButtons
        RadioButton selectedProjectTypeRadioButton = (RadioButton) projectType.getSelectedToggle();
        RadioButton selectedSortingCategoryRadioButton = (RadioButton) sortingCategory.getSelectedToggle();
        RadioButton selectedOrderRadioButton = (RadioButton) order.getSelectedToggle();

        // Convert to enums
        Sort.ProjectType projectType = Sort.ProjectType.valueOf(selectedProjectTypeRadioButton.getText().toUpperCase());
        Sort.SortingCategory sortingCategory = Sort.SortingCategory.valueOf(selectedSortingCategoryRadioButton.getText().toUpperCase());
        Sort.Order order = Sort.Order.valueOf(selectedOrderRadioButton.getText().toUpperCase());

        String fromDateString = fromDateField.getText();
        MyDate fromDate  = MyDate.parseStringToDate(fromDateString);
        model.setFromDateForReport(fromDate);

        String toDateString = toDateField.getText();
        MyDate toDate  = MyDate.parseStringToDate(toDateString);
        model.setToDateForReport(toDate);

        model.generateReport(order, sortingCategory, projectType);
        reset();
    }
}
