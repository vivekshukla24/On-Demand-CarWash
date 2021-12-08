package CG.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Admindata")
public class AdminDetails {

    @Id
    int id;
    String name;
    String password;

    //Default Constructor
    public AdminDetails(){

    }

    //Constructor
    public AdminDetails(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password=password;
    }

    //Getters and Setters
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}