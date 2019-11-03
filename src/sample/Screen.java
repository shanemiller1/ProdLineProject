package sample;

/**
 * class for screen implements other class.
 *
 * @author Shane Miller
 */
public class Screen implements ScreenSpec {

    private String resolution;
    private int refreshrate;
    private int responsetime;

    /**
     * getResolution method receives Resolution variable for Resolution.
     *
     * @return
     */
    @Override
    public String getResolution() {
        return resolution;
    }

    /**
     * getRefreshRate method receives RefreshRate variable for RefreshRate.
     *
     * @return
     */
    @Override
    public int getRefreshRate() {
        return refreshrate;
    }

    /**
     * getResponseTime method receives ResponseTime variable for ResponseTime.
     *
     * @return
     */
    @Override
    public int getResponseTime() {
        return responsetime;
    }

    /**
     * tostring returning data to print.
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n" + "Resolution: " + resolution + "\n" + "Refresh rate: " + refreshrate + "\n" + "Response time: " + responsetime;
    }

    /**
     * method setting variables this to variable.
     *
     * @param resolution
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * method setting variables this to variable.
     *
     * @param refreshrate
     */
    public void setRefreshrate(int refreshrate) {
        this.refreshrate = refreshrate;
    }

    /**
     * method setting variables this to variable.
     *
     * @param responsetime
     */
    public void setResponsetime(int responsetime) {
        this.responsetime = responsetime;
    }

    /**
     * constructor passing parameters.
     *
     * @param resolution
     * @param refreshrate
     * @param responsetime
     */
    Screen(String resolution, int refreshrate, int responsetime) {
        setResolution(resolution);
        setRefreshrate(refreshrate);
        setResponsetime(responsetime);
    }


}
