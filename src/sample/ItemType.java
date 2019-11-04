package sample;

/**
 * enum setting variables for audio, visual, audio & visual mobile.
 *
 * @author Shane Miller
 */
public enum ItemType {
    AUDIO("AU"), VISUAL("VI"), AUDIO_MOBILE("AM"), VISUAL_MOBILE("VM");

    private String code;

    /**
     * Ithem type setting string to C.
     *
     */
    ItemType(String code) {
        this.code = code;
    }

    /**
     * getType method receives type variable for type.
     *
     * @return
     */
    public String getType() {
        return code;
    }

    /**
     * getcode method receives code variable for code.
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * setcode method sets code variable for code.
     *
     * @return
     */
    public void setCode(String code) {
        this.code = code;
    }
}
