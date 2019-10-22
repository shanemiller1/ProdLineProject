package sample;


public class Screen implements ScreenSpec {

    private String resolution;
    private int refreshrate;
    private int responsetime;

    @Override
    public String getResolution() {
        return resolution;
    }

    @Override
    public int getRefreshRate() { return refreshrate;
    }

    @Override
    public int getResponseTime() {
        return responsetime;
    }

    @Override
    public String toString(){
        return "\n" + "Resolution: " + resolution + "\n" + "Refresh rate: " + refreshrate + "\n" + "Response time: " + responsetime;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setRefreshrate(int refreshrate) {
        this.refreshrate = refreshrate;
    }

    public void setResponsetime(int responsetime) {
        this.responsetime = responsetime;
    }

    Screen (String resolution, int refreshrate, int responsetime ) {
        setResolution(resolution);
        setRefreshrate(refreshrate);
        setResponsetime(responsetime);
    }


}
