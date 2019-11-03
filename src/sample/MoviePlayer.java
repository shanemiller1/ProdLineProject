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
     * @param name
     * @param manufacturer
     * @param screen
     * @param monitorType
     */
    MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
        super(name, manufacturer);
        this.screen = screen;
        this.monitorType = monitorType;
    }

    /**
     * to string returning super class to print information.
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "\nScreen:" + screen + "\nMonitor Type: " + monitorType;
    }

    /**
     * setScreen method receives Screen variable for Screen.
     *
     * @return
     */
    public Screen getScreen() {
        return screen;
    }

    /**
     * setScreen method sets Screen variable for Screen.
     *
     * @return
     */
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    /**
     * getMonitorType method receives MonitorType variable for MonitorType.
     *
     * @return
     */
    public MonitorType getMonitorType() {
        return monitorType;
    }

    /**
     * setMonitorType sets receives MonitorType variable for MonitorType.
     *
     * @param monitorType
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
