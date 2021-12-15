package CG.user.model;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

@Document(collection="userdata")
public class UserDetails {

    @Id
    int id;

    @NotEmpty(message = "Name can't be empty")
    String name;

    @NotEmpty(message = "Location can't be empty")
    String location;

    @NotEmpty(message = "Password can't be empty")
    String password;

    //Getter and Setters
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

    //Default Constructor
    public UserDetails(){

    }
    //Constructor
    public UserDetails(int id, String name, String location,String password) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
