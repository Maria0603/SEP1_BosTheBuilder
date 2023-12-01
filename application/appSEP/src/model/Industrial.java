package model;

public class Industrial extends Project {
    private int SquareMeters;
    private String UsedFor;

    public Industrial(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate,
                      MyDate endingDate, int SquareMeters, String UsedFor) {
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
        return "\nIndustrial\n" + super.toString() +
                "SquareMeters = " + SquareMeters +
                " UsedFor = " + UsedFor;
    }

    public Project copy() {
        return new Industrial(this.getId(), this.getTitle(), this.getExpectedBudget(), this.getExpectedMonths(),
            this.getCreationDate(), this.getEndingDate(), this.getSquareMeters(), this.getUsedFor());
    }
}
