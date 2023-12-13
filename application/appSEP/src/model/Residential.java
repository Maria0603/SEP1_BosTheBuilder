package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlAccessorType(XmlAccessType.FIELD)
// @XmlType(name = "Residental")

/**
 * Represents a residential project.
 */
@XmlRootElement(name = "Residential")
public class Residential extends Project {
  @XmlElement(name = "SquareMeters")
  private int squareMeters;
  @XmlElement(name = "NumberOfKitchens")
  private int numberOfKitchens;
  @XmlElement(name = "NumberOfBathrooms")
  private int numberOfBathrooms;
  @XmlElement(name = "NumberOfPlumbingRooms")
  private int numberOfOtherPlumbingRooms;
  @XmlElement(name = "IsNew")
  private boolean isNew;
  private int numberOfRooms;

  /**
   * Constructs a Residential project with the specified parameters.
   *
   * @param id                        The project ID.
   * @param title                     The project title.
   * @param expectedBudget            The expected budget.
   * @param expectedMonths            The expected duration in months.
   * @param creationDate              The creation date.
   * @param endingDate                The ending date.
   * @param squareMeters              The square meters.
   * @param numberOfKitchens          The number of kitchens.
   * @param numberOfBathrooms         The number of bathrooms.
   * @param numberOfOtherPlumbingRooms The number of other plumbing rooms.
   * @param isNew                     Whether the project is new.
   * @param numberOfRooms             The number of rooms.
   */
  public Residential(int id, String title, int expectedBudget,
                     int expectedMonths, MyDate creationDate, MyDate endingDate,
                     int squareMeters, int numberOfKitchens, int numberOfBathrooms,
                     int numberOfOtherPlumbingRooms, boolean isNew, int numberOfRooms) {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);

    this.squareMeters = squareMeters;
    this.numberOfKitchens = numberOfKitchens;
    this.numberOfBathrooms = numberOfBathrooms;
    this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;
    this.isNew = isNew;
    this.numberOfRooms = numberOfRooms;
  }

  /**
   * Constructs a default Residential project.
   */
  public Residential() {
    super();
    this.squareMeters = -1;
    this.numberOfKitchens = -1;
    this.numberOfBathrooms = -1;
    this.numberOfOtherPlumbingRooms = -1;
    this.isNew = false;
  }

  /**
   * Gets the square meters of the project.
   *
   * @return The square meters.
   */
  public int getSquareMeters() {
    return squareMeters;
  }

  /**
   * Gets the number of kitchens in the project.
   *
   * @return The number of kitchens.
   */
  public int getNumberOfKitchens() {
    return numberOfKitchens;
  }

  /**
   * Gets the number of bathrooms in the project.
   *
   * @return The number of bathrooms.
   */
  public int getNumberOfBathrooms() {
    return numberOfBathrooms;
  }

  /**
   * Gets the number of other plumbing rooms in the project.
   *
   * @return The number of other plumbing rooms.
   */
  public int getNumberOfOtherPlumbingRooms() {
    return numberOfOtherPlumbingRooms;
  }

  /**
   * Checks if the project is new.
   *
   * @return True if the project is new, false otherwise.
   */
  public boolean getIsNew() {
    return isNew;
  }

  /**
   * Gets the number of rooms in the project.
   *
   * @return The number of rooms.
   */
  public int getNumberOfRooms() {
    return numberOfRooms;
  }

  /**
   * Sets the square meters of the project.
   *
   * @param squareMeters The square meters.
   */
  public void setSquareMeters(int squareMeters) {
    this.squareMeters = squareMeters;
  }

  /**
   * Sets the number of bathrooms in the project.
   *
   * @param numberOfBathrooms The number of bathrooms.
   */
  public void setNumberOfBathrooms(int numberOfBathrooms) {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  /**
   * Sets the number of kitchens in the project.
   *
   * @param numberOfKitchens The number of kitchens.
   */
  public void setNumberOfKitchens(int numberOfKitchens) {
    this.numberOfKitchens = numberOfKitchens;
  }

  /**
   * Sets the number of other plumbing rooms in the project.
   *
   * @param numberOfOtherPlumbingRooms The number of other plumbing rooms.
   */
  public void setNumberOfOtherPlumbingRooms(int numberOfOtherPlumbingRooms) {
    this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;
  }

  /**
   * Sets whether the project is new.
   *
   * @param aNew True if the project is new, false otherwise.
   */
  public void setIsNew(boolean aNew) {
    isNew = aNew;
  }

  /**
   * Sets the number of rooms in the project.
   *
   * @param numberOfRooms The number of rooms.
   */
  public void setNumberOfRooms(int numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }

  /**
   * Checks if two Residential projects are equal.
   *
   * @param obj The object to compare with.
   * @return True if the projects are equal, false otherwise.
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Residential)) {
      return false;
    }
    Residential other = (Residential) obj;
    return super.equals(obj) && this.squareMeters == other.squareMeters
            && this.numberOfKitchens == other.numberOfKitchens
            && this.numberOfBathrooms == other.numberOfBathrooms
            && this.numberOfOtherPlumbingRooms == other.numberOfOtherPlumbingRooms
            && this.isNew == other.isNew
            && this.numberOfRooms == other.numberOfRooms;
  }

  /**
   * Returns a string representation of the Residential project.
   *
   * @return A string representation of the Residential project.
   */
  @Override
  public String toString() {
    return "\nResidential\n" + super.toString() + "\nsquareMeters="
            + squareMeters + " numberOfKitchens=" + numberOfKitchens
            + "\nnumberOfBathrooms=" + numberOfBathrooms
            + " numberOfOtherPlumbingRooms=" + numberOfOtherPlumbingRooms
            + "\nisNew=" + isNew;
  }

  /**
   * Creates a copy of the Residential project.
   *
   * @return A copy of the Residential project.
   */
  public Residential copy() {
    Residential copy = new Residential(getId(), getTitle(), getExpectedBudget(),
            getExpectedMonths(), getCreationDate().copy(), getEndingDate().copy(),
            squareMeters, numberOfKitchens, numberOfBathrooms,
            numberOfOtherPlumbingRooms, isNew, numberOfRooms);
    copy.setSpentMonths(this.getSpentMonths());
    copy.setSpentBudget(this.getSpentBudget());

    return copy;
  }
}
