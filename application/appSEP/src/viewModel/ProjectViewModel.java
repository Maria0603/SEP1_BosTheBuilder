package viewModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Project;

/**
 * The ProjectViewModel class represents the view model for a project.
 */
public class ProjectViewModel {

  private IntegerProperty idProperty;
  private StringProperty titleProperty;
  private StringProperty dateProperty;
  private StringProperty typeProperty;

  /**
   * Constructs a ProjectViewModel based on the provided Project model.
   *
   * @param project The Project model to create the view model from.
   */
  public ProjectViewModel(Project project) {
    idProperty = new SimpleIntegerProperty(project.getId());
    titleProperty = new SimpleStringProperty(project.getTitle());
    dateProperty = new SimpleStringProperty(project.getCreationDate().toString());
    typeProperty = new SimpleStringProperty(project.returnProjectType(project));
  }

  /**
   * Gets the IntegerProperty for the project's ID.
   *
   * @return The IntegerProperty for the project's ID.
   */
  public IntegerProperty getIdProperty() {
    return idProperty;
  }

  /**
   * Gets the StringProperty for the project's title.
   *
   * @return The StringProperty for the project's title.
   */
  public StringProperty getTitleProperty() {
    return titleProperty;
  }

  /**
   * Gets the StringProperty for the project's creation date.
   *
   * @return The StringProperty for the project's creation date.
   */
  public StringProperty getDateProperty() {
    return dateProperty;
  }

  /**
   * Gets the StringProperty for the project's type.
   *
   * @return The StringProperty for the project's type.
   */
  public StringProperty getTypeProperty() {
    return typeProperty;
  }
}
