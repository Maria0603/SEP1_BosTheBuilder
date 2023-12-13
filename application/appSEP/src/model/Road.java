package model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Represents a road project.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Road extends Project {
  @XmlElement(name = "length")
  private int length;
  @XmlElement(name = "width")
  private int width;
  @XmlElement(name = "numberOfBridges")
  private int numberOfBridges;
  @XmlElement(name = "numberOfTunnels")
  private int numberOfTunnels;
  @XmlElementWrapper(name = "EnvironmentalChallenges")
  @XmlElement(name = "Challenge")
  private List<String> environmentalChallenges;

  /**
   * Constructs a Road project with the specified parameters.
   *
   * @param length                  The length of the road.
   * @param width                   The width of the road.
   * @param numberOfBridges         The number of bridges in the road.
   * @param numberOfTunnels         The number of tunnels in the road.
   * @param id                      The project ID.
   * @param title                   The project title.
   * @param expectedBudget          The expected budget.
   * @param expectedMonths          The expected duration in months.
   * @param creationDate            The creation date.
   * @param endingDate              The ending date.
   * @param environmentalChallenges The environmental challenges associated with the road.
   */
  public Road(int length, int width, int numberOfBridges, int numberOfTunnels,
              int id, String title, int expectedBudget, int expectedMonths,
              MyDate creationDate, MyDate endingDate, List<String> environmentalChallenges) {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
    this.environmentalChallenges = environmentalChallenges;
    this.length = length;
    this.width = width;
    this.numberOfBridges = numberOfBridges;
    this.numberOfTunnels = numberOfTunnels;
  }

  /**
   * Constructs a default Road project.
   */
  public Road() {
    super();
    this.environmentalChallenges = null;
    this.length = -1;
    this.width = -1;
    this.numberOfBridges = -1;
    this.numberOfTunnels = -1;
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
   * Gets the environmental challenges associated with the road.
   *
   * @return The list of environmental challenges.
   */
  public List<String> getEnvironmentalChallenges() {
    return environmentalChallenges;
  }

  /**
   * Adds a new environmental challenge to the road.
   *
   * @param newChallenge The new environmental challenge to add.
   */
  public void addEnvironmentalChallenges(String newChallenge) {
    if (!environmentalChallenges.contains(newChallenge)) {
      environmentalChallenges.add(newChallenge);
    }
  }

  /**
   * Removes an environmental challenge from the road.
   *
   * @param challengeToRemove The environmental challenge to remove.
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
   * @param length The length of the road.
   */
  public void setLength(int length) {
    this.length = length;
  }

  /**
   * Sets the width of the road.
   *
   * @param width The width of the road.
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Sets the number of bridges in the road.
   *
   * @param numberOfBridges The number of bridges.
   */
  public void setNumberOfBridges(int numberOfBridges) {
    this.numberOfBridges = numberOfBridges;
  }

  /**
   * Sets the number of tunnels in the road.
   *
   * @param numberOfTunnels The number of tunnels.
   */
  public void setNumberOfTunnels(int numberOfTunnels) {
    this.numberOfTunnels = numberOfTunnels;
  }

  /**
   * Checks if two Road projects are equal.
   *
   * @param obj The object to compare with.
   * @return True if the projects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Road other = (Road) obj;
    return super.equals(obj) && this.length == other.length
            && this.width == other.width
            && this.numberOfTunnels == other.numberOfTunnels
            && this.numberOfBridges == other.numberOfBridges
            && this.environmentalChallenges.equals(other.environmentalChallenges);
  }

  /**
   * Generates a string representation of the Road project.
   *
   * @return The string representation of the Road project.
   */
  @Override
  public String toString() {
    return "\nRoad\n" + super.toString() + "length=" + length + " width="
            + width + "\nnumberOfBridges=" + numberOfBridges + " numberOfTunnels="
            + numberOfTunnels + "\nenvironmentalChallenges="
            + environmentalChallenges;
  }

  /**
   * Creates a copy of the Road project.
   *
   * @return The copied Road project.
   */
  @Override
  public Road copy() {
    Road copiedRoad = new Road(length, width, numberOfBridges, numberOfTunnels,
            getId(), getTitle(), getExpectedBudget(), getExpectedMonths(),
            getCreationDate(), getEndingDate(), getEnvironmentalChallenges());

    for (String challenge : environmentalChallenges) {
      copiedRoad.addEnvironmentalChallenges(challenge);
    }
    copiedRoad.setSpentMonths(this.getSpentMonths());
    copiedRoad.setSpentBudget(this.getSpentBudget());
    return copiedRoad;
  }
}
