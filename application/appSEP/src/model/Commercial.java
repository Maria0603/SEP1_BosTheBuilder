package model;

import java.util.Objects;

public class Commercial extends Project
{
  private int squareMeters;
  private int numberOfFloors;
  private String usedFor;


  public Commercial(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate, MyDate endingDate,
      int squareMeters, int numberOfFloors, String usedFor)
  {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
    this.squareMeters = squareMeters;
    this.numberOfFloors = numberOfFloors;
    this.usedFor = usedFor;
  }

  public int getSquareMeters()
  {
    return squareMeters;
  }

  public int getNumberOfFloors()
  {
    return numberOfFloors;
  }

  public String getUsedFor()
  {
    return usedFor;
  }

  public void setSquareMeters(int squareMeters)
  {
    this.squareMeters = squareMeters;
  }

  public void setNumberOfFloors(int numberOfFloors)
  {
    this.numberOfFloors = numberOfFloors;
  }

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

  @Override
  public String toString() {
    return "Commercial"  + "\n" + super.toString() + "\n" +
        "square meters = " + squareMeters + " number of floors = " + numberOfFloors +
        "\n" + "used fro = " + usedFor;
  }

  public Commercial copy() {
    return new Commercial(
        getId(), getTitle(), getExpectedBudget(), getExpectedMonths(), getCreationDate().copy(), getEndingDate().copy(),
        squareMeters, numberOfFloors, usedFor
    );
  }
}

