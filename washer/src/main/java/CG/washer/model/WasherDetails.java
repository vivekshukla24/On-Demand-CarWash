package CG.washer.model;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

@Document(collection="washerdetails")
public class WasherDetails {

    @Id
    int id;

    @NotEmpty(message = "Name must not be empty")
    String name;

    @NotEmpty(message = "Location must not be empty")
    String location;

    @NotEmpty(message = "password must not be empty")
    String password;

    //Getter and Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //Constructor
    public WasherDetails(int id,String name, String location,String password) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.password = password;
    }

    @Override
    public String toString() {
        return "WasherDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
