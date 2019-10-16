package sample;

public enum ItemType {
  AUDIO("AU"), VISUAL("VI"), AUDIO_MOBILE("AM"), VISUAL_MOBILE("VM");

  public String c;
  ItemType(String c){
    this.c = c;
  }
  public String getType(){
   return c;
  }
}
