package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a custom date class with day, month, and year attributes.
 */
public class MyDate implements Comparable<MyDate> {
  private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private int day;
  private int month;
  private int year;
  private String dateString;

  /**
   * Constructs a MyDate object with specified day, month, and year.
   *
   * @param day   The day.
   * @param month The month.
   * @param year  The year.
   */
  public MyDate(int day, int month, int year) {
    validateMonth(month);
    validateDay(day, month, year);
    this.day = day;
    this.month = month;
    this.year = year;
    this.dateString = this.toString();
  }

  /**
   * Constructs a MyDate object from a date string in the format DD-MM-YYYY.
   *
   * @param str The date string.
   */
  public MyDate(String str) {
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
    this.dateString = str;
  }

  /**
   * Default constructor for a MyDate object.
   */
  public MyDate() {
    year = 0;
    month = 0;
    day = 0;
    dateString = null;
  }

  /**
   * Constructs a date string from the given date.
   *
   * @param date The date to construct the date string from.
   * @return The date string.
   */
  public String constructDateString(MyDate date) {
    return date.year + "-" + date.month + "-" + date.day;
  }

  /**
   * Sets the date string for the MyDate object.
   *
   * @param year  The year.
   * @param month The month.
   * @param day   The day.
   */
  public void setDateString(int year, int month, int day) {
    dateString = year + "-" + month + "-" + day;
  }

  /**
   * Gets the date string of the MyDate object.
   *
   * @return The date string.
   */
  public String getDateString() {
    return dateString;
  }

  /**
   * Parses a date string to a MyDate object.
   *
   * @param dateString The date string.
   * @return A MyDate object.
   */
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

  /**
   * Adds months to the current MyDate object and returns a new MyDate object.
   *
   * @param monthsToAdd The number of months to add.
   * @return A new MyDate object after adding months.
   */
  public MyDate addMonths(int monthsToAdd) {
    LocalDate date = LocalDate.of(year, month, day).plusMonths(monthsToAdd);
    return new MyDate(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
  }

  /**
   * Compares the MyDate object with another MyDate object.
   *
   * @param other The other MyDate object to compare.
   * @return A negative integer, zero, or a positive integer if this object is less than, equal to, or greater
   * than the specified object.
   */
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

  /**
   * Validates the month to be between 1 and 12.
   *
   * @param month The month to validate.
   */
  private void validateMonth(int month) {
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("Month must be between 1 and 12.");
    }
  }

  /**
   * Validates the day based on the given month and year.
   *
   * @param day   The day to validate.
   * @param month The month.
   * @param year  The year.
   */
  private void validateDay(int day, int month, int year) {
    int daysInMonth = this.daysInMonth(month, year);
    if (day < 1 || day > daysInMonth) {
      throw new IllegalArgumentException("Day must be between 1 and " + daysInMonth + " for month " + month);
    }
  }

  /**
   * Gets the number of days in a month for the given month and year.
   *
   * @param month The month.
   * @param year  The year.
   * @return The number of days in the month.
   */
  private int daysInMonth(int month, int year) {
    if (month == 2) {
      return isLeapYear(year) ? 29 : 28;
    }
    return DAYS_IN_MONTH[month];
  }

  /**
   * Checks if the given year is a leap year.
   *
   * @param year The year to check.
   * @return True if the year is a leap year, false otherwise.
   */
  private boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  /**
   * Gets the day of the month.
   *
   * @return The day.
   */
  public int getDay() {
    return day;
  }

  /**
   * Gets the month.
   *
   * @return The month.
   */
  public int getMonth() {
    return month;
  }

  /**
   * Gets the year.
   *
   * @return The year.
   */
  public int getYear() {
    return year;
  }

  /**
   * Gets the number of months between two MyDate objects.
   *
   * @param myDate1 The first MyDate.
   * @param myDate2 The second MyDate.
   * @return The number of months between the two dates.
   */
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

  /**
   * Checks if this MyDate is in the interval between two other MyDate objects.
   *
   * @param fromMyDate The starting MyDate.
   * @param toMyDate   The ending MyDate.
   * @return True if this MyDate is in the interval, false otherwise.
   */
  public boolean isInInterval(MyDate fromMyDate, MyDate toMyDate) {
    return this.compareTo(fromMyDate) >= 0 && this.compareTo(toMyDate) <= 0;
  }

  /**
   * Returns the string representation of the MyDate object.
   *
   * @return The string representation of the MyDate object.
   */
  @Override
  public String toString() {
    return String.format("%02d-%02d-%04d", day, month, year);
  }

  /**
   * Checks if this MyDate object is equal to another object.
   *
   * @param obj The object to compare.
   * @return True if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) return false;

    MyDate other = (MyDate) obj;
    return day == other.day &&
            month == other.month &&
            year == other.year;
  }

  /**
   * Creates a copy of the MyDate object.
   *
   * @return A new instance of MyDate with the same attributes.
   */
  public MyDate copy() {
    return new MyDate(day, month, year);
  }

  /**
   * Main method for testing MyDate class.
   *
   * @param args Command-line arguments.
   */
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
