package model;

import java.util.Objects;

/**
 * The {@code Commercial} class represents a commercial project, extending the {@code Project} class.
 * It includes additional properties such as square meters, number of floors, and the purpose for which it is used.
 */
public class Commercial extends Project {

  private int squareMeters;
  private int numberOfFloors;
  private String usedFor;

  /**
   * Constructs a new {@code Commercial} object with the specified properties.
   *
   * @param id             The ID of the commercial project.
   * @param title          The title of the commercial project.
   * @param expectedBudget The expected budget for the commercial project.
   * @param expectedMonths The expected duration in months for the commercial project.
   * @param creationDate   The creation date of the commercial project.
   * @param endingDate     The ending date of the commercial project.
   * @param squareMeters   The square meters of the commercial project.
   * @param numberOfFloors The number of floors in the commercial project.
   * @param usedFor        The purpose for which the commercial project is used.
   */
  public Commercial(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate, MyDate endingDate,
                    int squareMeters, int numberOfFloors, String usedFor) {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
    this.squareMeters = squareMeters;
    this.numberOfFloors = numberOfFloors;
    this.usedFor = usedFor;
  }

  /**
   * Gets the square meters of the commercial project.
   *
   * @return The square meters of the commercial project.
   */
  public int getSquareMeters() {
    return squareMeters;
  }

  /**
   * Gets the number of floors in the commercial project.
   *
   * @return The number of floors in the commercial project.
   */
  public int getNumberOfFloors() {
    return numberOfFloors;
  }

  /**
   * Gets the purpose for which the commercial project is used.
   *
   * @return The purpose for which the commercial project is used.
   */
  public String getUsedFor() {
    return usedFor;
  }

  /**
   * Sets the square meters of the commercial project.
   *
   * @param squareMeters The square meters to set.
   */
  public void setSquareMeters(int squareMeters) {
    this.squareMeters = squareMeters;
  }

  /**
   * Sets the number of floors in the commercial project.
   *
   * @param numberOfFloors The number of floors to set.
   */
  public void setNumberOfFloors(int numberOfFloors) {
    this.numberOfFloors = numberOfFloors;
  }

  /**
   * Checks if this commercial project is equal to another object.
   *
   * @param obj The object to compare.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Commercial)) {
      return false;
    }
    Commercial other = (Commercial) obj;
    return super.equals(obj) &&
            this.squareMeters == other.squareMeters &&
            this.numberOfFloors == other.numberOfFloors &&
            Objects.equals(this.usedFor, other.usedFor);
  }

  /**
   * Returns a string representation of the commercial project.
   *
   * @return A string representation of the commercial project.
   */
  @Override
  public String toString() {
    return "Commercial" + "\n" + super.toString() + "\n" +
            "square meters = " + squareMeters + " number of floors = " + numberOfFloors +
            "\n" + "used for = " + usedFor;
  }

  /**
   * Creates a copy of the commercial project.
   *
   * @return A copy of the commercial project.
   */
  public Commercial copy() {
    return new Commercial(
            getId(), getTitle(), getExpectedBudget(), getExpectedMonths(), getCreationDate().copy(), getEndingDate().copy(),
            squareMeters, numberOfFloors, usedFor
    );
  }
}
