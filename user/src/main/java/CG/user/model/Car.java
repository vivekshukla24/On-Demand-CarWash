package CG.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CarInfo")
public class Car {
    //Car ID should be identical to the ID of the user who added the order
    @Id
    int id;
    String name;
    String status;

    //Default Constructor
    public Car(){

    }

    //Constructor
    public Car(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    //Getters and Setters
    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
