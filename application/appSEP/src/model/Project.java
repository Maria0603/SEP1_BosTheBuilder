package model;

/**
 * The {@code Project} class is an abstract class representing a project with common properties.
 */
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

  /**
   * Constructs a new {@code Project} with the specified parameters.
   *
   * @param id            The unique identifier of the project.
   * @param title         The title of the project.
   * @param expectedBudget     The expected budget of the project.
   * @param expectedMonths The expected duration of the project in months.
   * @param creationDate  The date when the project was created.
   * @param endingDate    The expected ending date of the project.
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
  }

  /**
   * Gets the unique identifier of the project.
   *
   * @return The project ID.
   */
  public int getId() {
    return id;
  }

  /**
   * Gets the title of the project.
   *
   * @return The project title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the expected budget of the project.
   *
   * @return The expected budget.
   */
  public int getExpectedBudget() {
    return expectedBudget;
  }

  /**
   * Gets the spent budget of the project.
   *
   * @return The spent budget.
   */
  public int getSpentBudget() {
    return spentBudget;
  }

  /**
   * Gets the creation date of the project.
   *
   * @return The creation date.
   */
  public MyDate getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the ending date of the project.
   *
   * @return The ending date.
   */
  public MyDate getEndingDate() {
    return endingDate;
  }

  /**
   * Gets the expected duration of the project in months.
   *
   * @return The expected duration in months.
   */
  public int getExpectedMonths() {
    return expectedMonths;
  }

  /**
   * Gets the spent duration of the project in months.
   *
   * @return The spent duration in months.
   */
  public int getSpentMonths() {
    return spentMonths;
  }

  /**
   * Checks if the project is finished.
   *
   * @return {@code true} if the project is finished, {@code false} otherwise.
   */
  public boolean isFinished() {
    return isFinished;
  }

  /**
   * Sets the creation date of the project.
   *
   * @param creationDate The new creation date.
   */
  public void setCreationDate(MyDate creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * Sets the ending date of the project.
   *
   * @param endingDate The new ending date.
   */
  public void setEndingDate(MyDate endingDate) {
    this.endingDate = endingDate;
  }

  /**
   * Sets the expected budget of the project.
   *
   * @param expectedBudget The new expected budget.
   */
  public void setExpectedBudget(int expectedBudget) {
    this.expectedBudget = expectedBudget;
  }

  /**
   * Sets the expected duration of the project in months.
   *
   * @param expectedMonths The new expected duration in months.
   */
  public void setExpectedMonths(int expectedMonths) {
    this.expectedMonths = expectedMonths;
  }

  /**
   * Sets the finished status of the project.
   *
   * @param finished The new finished status.
   */
  public void setFinished(boolean finished) {
    isFinished = finished;
  }

  /**
   * Sets the unique identifier of the project.
   *
   * @param id The new project ID.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Sets the spent budget of the project.
   *
   * @param spentBudget The new spent budget.
   */
  public void setSpentBudget(int spentBudget) {
    this.spentBudget = spentBudget;
  }

  /**
   * Sets the spent duration of the project in months.
   *
   * @param spentMonths The new spent duration in months.
   */
  public void setSpentMonths(int spentMonths) {
    this.spentMonths = spentMonths;
  }

  /**
   * Sets the title of the project.
   *
   * @param title The new project title.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Calculates the spent duration of the project in months.
   *
   * @param creationMyDate The creation date of the project.
   * @param endingMyDate    The ending date of the project.
   * @return The spent duration in months.
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
            "creation date = " + creationDate + " ending date = " + endingDate;
  }

  /**
   * Checks if this project is equal to another object.
   *
   * @param obj The object to compare.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Project other = (Project) obj;
    return this.id == other.id && this.isFinished == other.isFinished && this.expectedBudget == other.expectedBudget &&
            this.spentBudget == other.spentBudget && this.spentMonths == other.spentMonths && this.expectedMonths == other.expectedMonths &&
            this.title.equals(other.title) && this.creationDate.equals(other.creationDate) && this.endingDate.equals(other.endingDate);
  }

  /**
   * Creates a copy of the project.
   *
   * @return A copy of the project.
   */
  public abstract Project copy();
}
