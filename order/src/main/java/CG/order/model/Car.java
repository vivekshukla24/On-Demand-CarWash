package CG.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {
    //Car ID should be identical to the ID of the user who added the order
    @Id
    int id;
    String name;
    String model;

    //Default Constructor
    public Car(){

    }

    //Constructor
    public Car(int id, String name, String model) {
        this.id = id;
        this.name = name;
        this.model=model;
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
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
