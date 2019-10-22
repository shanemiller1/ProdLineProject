package sample;

public class MoviePlayer extends Product implements MultimediaController {

    private Screen screen;
    private MonitorType monitorType;

    MoviePlayer(String name, String manufacturer, String type) {
        super(name, manufacturer, type);
        setType("VISUAL");

    }

    MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
        super(name, manufacturer);
        super.setType("VISUAL");
        setScreen(screen);
        setMonitorType(monitorType);
    }

    @Override
    public String toString(){
        return super.toString() + "\nScreen:" + screen + "\nMonitor Type: " + monitorType;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public MonitorType getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(MonitorType monitorType) {
        this.monitorType = monitorType;
    }

    @Override
    public void play() {
        System.out.println("Playing movie");
    }

    @Override
    public void stop() {
        System.out.println("Stopping movie");
    }

    @Override
    public void previous() {
        System.out.println("Previous movie");

    }

    @Override
    public void next() {
        System.out.println("Next movie");

    }
}
