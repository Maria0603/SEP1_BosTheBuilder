package viewModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Project;

public class ProjectViewModel
{
  private IntegerProperty idProperty;
  private StringProperty titleProperty;
  private StringProperty dateProperty;

  public ProjectViewModel(Project project) {
    idProperty = new SimpleIntegerProperty(project.getId());
    titleProperty = new SimpleStringProperty(project.getTitle());
    dateProperty = new SimpleStringProperty(project.getCreationDate().toString());
  }

  public IntegerProperty getIdProperty()
  {
    return idProperty;
  }

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  public StringProperty getDateProperty()
  {
    return dateProperty;
  }
}
