package model;

import java.util.Date;

public class Commercial extends Project
{
  private int squareMeters;
  private int numberOfFloors;
  private String usedFor;
  

  public Commercial(int id, String title, int expectedBudget, int spentBudget, int expectedMonths,
      int spentMonths, boolean isFinished, Date creationDate, Date endingDate,
      int squareMeters, int numberOfFloors, String usedFor)
  {
    super(id, title, expectedBudget, spentBudget, expectedMonths, spentMonths, isFinished, creationDate, endingDate);
    this.squareMeters = 0;
    this.numberOfFloors = 0;
    this.usedFor = "";
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

  public void setSquareMeters()
  {
    this.squareMeters = squareMeters;
  }

  public void setNumberOfFloors()
  {
    this.numberOfFloors = numberOfFloors;
  }

  public void setUsedFor()
  {
    this.usedFor = usedFor;
  }
}

