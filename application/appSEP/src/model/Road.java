package model;
import java.util.ArrayList;
public class Road {
    private int length;
    private int width;
    private int numberOfBridges;
    private int numberOfTunnels;
    private ArrayList<String> environmentalChallenges;

    public Road() {
        this.environmentalChallenges = new ArrayList<>();
        this.length=0;
        this.width=0;
        this.numberOfBridges=0;
        this.numberOfTunnels=0;
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
        if(obj== null || getClass()!=obj.getClass()){
            return false;
        }
        Road other= (Road)obj;
        return this.length== other.length
                &&this.width==other.width
                &&this.numberOfTunnels==other.numberOfTunnels
                &&this.numberOfBridges==other.numberOfBridges
                &&this.environmentalChallenges.equals(other.environmentalChallenges);
    }
}
