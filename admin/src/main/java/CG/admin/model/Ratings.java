package CG.admin.model;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

@Document(collection="ratings")
public class Ratings {

    @Id
    @NotEmpty(message = "Rating should not be empty")
    int rating;
    @NotEmpty(message = "Name should not be empty")
    String washerName;
    String comment;

    //Constructor
    public Ratings(int rating, String washerName, String comment) {
        this.rating = rating;
        this.washerName = washerName;
        this.comment = comment;
    }

    //Getters and Setters
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getWasherName() {
        return washerName;
    }
    public void setWasherName(String washerName) {
        this.washerName = washerName;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "rating=" + rating +
                ", washerName='" + washerName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

}