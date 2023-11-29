package model;

import java.util.Date;

public class Industrial extends Project {
    private int SquareMeters;
    private String UsedFor;

    public Industrial(int id, String title, int expectedBudget, int expectedMonths, java.util.Date creationDate,
                      Date endingDate, int SquareMeters, String UsedFor) {
        super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
        this.SquareMeters = SquareMeters;
        this.UsedFor = UsedFor;
    }

    public int getSquareMeters() {
        return SquareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        SquareMeters = squareMeters;
    }

    public String getUsedFor() {
        return UsedFor;
    }

    public void setUsedFor(String usedFor) {
        UsedFor = usedFor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Industrial other = (Industrial) obj;
        return super.equals(obj) && this.SquareMeters == other.SquareMeters && this.UsedFor.equals(other.UsedFor);
    }

    @Override
    public String toString() {
        return "Industrial{" +
                "SquareMeters=" + SquareMeters +
                ", UsedFor='" + UsedFor + '\'' +
                '}';
    }
}
