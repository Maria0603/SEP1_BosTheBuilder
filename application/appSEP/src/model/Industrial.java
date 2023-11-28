package model;

public class Industrial {
    private int SquareMeters;
    private String UsedFor;
    public Industrial(int SquareMeters, String UsedFor){
        this.SquareMeters=SquareMeters;
        this.UsedFor=UsedFor;
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

}
