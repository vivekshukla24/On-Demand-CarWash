package CG.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CarInfo")
public class Car {
    //Car ID should be identical to the ID of the user who added the order
    @Id
    int id;
    String name;


    //Default Constructor
    public Car(){

    }

    //Constructor
    public Car(int id, String name) {
        this.id = id;
        this.name = name;

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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}