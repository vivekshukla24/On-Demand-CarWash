package CG.user.WrapperModel;

import CG.user.model.WashPacks;

public class OrderReceipt {
    private int orderID;
    private String WasherName;
    private WashPacks washPack;
    private int PayableAmount;
    private String details;
    //Default Constructor
    public OrderReceipt(){

    }

    public OrderReceipt(int orderID, String washerName, WashPacks washPack,  String details, int payableAmount) {
        this.orderID = orderID;
        this.WasherName = washerName;
        this.washPack = washPack;
        this.details=details;
        this.PayableAmount = payableAmount;

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
    public WashPacks getWashPack() {
        return washPack;
    }
    public void setWashPack(WashPacks washPack) {
        this.washPack = washPack;
    }
    public int getPayableAmount() {
        return PayableAmount;
    }
    public void setPayableAmount(int payableAmount) {
        PayableAmount = payableAmount;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "OrderReceipt{" +
                "orderID=" + orderID +
                ", WasherName='" + WasherName + '\'' +
                ", washPack=" + washPack +
                ", PayableAmount=" + PayableAmount +
                '}';
    }
}
