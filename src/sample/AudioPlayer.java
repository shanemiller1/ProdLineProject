package sample;


/**
 * Class for AudioPlayer.
 *
 * @author Shane Miller
 */
public class AudioPlayer extends Product implements MultimediaController {

  String audioSpecification;
  String mediaType;

  /**
   * getAudioSpecification method receives AudioSpecification variable for AudioSpecification.
   *
   * @return this the return.
   */
  public String getAudioSpecification() {
    return audioSpecification;
  }

  /**
   * setAudioSpecification method sets AudioSpecification variable for AudioSpecification.
   *
   * @param audioSpecification spec of audio.
   */
  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  /**
   * getMediaType method receives MediaType variable for MediaType.
   *
   * @return this the return.
   */
  public String getMediaType() {
    return this.mediaType;
  }

  /**
   * setMediaType method sets MediaType variable for MediaType.
   *
   * @param mediaType type of media.
   */
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  /**
   * constructor passing super class for name and manufacturer.
   *
   * @param name               name of product.
   * @param manufacturer       name of manufacturer.
   * @param audioSpecification specifies audio.
   * @param mediaType          specifies media type.
   */
  AudioPlayer(String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer);
    setAudioSpecification(audioSpecification);
    setMediaType(mediaType);

  }

  /**
   * toString returns from super class.
   *
   * @return this the return.
   */
  @Override
  public String toString() {
    return super.toString() + "\nSupported Audio Formats: " + audioSpecification
            + "\nSupported Playlist Formats: " + mediaType;
  }

  /**
   * method prints.
   */
  public void play() {

    System.out.println("Playing");
  }

  /**
   * method prints.
   */
  public void stop() {

    System.out.println("Stopping");
  }

  /**
   * method prints.
   */
  public void previous() {

    System.out.println("Previous");
  }

  /**
   * method prints.
   */
  public void next() {

    System.out.println("Next");
  }
}
