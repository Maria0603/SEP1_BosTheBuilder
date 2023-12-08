package Fxml;

import javafx.scene.layout.Region;
import model.BuildingCompanyModel;
import view.ViewHandler;
import viewModel.FinishedProjectListViewModel;

public class ReportController {

  private BuildingCompanyModel model;
  private FinishedProjectListViewModel viewModel;
  private ViewHandler viewHandler;
  private Region root;
  public void init(ViewHandler viewHandler, BuildingCompanyModel model,
      Region root) {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new FinishedProjectListViewModel(model);

  }

  public void reset() {
    init(this.viewHandler, this.model, this.root);
  }

  public Region getRoot() {
    return root;
  }
}
