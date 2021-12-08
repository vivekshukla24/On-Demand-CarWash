package CG.order.model;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    int date;
    @NotEmpty(message = "Phone number can't be empty")
    int phoneNo;
    @NotEmpty(message = "status can't be empty")
    String status;

    //Default Constructor
    public OrderDetails(){

    }

    //Constructor
    public OrderDetails(int orderId, String carName, String washerName, int washpackId, int date, int phoneNo, String status) {
        this.orderId = orderId;
        this.carName = carName;
        this.washerName = washerName;
        this.washpackId = washpackId;
        this.date = date;
        this.phoneNo = phoneNo;
        this.status=status;
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
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId=" + orderId +
                ", carName='" + carName + '\'' +
                ", washerName='" + washerName + '\'' +
                ", washpackId=" + washpackId +
                ", date=" + date +
                ", phoneNo=" + phoneNo +
                '}';
    }

}