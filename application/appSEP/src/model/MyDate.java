package model;

/**
 * The {@code MyDate} class represents a date with day, month, and year information.
 * It implements the Comparable interface for date comparison.
 */
public class MyDate implements Comparable<MyDate> {
  private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private int day;
  private int month;
  private int year;

  /**
   * Constructs a new {@code MyDate} object with the specified day, month, and year.
   *
   * @param day   The day of the date.
   * @param month The month of the date.
   * @param year  The year of the date.
   */
  public MyDate(int day, int month, int year) {
    validateMonth(month);
    validateDay(day, month, year);
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Compares this date with another date.
   *
   * @param other The date to compare.
   * @return A negative integer, zero, or a positive integer as this date is before, equal to, or after the specified date.
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

  /**
   * Gets the day of the date.
   *
   * @return The day of the date.
   */
  public int getDay() {
    return day;
  }

  /**
   * Gets the month of the date.
   *
   * @return The month of the date.
   */
  public int getMonth() {
    return month;
  }

  /**
   * Gets the year of the date.
   *
   * @return The year of the date.
   */
  public int getYear() {
    return year;
  }

  /**
   * Calculates the number of months between two dates.
   *
   * @param myDate1 The start date.
   * @param myDate2 The end date.
   * @return The number of months between the two dates.
   * @throws IllegalArgumentException If the end date precedes the start date.
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
   * Checks if this date is within the specified date interval.
   *
   * @param fromMyDate The start date of the interval.
   * @param toMyDate   The end date of the interval.
   * @return {@code true} if this date is within the specified interval, {@code false} otherwise.
   */
  public boolean isInInterval(MyDate fromMyDate, MyDate toMyDate) {
    return this.compareTo(fromMyDate) >= 0 && this.compareTo(toMyDate) <= 0;
  }

  /**
   * Returns a string representation of the date in the format "yyyy-MM-dd".
   *
   * @return A string representation of the date.
   */
  @Override
  public String toString() {
    return String.format("%04d-%02d-%02d", year, month, day);
  }

  /**
   * Checks if this date is equal to another object.
   *
   * @param obj The object to compare.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
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
   * Creates a copy of the date.
   *
   * @return A copy of the date.
   */
  public MyDate copy() {
    return new MyDate(day, month, year);
  }
}
