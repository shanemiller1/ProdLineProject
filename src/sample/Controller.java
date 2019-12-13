package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


/**
 * Class for Controller.
 *
 * @author Shane Miller
 */

public class Controller {
  @FXML
  private TextArea productLogtxtarea;

  @FXML
  private TextField txtProductName;

  @FXML
  private TextField txtManufacturer;

  @FXML
  private ChoiceBox<ItemType> cmbxItemType;

  @FXML
  private Label firstLbl;

  @FXML
  private Label lastLbl;

  @FXML
  private Button btnAp;

  @FXML
  private Button recordProductionBtn;

  @FXML
  private ComboBox<Integer> cmbxChoosequan;

  @FXML
  private TableColumn<Integer, Product> idCol;

  @FXML
  private TableColumn<String, Product> nameCol;

  @FXML
  private TableColumn<String, Product> manufacturerCol;

  @FXML
  private TableColumn<String, Product> typeCol;

  ObservableList<Product> productList = FXCollections.observableArrayList();

  ArrayList<Product> productLine = new ArrayList<>();

  ArrayList<ProductionRecord> productionRun = new ArrayList<ProductionRecord>();

  public static Connection conn = null;

  @FXML
  private TableView<Product> tableView;

  @FXML
  private ListView<Product> listChooseProducts;

  /**
   * first method to run in the controller class.
   */
  @FXML
  private void initialize() {
    conn = Main.initializeDB();
    cmbxChoosequan.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    cmbxItemType.getItems().setAll(ItemType.values());
    cmbxChoosequan.getSelectionModel().selectFirst();
    cmbxItemType.getSelectionModel().selectFirst();
    setupProdLineRecord();
    loadProductList();
    productLogtxtarea.setEditable(false);
  }

  /**
   * method Create Product objects from the Product database table
   * and add them to the productLine.
   */
  public void loadProductList() {
    if (conn != null) {
      try {
        String sql = "SELECT * FROM PRODUCT";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
          int id = rs.getInt("ID");
          String name = rs.getString("NAME");
          String code = rs.getString("TYPE");
          String manufacturer = rs.getString("MANUFACTURER");

          for (ItemType type : ItemType.values()) {
            if (type.getCode().equals(code)) {
              productLine.add(new Widget(name, manufacturer, type));
            }
          }
        }

        tableView.getItems().clear();
        tableView.getItems().addAll(productLine);


        listChooseProducts.getItems().clear();
        listChooseProducts.getItems().addAll(productLine);

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.out.println(productLine.size());
  }

  /**
   * method that sets cell factory to necessary information.
   */
  public void setupProdLineRecord() {
    idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
    typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
    tableView.setItems(productList);
  }

  /**
   * Event handler to add product info when button clicked.
   *
   * @param event on mouse clicked add product method executes
   */
  @FXML
  void addProduct(MouseEvent event) {
    String name = txtProductName.textProperty().get();
    String manufacturer = txtManufacturer.textProperty().get();
    System.out.println("ProductName is:"
        + name
        + "\n"
        + "manufacturer is:"
        + manufacturer
        + "\n");
    ItemType itemType = (ItemType) cmbxItemType.getValue();
    String sql = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES  ('"
        + txtProductName.getText()
        + "','"
        + itemType.getCode()
        + "','"
        + txtManufacturer.getText()
        + "');";
    Main.sqlExecute(sql);
    Widget addProduct = new Widget(
        txtProductName.getText(), txtManufacturer.getText(), cmbxItemType.getValue());
    productLine.add(addProduct);
    tableView.getItems().addAll(addProduct);
    listChooseProducts.getItems().add(addProduct);
  }

  /**
   * very creative method :).
   *
   * @param event when clicked.
   * @throws ParseException throws exception.
   */
  @FXML
  void recordProduction(MouseEvent event) throws ParseException {
    for (int i = 0; i < Integer.parseInt(String.valueOf(cmbxChoosequan.getValue())); i++) {
      int itemCount = 0;
      productionRun.add(
          new ProductionRecord(
              listChooseProducts.getSelectionModel().getSelectedItem(), itemCount));
      itemCount++;
    }
    productLogtxtarea.setText("Product ID: "
        + productLine.get(listChooseProducts.getSelectionModel().getSelectedIndex()).getName()
        + " " + String.valueOf(productionRun).substring(29, 86));
    addToProductionDB();
  }

  /**
   * very complex method :).
   *
   * @throws ParseException the exception.
   */
  public void addToProductionDB() throws ParseException {
    Random rand = new Random();
    int productionnum = rand.nextInt(1000);
    String productID = productLine.get(
        listChooseProducts.getSelectionModel().getSelectedIndex()).getName();
    String serialNumber = productionRun.toString().substring(29, 50);
    String dateProduced = (String.valueOf(new Date()));
    ProductionRecord prod = new ProductionRecord(
        productionnum, productID, serialNumber, dateProduced);
    String sql = "INSERT INTO PRODUCTIONRECORD(PRODUCTION_NUM, PRODUCT_ID,"
        + " SERIAL_NUM, DATE_PRODUCED, QUANITY) VALUES  ('"
        + productionnum
        + "','"
        + productID
        + "','"
        + serialNumber
        + "','"
        + dateProduced
        + "','"
        + cmbxChoosequan.getValue()
        + "');";
    Main.sqlExecute(sql);
  }
}
