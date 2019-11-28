/*Shane Miller
 9/21/19
  "main.java" Sprint 1 basis of GUI for imaginary facility that keeps track of products produced
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class Main extends Application {
    private static Statement stnt;
    Connection connection = null;

    /**
     * starting point of a javafx program.
     *
     * @param primaryStage first thing the user sees.
     * @throws Exception storing exception thrown.
     * @author Shane Miller
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeDB();
        Parent root = FXMLLoader.load(getClass().getResource("ProductionLineDashboard.fxml"));
        primaryStage.setTitle("Production Line");
        primaryStage.setScene(new Scene(root, 960, 540));
        primaryStage.show();
    }

    public static void sqlExecute(String SQLStatement) {
        try {
            stnt.executeUpdate(SQLStatement);
            System.out.println(SQLStatement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * method initializes and connects the program to the database.
     * @return
     */
    public static Connection initializeDB() {
        Connection connection = null;
        try {
            //noticed this is flagged by checkstyle but did not change this because it's a constant.
            final String JDBC_DRIVER = "org.h2.Driver";
            final String DB_URL = "jdbc:h2:./res/HRprodline";
            Properties prop = new Properties();
            prop.load(new FileInputStream("res/properties"));

            //  Database credentials
            final String USER = "";
            final String PASS = prop.getProperty("password");


            try {
                // STEP 1: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 2: Open a connection
                connection = DriverManager.getConnection(DB_URL, USER, PASS); //empty password

                //STEP 3: Execute a query
                stnt = connection.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception eb) {
            eb.printStackTrace();
        }
        return connection;
    }

    /**
     * main method in main containing code for issues..
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);

    }

}

