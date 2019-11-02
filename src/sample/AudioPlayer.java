package sample;

public class AudioPlayer extends Product implements MultimediaController {

  String audioSpecification;
  String mediaType;


  public String getAudioSpecification() {
    return audioSpecification;
  }

  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  public String getMediaType() {
    return this.mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  AudioPlayer(String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer);
    setAudioSpecification(audioSpecification);
    setMediaType(mediaType);

  }

  @Override
  public String toString() {
    return super.toString() + "\nSupported Audio Formats: " + audioSpecification
        + "\nSupported Playlist Formats: " + mediaType;
  }

  public void play() {

    System.out.println("Playing");
  }


  public void stop() {

    System.out.println("Stopping");
  }


  public void previous() {

    System.out.println("Previous");
  }


  public void next() {

    System.out.println("Next");
  }
}
