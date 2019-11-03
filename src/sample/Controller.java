
package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.xml.transform.Result;

public class Controller {

    public Statement stnt;
    public Statement stmt;
    @FXML
    public Button btnAp;
    @FXML
    public TextField txtProductName;
    @FXML
    public TextField txtManufacturer;
    @FXML
    public ComboBox<String> cmbxChoosequan;
    @FXML
    public ChoiceBox<ItemType> cmbxItemType;
    @FXML
    private TextArea ProductLogtxtarea;
    @FXML
    private TableView<Widget> tableView;
    @FXML
    private TableColumn<Product, Integer> idCol;
    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private TableColumn<Product, String> manufacturerCol;
    @FXML
    private TableColumn<Product, String> typeCol;
    Connection connection = null;

    ArrayList<Widget> productLine = new ArrayList<>();
    ObservableList<Widget> list = FXCollections.observableArrayList(productLine);

    /**
     * first method to run in the controller class.
     *
     * @author Shane Miller
     */
    @FXML
    private void initialize() {
        initializeDB();
        initCol();
        setupProductLineTable();
        cmbxChoosequan.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        cmbxChoosequan.setEditable(true);
        cmbxItemType.getItems().setAll(ItemType.values());
        cmbxChoosequan.getSelectionModel().selectFirst();
        cmbxItemType.getSelectionModel().selectFirst();
        ProductionRecord PR = new ProductionRecord(0, 3, "1", new Date());
        ProductLogtxtarea.setText(PR.toString());
    }

    /**
     * Method On clicking the button it adds a row to the table in the database.
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
     * method initializes and connects the program to the database.
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

    /**
     * method initialized columns and sets each property value to specified names.
     */
    public void initCol() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
    }

    public void setupProductLineTable() {
        list.clear();
        String sql = "SELECT * FROM PRODUCT";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt("Id");
                String NAME = rs.getString("Name");
                String MANUFACTURER = rs.getString("Manufacturer");
                String TYPE = rs.getString("Type");

                list.add(new Widget(ID, NAME, MANUFACTURER, TYPE));
            }
            tableView.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
