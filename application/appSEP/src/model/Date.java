package model;
public class Date{

  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year) {
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("The month has to be between 1 and 12.");
    }

    if (day < 1 || day > daysInMonth(month, year)) {
      throw new IllegalArgumentException("The day is not valid for this specific month.");
    }

    this.day = day;
    this.month = month;
    this.year = year;
  }
  private int daysInMonth(int month, int year) {
    switch (month) {
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      case 2:
        return isLeapYear(year) ? 29 : 28;
      default:
        return 31;
    }
  }

  private boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }


  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public static int monthsBetween(Date date1, Date date2){

    if (date2.getYear() < date1.getYear() || (date2.getYear() == date1.getYear() && date2.getMonth() < date1.getMonth())) {
      throw new IllegalArgumentException("The second date must be after or equal to the first date.");
    }

    int monthsBetween = (date2.getYear() - date1.getYear()) * 12 + date2.getMonth() - date1.getMonth();

    if (date2.getDay() < date1.getDay()) {
      monthsBetween--;  // Subtract 1 month il date2's day is before date1's one.
    }

    return monthsBetween;
  }

  public boolean isInInterval(Date fromDate, Date toDate){
    // Verify the year
    if (this.getYear() >= fromDate.getYear() && this.getYear() <= toDate.getYear()) {
      // Verify the month
      if (this.getYear() == fromDate.getYear() && this.getMonth() < fromDate.getMonth()) {
        return false; // same year but lower month
      }
      if (this.getYear() == toDate.getYear() && this.getMonth() > toDate.getMonth()) {
        return false; // same year but higher month
      }

      // Verify the day
      if (this.getYear() == fromDate.getYear() && this.getMonth() == fromDate.getMonth() && this.getDay() < fromDate.getDay()) {
        return false; // Year and month are the same but the day is lower
      }
      if (this.getYear() == toDate.getYear() && this.getMonth() == toDate.getMonth() && this.getDay() > toDate.getDay()) {
        return false; // Year and month are the same but the day is higher
      }

      return true; // The date is in the interval
    }

    return false; // The year is outside the interval
  }

}