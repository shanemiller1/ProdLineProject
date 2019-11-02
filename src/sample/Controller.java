
package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Controller {

  @FXML
  public Button btnAp;
  @FXML
  public TextField txtProductName;
  @FXML
  public TextField txtManufacturer;
  @FXML
  public ComboBox<String> cmbxChoosequan;
  public Statement stnt;
  @FXML
  public ChoiceBox<ItemType> cmbxItemType;
  @FXML
  private TextArea ProductLogtxtarea;


  /**
   * first method to run in the controller class.
   *
   * @author Shane Miller
   */
  @FXML
  private void initialize() {
    initializeDB();
    cmbxChoosequan.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    cmbxChoosequan.setEditable(true);
    cmbxItemType.getItems().setAll(ItemType.values());
    cmbxChoosequan.getSelectionModel().selectFirst();
    cmbxItemType.getSelectionModel().selectFirst();;
    ProductionRecord PR = new ProductionRecord(0, 3, "1", new Date());
    ProductLogtxtarea.setText(PR.toString());
  }

  /**
   * On clicking the button it adds a row to the table in the database.
   *
   * @param actionEvent stores user input from mouse event.
   */
  @FXML
  public void message(javafx.event.ActionEvent actionEvent) {
    String name = txtProductName.textProperty().get();
    String manufacturer = txtManufacturer.textProperty().get();
    System.out.println("ProductName is:" + name + "\n" + "manufacturer is:" + manufacturer + "\n");
    ItemType itemType = cmbxItemType.getValue();
    String sql = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES  ('"
        + itemType.getC()
        + "','"
        + txtManufacturer.getText()
        + "','"
        + txtProductName.getText()
        + "');";
    try {
      System.out.println(sql);
      stnt.executeUpdate(sql); //can be fixed with a prepared statement
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * initializes and connects the program to the database.
   */
  private void initializeDB() {
    //noticed this is flagged by checkstyle but did not change this because it's a constant.
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/HRprodline";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    //Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS); //empty password

      //STEP 3: Execute a query
      stnt = conn.createStatement();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
