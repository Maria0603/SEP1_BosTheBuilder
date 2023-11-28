package model;

import java.util.Date;

public class Residental extends Project {
  private int squareMeters;
  private int numberOfKitchens;
  private int numberOfBathrooms;
  private int numberOfOtherPlumbingRooms;
  private boolean isNew;
  public Residental(int id, String title, int expectedBudget, int expectedMonths, Date creationDate,
      Date endingDate, int squareMeters, int numberOfKitchens, int numberOfBathrooms,
      int numberOfOtherPlumbingRooms, boolean isNew) {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);

    this.squareMeters = squareMeters;
    this.numberOfKitchens = numberOfKitchens;
    this.numberOfBathrooms = numberOfBathrooms;
    this.numberOfOtherPlumbingRooms = numberOfOtherPlumbingRooms;
    this.isNew = isNew;
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
}
