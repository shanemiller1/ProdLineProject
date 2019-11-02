package sample;

public enum ItemType {
  AUDIO("AU"), VISUAL("VI"), AUDIO_MOBILE("AM"), VISUAL_MOBILE("VM");

  private String c;
  ItemType(String c){
    this.c = c;
  }
  public String getType(){
   return c;
  }

  public String getC() {
    return c;
  }

  public void setC(String c) {
    this.c = c;
  }
}
