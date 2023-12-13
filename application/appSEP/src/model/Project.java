package model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Represents an abstract class for projects.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Residential.class, Commercial.class, Industrial.class, Road.class})
public abstract class Project {

  private int id;
  private String title;
  private int expectedBudget;
  private int spentBudget;
  private int expectedMonths;
  private int spentMonths;
  private boolean isFinished;
  private MyDate creationDate;
  private MyDate endingDate;
  private String creationDateString;
  private String endingDateString;

  /**
   * Constructs a project with specified attributes.
   *
   * @param id                The ID of the project.
   * @param title             The title of the project.
   * @param expectedBudget    The expected budget for the project.
   * @param expectedMonths    The expected duration in months.
   * @param creationDateString The creation date string.
   * @param endingDateString   The ending date string.
   */
  public Project(int id, String title, int expectedBudget, int expectedMonths, String creationDateString, String endingDateString) {
    this.id = id;
    this.title = title;
    this.expectedBudget = expectedBudget;
    this.spentBudget = 0;
    this.expectedMonths = expectedMonths;
    this.spentMonths = 0;
    this.creationDate = new MyDate(creationDateString);
    this.endingDate = new MyDate(endingDateString);
    this.isFinished = false;
    this.creationDateString = creationDateString;
    this.endingDateString = endingDateString;
  }

  /**
   * Constructs a project with specified attributes.
   *
   * @param id          The ID of the project.
   * @param title       The title of the project.
   * @param expectedBudget The expected budget for the project.
   * @param expectedMonths The expected duration in months.
   * @param creationDate The creation date of the project.
   * @param endingDate   The ending date of the project.
   */
  public Project(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate, MyDate endingDate) {
    this.id = id;
    this.title = title;
    this.expectedBudget = expectedBudget;
    this.spentBudget = 0;
    this.expectedMonths = expectedMonths;
    this.spentMonths = 0;
    this.creationDate = creationDate;
    this.endingDate = endingDate;
    this.isFinished = false;
    this.creationDateString = creationDate.toString();
    this.endingDateString = endingDate.toString();
  }

  /**
   * Default constructor for the Project class.
   */
  public Project() {
    this.id = -1;
    this.title = null;
    this.expectedBudget = -1;
    this.spentBudget = -1;
    this.expectedMonths = -1;
    this.spentMonths = -1;
    this.creationDate = null;
    this.endingDate = null;
    this.isFinished = false;
  }

  // Getters and Setters

  /**
   * Gets the ID of the project.
   *
   * @return The ID of the project.
   */
  public int getId() {
    return id;
  }

  /**
   * Gets the title of the project.
   *
   * @return The title of the project.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the expected budget for the project.
   *
   * @return The expected budget for the project.
   */
  public int getExpectedBudget() {
    return expectedBudget;
  }

  /**
   * Gets the spent budget for the project.
   *
   * @return The spent budget for the project.
   */
  public int getSpentBudget() {
    return spentBudget;
  }

  /**
   * Gets the creation date of the project.
   *
   * @return The creation date of the project.
   */
  public MyDate getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the creation date string of the project.
   *
   * @return The creation date string of the project.
   */
  public String getCreationDateString() {
    return creationDateString;
  }

  /**
   * Gets the ending date of the project.
   *
   * @return The ending date of the project.
   */
  public MyDate getEndingDate() {
    return endingDate;
  }

  /**
   * Gets the ending date string of the project.
   *
   * @return The ending date string of the project.
   */
  public String getEndingDateString() {
    return endingDateString;
  }

  /**
   * Gets the expected duration in months for the project.
   *
   * @return The expected duration in months for the project.
   */
  public int getExpectedMonths() {
    return expectedMonths;
  }

  /**
   * Gets the spent duration in months for the project.
   *
   * @return The spent duration in months for the project.
   */
  public int getSpentMonths() {
    return spentMonths;
  }

  /**
   * Checks if the project is finished.
   *
   * @return True if the project is finished, false otherwise.
   */
  public boolean isFinished() {
    return isFinished;
  }

  // Setter methods

  /**
   * Sets the creation date of the project.
   *
   * @param creationDate The new creation date of the project.
   */
  public void setCreationDate(MyDate creationDate) {
    this.creationDate = creationDate;
    creationDateString = creationDate.getDateString();
  }

  /**
   * Sets the ending date of the project.
   *
   * @param endingDate The new ending date of the project.
   */
  public void setEndingDate(MyDate endingDate) {
    this.endingDate = endingDate;
    endingDateString = endingDate.getDateString();
  }

  /**
   * Sets the expected budget for the project.
   *
   * @param expectedBudget The new expected budget for the project.
   */
  public void setExpectedBudget(int expectedBudget) {
    this.expectedBudget = expectedBudget;
  }

  /**
   * Sets the expected duration in months for the project.
   *
   * @param expectedMonths The new expected duration in months for the project.
   */
  public void setExpectedMonths(int expectedMonths) {
    this.expectedMonths = expectedMonths;
  }

  /**
   * Sets the finished status of the project.
   *
   * @param finished True if the project is finished, false otherwise.
   */
  public void setFinished(boolean finished) {
    isFinished = !finished;
  }

  /**
   * Sets the ID of the project.
   *
   * @param id The new ID for the project.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Sets the spent budget for the project.
   *
   * @param spentBudget The new spent budget for the project.
   */
  public void setSpentBudget(int spentBudget) {
    this.spentBudget = spentBudget;
  }

  /**
   * Sets the spent duration in months for the project.
   *
   * @param spentMonths The new spent duration in months for the project.
   */
  public void setSpentMonths(int spentMonths) {
    this.spentMonths = spentMonths;
  }

  /**
   * Sets the title of the project.
   *
   * @param title The new title for the project.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Calculates the spent months between creation and ending dates.
   *
   * @param creationMyDate The creation date.
   * @param endingMyDate   The ending date.
   * @return The number of months between creation and ending dates.
   */
  public int calculateSpentMonths(MyDate creationMyDate, MyDate endingMyDate) {
    return MyDate.monthsBetween(creationMyDate, endingMyDate);
  }

  /**
   * Returns a string representation of the project.
   *
   * @return A string representation of the project.
   */
  @Override
  public String toString() {
    return "ID = " + id + " title = " + title + "\n" +
            "expected budget = " + expectedBudget + " spent budget = " + spentBudget + "\n" +
            "expected months = " + expectedMonths + " spent months = " + spentMonths + "\n" +
            "creation date = " + creationDate.toString() + " ending date = " + endingDate.toString();
  }

  /**
   * Returns the type of the project.
   *
   * @param project The project instance.
   * @return The type of the project.
   */
  public String returnProjectType(Project project) {
    if (project instanceof Residential) {
      return "residential";
    } else if (project instanceof Commercial) {
      return "commercial";
    } else if (project instanceof Industrial) {
      return "industrial";
    } else {
      return "road";
    }
  }

  /**
   * Checks if the current project is equal to another object.
   *
   * @param obj The object to compare with.
   * @return True if the projects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Project other = (Project) obj;
    return this.id == other.id && this.isFinished == other.isFinished &&
            this.expectedBudget == other.expectedBudget &&
            this.spentBudget == other.spentBudget &&
            this.spentMonths == other.spentMonths &&
            this.expectedMonths == other.expectedMonths && this.title.equals(
            other.title) && this.creationDate.equals(other.creationDate)
            && this.endingDate.equals(other.endingDate);
  }

  /**
   * Creates a copy of the project.
   *
   * @return A copy of the project.
   */
  public abstract Project copy();

}
