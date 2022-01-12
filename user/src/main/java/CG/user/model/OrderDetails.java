package CG.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collection="orders")
public class OrderDetails {

    @Id
    String orderId;
    @NotEmpty(message = "Email Can't be empty")
    String useremailid;
    @NotEmpty(message = "Washer Name Can't be empty")
    String washerName;
    @NotEmpty(message = "Wash pack can't be empty")
    String washpack;
    @NotEmpty(message = "Date can't be empty")
    long phoneNo;
    @NotEmpty(message = "Pincode can't be empty")
    String areapincode;
    @NotEmpty(message = "status can't be empty")
    String status;
    @NotEmpty(message = "car field can't be empty")
    Car cars;

    //Default Constructor
    public OrderDetails(){
    }

    //Constructor
    public OrderDetails(String orderId, String useremailid, String washerName, String washpack, long phoneNo, String areapincode, String status, Car cars) {
        this.orderId = orderId;
        this.useremailid = useremailid;
        this.washerName = washerName;
        this.washpack = washpack;
        this.phoneNo = phoneNo;
        this.areapincode = areapincode;
        this.status = status;
        this.cars = cars;
    }

    //Getters and Setters
    public String getUseremailid() {
        return useremailid;
    }
    public void setUseremailid(String useremailid) {
        this.useremailid = useremailid;
    }
    public String getAreapincode() {
        return areapincode;
    }
    public void setAreapincode(String areapincode) {
        this.areapincode = areapincode;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getWasherName() {
        return washerName;
    }
    public void setWasherName(String washerName) {
        this.washerName = washerName;
    }
    public String getWashpack() {
        return washpack;
    }
    public void setWashpack(String washpack) {
        this.washpack = washpack;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Car getCars() {
        return cars;
    }
    public void setCars(Car cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId='" + orderId + '\'' +
                ", useremailid='" + useremailid + '\'' +
                ", washerName='" + washerName + '\'' +
                ", washpack=" + washpack +
                ", phoneNo=" + phoneNo +
                ", areapincode='" + areapincode + '\'' +
                ", status='" + status + '\'' +
                ", cars=" + cars +
                '}';
    }
}
