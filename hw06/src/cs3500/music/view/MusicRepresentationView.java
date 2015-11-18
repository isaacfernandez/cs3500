package cs3500.music.view;

/**
 * Interface to be implemented by all testable, displayable views
 */
public interface MusicRepresentationView {

    /**
     * Represents the data statically, or sets up window
     */
    void display(SafeMusicRepresentation m);

    /**
     * Sets up the display as it should look during the given beat
     * @param beat the time being displayed
     */
    void displayAtBeat(SafeMusicRepresentation m, int beat);
    /**
     * The 'play' button for the view. Useless for those that statically display the data.
     */
    void play(SafeMusicRepresentation m);

    /**
     * For testing purposes, return the log string builder
     */
    Appendable getLog();
}
