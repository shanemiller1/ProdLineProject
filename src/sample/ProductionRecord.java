package sample;

import java.util.Date;

public class ProductionRecord {
    private int ProductionNum;
    private int productID;
    private String serialNumber;
    private Date dateProduced;

    public ProductionRecord(int productID) {
        ProductionNum = 0;
        serialNumber = "0";
        dateProduced = new Date();
        this.productID = productID;
    }

    @Override
    public String toString(){
        return "Prod. Num: " + ProductionNum + " Product ID: " + productID + " Serial Num: "
                + serialNumber + " Date: " + dateProduced;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSerialNum() {
        return serialNumber;
    }

    public void setSerialNum(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getProdDate() {
        return dateProduced;
    }

    public void setProdDate(Date dateProduced) {
        this.dateProduced = dateProduced;
    }

    public int getProductionNum() {
        return ProductionNum;
    }

    public void setProductionNum(int productionNum) {
        ProductionNum = productionNum;
    }

    public ProductionRecord(int ProductionNum, int productID, String serialNumber, Date dateProduced) {
        this.ProductionNum = ProductionNum;
        this.productID = productID;
        this.serialNumber = serialNumber;
        this.dateProduced = dateProduced;
    }
}
