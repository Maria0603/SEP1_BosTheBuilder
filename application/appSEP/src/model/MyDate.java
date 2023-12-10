package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class MyDate implements Comparable<MyDate> {
  private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private int day;
  private int month;
  private int year;
  private String dateString;

  public MyDate(int day, int month, int year) {
    validateMonth(month);
    validateDay(day, month, year);
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public MyDate(String str){
    String[] parts = str.split("-");
    if (parts.length != 3) {
      throw new IllegalArgumentException("The date format should be DD-MM-YYYY");
    }

    int day = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int year = Integer.parseInt(parts[2]);
    validateMonth(month);
    validateDay(day, month, year);

    this.day = day;
    this.month = month;
    this.year = year;

  }

  public MyDate(){
    year = 0;
    month = 0;
    day = 0;
    dateString = null;
  }

  public String constructDateString(MyDate date){
    return date.year + "-" + date.month + "-" + date.day;
  }

  public void setDateString(int year, int month, int day) {
    dateString = year + "-" + month + "-" + day;
  }

  public String getDateString() {
    return dateString;
  }

  public static MyDate parseStringToDate(String dateString) {
    String[] parts = dateString.split("-");
    if (parts.length != 3) {
      throw new IllegalArgumentException("The date format should be DD-MM-YYYY");
    }

    int day = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int year = Integer.parseInt(parts[2]);

    return new MyDate(day, month, year);
  }

  public MyDate addMonths(int monthsToAdd) {
    LocalDate date = LocalDate.of(year, month, day).plusMonths(monthsToAdd);
    return new MyDate(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
  }
  @Override
  public int compareTo(MyDate other) {
    if (this.year != other.year) {
      return Integer.compare(this.year, other.year);
    } else if (this.month != other.month) {
      return Integer.compare(this.month, other.month);
    } else {
      return Integer.compare(this.day, other.day);
    }
  }

  private void validateMonth(int month) {
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("Month must be between 1 and 12.");
    }
  }

  private void validateDay(int day, int month, int year) {
    int daysInMonth = this.daysInMonth(month, year);
    if (day < 1 || day > daysInMonth) {
      throw new IllegalArgumentException("Day must be between 1 and " + daysInMonth + " for month " + month);
    }
  }

  private int daysInMonth(int month, int year) {
    if (month == 2) {
      return isLeapYear(year) ? 29 : 28;
    }
    return DAYS_IN_MONTH[month];
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

  public static int monthsBetween(MyDate myDate1, MyDate myDate2) {
    if (myDate2.year < myDate1.year ||
        (myDate2.year == myDate1.year && myDate2.month < myDate1.month)) {
      throw new IllegalArgumentException("The end date must not precede the start date.");
    }

    int monthDiff = (myDate2.year - myDate1.year) * 12 + (myDate2.month - myDate1.month);
    if (myDate2.day < myDate1.day) {
      monthDiff--;
    }
    return monthDiff;
  }

  public boolean isInInterval(MyDate fromMyDate, MyDate toMyDate) {
    return this.compareTo(fromMyDate) >= 0 && this.compareTo(toMyDate) <= 0;
  }

  @Override
  public String toString() {
    return String.format("%02d-%02d-%04d", day, month, year);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) return false;

    MyDate other = (MyDate) obj;
    return day == other.day &&
        month == other.month &&
        year == other.year;
  }

  public MyDate copy() {
    return new MyDate(day, month, year);
  }

  public static void main(String[] args) {
    String dateStr = "01-09-2023";
    try {
      MyDate date = parseStringToDate(dateStr);
      System.out.println("Parsed date is: " + date);
      // Assuming MyDate class has a toString() method that formats the date back into a string.
    } catch (Exception e) {
      e.printStackTrace();
    }

    MyDate date1 = new MyDate("1-2-3002");
    System.out.println("New date: " + date1);
  }
}
