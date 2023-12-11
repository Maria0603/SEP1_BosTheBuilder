package model;

/**
 * The {@code Residental} class represents a residential project, extending the {@code Project} class.
 */
public class Residental extends Project {
  private int squareMeters;
  private int numberOfKitchens;
  private int numberOfBathrooms;
  private int numberOfOtherPlumbingRooms;
  private boolean isNew;

  /**
   * Constructs a new residential project with the specified parameters.
   *
   * @param id                         The project ID.
   * @param title                      The project title.
   * @param expectedBudget             The expected budget for the project.
   * @param expectedMonths             The expected duration of the project in months.
   * @param creationDate               The date when the project was created.
   * @param endingDate                 The date when the project is expected to end.
   * @param squareMeters               The total square meters of the residential area.
   * @param numberOfKitchens           The number of kitchens in the residential area.
   * @param numberOfBathrooms          The number of bathrooms in the residential area.
   * @param numberOfOtherPlumbingRooms The number of other plumbing rooms in the residential area.
   * @param isNew                      Indicates whether the residential area is new.
   */
  public Residental(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate,
                    MyDate endingDate, int squareMeters, int numberOfKitchens, int numberOfBathrooms,
                    int numberOfOtherPlumbingRooms, boolean isNew) {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);

    this.squareMeters = squareMeters;
    this.numberOfKitchens = numberOfKitchens;
    this.numberOfBathrooms = numberOfBathrooms;
    this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;
    this.isNew = isNew;
  }

  /**
   * Gets the total square meters of the residential area.
   *
   * @return The square meters of the residential area.
   */
  public int getSquareMeters() {
    return squareMeters;
  }

  /**
   * Gets the number of bathrooms in the residential area.
   *
   * @return The number of bathrooms.
   */
  public int getNumberOfBathrooms() {
    return numberOfBathrooms;
  }

  /**
   * Gets the number of kitchens in the residential area.
   *
   * @return The number of kitchens.
   */
  public int getNumberOfKitchens() {
    return numberOfKitchens;
  }

  /**
   * Gets the number of other plumbing rooms in the residential area.
   *
   * @return The number of other plumbing rooms.
   */
  public int getNumberOfOtherPlumbingRooms() {
    return numberOfOtherPlumbingRooms;
  }

  /**
   * Gets the status indicating whether the residential area is new.
   *
   * @return {@code true} if the residential area is new, {@code false} otherwise.
   */
  public boolean getIsNew() {
    return isNew;
  }

  /**
   * Sets the total square meters of the residential area.
   *
   * @param squareMeters The square meters to set.
   */
  public void setSquareMeters(int squareMeters) {
    this.squareMeters = squareMeters;
  }

  /**
   * Sets the number of bathrooms in the residential area.
   *
   * @param numberOfBathrooms The number of bathrooms to set.
   */
  public void setNumberOfBathrooms(int numberOfBathrooms) {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  /**
   * Sets the number of kitchens in the residential area.
   *
   * @param numberOfKitchens The number of kitchens to set.
   */
  public void setNumberOfKitchens(int numberOfKitchens) {
    this.numberOfKitchens = numberOfKitchens;
  }

  /**
   * Sets the number of other plumbing rooms in the residential area.
   *
   * @param numberOfOtherPlumbingRooms The number of other plumbing rooms to set.
   */
  public void setNumberOfOtherPlumbingRooms(int numberOfOtherPlumbingRooms) {
    this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;
  }

  /**
   * Sets the status indicating whether the residential area is new.
   *
   * @param isNew The status to set.
   */
  public void setIsNew(boolean isNew) {
    this.isNew = isNew;
  }

  /**
   * Checks if this residential project is equal to another object.
   *
   * @param obj The object to compare.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Residental other = (Residental) obj;
    return super.equals(other) && squareMeters == other.squareMeters &&
            numberOfKitchens == other.numberOfKitchens &&
            numberOfBathrooms == other.numberOfBathrooms &&
            numberOfOtherPlumbingRooms == other.numberOfOtherPlumbingRooms &&
            isNew == other.isNew;
  }

  /**
   * Returns a string representation of the residential project.
   *
   * @return A string representation of the residential project.
   */
  @Override
  public String toString() {
    return "\nResidental\n" + super.toString() +
            "squareMeters=" + squareMeters +
            " numberOfKitchens=" + numberOfKitchens +
            "\nnumberOfBathrooms=" + numberOfBathrooms +
            " numberOfOtherPlumbingRooms=" + numberOfOtherPlumbingRooms +
            "\nisNew=" + isNew;
  }

  /**
   * Creates a copy of the residential project.
   *
   * @return A copied instance of the residential project.
   */
  public Residental copy() {
    Residental copiedResidental = new Residental(getId(), getTitle(), getExpectedBudget(), getExpectedMonths(),
            getCreationDate(), getEndingDate(), squareMeters, numberOfKitchens,
            numberOfBathrooms, numberOfOtherPlumbingRooms, isNew);

    return copiedResidental;
  }
}
