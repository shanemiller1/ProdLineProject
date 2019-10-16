package sample;

public abstract class Screen implements ScreenSpec {

  private String resolution;
  private int refreshrate;
  private int responsetime;

  @Override
  public String getResolution() {
    return null;
  }

  @Override
  public int getRefreshRate() {
    return 0;
  }

  @Override
  public int getResponseTime() {
    return 0;
  }

  public String toString(){
    return "responsetime: " + resolution + "\n" + "refreshrate: " + refreshrate + "\n" + "responsetime: " + responsetime;
  }

}
