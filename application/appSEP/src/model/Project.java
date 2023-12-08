package model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Residential.class, Commercial.class, Industrial.class, Road.class})
public abstract class Project {

  private int id;

  private String title;

  private int expectedBudget;

  private int spentBudget;

  private int expectedMonths;

  private int spentMonths;

  private boolean isFinished;
  private MyDate creationDate;
  private MyDate endingDate;
  private String creationDateString;

  private String endingDateString;

  public Project(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate, MyDate endingDate){
    this.id = id;
    this.title = title;
    this.expectedBudget = expectedBudget;
    this.spentBudget = 0;
    this.expectedMonths = expectedMonths;
    this.spentMonths = 0;
    this.creationDate = creationDate;
    this.endingDate = endingDate;
    this.isFinished = false;
    creationDateString = creationDate.getDateString();
    endingDateString = endingDate.getDateString();
  }

  public Project(){
    this.id = -1;
    this.title = null;
    this.expectedBudget = -1;
    this.spentBudget = -1;
    this.expectedMonths = -1;
    this.spentMonths = -1;
    this.creationDate = null;
    this.endingDate = null;
    this.isFinished = false;
    creationDateString = null;
    endingDateString = null;

  }
  public int getId() {return id;}
  public String getTitle() {return title;}
  public int getExpectedBudget() {return expectedBudget;}
  public int getSpentBudget() {return spentBudget;}
  public MyDate getCreationDate() {return creationDate;}
  public MyDate getEndingDate() {return endingDate;}
  public int getExpectedMonths() {return expectedMonths;}
  public int getSpentMonths() {return spentMonths;}
  public boolean isFinished() { return isFinished;}
  public void setCreationDate(MyDate creationDate) {
    this.creationDate = creationDate;
    creationDateString = creationDate.getDateString();
  }
  public void setEndingDate(MyDate endingDate) {
    this.endingDate = endingDate;
    endingDateString = endingDate.getDateString();
  }
  public void setExpectedBudget(int expectedBudget) {this.expectedBudget = expectedBudget;}
  public void setExpectedMonths(int expectedMonths) {this.expectedMonths = expectedMonths;}
  public void setFinished(boolean finished) {isFinished = !finished;}
  public void setId(int id) {this.id = id;}
  public void setSpentBudget(int spentBudget) {this.spentBudget = spentBudget;}
  public void setSpentMonths(int spentMonths) {this.spentMonths = spentMonths;}
  public void setTitle(String title) {this.title = title;}
  public int calculateSpentMonths(MyDate creationMyDate, MyDate endingMyDate){
    return MyDate.monthsBetween(creationMyDate, endingMyDate);
  }

  @Override public String toString() {
    return "ID = " + id + " title = " + title + "\n" + "expected budget = " + expectedBudget + " spent budget = " + spentBudget + "\n"
        + "expected months = " + expectedMonths + " spent months = " + spentMonths + "\n" + "creation date = " + creationDateString
        + " ending date = " + endingDateString;
  }

  public String returnProjectType(Project project) {
    if (project instanceof Residential) {
      return "residential";
    }
    else if (project instanceof Commercial) {
      return "commercial";
    }
    else if (project instanceof Industrial) {
      return "industrial";
    }
    else {
      return "road";
    }
  }

  @Override public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Project other = (Project) obj;
    return this.id == other.id && this.isFinished == other.isFinished
        && this.expectedBudget == other.expectedBudget
        && this.spentBudget == other.spentBudget
        && this.spentMonths == other.spentMonths
        && this.expectedMonths == other.expectedMonths && this.title.equals(
        other.title) && this.creationDate.equals(other.creationDate)
        && this.endingDate.equals(other.endingDate);
  }

  public abstract Project copy();

}
