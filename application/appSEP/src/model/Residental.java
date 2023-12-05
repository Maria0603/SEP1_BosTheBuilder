package model;

import javax.xml.bind.annotation.*;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Residental")
public class Residental extends Project {
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

  public Residental(){
    super();
    this.squareMeters = -1;
    this.numberOfKitchens = -1;
    this.numberOfBathrooms = -1;
    this.numberOfOtherPlumbingRooms = -1;
    this.isNew = false;
  }
  public int getSquareMeters() {return squareMeters;}
  public int getNumberOfBathrooms() {return numberOfBathrooms;}
  public int getNumberOfKitchens() {return numberOfKitchens;}
  public int getNumberOfOtherPlumbingRooms() {return numberOfOtherPlumbingRooms;}
  public boolean getIsNew(){return isNew;}
  public void setSquareMeters(int squareMeters) {this.squareMeters = squareMeters;}
  public void setNumberOfBathrooms(int numberOfBathrooms) {this.numberOfBathrooms = numberOfBathrooms;}
  public void setNumberOfKitchens(int numberOfKitchens) {this.numberOfKitchens = numberOfKitchens;}
  public void setNumberOfOtherPlumbingRooms(int numberOfOtherPlumbingRooms) {this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;}
  public void setIsNew(boolean aNew) {isNew = aNew;}

  public boolean equals(Object obj) {
    if(obj == null || getClass() != obj.getClass()){
      return false;
    }
    Residental other = (Residental) obj;
    return super.equals(other) && squareMeters == other.squareMeters &&
        numberOfKitchens == other.numberOfKitchens &&
        numberOfBathrooms == other.numberOfBathrooms &&
        numberOfOtherPlumbingRooms == other.numberOfOtherPlumbingRooms &&
        isNew == other.isNew;
  }

  @Override
  public String toString() {
    return "\nResidental\n" + super.toString() +
        "\nsquareMeters=" + squareMeters +
        " numberOfKitchens=" + numberOfKitchens +
        "\nnumberOfBathrooms=" + numberOfBathrooms +
        " numberOfOtherPlumbingRooms=" + numberOfOtherPlumbingRooms +
        "\nisNew=" + isNew;
  }

  public Residental copy() {
    Residental copiedResidental = new Residental(getId(), getTitle(), getExpectedBudget(), getExpectedMonths(),
        getCreationDate(), getEndingDate(), squareMeters, numberOfKitchens,
        numberOfBathrooms, numberOfOtherPlumbingRooms, isNew);

    return copiedResidental;
  }
}
