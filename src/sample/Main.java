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

public class Main extends Application {

  /**
   * starting point of a javafx program.
   *
   * @param primaryStage first thing the user sees.
   * @throws Exception storing exception thrown.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProductionLineDashboard.fxml"));
    primaryStage.setTitle("GUIProgramAlpha");
    primaryStage.setScene(new Scene(root, 960, 540));
    primaryStage.show();
  }


  public static void main(String[] args) {
    //issue 1
    Product product1 = new Widget("iPod", "Apple", "AM");
    System.out.println(product1.toString());
    Product product2 = new Widget("Zune", "Microsoft", "AM");
    System.out.println(product2.toString());

    //issue2
    AudioPlayer newProduct = new AudioPlayer("DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    System.out.println(newProduct);
    newProduct.play();
    newProduct.stop();
    newProduct.next();
    newProduct.previous();

    launch(args);
  }
}
