package model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD) public class Road extends Project {
  @XmlElement(name = "length") private int length;
  @XmlElement(name = "width") private int width;
  @XmlElement(name = "numberOfBridges") private int numberOfBridges;
  @XmlElement(name = "numberOfTunnels") private int numberOfTunnels;
  @XmlElementWrapper(name = "EnvironmentalChallenges") @XmlElement(name = "Challenge") private List<String> environmentalChallenges;

  public Road(int length, int width, int numberOfBridges, int numberOfTunnels,
      int id, String title, int expectedBudget, int expectedMonths,
      MyDate creationDate, MyDate endingDate, List<String> challenges) {
    super(id, title, expectedBudget, expectedMonths, creationDate, endingDate);
    this.environmentalChallenges = challenges;
    this.length = length;
    this.width = width;
    this.numberOfBridges = numberOfBridges;
    this.numberOfTunnels = numberOfTunnels;
  }

  public Road() {
    super();
    this.environmentalChallenges = null;
    this.length = -1;
    this.width = -1;
    this.numberOfBridges = -1;
    this.numberOfTunnels = -1;
  }

  public int getLength() {
    return length;
  }

  public int getWidth() {
    return width;
  }

  public int getNumberOfBridges() {
    return numberOfBridges;
  }

  public int getNumberOfTunnels() {
    return numberOfTunnels;
  }

  public List<String> getEnvironmentalChallenges() {
    return environmentalChallenges;
  }

  public void addEnvironmentalChallenges(String newChallenge) {
    if (!environmentalChallenges.contains(newChallenge)) {
      environmentalChallenges.add(newChallenge);
    }
  }

  public void removeEnvironmentalChallenges(String challengeToRemove) {
    for (int i = 0; i < environmentalChallenges.size(); i++) {
      if (environmentalChallenges.get(i).equals(challengeToRemove)) {
        environmentalChallenges.remove(i);
      }
    }
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setNumberOfBridges(int numberOfBridges) {
    this.numberOfBridges = numberOfBridges;
  }

  public void setNumberOfTunnels(int numberOfTunnels) {
    this.numberOfTunnels = numberOfTunnels;
  }

  @Override public boolean equals(Object obj) {
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

  public String toString() {
    return "\nRoad\n" + super.toString() + "length=" + length + " width="
        + width + "\nnumberOfBridges=" + numberOfBridges + " numberOfTunnels="
        + numberOfTunnels + "\nenvironmentalChallenges="
        + environmentalChallenges;
  }

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


