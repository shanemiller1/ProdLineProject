package sample;

import java.util.Date;

/**
 * Class for production record.
 *
 * @author Shane Miller
 */
public class ProductionRecord {

  private int productionNum;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  /**
   * method defining values for fields.
   *
   * @param productID id for product.
   */
  public ProductionRecord(int productID) {
    this.productionNum = productionNum;
    serialNumber = "0";
    dateProduced = new Date();
    this.productID = productID;
  }

  /**
   * constructor calling variables to print a log for products.
   *
   * @param productProduced products produced.
   * @param itemCount       the item count.
   */
  public ProductionRecord(Product productProduced, int itemCount) {
    setSerialNum(productProduced.getManufacturer().substring(0, 3)
        + productProduced.getType().getCode() + "0000" + itemCount);
    setProdDate(new Date());
  }

  public ProductionRecord(int productionnum, String productID, String serialNumber, String dateProduced) {
  }

  /**
   * toString returns variables to print to logs.
   *
   * @return returns string value.
   */
  @Override
  public String toString() {
    return "\nProd. Num: " + productionNum + " Product ID: " + productID + " Serial Num: "
        + serialNumber + " Date: " + dateProduced;
  }

  /**
   * getType method receives ProductID variable for ProductID.
   *
   * @return returns product id.
   */
  public int getProductID() {
    return productID;
  }

  /**
   * setProductID method sets ProductID variable for ProductID.
   *
   * @param productID the product id.
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * getSerialNum method receives SerialNum variable for SerialNum.
   *
   * @return this the return.
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * setSerialNum method sets serialNum variable for serialNum.
   *
   * @param serialNumber this the serial number.
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * getProdDate method receives prodDate variable for prodDate.
   *
   * @return this the return.
   */
  public Date getProdDate() {
    return dateProduced;
  }

  /**
   * setProdDate method sets prodDate variable for prodDate.
   *
   * @param dateProduced date produced.
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * getProductionNum method receives ProductionNum variable for ProductionNum.
   *
   * @return this the return.
   */
  public int getProductionNum() {
    //Random rand = new Random();
    //int ProductionNum = rand.nextInt(100);
    return productionNum;
  }

  /**
   * setProductionNum method sets ProductionNum variable for ProductionNum.
   *
   * @param productionNum number of production number.
   */
  public void setProductionNum(int productionNum) {
    this.productionNum = productionNum;
  }

  /**
   * constructor setting variables this to variables.
   *
   * @param productionnum the production number.
   * @param productID     id for products.
   * @param serialNumber  serial number for product.
   * @param dateProduced  date the product is produced.
   */
  public ProductionRecord(int productionnum, int productID,
                          String serialNumber, Date dateProduced) {
    this.productionNum = productionnum;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }
}
