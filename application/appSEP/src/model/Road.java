package model;
import java.util.ArrayList;

public class Road extends Project{
    private int length;
    private int width;
    private int numberOfBridges;
    private int numberOfTunnels;
    private ArrayList<String> environmentalChallenges;

    public Road(int length, int width, int numberOfBridges, int numberOfTunnels, int id, String title, int expectedBudget, int expectedMonths, MyDate creationDate, MyDate endingDate) {
        super( id,  title,  expectedBudget,  expectedMonths,  creationDate,  endingDate);
        this.environmentalChallenges = new ArrayList<>();
        this.length=length;
        this.width=width;
        this.numberOfBridges=numberOfBridges;
        this.numberOfTunnels=numberOfTunnels;
    }

    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
    public int getNumberOfBridges(){
        return numberOfBridges;
    }
    public int getNumberOfTunnels(){
        return numberOfTunnels;
    }
    public void addEnvironmentalChallenges(String newChallenge){
        if (!environmentalChallenges.contains(newChallenge)) {
            environmentalChallenges.add(newChallenge);
        }
    }
    public void removeEnvironmentalChallenges(String challengeToRemove){
        for (int i = 0; i < environmentalChallenges.size(); i++) {
            if (environmentalChallenges.get(i).equals(challengeToRemove)) {
                environmentalChallenges.remove(i);
            }
        }
    }

    public void setLength(int length){
        this.length=length;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public void setNumberOfBridges(int numberOfBridges){
        this.numberOfBridges=numberOfBridges;
    }
    public void setNumberOfTunnels(int numberOfTunnels){
        this.numberOfTunnels=numberOfTunnels;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Road other= (Road)obj;
        return super.equals(obj) && this.length == other.length
                &&this.width == other.width
                &&this.numberOfTunnels == other.numberOfTunnels
                &&this.numberOfBridges == other.numberOfBridges
                &&this.environmentalChallenges.equals(other.environmentalChallenges);
    }

    public String toString() {
        return  "\nRoad\n" + super.toString() +
            "length=" + length +
            " width=" + width +
            "\nnumberOfBridges=" + numberOfBridges +
            " numberOfTunnels=" + numberOfTunnels +
            "\nenvironmentalChallenges=" + environmentalChallenges;
    }

}
