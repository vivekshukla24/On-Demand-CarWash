package CG.admin.WrapperModel;

import CG.admin.model.Ratings;
import CG.admin.model.WasherDetails;
import java.util.List;

//This is a wrapper class to get ratings of specific washer
public class WasherRatings {
    private WasherDetails washerName;
    private List<Ratings> ratingsList;

    //Default Constructor
    public WasherRatings(){

    }

    //Constructor
    public WasherRatings(WasherDetails washerName, List<Ratings> ratingsList) {
        this.washerName = washerName;
        this.ratingsList = ratingsList;
    }

    //Getter and Setters
    public WasherDetails getWasherName() {
        return washerName;
    }
    public void setWasherName(WasherDetails washerName) {
        this.washerName = washerName;
    }
    public List<Ratings> getRatingsList() {
        return ratingsList;
    }
    public void setRatingsList(List<Ratings> ratingsList) {
        this.ratingsList = ratingsList;
    }

    @Override
    public String toString() {
        return "WasherRatings{" +
                "washerName=" + washerName +
                ", ratingsList=" + ratingsList +
                '}';
    }
}
