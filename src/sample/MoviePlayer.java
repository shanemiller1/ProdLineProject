package sample;

/**
 * class movie player extending product and implements controller for multimedia.
 *
 * @author Shane Miller
 */
public class MoviePlayer extends Product implements MultimediaController {

  private Screen screen;
  private MonitorType monitorType;

  /**
   * constructor passing super class for name and manufacturer.
   *
   * @param name         name.
   * @param manufacturer name of manufacturer.
   * @param screen       type of screen.
   * @param monitorType  type of monitor.
   */
  MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * to string returning super class to print information.
   *
   * @return ret the super to string.
   */
  @Override
  public String toString() {
    return super.toString() + "\nScreen:" + screen + "\nMonitor Type: " + monitorType;
  }

  /**
   * setScreen method receives Screen variable for Screen.
   *
   * @return ret the screen.
   */
  public Screen getScreen() {
    return screen;
  }

  /**
   * setScreen method sets Screen variable for Screen.
   *
   * @param screen screen ?.
   */
  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  /**
   * getMonitorType method receives MonitorType variable for MonitorType.
   *
   * @return returns monitor type.
   */
  public MonitorType getMonitorType() {
    return monitorType;
  }

  /**
   * setMonitorType sets receives MonitorType variable for MonitorType.
   *
   * @param monitorType type of monitor.
   */
  public void setMonitorType(MonitorType monitorType) {
    this.monitorType = monitorType;
  }

  /**
   * method prints info.
   */
  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * method prints info.
   */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /**
   * method prints info.
   */
  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  /**
   * method prints info.
   */
  @Override
  public void next() {
    System.out.println("Next movie");
  }
}
