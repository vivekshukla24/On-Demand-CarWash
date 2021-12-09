package CG.order.model;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="orders")
public class OrderDetails {

    @Id
    @NotEmpty(message = "OrderId can't be empty")
    int orderId;
    @NotEmpty(message = "Car name can't be empty")
    String carName;
    @NotEmpty(message = "Washer Name Can't be empty")
    String washerName;
    @NotEmpty(message = "Wash pack can't be empty")
    int washpackId;
    @NotEmpty(message = "Date can't be empty")
    int phoneNo;
    @NotEmpty(message = "status can't be empty")
    String status;
    @NotEmpty(message = "car field can't be empty")
    List<Car> cars;

    //Default Constructor
    public OrderDetails(){

    }

    public OrderDetails(int orderId, String carName, String washerName, int washpackId, int phoneNo, String status, List<Car> cars) {
        this.orderId = orderId;
        this.carName = carName;
        this.washerName = washerName;
        this.washpackId = washpackId;
        this.phoneNo = phoneNo;
        this.status = status;
        this.cars = cars;
    }

    //Getters and Setters
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getWasherName() {
        return washerName;
    }
    public void setWasherName(String washerName) {
        this.washerName = washerName;
    }
    public int getWashpackId() {
        return washpackId;
    }
    public void setWashpackId(int washpackId) {
        this.washpackId = washpackId;
    }
    public int getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId=" + orderId +
                ", carName='" + carName + '\'' +
                ", washerName='" + washerName + '\'' +
                ", washpackId=" + washpackId +
                ", phoneNo=" + phoneNo +
                ", status='" + status + '\'' +
                ", cars=" + cars +
                '}';
    }
}
