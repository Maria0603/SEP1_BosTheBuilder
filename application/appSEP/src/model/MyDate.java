package model;
public class MyDate implements Comparable<MyDate> {
  private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private int day;
  private int month;
  private int year;

  public MyDate(int day, int month, int year) {
    validateMonth(month);
    validateDay(day, month, year);
    this.day = day;
    this.month = month;
    this.year = year;
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
    return String.format("%04d-%02d-%02d", year, month, day);
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
}
