package cs3500.music.view;

/**
 * Created by isaacf on 11/2/15.
 */
public interface MusicRepresentationView {

    /**
     * Represents the data statically, or sets up window
     */
    void display(SafeMusicRepresentation m);

    /**
     * The 'play' button for the view. Useless for those that statically display the data.
     */
    void play(SafeMusicRepresentation m);

    /**
     * For testing purposes, return the log string builder
     */
    Appendable getLog();
}
