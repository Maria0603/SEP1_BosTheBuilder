package model;

import java.util.Date;

public abstract class Project {
  private int id;
  private String title;
  private int expectedBudget;
  private int spentBudget;
  private int expectedMonths;
  private int spentMonths;
  private boolean isFinished;
  private Date creationDate;
  private Date endingDate;

  public Project(int id, String title, int expectedBudget, int expectedMonths, Date creationDate, Date endingDate){
    this.id = id;
    this.title = title;
    this.expectedBudget = expectedBudget;
    this.spentBudget = 0;
    this.expectedMonths = expectedMonths;
    this.spentMonths = 0;
    this.creationDate = creationDate;
    this.endingDate = endingDate;
    this.isFinished = false;
  }

  public int getId() {return id;}
  public String getTitle() {return title;}
  public int getExpectedBudget() {return expectedBudget;}
  public int getSpentBudget() {return spentBudget;}
  public Date getCreationDate() {return creationDate;}
  public Date getEndingDate() {return endingDate;}
  public int getExpectedMonths() {return expectedMonths;}
  public int getSpentMonths() {return spentMonths;}
  public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}
  public void setEndingDate(Date endingDate) {this.endingDate = endingDate;}
  public void setExpectedBudget(int expectedBudget) {this.expectedBudget = expectedBudget;}
  public void setExpectedMonths(int expectedMonths) {this.expectedMonths = expectedMonths;}
  public void setFinished(boolean finished) {isFinished = finished;}
  public void setId(int id) {this.id = id;}
  public void setSpentBudget(int spentBudget) {this.spentBudget = spentBudget;}
  public void setSpentMonths(int spentMonths) {this.spentMonths = spentMonths;}
  public void setTitle(String title) {this.title = title;}
  public int calculateSpentMonths(model.Date creationDate, model.Date endingDate){
    return model.Date.monthsBetween(creationDate, endingDate);
  }
}
