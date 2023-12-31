package model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Industrial extends Project {
    @XmlElement(name = "SquareMeters")
    private int SquareMeters;
    @XmlElement(name = "UsedFor")
    private String UsedFor;

    public Industrial(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate,
                      MyDate endingDate, int SquareMeters, String UsedFor) {
        super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
        this.SquareMeters = SquareMeters;
        this.UsedFor = UsedFor;
    }

    public Industrial(){
        super();
        this.SquareMeters = -1;
        this.UsedFor = null;
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
                "\nSquareMeters = " + SquareMeters +
                " UsedFor = " + UsedFor;
    }

    public Project copy() {
        Industrial copy = new Industrial(this.getId(), this.getTitle(), this.getExpectedBudget(), this.getExpectedMonths(),
            this.getCreationDate(), this.getEndingDate(), this.getSquareMeters(), this.getUsedFor());
        copy.setSpentMonths(this.getSpentMonths());
        copy.setSpentBudget(this.getSpentBudget());
        return copy;
    }
}
