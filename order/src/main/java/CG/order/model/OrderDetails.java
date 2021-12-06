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

    @NotEmpty(message = "Car model can't be empty")
    String carModel;

    @NotEmpty(message = "Washer Name Can't be empty")
    String washerName;

    @NotEmpty(message = "Wash pack can't be empty")
    int washpackId;

    @NotEmpty(message = "Date can't be empty")
    int date;

    @NotEmpty(message = "Phone number can't be empty")
    int phoneNo;

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
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
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
    @Override
    public String toString() {
        return "OrderDetails [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", washerName="
                + washerName + ", washpackId=" + washpackId + ", date=" + date + ", phoneNo=" + phoneNo + "]";
    }
}
