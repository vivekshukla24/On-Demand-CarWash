package CG.admin.WrapperModel;

import CG.admin.model.Ratings;
import java.util.List;

//This is a wrapper class to get ratings of specific washer
public class WasherRatings {
    private String WasherID;
    private String WasherName;
    private String WasherEmailID;
    private List<Ratings> Ratings;

    //Default Constructor
    public WasherRatings(){

    }

    //Constructor
    public WasherRatings(String washerID, String washerName, String washerEmailID, List<CG.admin.model.Ratings> ratings) {
        WasherID = washerID;
        WasherName = washerName;
        WasherEmailID = washerEmailID;
        Ratings = ratings;
    }

    //Getter and Setters
    public String getWasherID() {
        return WasherID;
    }
    public void setWasherID(String washerID) {
        WasherID = washerID;
    }
    public String getWasherName() {
        return WasherName;
    }
    public void setWasherName(String washerName) {
        WasherName = washerName;
    }
    public String getWasherEmailID() {
        return WasherEmailID;
    }
    public void setWasherEmailID(String washerEmailID) {
        WasherEmailID = washerEmailID;
    }
    public List<Ratings> getRatings() {
        return Ratings;
    }
    public void setRatings(List<Ratings> ratings) {
        Ratings = ratings;
    }

    @Override
    public String toString() {
        return "WasherRatings{" +
                "WasherID='" + WasherID + '\'' +
                ", WasherName='" + WasherName + '\'' +
                ", WasherEmailID='" + WasherEmailID + '\'' +
                ", Ratings=" + Ratings +
                '}';
    }
}
