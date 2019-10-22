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

import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {

  /**
   * starting point of a javafx program.
   *
   * @param primaryStage first thing the user sees.
   * @throws Exception storing exception thrown.
   * @author Shane Miller
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProductionLineDashboard.fxml"));
    primaryStage.setTitle("GUIProgramAlpha");
    primaryStage.setScene(new Scene(root, 960, 540));
    primaryStage.show();
  }


  public static void main(String[] args) {
      /**
       * Issue1
       */
    Product product1 = new Widget("iPod", "Apple", "AM");
    System.out.println(product1.toString());
    Product product2 = new Widget("Zune", "Microsoft", "AM");
    System.out.println(product2.toString());

      /**
       * Issue2
       */
    AudioPlayer newProduct = new AudioPlayer("DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    System.out.println(newProduct);
    newProduct.play();
    newProduct.stop();
    newProduct.next();
    newProduct.previous();

      /**
       * Issue3a
       */
    Screen s1 = new Screen("600x400", 40, 22);
    System.out.println(s1);

      /**
       * Issue3b
       */
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
            "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
            MonitorType.LCD);
    ArrayList<MultimediaController> productList = new ArrayList<MultimediaController>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaController p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }

      /**
       * Issue4
       */
      // test constructor used when creating production records from user interface
      Integer numProduced = 3;  // this will come from the combobox in the UI

      for (int productionRunProduct = 0; productionRunProduct < numProduced; productionRunProduct++) {
          ProductionRecord pr = new ProductionRecord(0);
          System.out.println(pr.toString());
      }

      // test constructor used when creating production records from reading database
      ProductionRecord pr = new ProductionRecord(0, 3, "1", new Date());
      System.out.println(pr.toString());

      // testing accessors and mutators
      pr.setProductionNum(1);
      System.out.println(pr.getProductionNum());

      pr.setProductID(4);
      System.out.println(pr.getProductID());

      pr.setSerialNum("2");
      System.out.println(pr.getSerialNum());

      pr.setProdDate(new Date());
      System.out.println(pr.getProdDate());

      launch(args);
  }
}
