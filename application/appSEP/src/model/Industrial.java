package model;

/**
 * The {@code Industrial} class represents an industrial project, extending the {@code Project} class.
 * It includes additional properties such as square meters and the purpose for which it is used.
 */
public class Industrial extends Project {

    private int SquareMeters;
    private String UsedFor;

    /**
     * Constructs a new {@code Industrial} object with the specified properties.
     *
     * @param id             The ID of the industrial project.
     * @param title          The title of the industrial project.
     * @param expectedBudget The expected budget for the industrial project.
     * @param expectedMonths The expected duration in months for the industrial project.
     * @param creationDate   The creation date of the industrial project.
     * @param endingDate     The ending date of the industrial project.
     * @param SquareMeters   The square meters of the industrial project.
     * @param UsedFor        The purpose for which the industrial project is used.
     */
    public Industrial(int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate,
                      MyDate endingDate, int SquareMeters, String UsedFor) {
        super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
        this.SquareMeters = SquareMeters;
        this.UsedFor = UsedFor;
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
     * @param squareMeters The square meters to set.
     */
    public void setSquareMeters(int squareMeters) {
        SquareMeters = squareMeters;
    }

    /**
     * Gets the purpose for which the industrial project is used.
     *
     * @return The purpose for which the industrial project is used.
     */
    public String getUsedFor() {
        return UsedFor;
    }

    /**
     * Sets the purpose for which the industrial project is used.
     *
     * @param usedFor The purpose to set.
     */
    public void setUsedFor(String usedFor) {
        UsedFor = usedFor;
    }

    /**
     * Checks if this industrial project is equal to another object.
     *
     * @param obj The object to compare.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
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
     * Returns a string representation of the industrial project.
     *
     * @return A string representation of the industrial project.
     */
    @Override
    public String toString() {
        return "\nIndustrial\n" + super.toString() +
                "SquareMeters = " + SquareMeters +
                " UsedFor = " + UsedFor;
    }

    /**
     * Creates a copy of the industrial project.
     *
     * @return A copy of the industrial project.
     */
    public Project copy() {
        return new Industrial(this.getId(), this.getTitle(), this.getExpectedBudget(), this.getExpectedMonths(),
                this.getCreationDate(), this.getEndingDate(), this.getSquareMeters(), this.getUsedFor());
    }
}
