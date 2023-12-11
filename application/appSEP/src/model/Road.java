package model;

import java.util.ArrayList;

/**
 * The {@code Road} class represents a road construction project, extending the {@code Project} class.
 */
public class Road extends Project {
    private int length;
    private int width;
    private int numberOfBridges;
    private int numberOfTunnels;
    private ArrayList<String> environmentalChallenges;

    /**
     * Constructs a new road construction project with the specified parameters.
     *
     * @param length                  The length of the road.
     * @param width                   The width of the road.
     * @param numberOfBridges         The number of bridges in the road.
     * @param numberOfTunnels         The number of tunnels in the road.
     * @param id                      The project ID.
     * @param title                   The project title.
     * @param expectedBudget          The expected budget for the project.
     * @param expectedMonths          The expected duration of the project in months.
     * @param creationDate            The date when the project was created.
     * @param endingDate              The date when the project is expected to end.
     * @param environmentalChallenges The list of environmental challenges associated with the road.
     */
    public Road(int length, int width, int numberOfBridges, int numberOfTunnels,
                int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate,
                MyDate endingDate, ArrayList<String> environmentalChallenges) {
        super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
        this.environmentalChallenges = environmentalChallenges;
        this.length = length;
        this.width = width;
        this.numberOfBridges = numberOfBridges;
        this.numberOfTunnels = numberOfTunnels;
    }

    /**
     * Gets the length of the road.
     *
     * @return The length of the road.
     */
    public int getLength() {
        return length;
    }

    /**
     * Gets the width of the road.
     *
     * @return The width of the road.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the number of bridges in the road.
     *
     * @return The number of bridges.
     */
    public int getNumberOfBridges() {
        return numberOfBridges;
    }

    /**
     * Gets the number of tunnels in the road.
     *
     * @return The number of tunnels.
     */
    public int getNumberOfTunnels() {
        return numberOfTunnels;
    }

    /**
     * Gets the list of environmental challenges associated with the road.
     *
     * @return The list of environmental challenges.
     */
    public ArrayList<String> getEnvironmentalChallenges() {
        return environmentalChallenges;
    }

    /**
     * Adds a new environmental challenge to the road project.
     *
     * @param newChallenge The new challenge to add.
     */
    public void addEnvironmentalChallenges(String newChallenge) {
        if (!environmentalChallenges.contains(newChallenge)) {
            environmentalChallenges.add(newChallenge);
        }
    }

    /**
     * Removes an environmental challenge from the road project.
     *
     * @param challengeToRemove The challenge to remove.
     */
    public void removeEnvironmentalChallenges(String challengeToRemove) {
        for (int i = 0; i < environmentalChallenges.size(); i++) {
            if (environmentalChallenges.get(i).equals(challengeToRemove)) {
                environmentalChallenges.remove(i);
            }
        }
    }

    /**
     * Sets the length of the road.
     *
     * @param length The length to set.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Sets the width of the road.
     *
     * @param width The width to set.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the number of bridges in the road.
     *
     * @param numberOfBridges The number of bridges to set.
     */
    public void setNumberOfBridges(int numberOfBridges) {
        this.numberOfBridges = numberOfBridges;
    }

    /**
     * Sets the number of tunnels in the road.
     *
     * @param numberOfTunnels The number of tunnels to set.
     */
    public void setNumberOfTunnels(int numberOfTunnels) {
        this.numberOfTunnels = numberOfTunnels;
    }

    /**
     * Checks if this road project is equal to another object.
     *
     * @param obj The object to compare.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Road other = (Road) obj;
        return super.equals(obj) && this.length == other.length && this.width == other.width
                && this.numberOfTunnels == other.numberOfTunnels
                && this.numberOfBridges == other.numberOfBridges && this.environmentalChallenges.equals(
                other.environmentalChallenges);
    }

    /**
     * Returns a string representation of the road project.
     *
     * @return A string representation of the road project.
     */
    @Override
    public String toString() {
        return "\nRoad\n" + super.toString() + "length=" + length + " width=" + width + "\nnumberOfBridges=" + numberOfBridges
                + " numberOfTunnels=" + numberOfTunnels
                + "\nenvironmentalChallenges=" + environmentalChallenges;
    }

    /**
     * Creates a copy of the road project.
     *
     * @return A copied instance of the road project.
     */
    public Road copy() {
        Road copiedRoad = new Road(length, width, numberOfBridges,
                numberOfTunnels, getId(), getTitle(), getExpectedBudget(),
                getExpectedMonths(), getCreationDate(), getEndingDate(), getEnvironmentalChallenges());

        for (String challenge : environmentalChallenges) {
            copiedRoad.addEnvironmentalChallenges(challenge);
        }
        return copiedRoad;
    }
}
