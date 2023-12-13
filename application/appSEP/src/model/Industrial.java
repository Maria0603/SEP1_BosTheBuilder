package model;

import javax.xml.bind.annotation.*;

/**
 * Represents an industrial project.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Industrial extends Project {
    @XmlElement(name = "SquareMeters")
    private int SquareMeters;
    @XmlElement(name = "UsedFor")
    private String UsedFor;

    /**
     * Constructs an industrial project with specified attributes.
     *
     * @param id            The ID of the project.
     * @param title         The title of the project.
     * @param expectedBudget      The expected budget for the project.
     * @param expectedMonths The expected duration of the project in months.
     * @param creationDate  The creation date of the project.
     * @param endingDate    The expected ending date of the project.
     * @param SquareMeters  The square meters of the industrial project.
     * @param UsedFor       The purpose or use of the industrial project.
     */
    public Industrial(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate,
                      MyDate endingDate, int SquareMeters, String UsedFor) {
        super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
        this.SquareMeters = SquareMeters;
        this.UsedFor = UsedFor;
    }

    /**
     * Default constructor for an industrial project.
     */
    public Industrial() {
        super();
        this.SquareMeters = -1;
        this.UsedFor = null;
    }

    /**
     * Gets the square meters of the industrial project.
     *
     * @return The square meters of the industrial project.
     */
    public int getSquareMeters() {
        return SquareMeters;
    }

    /**
     * Sets the square meters of the industrial project.
     *
     * @param squareMeters The square meters to be set.
     */
    public void setSquareMeters(int squareMeters) {
        SquareMeters = squareMeters;
    }

    /**
     * Gets the purpose or use of the industrial project.
     *
     * @return The purpose or use of the industrial project.
     */
    public String getUsedFor() {
        return UsedFor;
    }

    /**
     * Sets the purpose or use of the industrial project.
     *
     * @param usedFor The purpose or use to be set.
     */
    public void setUsedFor(String usedFor) {
        UsedFor = usedFor;
    }

    /**
     * Checks if this industrial project is equal to another object.
     *
     * @param obj The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Industrial other = (Industrial) obj;
        return super.equals(obj) && this.SquareMeters == other.SquareMeters && this.UsedFor.equals(other.UsedFor);
    }

    /**
     * Converts the industrial project to a string.
     *
     * @return A string representation of the industrial project.
     */
    @Override
    public String toString() {
        return "\nIndustrial\n" + super.toString() +
                "\nSquareMeters = " + SquareMeters +
                " UsedFor = " + UsedFor;
    }

    /**
     * Creates a copy of the industrial project.
     *
     * @return A new instance of Industrial with the same attributes.
     */
    @Override
    public Project copy() {
        Industrial copy = new Industrial(this.getId(), this.getTitle(), this.getExpectedBudget(), this.getExpectedMonths(),
                this.getCreationDate(), this.getEndingDate(), this.getSquareMeters(), this.getUsedFor());
        copy.setSpentMonths(this.getSpentMonths());
        copy.setSpentBudget(this.getSpentBudget());
        return copy;
    }
}
