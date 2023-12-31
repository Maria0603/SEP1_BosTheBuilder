package model;

import javax.xml.bind.annotation.*;
import java.util.Objects;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Residental")
public class Residential extends Project {
  @XmlElement(name = "SquareMeters") private int squareMeters;
  @XmlElement(name = "NumberOfKitchens") private int numberOfKitchens;
  @XmlElement(name = "NumberOfBathrooms") private int numberOfBathrooms;
  @XmlElement(name = "NumberOfPlumbingRooms") private int numberOfOtherPlumbingRooms;
  @XmlElement(name = "IsNew") private int numberOfRooms;
  private boolean isNew;

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

  public Residential() {
    super();
    this.squareMeters = -1;
    this.numberOfKitchens = -1;
    this.numberOfBathrooms = -1;
    this.numberOfOtherPlumbingRooms = -1;
    this.isNew = false;
  }

  public int getSquareMeters() {
    return squareMeters;
  }

  public int getNumberOfBathrooms() {
    return numberOfBathrooms;
  }

  public int getNumberOfKitchens() {
    return numberOfKitchens;
  }

  public int getNumberOfOtherPlumbingRooms() {
    return numberOfOtherPlumbingRooms;
  }

  public boolean getIsNew() {
    return isNew;
  }

  public int getNumberOfRooms() {
    return numberOfRooms;
  }

  public void setSquareMeters(int squareMeters) {
    this.squareMeters = squareMeters;
  }

  public void setNumberOfBathrooms(int numberOfBathrooms) {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  public void setNumberOfKitchens(int numberOfKitchens) {
    this.numberOfKitchens = numberOfKitchens;
  }

  public void setNumberOfOtherPlumbingRooms(int numberOfOtherPlumbingRooms) {
    this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;
  }

  public void setIsNew(boolean aNew) {
    isNew = aNew;
  }

  public void setNumberOfRooms(int numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }

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
        && this.numberOfOtherPlumbingRooms == other.numberOfOtherPlumbingRooms;
  }

  @Override public String toString() {
    return "\nResidential\n" + super.toString() + "\nsquareMeters="
        + squareMeters + " numberOfKitchens=" + numberOfKitchens
        + "\nnumberOfBathrooms=" + numberOfBathrooms
        + " numberOfOtherPlumbingRooms=" + numberOfOtherPlumbingRooms
        + "\nisNew=" + isNew;
  }

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
