package sample;

import java.util.Date;

/**
 * Class for production record.
 *
 * @author Shane Miller
 */
public class ProductionRecord {
    private int ProductionNum;
    private int productID;
    private String serialNumber;
    private Date dateProduced;

    /**
     * method defining values for fields.
     *
     * @param productID
     */
    public ProductionRecord(int productID) {
        ProductionNum = 0;
        serialNumber = "0";
        dateProduced = new Date();
        this.productID = productID;
    }

    /**
     * constructor calling variables to print a log for products.
     *
     * @param productProduced
     * @param itemCount
     */
    public ProductionRecord(Product productProduced, int itemCount) {
        setSerialNum(productProduced.getManufacturer().substring(0, 3) + productProduced.getType().getC() + "0000" + itemCount);
        setProdDate(new Date());
    }

    /**
     * toString returns variables to print to logs.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Prod. Num: " + ProductionNum + " Product ID: " + productID + " Serial Num: "
                + serialNumber + " Date: " + dateProduced;
    }

    /**
     * getType method receives ProductID variable for ProductID.
     *
     * @return
     */
    public int getProductID() {
        return productID;
    }

    /**
     * setProductID method sets ProductID variable for ProductID.
     *
     * @return
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * getSerialNum method receives SerialNum variable for SerialNum.
     *
     * @return
     */
    public String getSerialNum() {
        return serialNumber;
    }

    /**
     * setSerialNum method sets serialNum variable for serialNum.
     *
     * @return
     */
    public void setSerialNum(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * getProdDate method receives prodDate variable for prodDate.
     *
     * @return
     */
    public Date getProdDate() {
        return dateProduced;
    }

    /**
     * setProdDate method sets prodDate variable for prodDate.
     *
     * @return
     */
    public void setProdDate(Date dateProduced) {
        this.dateProduced = dateProduced;
    }

    /**
     * getProductionNum method receives ProductionNum variable for ProductionNum.
     *
     * @return
     */
    public int getProductionNum() {
        return ProductionNum;
    }

    /**
     * setProductionNum method sets ProductionNum variable for ProductionNum.
     *
     * @return
     */
    public void setProductionNum(int productionNum) {
        ProductionNum = productionNum;
    }

    /**
     * constructor setting variables this to variables.
     *
     * @param ProductionNum
     * @param productID
     * @param serialNumber
     * @param dateProduced
     */
    public ProductionRecord(int ProductionNum, int productID, String serialNumber, Date dateProduced) {
        this.ProductionNum = ProductionNum;
        this.productID = productID;
        this.serialNumber = serialNumber;
        this.dateProduced = dateProduced;
    }
}
