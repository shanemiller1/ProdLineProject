package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {

    private static Statement stnt;

    @FXML
    private TextField txtProductName;

    @FXML
    private TextField txtManufacturer;

    @FXML
    private ChoiceBox<?> cmbxItemType;

    @FXML
    private Button btnAp;

    @FXML
    private TableView<Product> tableView;

    @FXML
    private ComboBox<Integer> cmbxChoosequan;

    @FXML
    private TextArea productLogtxtarea;

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
    }

    @FXML
    public void addProduct(javafx.event.ActionEvent actionEvent) {
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
                + itemType.getCode()
                + "','"
                + txtManufacturer.getText()
                + "','"
                + txtProductName.getText()
                + "');";
        try {
            System.out.println(sql);
            stnt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Widget addProduct = new Widget(txtProductName.getText(), txtManufacturer.getText(), itemType);
        productLine.add(addProduct);
        Main.sqlExecute(sql);
        tableView.getItems().addAll(addProduct);
    }
}
