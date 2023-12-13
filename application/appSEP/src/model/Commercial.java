package model;

import javax.xml.bind.annotation.*;
import java.util.Objects;

/**
 * Represents a Commercial project.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Commercial extends Project {

  @XmlElement(name = "SquareMeters")
  private int squareMeters;

  @XmlElement(name = "NumberOfFloors")
  private int numberOfFloors;

  @XmlElement(name = "UsedFor")
  private String usedFor;

  /**
   * Constructs a Commercial project with specified properties.
   *
   * @param id             The project ID.
   * @param title          The project title.
   * @param expectedBudget The expected budget for the project.
   * @param expectedMonths The expected duration of the project in months.
   * @param creationDate   The creation date of the project.
   * @param endingDate     The ending date of the project.
   * @param squareMeters   The square meters of the commercial project.
   * @param numberOfFloors The number of floors in the commercial project.
   * @param usedFor        The purpose or use of the commercial project.
   */
  public Commercial(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate, MyDate endingDate,
                    int squareMeters, int numberOfFloors, String usedFor) {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
    this.squareMeters = squareMeters;
    this.numberOfFloors = numberOfFloors;
    this.usedFor = usedFor;
  }

  /**
   * Default constructor for Commercial project.
   */
  public Commercial() {
    super();
    this.squareMeters = -1;
    this.numberOfFloors = -1;
    this.usedFor = null;
  }

  /**
   * Get the square meters of the commercial project.
   *
   * @return The square meters.
   */
  public int getSquareMeters() {
    return squareMeters;
  }

  /**
   * Get the number of floors in the commercial project.
   *
   * @return The number of floors.
   */
  public int getNumberOfFloors() {
    return numberOfFloors;
  }

  /**
   * Get the purpose or use of the commercial project.
   *
   * @return The purpose or use.
   */
  public String getUsedFor() {
    return usedFor;
  }

  /**
   * Set the square meters of the commercial project.
   *
   * @param squareMeters The square meters to set.
   */
  public void setSquareMeters(int squareMeters) {
    this.squareMeters = squareMeters;
  }

  /**
   * Set the number of floors in the commercial project.
   *
   * @param numberOfFloors The number of floors to set.
   */
  public void setNumberOfFloors(int numberOfFloors) {
    this.numberOfFloors = numberOfFloors;
  }

  /**
   * {@inheritDoc}
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
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "\nCommercial" + "\n" + super.toString() + "\n" +
            "square meters = " + squareMeters + " number of floors = " + numberOfFloors +
            "\n" + "used for = " + usedFor;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Commercial copy() {
    Commercial copy = new Commercial(
            getId(), getTitle(), getExpectedBudget(), getExpectedMonths(), getCreationDate().copy(), getEndingDate().copy(),
            squareMeters, numberOfFloors, usedFor);
    copy.setSpentMonths(this.getSpentMonths());
    copy.setSpentBudget(this.getSpentBudget());
    return copy;
  }
}
