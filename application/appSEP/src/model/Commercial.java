package model;

import java.util.Date;
import java.util.Objects;

public class Commercial extends Project
{
  private int squareMeters;
  private int numberOfFloors;
  private String usedFor;


  public Commercial(int id, String title, int expectedBudget, int expectedMonths, Date creationDate, Date endingDate,
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

  public void setUsedFor(String usedFor)
  {
    this.usedFor = usedFor;
  }
  public boolean equals(Object obj) {

    if (!(obj instanceof Commercial)) {

      return false;
    }
    Commercial other = (Commercial) obj;

    return super.equals(other) && this.squareMeters == other.squareMeters &&
        this.numberOfFloors == other.numberOfFloors &&
        Objects.equals(this.usedFor, other.usedFor);
  }
}
