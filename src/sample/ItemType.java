package sample;

/**
 * enum setting variables for audio, visual, audio & visual mobile.
 *
 * @author Shane Miller
 */
public enum ItemType {
    AUDIO("AU"), VISUAL("VI"), AUDIO_MOBILE("AM"), VISUAL_MOBILE("VM");

    private String c;

    /**
     * Ithem type setting string to C.
     *
     * @param c
     */
    ItemType(String c) {
        this.c = c;
    }

    /**
     * getType method receives type variable for type.
     *
     * @return
     */
    public String getType() {
        return c;
    }

    /**
     * getC method receives c variable for c.
     *
     * @return
     */
    public String getC() {
        return c;
    }

    /**
     * setC method sets c variable for c.
     *
     * @return
     */
    public void setC(String c) {
        this.c = c;
    }
}
