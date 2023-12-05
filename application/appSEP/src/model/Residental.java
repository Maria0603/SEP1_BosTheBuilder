package model;

public class Residental extends Project {
  private int squareMeters;
  private int numberOfKitchens;
  private int numberOfBathrooms;
  private int numberOfOtherPlumbingRooms;
  private int numberOfRooms;
  private boolean isNew;

  public Residental(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate,
      MyDate endingDate, int squareMeters, int numberOfKitchens, int numberOfBathrooms,
      int numberOfOtherPlumbingRooms, boolean isNew, int numberOfRooms) {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);

    this.squareMeters = squareMeters;
    this.numberOfKitchens = numberOfKitchens;
    this.numberOfBathrooms = numberOfBathrooms;
    this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;
    this.isNew = isNew;
    this.numberOfRooms = numberOfRooms;
  }

  public int getSquareMeters() {return squareMeters;}
  public int getNumberOfBathrooms() {return numberOfBathrooms;}
  public int getNumberOfKitchens() {return numberOfKitchens;}
  public int getNumberOfOtherPlumbingRooms() {return numberOfOtherPlumbingRooms;}
  public boolean getIsNew(){return isNew;}
  public  int getNumberOfRooms() {return numberOfRooms;}
  public void setSquareMeters(int squareMeters) {this.squareMeters = squareMeters;}
  public void setNumberOfBathrooms(int numberOfBathrooms) {this.numberOfBathrooms = numberOfBathrooms;}
  public void setNumberOfKitchens(int numberOfKitchens) {this.numberOfKitchens = numberOfKitchens;}
  public void setNumberOfOtherPlumbingRooms(int numberOfOtherPlumbingRooms) {this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;}
  public void setIsNew(boolean aNew) {isNew = aNew;}
  public void setNumberOfRooms(int numberOfRooms) {this.numberOfRooms = numberOfRooms;}

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
        "squareMeters=" + squareMeters +
        " numberOfKitchens=" + numberOfKitchens +
        "\nnumberOfBathrooms=" + numberOfBathrooms +
        " numberOfOtherPlumbingRooms=" + numberOfOtherPlumbingRooms +
        "\nisNew=" + isNew;
  }

  public Residental copy() {
    Residental copiedResidental = new Residental(getId(), getTitle(), getExpectedBudget(), getExpectedMonths(),
        getCreationDate(), getEndingDate(), squareMeters, numberOfKitchens,
        numberOfBathrooms, numberOfOtherPlumbingRooms, isNew, numberOfRooms);

    return copiedResidental;
  }
}
