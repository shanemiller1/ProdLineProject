package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

    Statement statement;
    @FXML
    protected AnchorPane rootPane;
    @FXML
    protected ImageView logoImage;

    @FXML
    private TextField txtProductName;

    @FXML
    private TextField txtManufacturer;

    @FXML
    private ChoiceBox<ItemType> cmbxItemType;

    @FXML
    private Button btnAp;

    @FXML
    private TableView<Product> tableView;

    @FXML
    private ComboBox<Integer> cmbxChoosequan;

    @FXML
    private TextArea productLogtxtarea;

    @FXML
    private TableColumn<Integer, Product> idCol;

    @FXML
    private TableColumn<String, Product> nameCol;

    @FXML
    private TableColumn<String, Product> manufacturerCol;

    @FXML
    private TableColumn<String, Product> typeCol;

    @FXML
    private ListView<Product> listChooseProducts;

    ArrayList<Product> productLine = new ArrayList<>();

    /**
     * first method to run in the controller class.
     *
     * @author Shane Miller
     */
    @FXML
    private void initialize() {
        cmbxChoosequan.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        cmbxChoosequan.setEditable(true);
        cmbxItemType.getItems().setAll(ItemType.values());
        cmbxChoosequan.getSelectionModel().selectFirst();
        cmbxItemType.getSelectionModel().selectFirst();
        ProductionRecord pr = new ProductionRecord(0, 3, "1", new Date());
        productLogtxtarea.setText(pr.toString());
        listChooseProducts.getItems().addAll(productLine);
        setupProdLineRecord();
    }

    /**
     * method that sets cell factory to necessary information.
     */
    public void setupProdLineRecord() {
        ObservableList<Product> productList = FXCollections.observableArrayList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableView.setItems(productList);
    }

    /**
     * Event handler to add product info when button clicked.
     *
     * @param event
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
        String SQL = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES  ('"
                + itemType.getCode()
                + "','"
                + txtManufacturer.getText()
                + "','"
                + txtProductName.getText()
                + "');";
        Widget addProduct = new Widget(txtProductName.getText(), txtManufacturer.getText(), cmbxItemType.getValue());
        productLine.add(addProduct);
        tableView.getItems().addAll(addProduct);
        listChooseProducts.getItems().add(addProduct);

    }
}
