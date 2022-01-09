package CG.user.WrapperModel;

import CG.user.model.WashPacks;

public class OrderReceipt {
    private int orderID;
    private String CustomerEmail;
    private String WasherName;
    private String washPackName;
    private String washPackDetails;
    private int washPckPrice;

    //Default Constructor
    public OrderReceipt(){

    }

    //Constructor
    public OrderReceipt(int orderID, String customerEmail, String washerName, String washPackName, String washPackDetails, int washPckPrice) {
        this.orderID = orderID;
        CustomerEmail = customerEmail;
        WasherName = washerName;
        this.washPackName = washPackName;
        this.washPackDetails = washPackDetails;
        this.washPckPrice = washPckPrice;
    }

    //Getter and Setters
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public String getWasherName() {
        return WasherName;
    }
    public void setWasherName(String washerName) {
        WasherName = washerName;
    }
    public String getCustomerEmail() {
        return CustomerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }
    public String getWashPackName() {
        return washPackName;
    }
    public void setWashPackName(String washPackName) {
        this.washPackName = washPackName;
    }
    public String getWashPackDetails() {
        return washPackDetails;
    }
    public void setWashPackDetails(String washPackDetails) {
        this.washPackDetails = washPackDetails;
    }
    public int getWashPckPrice() {
        return washPckPrice;
    }
    public void setWashPckPrice(int washPckPrice) {
        this.washPckPrice = washPckPrice;
    }

    @Override
    public String toString() {
        return "OrderReceipt{" +
                "orderID=" + orderID +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", WasherName='" + WasherName + '\'' +
                ", washPackName='" + washPackName + '\'' +
                ", washPackDetails='" + washPackDetails + '\'' +
                ", washPckPrice=" + washPckPrice +
                '}';
    }
}
